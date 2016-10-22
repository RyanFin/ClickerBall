package me.finlayson.ryan.game.model;

import java.awt.Rectangle;

import me.finlayson.ryan.framework.util.RandomNumberGenerator;
import me.finlayson.ryan.game.main.GameMain;
import me.finlayson.ryan.game.main.Resources;

public class Ball {
	
	private int x, y, width, height, velX, velY;
	private Rectangle rect;
	
	public Ball(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		velX = 5;
		velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
		rect = new Rectangle(x,y,width,height);
		//System.out.println("Random Number: "+velY);
	}
	
	public void update(){
		x += velX;
		y += velY;
		correctYCollisions();
		updateRect();
	}
	
	public void correctYCollisions(){
		if (y < 0){
			y = 0;
		}else if(y + height > GameMain.GAME_HEIGHT){
			y = GameMain.GAME_HEIGHT - height;
			
		}else{
			return;
		}
		velY = -velY; //change direction of ball
		Resources.bounce.play(); //play bounce sound
	}
	
	public void updateRect(){
		rect.setBounds(x, y, width, height);
	}
	
	//Misc. Methods
	
	public void onCollideWith(Paddle p){
		if(x < GameMain.GAME_WIDTH / 2){ //left side of screen
			x = p.getX() + p.getWidth();
		}else{ //right side of screen
			x = p.getX() - width;
		}
		velX = -velX;
		velY += RandomNumberGenerator.getRandIntBetween(-2, 3);
	}
	
	public boolean isDead(){
		return (x < 0|| x + width > GameMain.GAME_WIDTH);
	}
	
	public void reset(){
		x = 300;
		y = 200;
		velX = 5;
		velY = RandomNumberGenerator.getRandIntBetween(-4, 5);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getRect() {
		return rect;
	}
	

}
