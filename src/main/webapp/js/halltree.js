// JavaScript Document
$(document).ready(function() {
    $("#personhall").click(function(){
		$("#hallperson").slideToggle("slow");
		$("#phimg1").toggle();
		$("#phimg2").toggle();
	})
});

$(document).ready(function() {
    $("#friendsmy").click(function(){
		$("#myfriends").slideToggle("slow");
		$("#mfimg1").toggle();
		$("#mfimg2").toggle();
	})
});

