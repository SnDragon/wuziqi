<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link href="<%=basePath %>/css/index.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath %>/css/custom.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=basePath %>/js/index.js"></script>

</head>
<body>
    <div id="header">
   	 	<div id="pvebutton">
    		<p><a href="PVE.html" ><button type="button" id="button">人机对战</button></a></p>
            </div>
        <div id="pvpbutton">
        	<p><button type="button" id="button" onclick="showLogin()">双人对战</button></p>
            </div>
            <div id="setbutton">
        	<p><button type="button" id="button" onClick="showSetframe()">设置</button></p>
            </div>
            <div id="illustrate">
        	<p><button type="button" id="button" onClick="showIllustrateframe()">规则说明</button></p>
    	</div>
    </div>
    
    <div id="blanks"></div>
    <div id="login">

        <form action="#" method="post">
        <h1>登录</h1>
        <em id="login_fail_em" class="hide">账号或密码不正确</em>
        <fieldset>
        <legend>Personal information:</legend>
        账号：<br />
		<input type="text" name="ID" id="login_account">
        <br />
		密码：<br />
		<input type="text" name="password" id="login_password">
        <br />
        <br />
		<button type="button" style="margin:2px" id="login_button">Log</button>
        <button type="button" style="margin:2px" onclick="showResgister()">Register</button>
        </fieldset>
        </form>
        <div id="btnclose" style="position:absolute;left:93%;top:0%;z-index:5;">
     <img src="<%=basePath %>/images/close.png" onclick="hidediv();"/>
    	</div>
    </div>
    
    <div id="setframe">
    	<div><h1>设置</h1></div>
        <div>
        <input name="难度" type="radio" value="新手" checked>新手
        <input name="难度" type="radio" value="高手">高手
        <input name="难度" type="radio" value="大师">大师
        </div>
        <div id="btnclose" style="position:absolute;left:90%;top:7%;z-index:5;">
     <img src="images/close.png" onclick="hidediv();"/>
    	</div>
    </div>
    
    <div id="illustrateframe">
    	<div><h1 style="text-align:center">规则说明</h1></div>
        <div style="font-size:25px;width:80%;">
        <ul>
        	<li>五子棋专用棋盘为 15×15,盘面有纵横各十五条等距离垂直交叉的平行线构成,共225个交叉点。</li>
			<li>黑先、白后,相互顺序落子。</li>
			<li>最先在棋盘横向、竖向、斜向形成连续的相同色五个棋子的一方为胜</li>
		</ul>
        </div>
        <div id="btnclose" style="position:absolute;left:90%;top:7%;z-index:5;">
     <img src="images/close.png" onclick="hidediv();"/>
    	</div>
    </div>
    
        <div id="resgister">

        <form action="#" method="post">
        <h1>注册</h1>
        <em class="hide">账户已存在</em>
        <fieldset>
        <legend>Personal information:</legend>
        账号：<br />
		<input type="text" name="id" id="register_account">
        <br />
		密码：<br />
		<input type="text" name="password" id="register_pass">
        <br />
        确认密码：<br />
		<input type="text" name="again_password" id="register_again_pass">
        <br />
		<button type="button" style="margin:2px" id="register_button">确认注册</button>
        <button type="button" style="margin:2px"  onclick="showAgLogin()">取消</button>
        </fieldset>
        </form>
        <div id="btnclose" style="position:absolute;left:93%;top:0%;z-index:5;">
     <img src="<%=basePath %>/images/close.png" onclick="hidediv();"/>
    	</div>
    </div>
</body>
<input type="hidden" id="basePath" value="<%=basePath %>" />
<script src="<%=basePath%>/js/jquery-1.8.0.min.js"></script>
<script>
	$("#register_button").click(function(){
		var account=$("#register_account").val();
		var pass=$("#register_pass").val();
		var again_pass=$("#register_again_pass").val();
		//加上判断，账号名是否为空，密码是否一致
		if(pass!=again_pass){
			alert("两次输入的密码不一致");
			return;
		}
		$.ajax({
			type:"POST",
			url:$("#basePath").val()+"/user/doRegister",
			data:{
				account:account,
				pass1:pass,
				pass2:again_pass
			},
			dataType:"text",
			success:function(data){
				if(data=="success"){
					alert("注册成功!");
					showAgLogin()
				}else{
					alert("注册失败!");
				}
			}
		});
	});
	//登录
	$("#login_button").click(function(){
		var account=$("#login_account").val();
		var pass=$("#login_password").val();
		
		//验证账号密码是否为空
		$.ajax({
			type:"POST",
			url:$("#basePath").val()+"/user/doLogin",
			data:{
				account:account,
				pass:pass
			},
			dataType:"text",
			success:function(data){
				if(data=="success"){
					window.location.href=$("#basePath").val()+"/game_hall"
				}else{
					$("#login_fail_em").removeClass("hide");					
				}
			}
		});
		
	});
	
</script>
</html>
