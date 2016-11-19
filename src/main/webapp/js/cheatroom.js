window.onload=function(){ //页面加载完毕后，执行下面代码
 var osend=document.getElementById("analytic");//获取发送按钮对象
 var otext=document.getElementById("cheattext");//获取输入框对象
 var ochat_show=document.getElementById("out");//获取显示框div对象
 var omianWindow=document.getElementById("cheat");//获取整个聊天窗口对象
 osend.onclick=function(){//发送按钮点击事件
  if(otext.value==""){//如果输入框内容为空，给出提示内容！
   alert('请输入需要发送的内容！');
  }else{//否则输入框不为空，执行以下发送代码
  var str2=chat_time();//调用时间函数，讲返回值赋给该变量。
  ochat_show.innerHTML = ochat_show.innerHTML+" "+" "+str2+"<br/>"+"<p>"+"0-0:"+otext.value+"</p>";//赋值：输入框内容赋值给显示框，保留原有内容的前提下。
  otext.value="";//点击的时候，输入框内容清空
  };
 //alert(ochat_show.innerHTML);
 };
 
 function chat_time(){//自定义函数 通过时间对象，取得时间。
 var newdate=new Date;//创建时间当前日期对象
 var h=newdate.getHours();//取得当前时间日期对象的小时，并赋值给变量
 var m=newdate.getMinutes();//取得当前时间日期对象的分钟，并赋值给变量
 var s=newdate.getSeconds();//取得当前时间日期对象的秒数，并赋值给变量
 var y=newdate.getFullYear();//取得当前时间日期对象的年份，并赋值给变量
 var M=newdate.getMonth()+1;//取得当前时间日期对象的月份，并赋值给变量
 var d=newdate.getDate();//取得当前时间日期对象的天，并赋值给变量
 if(s>=10)
 {
    var str=""+y+"-"+M+"-"+d+" "+h+":"+m+":"+s;//讲获取的时间日期转换了字符串。
 }
 else
 {
	 var str=""+y+"-"+M+"-"+d+" "+h+":"+m+":"+"0"+s;
 }
 return str;//返回时间格式字符串给函数调用的地方。
     };
//alert(chat_time());
 
};