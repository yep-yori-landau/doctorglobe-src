$(document).ready(function() {
	
	
	
	dynamicFilter(true);
	
	$('.filters').click(function(){			
		dynamicFilter(true);
	});
	
	function dynamicFilter(showmax){
		var rangemaxvalue = $('.rangemaxvalue').text();		
		var rangeminvalue = $('.rangeminvalue').text();
		if(rangemaxvalue.indexOf('K') === -1){			
			$('.rangemaxvalue').text(Math.ceil(rangemaxvalue/1000)+"K");					
			$('.rangeminvalue').text(Math.floor(rangeminvalue/1000)+"K");
		}
		var regionSel = '';
		var amenitySel = '';
		var equipmentSel = '';
		var genderSel = '';
		var availabilitySel = '';
		var usaffilicationSel = '';
		var languageSel = '';
		
		var $result = $('.res');
		$('.filters').each(function(){
			var id = $(this).attr('id');
			if($(this).is(':checked')){
				if($("#"+id).hasClass("region")){
				   if(regionSel == ''){
					   regionSel += '.'+$(this).attr('id');
				   }else{
					   regionSel += ',.'+$(this).attr('id');
				   }
				}
				else if($("#"+id).hasClass("amenity")){
					if(amenitySel == ''){
						   amenitySel += '.'+$(this).attr('id');
					   }else{
						   amenitySel += '.'+$(this).attr('id');
					}
				}
				else if($("#"+id).hasClass("equipment")){
					if(equipmentSel == ''){
						   equipmentSel += '.'+$(this).attr('id');
					   }else{
						   equipmentSel += '.'+$(this).attr('id');
					}
				}
				else if($("#"+id).hasClass("gender")){
					if(genderSel == ''){
						   genderSel += '.'+$(this).attr('id');
					   }else{
						   genderSel += ',.'+$(this).attr('id');
					}
				}
				else if($("#"+id).hasClass("availability")){
					if(availabilitySel == ''){
						availabilitySel += '.'+$(this).attr('id');
					 }else{
						   availabilitySel += ',.'+$(this).attr('id');
					 }
				}
				else if($("#"+id).hasClass("usaffilication")){
					if(usaffilicationSel == ''){
						usaffilicationSel += '.'+$(this).attr('id');
					 }else{
						 usaffilicationSel += ',.'+$(this).attr('id');
					 }
				}
				else if($("#"+id).hasClass("language")){
					if(languageSel == ''){
						languageSel += '.'+$(this).attr('id');
					 }else{
						 languageSel += ',.'+$(this).attr('id');
					 }
				}
			}			
		});	
		
		if(regionSel != ''){
			$result = $result.filter(regionSel);
		}
		if(amenitySel != ''){
			$result = $result.filter(amenitySel);
		}
		if(equipmentSel != ''){
			$result = $result.filter(equipmentSel);
		}
		if(genderSel != ''){
			$result = $result.filter(genderSel);
		}
		if(availabilitySel != ''){
			$result = $result.filter(availabilitySel);
		}
		if(usaffilicationSel != ''){
			$result = $result.filter(usaffilicationSel);
		}
		if(languageSel != ''){
			$result = $result.filter(languageSel);
		}
		$('.res').hide();
		$checked = $('input:checked');		
		if($checked.length){
			$result.show();
		}else{
			$('.res').show();
		}
		var value = parseInt($('.rangevalue').text());		
		var availabilityTime = parseInt($('.timemax').text());
		var flighthourmax = parseInt($('.flighthourmax').text());
		//var ratingvalue = $('#userrating').rateit('value');
		
		$('.res').each(function(){
			  var price = parseInt($(this).find('.price').text());	
			  var availabilitydays = parseInt($(this).find('.availabilitydays').text());
			  var flighthour = parseInt($(this).find('.flighthour').text());			 
			  if((value > price && $(this).is(":visible"))){ 
				  $(this).hide();
			  }			  
			  if(flighthourmax < flighthour && $(this).is(":visible")){
				  $(this).hide();
			  }
			  if(availabilityTime < availabilitydays && $(this).is(":visible")){
				  $(this).hide();
			  }
			  /*var rating = parseInt($(this).find('.ratings').text());
			  if(ratingvalue > rating && $(this).is(":visible") && ratingvalue != 0){
				  $(this).hide();
			  }*/
			  if($(".textsearch").length > 0){
				  var text = $(this).find("ul").find("li").find("h3").text().toLowerCase();				  
				  var textsearch = $(".textsearch").val().toLowerCase();
				  if(!($(this).is(":visible") && text.indexOf(textsearch) >= 0)){
							$(this).hide();
				  }
			  	  
			  }
		});
		if(showmax){
			showMax();
		}
	}
	
	function showMax(){
		var num = parseInt($('.viewmore').attr('data-value'));
		var noofresults = num * 2;		
		var count = 0;
		var rank = 0;
		$('.resultsdiv').each(function(){			
			if($(this).is(":visible")){
				count++;
				rank++;
				$(this).find('.rankresult').text(rank);
			}
			if(count > noofresults){
				$(this).hide();
			}
		});
		
		if(count > noofresults){
			$('.viewmore').show();
			$('.viewmore').attr('data-value',num);
		}else{
			$('.viewmore').hide();
			$('.viewmore').attr('data-value',5);
		}
		if(count != 0){
			$('.notfound').hide();
		}
		if(count == 0){
			$('.notfound').show();
		}
		$('.totalfound').text(count);		
		$('.totalresult').text(count);
	}
	
	$('.viewmore').click(function(){
		var num = parseInt($(this).attr('data-value')) + 5;		
		$(this).attr('data-value',num);			
		dynamicFilter(true);
	});
	
	function hideFilters(id,selClass){		
		var classArray = selClass.split(" ");		
		for(var i=0;i<classArray.length;i++){
			var found = false;						
			$('.res').each(function(){
				var resultid = $(this).attr('id');
				if(resultid != id && $(this).hasClass(classArray[i])){
					found = true;
				}
			});
			
			if(!found){
				$('.filters').each(function(){
					var filterid = $(this).attr('id');
					if(filterid == classArray[i]){
						this.checked = false;
						$(this).attr("disabled",true);
					}
				});
			}
			
		}
	}
	
	$("li article .ico-close").click(function(){
		var id = $(this).parent().attr('id');
		var selClass =$(this).parent().attr('class');		
		hideFilters(id,selClass);
		$(this).parent().hide('slow');
		$(this).parent().parent('li').slideUp("slow", function() { $(this).remove();});
		dynamicFilter(true);
	});	
	
	$("#textsearch").keyup(function(){
		var valThis = $(this).val().toLowerCase();		
		$('.res').show();		
		if(valThis == ""){
		        $('.res').show();           
		        dynamicFilter(true);
		}else{ 
			$('.viewmore').hide();
			dynamicFilter(false);
			var found = false;
			var count = 0;
			$('.res').each(function(){
				var text = $(this).find("ul").find("li").find("h3").text().toLowerCase();
				if(!($(this).is(":visible") && text.indexOf(valThis) >= 0)){
					$(this).hide();
				}else{
					found = true;
					count++;
				}				
			});
			if(!found){
				$('.totalfound').text(count);
				$('.notfound').show();
			}else{
				$('.totalfound').text(count);
				showMax();
				$('.notfound').hide();
			}
		}		
	});
	
	$(".clearfilter").click(function(){
		$('.filters').each(function(){
			this.checked = false;
			$(this).removeAttr('disabled');
		});
		//$('.rateit-reset').trigger("click");
		$('.slider-bonus-filter').slider({
			value: parseInt($('.rangeminvalue').text())*1000,			
		});		
		$('.slider-time-duration').slider({
			value: parseInt($('.timemaxvalue').text()),			
		});
		$('.slider-flight-hour').slider({
			value: parseInt($('.flighthourmaxvalue').text()),			
		});		
		//$('.rangemax').text(parseInt($('.rangeminvalue').text())+"K");
		$('.rangevalue').text(parseInt($('.rangeminvalue').text())*1000);
		$('.timemax').text(parseInt($('.timemaxvalue').text()));
		$('.flighthourmax').text(parseInt($('.flighthourmaxvalue').text()));
		$("#textsearch").val('');
		dynamicFilter(true);
	});	
	
	$('.description').expander({slicePoint: 150,
		afterExpand: function(){
			$(this).find('.details').removeAttr('style');
		},
	});
	
	/*$('#userrating').bind('rated', function(event, value){	
	     dynamicFilter(true);	   
	});*/	
	
	//$('.rateit').rateit({ max: 5, step: 1});
	
	$("select.sort-select").change(function(){
		var val = $(this).val();
		if(val != "none" || val != "bonus"){
			$('.resli').sort(function (a, b) {
				  return $(a).find('.'+val).text() - $(b).find('.'+val).text();
				}).each(function (_, container) {
				  $(container).parent().append(container);
			});
		}
		if(val == "bonus"){
			$('.resli').sort(function (a, b) {
				  return $(b).find('.'+val).text() - $(a).find('.'+val).text();
				}).each(function (_, container) {
				  $(container).parent().append(container);
			});
		}
		
	});
	
	var $slider1 = $('.slider-bonus-filter').slider({
		range: "min",
		step: parseInt(((parseInt($('.rangemaxvalue').text())*1000)-(parseInt($('.rangeminvalue').text())*1000))/5),
		min: parseInt($('.rangeminvalue').text())*1000,
		max: parseInt($('.rangemaxvalue').text())*1000,
		value: parseInt($('.rangeminvalue').text())*1000,		
		slide: function(event, ui){
			$('.rangevalue').text(parseInt(ui.value));    		
    		dynamicFilter(true);
		}
	});	
	$slider1.slider("float");
	
	var $slider2 = $('.slider-flight-hour').slider({
		range: "min",
		step: 1,
		min: parseInt($('.flighthourminvalue').text()),
		max: parseInt($('.flighthourmaxvalue').text()),
		value: parseInt($('.flighthourmaxvalue').text()),
		slide: function(event, ui){			
    		$('.flighthourmax').text(parseInt(ui.value));
    		dynamicFilter(true);
		}
	});	
	$slider2.slider("float");
	var $slider3 = $('.slider-time-duration').slider({
		range: "min",
		step: 1,
		min: 1,
		max: parseInt($('.timemaxvalue').text()),
		value: parseInt($('.timemaxvalue').text()),
		slide: function(event, ui){			
    		$('.timemax').text(parseInt(ui.value));
    		dynamicFilter(true);
		}
	});	
	$slider3.slider("float");
});