var game={
	width:640,
	height:360,
	ctx: undefined,
	ball1: undefined,
	rows:4,
	cols:8,
	platform: undefined,
	blocks : [],
	running: true,
	score : 0,
	sprites:{
//		background: undefined,
		platform: undefined,
		ball1: undefined,
		block: undefined,
	},
init: function(){
	var canvas = document.getElementById("mycanvas");
	
	this.ctx = canvas.getContext("2d");
// requestAnimationFrame polyfill
(function() {
  var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame ||                      window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
  window.requestAnimationFrame = requestAnimationFrame;
})();	
	window.addEventListener("keydown",function(e){
		if(e.keyCode == 37){
			game.platform.dx = -game.platform.velocity;
		}else if(e.keyCode == 39){
			game.platform.dx = game.platform.velocity;
		}else if(e.keyCode == 32){
			game.platform.releaseBall();
		}
	});
	window.addEventListener("keyup",function(e){
		game.platform.stop();
	});
	window.addEventListener("mousedown",function(e){
		game.platform.releaseBall();
	});
	window.addEventListener("mousemove",function(e){
		game.platform.moveAt(e.clientX);
	});

	canvas.addEventListener("mouseenter",function(e){
		game.platform.releaseBall();
	});
	canvas.addEventListener("touchstart",function(e){
		game.platform.releaseBall();
	});
	canvas.addEventListener("touchenter",function(e){
		game.platform.releaseBall();
	});
	canvas.addEventListener("touchmove",function(e){
		game.platform.releaseBall();
	});
	
},
	over:function(message){
		this.running = false;
		alert(message);
		window.location.reload();
	},
load: function(){
	for(var key in this.sprites){
		this.sprites[key] = new Image();
		this.sprites[key].src = "images/"+key+".png";
		//console.log(key);
	}
},
create:function(){
	for(var row=0;row<this.rows;row++){
		for(var col=0;col<this.cols;col++){
			this.blocks.push({
			x: 68*col+50,
			y: 38*row+35,
			width: 64,
			height: 32,
			isAlive: true,
			});
	}}
	//blocks
	
},	
start: function(){
	this.init();
	this.load();
	this.create();
	this.run();
},
render:function(){
	this.ctx.clearRect(0, 0, this.width, this.height);
//	this.ctx.drawImage(this.sprites.background, 0, 0);
	this.ctx.drawImage(this.sprites.platform, this.platform.x, this.platform.y);
	this.ctx.drawImage(this.sprites.ball1, this.ball1.x, this.ball1.y);
	this.blocks.forEach(function(element){
		if(element.isAlive){
			this.ctx.drawImage(this.sprites.block, element.x, element.y);
		}
	}, this);
	},
update:function(){
	if(this.ball1.collide(this.platform)){
		this.ball1.bumbPlatform(this.platform);
	}
	if(this.platform.dx){
		this.platform.move();
	}
	if(this.ball1.dx||this.ball1.dy){
		this.ball1.move();
	}
	this.blocks.forEach(function(element){
		if(element.isAlive){
		if(this.ball1.collide(element)){
			this.ball1.bumbBlock(element);
		}
	}
	}, this);
	this.ball1.checkBounds();
	
},	
run:function(){
		this.update();
		this.render();
		if(this.running){
		window.requestAnimationFrame(function(){
			game.run();
		});
		}
	},
};
game.ball1 = {
	width:22,
	height:22,
	frame: 0,
	x:340,
	y:278,
	dx:0,
	dy:0,
	velocity:3,
	move: function(){
		this.x += this.dx;
		this.y += this.dy;
	},
	jump:function(){
		this.dx = -this.velocity;
		this.dy = -this.velocity;
	},
	collide:function(element){
		var x = this.x + this.dx;
		var y = this.y + this.dy;
		if(x+this.width>element.x&&
		  x< element.x+element.width&&
		  y+this.height>element.y&&
		  y< element.y+element.height){
			return true;
		}
		return false;
	},
	bumbBlock:function(block){
		this.dy *= -1;
		block.isAlive = false;
		++game.score;
		if(game.score>=game.blocks.length)
			{game.over("You Win!")}
	},
	onTheLeftSide: function(platform){
		return(this.x+this.width/2)<(platform.x+platform.width/2);
	},
	bumbPlatform:function(platform){
		this.dy = -this.velocity;
	this.dx = this.onTheLeftSide(platform) ? -this.velocity : this.velocity;
	},
	checkBounds:function(){
		var x = this.x + this.dx;
		var y = this.y + this.dy;
		if(x<0){
			this.x=0;
			this.dx = this.velocity;
		}else if(x>game.width){
			this.x=game.width;
			this.dx = -this.velocity;
		}else if(y<0){
			this.y=0;
			this.dy=this.velocity;
		}else if(y>game.height){
			game.over("Game Over!");
		}
	},
};
game.platform = {
	x:300,
	y:300,
	width:104,
	height:25,
	velocity: 6,
	dx:0,
	isMove:false,
	ball1:game.ball1,
	moveAt:function(x1){
		if(x1>this.x && x1<(this.x+this.width)){
			this.isMove = true;
			this.dx = (x1 - this.x-this.width/2)*this.velocity/10;	
			}else{
			this.dx = 0;
		}
	},
	releaseBall:function(){
		if(this.ball1){
			this.ball1.jump();
			this.ball1 = false;
		}
	},
	move: function(){
		if(this.isMove){
		this.x += this.dx;
		if(this.ball1){
			this.ball1.x += this.dx;
		}
		this.isMove  = false;
		}
	},
	stop: function(){
	this.dx = 0;
		if(this.ball1){
			this.ball1.dx = 0;
		}
}
};
window.addEventListener("load",function(){
	game.start();
});

