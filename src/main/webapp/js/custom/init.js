var path = "ws://" + window.location.host + "/"
		+ window.location.pathname.split("/")[1];
var webSocket = new WebSocket(path + "/websocket");
webSocket.onopen = function(event) {
	onOpen(event);
}
webSocket.onerror = function(event) {
	onError(event);
}
webSocket.onmessage = function(event) {
	onMessage(event);
}
webSocket.onclose=function(event){
	onClose(event);
}
function onOpen(event) {
	alert("与服务器建立连接!");
}
function onError(event) {
	alert("出错啦!");
}
function onClose(event){
	alert("与服务器断开连接!");
}

function onMessage(event) {
	var data=JSON.parse(event.data);
	//接收在线用户列表
	 if(data.type==1){
		 $("#online_user_num").html(data.content.length);
		 var str="";
		 $.each(data.content,function(){
			 str+='<li class="li'+this.userId+'">'+this.userName+"</li>";
		 });
		 $("#hallperson").html(str);
	 }else if(data.type==2){
		 //接收刚登录的用户信息
		 var user=data.content;
		 var str=user.userName+"   上线了。。。<br/>";
		 $("#out").append(str);
		 
		 str='<li class="li'+user.userId+'">'+user.userName+"</li>";
		 $("#hallperson").append(str);
		 var num=Number($("#online_user_num").html())+1;
		 $("#online_user_num").html(num);
	 }else if(data.type==3){
		 //接收用户发送到大厅的消息
		 var record=data.content;
		 var str="<p><em>"+record.sendTime+"</em> "+record.senderName+":"+AnalyticEmotion(record.text)+"</p>";
		 $("#out").append(str);
	 }else if(data.type==4){
		 //接收离线的用户信息
		 var user=data.content;
		 var str="<p>"+user.userName+" 下线了。。。</p>";
		 $("#out").append(str);
		 
		 //在线人数减一
		 var num=Number($("#online_user_num").html())-1;
		 $("#online_user_num").html(num);
		 $("#hallperson .li"+user.userId).remove();
	 }
}
