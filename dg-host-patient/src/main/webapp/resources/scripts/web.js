 $(document).ready(function() {		
	 
		$("body").on('click','div ol li a',function(){		
			$(this).parent().parent().find('li').removeClass('active');		
			$(this).parent().addClass('active');
		});	
		$(".facs").hide();		
		
		$("body").on('click','.location',function(){
			var id = $(this).attr('id');
			var lastChar = id.match(/\d+/);
			$('.general'+lastChar).slideUp();
			$('.fac'+lastChar).slideUp();		
			$('.'+id).slideDown();
			$('.'+id).css("position","relative");
			$('.'+id).css("left","0px");			
		});
		$("body").on('click','.general',function(){
			var id = $(this).attr('id');			
			var lastChar = id.match(/\d+/);			
			$('.location'+lastChar).slideUp();
			$('.fac'+lastChar).slideUp();
			$('.'+id).slideDown();
		});		
		$("body").on('click','.fac',function(){
			var id = $(this).attr('id');			
			var lastChar = id.match(/\d+/);				
			$('.location'+lastChar).slideUp();
			$('.general'+lastChar).slideUp();
			$('.'+id).slideDown();
		});	
		$("body").on('click','.resume',function(){
			var id = $(this).attr('id');			
			var lastChar = id.match(/\d+/);	
			$('.stats'+lastChar).slideUp();
			$('.'+id).slideDown();
		});	
		$("body").on('click','.stats',function(){
			var id = $(this).attr('id');			
			var lastChar = id.match(/\d+/);	
			$('.resume'+lastChar).slideUp();
			$('.'+id).slideDown();
		});	
		var loginmsg = null;
		var datahref = null;
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
			fitToView: true,
			'helpers'     : { 
	            'overlay' : {'closeClick': false},
	         },
			beforeLoad :function(){
				
			},
		    afterLoad  : function(){
				this.width = parseInt(this.element.data('fancybox-width'));
				this.height = parseInt(this.element.data('fancybox-height'));			
			},	
			beforeClose   : function(){			
				loginmsg = $(".fancybox-iframe").contents().find('.loginerror').text();			
				if(loginmsg == "0"){				
						window.location.reload(true);				
				}
			},
			afterClose : function(){
				/* hide login window open signup window*/
				if(loginmsg == "2"){				
					$('#js-signup').trigger("click");
				}else if(loginmsg == "3"){				
					$('#js-forgot').trigger("click");
				}else if(loginmsg == "5"){
					$('#js-signin').trigger("click");
				}
			},		
	});	
		
	var signupmsg = null;
	$(".various1").fancybox({		
			fitToView	: false,		
			padding     : 0,
			autoSize	: false,
			closeClick	: false,
			closeBtn	: false,
			openEffect	: 'none',
			closeEffect	: 'none',		
			'helpers'     : { 
	            'overlay' : {'closeClick': false},
	         },
			beforeLoad  : function(){
				this.width = parseInt(this.element.data('fancybox-width'));
				this.height = parseInt(this.element.data('fancybox-height'));			
			},	
			beforeClose   : function(){			
				signupmsg = $(".fancybox-iframe").contents().find('.signuperror').text();						
				if(signupmsg == "0"){				
					$(".overlay-bg").slideDown(
							"fast",
							function() {
								$(window).scrollTop(0), $(
										".js-confirmation-overlay").fadeIn("fast");
					});				
				}		
			},
			afterClose : function(){
				console.log(signupmsg);
				if(signupmsg == "2"){				
					$('#js-signin').trigger("click");					
				}	
			}
	});
		
	$(".signupcall").click(function(){		
		$('.loginerror').html("2");
		parent.jQuery.fancybox.close();		
	});
	
	$(".signincall").click(function(){		
		$('.signuperror').html("2");
		parent.jQuery.fancybox.close();		
	});
	
	$(".forgotcall").click(function(){		
		$('.loginerror').html("3");
		parent.jQuery.fancybox.close();		
	});
	
	$(".fancyclose").click(function(){
		$('.loginerror').html("5");
		$('.signuperror').html("2");		
	    parent.jQuery.fancybox.close();	    
	});
		
	$(".overlay").on("click", ".ico-close", function(a) {
		a.stopPropagation(), $(".overlay-bg, .overlay").hide();
		$('#js-signin').trigger("click");
	}), $(".overlay-bg").on("click", function() {
		$(".overlay").find(".ico-close").trigger("click");
	}), $(".confirmationcontent").on("click",".btn", function() {
		$(".overlay").find(".ico-close").trigger("click");
	});
	
	$(".fig-block").on("click", "button", function() {
		var overlay = $(this).attr("id");
		$(".overlay-bg").slideDown("fast", function() {
			$(window).scrollTop(0), $("." + overlay).fadeIn("fast");
		});
	});
	
	
	$(".various2").fancybox({		
		fitToView	: false,		
		padding     : 0,
		autoSize	: false,
		closeClick	: false,
		closeBtn	: false,
		openEffect	: 'none',
		closeEffect	: 'none',		
		beforeLoad  : function(){
			this.width = parseInt(this.element.data('fancybox-width'));
			this.height = parseInt(this.element.data('fancybox-height'));		
		},
		afterLoad   : function(){
			datahref = this.element.data('href');
		},
		beforeClose   : function(){
			       if(datahref){
			    	   window.location.href = datahref;
			       }else{
			    	   window.location.reload(true);
			       }
		}
	});
	
	$(".various3").fancybox({		
		fitToView	: false,		
		padding     : 0,
		autoSize	: false,
		closeClick	: false,
		closeBtn	: false,
		openEffect	: 'none',
		closeEffect	: 'none',		
		beforeLoad  : function(){
			this.width = parseInt(this.element.data('fancybox-width'));
			this.height = parseInt(this.element.data('fancybox-height'));		
		},
		afterLoad   : function(){
			datahref = this.element.data('href');
		},
		beforeClose   : function(){
			loginmsg = $(".fancybox-iframe").contents().find('.loginerror').text();
			if(datahref && loginmsg == "4"){
			    	   window.location.href = datahref;
			}
		}
	});
	
	$(".btn-conference-ok").click(function(){
		$('.loginerror').html("4");
		parent.jQuery.fancybox.close();
	});
	
	$(".btn-conference-cancel").click(function(){		
		parent.jQuery.fancybox.close();		
	});
	
	
	/*var pc = getParameterByName('pc');	
	if(pc != ""){		
		$("select.patientcasetreatment").val(pc);		
  	}
	
	$("select.patientcasetreatment").change(function(){
		var val = $(this).val();		
		var path = window.location.pathname;		
		var pc = getParameterByName('pc');		
		if(val != null){
			if(path.indexOf('?pc=') != -1){   			
  			path = path +"?pc="+val;
  		 	}else{
      		 path = path +"?pc="+val;
  		 	} 
		 var url = location.protocol + '//' + location.host+path;
			if(pc != val){
				window.location.href = url;
			}	
		}
	}).change();*/	
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	linkvisted();
	headerLinkVisted();
	/*
	 * higlighted to menu on visiting
	 */
	function linkvisted(){
		var url = window.location.href;
		$('.no-pad ul li a').filter(function() {
		    return this.href == url;
		}).parent().addClass('active');
	}
	
	function headerLinkVisted(){		
		var url = window.location.href;
		url = url.split('?')[0];
		$('#main-nav ul li a').filter(function() {
		    return this.href == url;
		}).addClass('active');
	}
	
	$(".hospitaltab").click(function(){
	     var id = $(this).attr('id');
	     $('.pcmresult').each(function(){
	    	 if($(this).hasClass(id)){
	    		 $(this).removeClass("hidemessages");
	    		 $(this).show();
	    	 }else{
	    		 $(this).hide();
	    	 }
	     });
	});
	
	
	var numberOfOptions = $("select.patientcasetreatment option").length;	
	if(numberOfOptions == 0){
		$('.pcdiv').hide();
	}else if(numberOfOptions >= 2){
		$('.pcname').show();
		$(".patientcasetreamenttext").hide();
	}
	
	$('select.js-select').msDropDown();
	
	
	$("select.usersort-select").change(function(){
		var $divs = $(".resli");
		var val = $(this).val();		
		if(val != "date"){			
			$divs.sort(function (a, b) {				  
				  return ($(a).find('.'+val).text().toUpperCase() > $(b).find('.'+val).text().toUpperCase()) ? 1 : -1;
				}).appendTo(".result-container");	
		}else{
			$divs.sort(function (a, b) {
				  console.log($(a).find('.'+val).text().toUpperCase());
				  return ($(a).find('.'+val).text().toUpperCase() > $(b).find('.'+val).text().toUpperCase()) ? 1 : -1;
				}).appendTo(".result-container");
		}
	});		
	
	$(".fancybox").fancybox({
		openEffect	: 'none',
		closeEffect	: 'none'
	});
	
	$(".image-description").tooltipster();
	
	$('.datetimepicker').datetimepicker({		
		format:'M d, Y h:i a',
		step:'30',
		minDate:'-1970/01/02', // yesterday is minimum date		
	});
	
	/**
	 * video pause on arrowleft or arrowright or close button click
	 */
	$('.videoclose').click(function(){		
		pauseVideo();
	});
	
	function pauseVideo(){
		$("video").each(function(){
		    $(this).get(0).pause();
		});
	}
	
	$('.datepicker').datetimepicker({
		inline : true,
		timepicker:false,
		format:'M d, Y',
		minDate:0,
		onShow : function(ct,$input){
			var date = new Date($input.val());
		    var currentDate = new Date();			    
		    if(date > currentDate){			    	
		    	$('.timepicker').setOptions({
		    		minTime:'00:00',	
		    	});
		    }else{			    	
		    	$('.timepicker').setOptions({
		    		minTime:new Date(),	
		    	});
		    }
		},
		onChangeDateTime:function(dp,$input){
		    var date = new Date($input.val());
		    var currentDate = new Date();
		    if(date > currentDate){			    	
		    	$('.timepicker').setOptions({
		    		minTime:'00:00'	
		    	})
		    }else{
		    	$('.timepicker').setOptions({
		    		minTime:new Date(),	
		    	})
		    }		    
		},
	});
	
	$('.timepicker').datetimepicker({			
		datepicker:false,
		format:'h:i a',			
		step:15,			
	});
	
	$('.fileupload').change(function(){
		var filePath = $(this).val();
		$('.filename').val(filePath);
	});
	
	$('.uploaddatepicker').datetimepicker({		
		timepicker:false,
		format:'M d, Y',
		maxDate:0,
	});
	
 });
