 $(document).ready(function() {		
	 
	
	$(".various").fancybox({		
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
		beforeClose   : function(){							
					window.location.reload(true);			
		},			
	});	
	
	$(".fancyclose").click(function(){
	    parent.jQuery.fancybox.close();
	});
	
	
	linkvisted();
	/*
	 * higlighted to menu on visiting
	 */
	function linkvisted(){
		var url = window.location.href;		
		$('nav ul li a').filter(function() {
		    return this.href == url;
		}).addClass('active');
	}
	
	$('.viewpatient').click(function(){
		$('.tabs').find('li').removeClass('active');
		$(this).parent('li').addClass('active');
		var id = $(this).attr('id');
		$('.'+id).show();
		if(id == 'patientfileshow'){
			$('.patientconferenceshow').hide();			
		}else{
			$('.patientfileshow').hide();
		}
	});
	
	$('.date-picker').datepicker({
			dateFormat: 'yy-mm-dd H:i',
			changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        showButtonPanel: true,
	        minDate: "-80Y",
	        maxDate: "-21Y",
	        yearRange: '-80:-21',
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
	
	$('.forgotcall').click(function(){		
		$('.forgotbox').show();
	});
	
	$(".image-description").tooltipster();
	

	$(".fancybox").fancybox({
		openEffect	: 'none',
		closeEffect	: 'none'
	});
	
	$(".readonly").keydown(function(e){
        e.preventDefault();
    });
	
 });
