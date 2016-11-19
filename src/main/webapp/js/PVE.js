// JavaScript Document

//选项卡
$(document).ready(function() {
    $("#room").click(function(){
		$("#roommessage").show();
		$("#friendsmessage").hide();
	})
});
$(document).ready(function() {
    $("#friends").click(function(){
		$("#roommessage").hide();
		$("#friendsmessage").show();
	})
});
