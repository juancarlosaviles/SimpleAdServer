function doGet(){
	$.ajax({
    	type: "GET",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:9383/SimpleAdServer/services/partnerservice/partners/"+$('#partnerId').val()})
       .then(function(data) {
    	 if(data == null){
		alert("No active ad campaigns exist for the specified partner")
	}else
       $('#partnerId').val(data.partnerId);
       $('#duration').val(data.duration);
       $('#adContent').val(data.adContent);
    });
}
	
function doPost(){
	$.ajax({
		type: "POST",
		 contentType: "application/json; charset=utf-8",
	     dataType: "json",
	     data: JSON.stringify({duration:$('#duration').val(),adContent:$('#adContent').val() }),
	    url: "http://localhost:9383/SimpleAdServer/services/partnerservice/partners"})
	    .then(function(data) {
			$('#partnerId').val(data.partnerId);
		    $('#duration').val(data.duration);
		    $('#adContent').val(data.adContent);  
		    alert("AdCampain Saved Succesfuly");
		});
	    
	}
