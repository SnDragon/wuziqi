// JavaScript Document
//打开创建房间窗口
$(document).ready(function(){
	$("#btcr").click(function(){
		$("#blanks").css({"display":"block"});
    	$("#roomcreat").css({"display":"block"});	
  });
});
//关闭创建房间窗口
$(document).ready(function(){
	$("#btnc").click(function(){
		$("#blanks").css({"display":"none"});
    	$("#roomcreat").css({"display":"none"});	
  });
});



$(document).ready(function(){
	var RoomID = $("input[name='text']").val(); 
	var pattern = $('input[name=pattern][checked]').val();
	var rank = $('input[name=rank][checked]').val();
	var roundtime = $('input[name=roundtime][checked]').val();
	$("#creatroombt").bind("click",function(){
		$("#roomtable").append("<tr><td>'RoomID'</td><td>'pattern'</td><td>等级</td><td>时间</td><td>1</td><td>等待中</td><td><a href='PVP_room.html'><button type='button' id='goto'>进入</button></a></td><td><button type='button' id='goto'>观战</button></td></tr>");	
  });
});

