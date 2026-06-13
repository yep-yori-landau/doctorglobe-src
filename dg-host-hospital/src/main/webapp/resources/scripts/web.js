$(document).ready(function() {
	
	linkvisted();
	
	function linkvisted(){
		var url = window.location.href;
		$('.acc-content ul li a').filter(function() {
		    return this.href == url;
		}).parent().addClass('active');	
		
		$('.acc-block .acc-title a').filter(function() {
		    return this.href == url;
		}).parent().parent().addClass('acc-open');
		
		$('.acc-content ul li a').filter(function() {
		    return this.href == url;
		}).parents('.acc-content').parents('.acc-block').addClass('acc-open');		
		
		$('.sub-accordion li > a').filter(function(){
			return this.href == url && $(this).parent('li').find('ul').children().length;
		}).parents('li').addClass("sub-open").removeClass("active");
		
		$('.sub-accordion li > a').filter(function(){
			return this.href == url && $(this).parent('li').find('ul').length;
		}).parents('li').addClass("sub-open").removeClass("active");
	}
	
	/*$('.datepicker').datetimepicker({
		timepicker:false,
		format : 'Y-m-d',
		scrollInput : false,		
		closeOnDateSelect: true,	
	});*/
	
	$('.datepicker').datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
        changeYear: true,
        numberOfMonths: 1,
        showButtonPanel: true,
        maxDate:"0",
        minDate:"-100Y",
        yearRange: '-100:-0',
       
	});
	
	$('.dob').datepicker({		
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
        changeYear: true,
        numberOfMonths: 1,
        showButtonPanel: true,
        minDate: "-100Y",
        maxDate: "-21Y",
        yearRange: '-100:-0',		
	});	
	
	$(document).on('click','.btn-cal',function(){		
		var id = $(this).attr('id');	
		$('.'+id).focus();		
	});
	
	$('.accreditationcheck').click(function(){
		var id = $(this).attr('id');		
		var n = id.lastIndexOf('.');		
		var datepicker = "datepicker"+id.substring(n-1,n);
		if(n == 32){
			datepicker = "datepicker"+id.substring(n-2,n);
		}
		if($(this).is(':checked')){			
			$("."+datepicker).attr("required",true);
			$("."+datepicker).focus();			
		}else{
			$("."+datepicker).removeAttr("required");
		}
	});
	
	$(".various").fancybox({		
		fitToView	: false,		
		padding     : 0,
		margin      : 0,
		autoSize	: false,		
		closeClick	: false,
		closeBtn	: false,		
		scrolling : 'no', 
		openEffect	: 'elastic',
		closeEffect	: 'elastic',
	    afterLoad  : function(){
			this.width = parseInt(this.element.data('fancybox-width'));
			this.height = parseInt(this.element.data('fancybox-height'));			
		},
		beforeClose   : function(){							
			window.location.reload(true);			
		}	
	});	
	
	$(".fancyclose").click(function(){
	    parent.jQuery.fancybox.close();
	});
	
	$('.showuploadform').click(function(){
		$('.uploadformshow').show();
		$('.uploadshow').hide();
	});
	
	$('.fileupload').change(function(){
		var filePath = $(this).val();
		$('.filepath').text(filePath);
	});
	
	$('.policyfileupload').change(function(){
		var filePath = $(this).val();
		$('.policyfile').val(filePath);
	});
	
	$(".image-description").tooltipster();
	

	$(".fancybox").fancybox({
		openEffect	: 'none',
		closeEffect	: 'none'
	});

	$('select.my-select').msDropDown();	
	
	$('.addbtn').click(function(){
		var options = '';	
		$('.mylistbox').find("option:selected").each(function(){
			options += '<option value="' + this.value + '">' + this.text + '</option>';			
		});						
		$('.mylistbox').find("option:selected").remove();
		$('.mylistbox1').append(options);		
		$('select.mylistbox1 option').attr("selected",false);
	});
	
	$('.removebtn').click(function(){		
		var options = '';
		$('.mylistbox1 > option:selected').each(function(){
			options += '<option value="' + this.value + '">' + this.text + '</option>';			
		});
		$('.mylistbox1 > option:selected').remove();				
		$('.mylistbox').append(options);		
		$('select.mylistbox option').attr("selected",false);		
	});
	$('.addallbtn').click(function(){		
		$('.mylistbox > option').remove().appendTo('.mylistbox1');		
	});
	
	$('.removeallbtn').click(function(){		
		$('.mylistbox1 > option').remove().appendTo('.mylistbox');		
	});	
	
	$('.btn-list-submit').click(function(){
		$('select.mylistbox option').attr("selected",true);
		$('select.mylistbox1 option').attr("selected",true);		
	});
	
	$('.practitionerspecialty').change(function(){
		 var val = $(".practitionerspecialty option:selected").val();		 
		 $(".result").show();
		 if(val != 'all'){
			 $("select.practitionertreatment").msDropDown().data("dd").destroy();
			 $('select.practitionertreatment').val('all');
			 $("select.practitionertreatment").msDropDown().data("dd");
			 $(".result").each(function(){
				   if(!$(this).hasClass('s'+val)){
					   $(this).hide();
				   }
			 });
		 }
	}).change();
	
	$('.practitionertreatment').change(function(){
		 var val = $(".practitionertreatment option:selected").val();		 
		 $(".result").show();
		 if(val != 'all'){
			 $("select.practitionerspecialty").msDropDown().data("dd").destroy();
			 $('select.practitionerspecialty').val('all');
			 $("select.practitionerspecialty").msDropDown().data("dd");
			 $(".result").each(function(){
				   if(!$(this).hasClass('t'+val)){
					   $(this).hide();
				   }
			 });
		 } 
	}).change();
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	$("#textsearch").keyup(function(){
		var valThis = $(this).val().toLowerCase();		
		if(valThis == ""){
		        $('.result').show();           
		}else{ 
			$('.result').each(function(){
				var text = $(this).find("td").text().toLowerCase();				
				(text.indexOf(valThis) >= 0) ? $(this).show() : $(this).hide();
			});
		}
	});
	
	$(".user-info").on(
			"click",
			function(a) {
				 $(this).parents(".user-menu").find(
						"ul:first").slideDown().addClass("active");
			}), $(".user-info").on("mouseleave", function() {
		$(this).parents(".user-menu").find("ul:first").slideUp();
	});
	
	$('.btn-cancel').click(function(){
		window.location.reload(true);
	});
	
});