package me.finlayson.ryan.game.model;

import java.awt.Rectangle;

import me.finlayson.ryan.game.main.GameMain;

public class Paddle {
	
	private int x, y, width, height, velY; //position and dimensions of Paddle object
	private Rectangle rect; //bounding box
	
	private static final int MOVE_SPEED_Y = 4; //constant variable for acceleration purposes
	
	public Paddle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		//bounding box initialisation
		rect = new Rectangle(x, y, width, height); //same position and dimensions to object
		//acceleration variable
		velY = 0;
	}
	
	public void update(){
		y += velY; //or y = y + velY
		
		if(y < 0){
			y = 0;
		}else if(y+ height >GameMain.GAME_HEIGHT ){
			y = GameMain.GAME_HEIGHT - height;
		}
		
		
		updateRect(); //update bounding box rect to the position of the paddle object
	}
	
	private void updateRect(){
		rect.setBounds(x, y, width, height);
	}
	
	public void accelUp(){
		velY += -MOVE_SPEED_Y; //no hard-coded integers, same as  -(4)
	}
	
	public void accelDown(){
		velY += MOVE_SPEED_Y;
	}
	
	public void stop(){
		velY = 0;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	//--Getters--
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Rectangle getRect(){
		return rect;
	}

}
