// JavaScript Document

$(document).ready(function() {
	
	$(document).on("click","#hallperson li,#myfriends li",function(e){
		var leftpos = e.pageX-307;
		var toppos = e.pageY-234;
		$("#personinthehall").css({left:leftpos,top:toppos});
//		alert($(this).attr("val"));
		var userId=$(this).attr("class").slice(2);
		$("#ad_friend_id").val(userId);
		$.ajax({
			type:"GET",
			url:$("#basePath").val()+"/user/"+userId,
			data:{
				userId:$("#userId").val()
			},
			dataType:"json",
			success:function(data){
				if(data.user.userId){
					$("#person_name").html(data.user.userName);
					if(data.user.userIntegral>100){
						$("#person_rank").html("大师");
					}else{
						$("#person_rank").html("草民");
					}
					
					$("#person_score").html(data.user.userIntegral);
					$("#person_wingames").html(data.user.userWinNum);
					var win_num=Number(data.user.userWinNum);
					var lose_num=Number(data.user.userLoseNum);
					var tie_num=Number(data.user.userTieNum);
					var win_rate=win_num==0?0:win_num/(win_num+lose_num+tie_num);
					$("#person_winrate").html(win_rate/10.0+"%");		
					
					if(data.isFriend){
						$("#friendadds").addClass("hide");
						$("#cheatpersonnal").removeClass("hide");
						$("#frienddelete").removeClass("hide");
					}else{
						$("#friendadds").removeClass("hide");
						$("#cheatpersonnal").addClass("hide");
						$("#frienddelete").addClass("hide");
					}
				}
				
			}
		})
		$("#personinthehall").show();
	})
	
	$("#btpsithc").click(function(){
		$("#personinthehall").css({"display":"none"});	
  });
	
	//删除好友
	$("#frienddelete").click(function(){
		$.ajax({
			type:"POST",
			url:$("#basePath").val()+"/friend/removeFriend",
			contentType:"application/json",
			data:JSON.stringify({
				user1Id:$("#userId").val(),
				user2Id:$("#ad_friend_id").val()
			}),
			dataType:"text",
			success:function(data){
				if(data=="success"){
					alert("删除成功");
				}else{
					alert("删除失败");
				}
			}
		});
	});
	//添加好友
	$("#friendadds").click(function(){
		$.ajax({
			type:"POST",
			url:$("#basePath").val()+"/friend/addFriend",
			contentType:"application/json",
			data:JSON.stringify({
				user1Id:$("#userId").val(),
				user2Id:$("#ad_friend_id").val()
			}),
			dataType:"text",
			success:function(data){
				if(data=="success"){
					alert("添加成功");
				}else{
					alert("添加失败");
				}
			}
			
		});
	})
});