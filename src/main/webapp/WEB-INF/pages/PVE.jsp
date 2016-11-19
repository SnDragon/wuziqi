<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String basePath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PVE</title>
	<link href="<%=basePath %>/css/PVE.css" rel="stylesheet" type="text/css">
    <script src="<%=basePath %>/js/jquery-1.8.0.min.js"></script>
</head>

<body>
	<div id="player1">
    <img src="<%=basePath %>/images/u196.jpg" width="150" height="200">
    </div>
    <div id="computer">
    	<img src="<%=basePath %>/images/people3.jpg" width="150" height="200">
    </div>
    <div id="chessboard">
        <canvas id="canvas" width="700" height="700" style = "border:1px solid;background-image:url(images/chessbg.png);background-size:cover; "></canvas>

	    <br>
        <button type="button" id="heqi">和棋</button>|<button type="button" id="huiqi">悔棋</button>|<a href="index.html"><button type="button" id="tuichu">退出</button></a>
    </div>
    <script src="<%=basePath %>/js/chessboard.js"></script>
    <script src="<%=basePath %>/js/interact.js"></script>

	
</body>
</html>
    