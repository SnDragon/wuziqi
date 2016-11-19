/**
 * Created by Administrator on 2016/10/27.
 */

//定义参数
var canvas=document.getElementById('canvas');
var cxt=canvas.getContext('2d');
var img_b=new Image();
img_b.src ="images/b.png";
var img_w=new Image();
img_w.src="images/w.png";

//格子之间的间隔
const INTERVAL =45;
//棋盘边距离
const MARGIN = 35;
//边数 棋盘用15*15
const EDGR_NUM = 15;

//define chess type
const BLACK = 1;
const WHITE = -1;
const EMPTY = 0;

var player = BLACK;//轮到哪方下棋
var isWell = false;//是否结束


class Move{
    constructor(x,y, ...rest){
    this.x = x;
    this.y = y;
    this.owner = rest[0];
}
}

class Borad{

    constructor(EDGR_NUM){
        //为悔棋服务
        this.chesslist=[];

        this.chessData = new Array(EDGR_NUM);
        //这个为棋盘的二维数组用来保存棋盘信息，初始化0为没有走过的，1为白棋走的，2为黑棋走的
        for (var x = 0; x < EDGR_NUM; x+=1)
        {
            this.chessData[x] = new Array(EDGR_NUM);
            for (var y = 0; y < EDGR_NUM; y+=1)
            {
                this.chessData[x][y] = EMPTY;
            }
        }

        this.drawboard();

    }

    //检查当前位子是否有子
    isEmpty(move) {
    return !  this.chessData[move.x][move.y];
    }

    //绘制棋盘的线
     drawboard(){
        for (var i = MARGIN; i < MARGIN+INTERVAL*(EDGR_NUM); i += INTERVAL) {
            cxt.beginPath();
            cxt.moveTo(MARGIN, i);
            cxt.lineTo(MARGIN+INTERVAL*(EDGR_NUM-1), i);
            cxt.closePath();
            cxt.stroke();
            cxt.beginPath();
            cxt.moveTo(i, MARGIN);
            cxt.lineTo(i, MARGIN+INTERVAL*(EDGR_NUM-1));
            cxt.closePath();
            cxt.stroke();
        }
    }

    drawchess(move){
        if(move.owner == BLACK)
            var img = img_b;
        else
            var img = img_w;
        cxt.drawImage(img,move.x*INTERVAL+MARGIN/2,move.y*INTERVAL+MARGIN/2);
    }

    savechess(move) {
        if (! this.isEmpty(move)) {//判断该位置是否被下过了
            alert("该位置已经有子，你不能在这个位置下棋");
            return false;
        }
        this.chessData[move.x][move.y] = move.owner;

        this.drawchess(move);

        this.chesslist.push(move);
        if (this.isWin(move)){
            alert(player+"获胜")
        }
        return true;
    }

    isWin(move){
        var player = move.owner;
        var count = 1;
        //检查横
        for(var i=1;i<5;i++){
            if (move.x-i<0 || this.chessData[move.x-i][move.y] != player)
                break;
            count++;
        }
        for(var i=1;i<5;i++){
            if (move.x+i>=EDGR_NUM||this.chessData[move.x+i][move.y]!= player)
                break;
            count++;
        }
        if (count>=5) return 1;

        //检查竖
        count = 1;
        for(var i=1;i<5;i++){
            if (move.y-i<0 || this.chessData[move.x][move.y-i] != player)
                break;
            count++;
        }
        for(var i=1;i<5;i++){
            if (move.y+i>=EDGR_NUM||this.chessData[move.x][move.y+i] != player)
                break;
            count++;
        }
        if (count>=5) return 1;

        //检查左斜
        count = 1;
        for(var i=1;i<5;i++){
            if (move.x+i>=EDGR_NUM||move.y-i<0 ||this.chessData[move.x+i][move.y-i] != player)
            break;
            count++;
        }
        for(var i=1;i<5;i++){
            if (move.x-i<0 || move.y+i>=EDGR_NUM||this.chessData[move.x-i][move.y+i] != player)
                break;
            count++;
        }
        if (count>=5) return 1;

        //检查右斜
        count = 1;
        for(var i=1;i<5;i++){
            if (move.x+i>=EDGR_NUM||move.y+i>=EDGR_NUM||this.chessData[move.x+i][move.y+i] != player)
                break;
            count++;
        }
        for(var i=1;i<5;i++){
            if (move.x-i<0||move.y-i<0 ||this.chessData[move.x-i][move.y-i]!= player)
                break;
            count++;
        }
        if (count>=5) return 1;
        return 0;

    }

    retract(){
        if(! this.chesslist.length){
            alert("当前棋盘没有棋子");
            return 0;
        }
        var move = this.chesslist.pop();
        this.chessData[move.x][move.y] = EMPTY;
        player = move.owner;
        cxt.clearRect(0, 0, 700, 700);
        this.drawboard()
        for (var x of this.chesslist){
            this.drawchess(x);
        }

    }


}

var board = new Borad(EDGR_NUM);


canvas.onclick=function(e){//给canvas添加点击事件
    e=e||event;//获取事件对象
    //获取事件在canvas中发生的位置
    var bbox = canvas.getBoundingClientRect();
    var x=Math.round((e.clientX-bbox.left-MARGIN)/INTERVAL)*INTERVAL+MARGIN;
    var y=Math.round((e.clientY-bbox.top-MARGIN)/INTERVAL)*INTERVAL+MARGIN;

    //如果事件位置在矩形区域中
    if (isWell == true) {
        alert("已经结束了，如果需要重新玩，请刷新");
        return;
    }

    var move = new Move( (x-MARGIN)/INTERVAL,(y-MARGIN)/INTERVAL,player);
    console.log("棋盘坐标"+move.x+"　"+move.y);

    if(! board.savechess(move)) return;
    player = -player;


    // console.log("原生坐标"+(e.clientX-bbox.left-MARGIN)/40+"　"+(e.clientY-canvas.offsetTop- bbox.top-MARGIN)/40);
    // console.log("is empty?:"+isEmpty(human_move));


    }

