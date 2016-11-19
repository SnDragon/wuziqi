<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>PVP_hall</title>
    <link href="<%=basePath %>/css/PVP_hall.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/jquery.sinaEmotion.css" />
	<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/jquery.sinaEmotion.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/cheat.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/CreatRoom.js">
	</script>
 	<script type="text/javascript" src="<%=basePath %>/js/halltree.js">
	</script>
	 <script type="text/javascript" src="<%=basePath %>/js/pshow.js">
	</script>
 
</head>
<body>
<div id="roomlist">
<table id="roomtable" >
  <tr id="tablelist">
    <th scope="col">房间名</th>
    <th scope="col">座位</th>
    <th scope="col">进入等级</th>
    <th scope="col">出手时间</th>
    <th scope="col">人数</th>
    <th scope="col">状态</th>
    <th colspan="2" scope="col">操作</th>
  </tr>
  <tr >
    <td>房间01</td>
    <td>随机模式</td>
    <td>无限制</td>
    <td>30s</td>
    <td>1</td>
    <td>等待中</td>
    <td><a href="PVP_room.html"><button type="button" id="goto">进入</button></a></td>
    <td><button type="button" id="goto">观战</button></td>
  </tr>
</table>
</div>
<div id="spanpage">
    <div id="leftspan" ><img src="<%=basePath %>/images/leftspand.png" width="30" height="30" /></div>
    <div id="rightspan"><img src="<%=basePath %>/images/rightspand.png" width="30" height="30" /></div>
    <div id="creatroom">
    	<button type="button" id="btcr">创建房间</button>
    </div>
</div>

    <div id="blanks"></div>
    <div id="roomcreat">

        <form action="#" method="post">
        <h1>创建房间</h1>
        <fieldset>
        <legend>Personal information:</legend>
        房间名：<br />
		<input type="text" name="RoomID" />
        <br />
        <br />
		模式：
		<input type="radio" name="pattern" value="先手" />先手
        <input type="radio" name="pattern" value="后手" />后手
        <input type="radio" name="pattern" value="随机" />随机
        <br />
        <br />
        等级限制：
		<input type="radio" name="rank" value="无限制" />无限制
        <input type="radio" name="rank" value="匹配" />与自身匹配
        <br />
        <br />
        出手时间：
		<input type="radio" name="roundtime" value="15s" />15s
        <input type="radio" name="roundtime" value="30s" />30s
        <input type="radio" name="roundtime" value="60s" />60s
        <br />
        <br />
		<button type="button" id="creatroombt">创建</button>
        
        </fieldset>
        </form>
        <div id="btnclose">
     <img src="<%=basePath %>/images/close.png" id="btnc"/>
    	</div>
    </div>



<div id="cheat">
<form action="">
      <fieldset>
      <legend>cheat:</legend>
                 <div id="out" ></div>
	  <textarea class="emotion" cols="30" rows="1" id="cheattext"></textarea>
      <input id="face" type="button" value="表情" />
      <input id="analytic" type="button" value="发送"/>
   
      </fieldset>
      </form>
</div>

<div id="rightarea">
	<div id="personnalmessage">
		<div id="personnalimg"><img src="<%=basePath %>/images/u196.jpg" width="150" height="200" /></div>
		<div id="personnaltxt"><table  border="0">
  <tr>
    <th scope="row">昵称：</th>
    <td>${user.userName }</td>
  </tr>
  <tr>
    <th scope="row">积分：</th>
    <td>${user.userIntegral }</td>
  </tr>
  <tr>
    <th scope="row">等级：</th>
    <td>大师</td>
  </tr>
  <tr>
    <th scope="row">胜场：</th>
    <td>${user.userWinNum }</td>
  </tr>
  <tr>
    <th scope="row">胜率：</th>
    <td>100%</td>
  </tr>
</table>
		</div>
	</div>
    <div id="hallmassage">
        <div id="hallpersoncircle">
        	<p id="personhall"><img src="<%=basePath %>/images/rightarrow.png"  id="phimg1" /><img src="images/downarrow.png" id="phimg2" />大厅人数（<span id="online_user_num">0</span>）</p>
        	<ul id="hallperson">
            </ul>
            <p id="friendsmy"><img src="<%=basePath %>/images/rightarrow.png"  id="mfimg1" /><img src="images/downarrow.png" id="mfimg2"/>我的好友(<span id="online_friend_num">0</span>/<span id="friend_num">0</span>)</p>
            <ul id="myfriends">
            </ul>
        </div>
        
        
        <div id="exit">
        	<a href="<%=basePath %>/logout" style="color:#FFFFFF;">退出</a>
        </div>
    </div>
</div>


<div id="personinthehall">
    <div id="up">
        <div id="head">
            <img src="<%=basePath %>/images/u492.jpg" width="106" height="106" />
        </div>
        <div >
                昵称：<span id="person_name"></span>
        </div>
        <div >
                等级：<span id="person_rank"></span>
        </div>
    </div> 
    <div id="down">               
        <div >
            积分：<span id="person_score"></span>
        </div>
        <div >
            胜场：<span id="person_wingames"></span>
        </div>
        <div>
            胜率：<span id="person_winrate"></span>
        </div>
     </div>
     <div id="fadd">
     	 <button id="cheatpersonnal" class="hide">私聊</button>
        <button id="friendadds">添加好友+</button>
        <button id="frienddelete" class="hide">删除好友-</button>
     </div>
     <div id="btpsithclose">
    <img src="<%=basePath %>/images/close.png" id="btpsithc"/>
     </div>
     
     <input type="hidden" id="ad_friend_id" value=""/>
</div>




<input type="hidden" id="userId" value="${user.userId }" />
<input type="hidden" id="userName" value="${user.userName }" />
<input type="hidden" id="basePath" value="<%=basePath %>" />

<script type="text/javascript" src="<%=basePath %>/js/custom/init.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		// 绑定表情
		$('#face').SinaEmotion($('.emotion'));
		//请求好友列表
		$.ajax({
			type:"GET",
			url:$("#basePath").val()+"/friend/friendList/"+$("#userId").val(),
			dataType:"json",
			success:function(data){
				if(!data.length){
					return;
				}
				var str="";
				var count=0;
				$.each(data,function(){
					if(this.userStatus==1){
						count++;
					}
					str=str+'<li class="li'+this.userId+'">'+this.userName+'</li>';
				});
				$("#online_friend_num").html(count);
				$("#friend_num").html(data.length);
				$("#myfriends").append(str);
			}
		});
		
		
		
		var obj={
				type:1,//1.用户登录
				content:{
					userId:$("#userId").val(),
					userName:$("#userName").val()
				}
		};
		var userStr=JSON.stringify(obj);
		//webSocket可能还没建立好连接。。。设置循环
		var t=setInterval(function(){
			if(webSocket.readyState==0){
				console.log("wait...");
			}else if(webSocket.readyState==1){
				webSocket.send(userStr);
				clearInterval(t);
			}
		},10);
		
		
		
	});
	
	
	
</script>
    	
</body>
</html>

