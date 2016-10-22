package me.finlayson.ryan.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.finlayson.ryan.game.main.GameMain;

public abstract class State { 
	//This superclass State binds the contract for all subclasses. 
	//Will NOT be an actual state in the game
	//ALL methods MUST be implemented in future subclasses
	
	public abstract void init(); //this method is called during the transition to another state
	
	public abstract void update(); //method is called for every iteration/ frame of the game loop
	
	public abstract void render(Graphics g); 
	//method is called to render images to the screen for every frame in game loop 
	
	public abstract void onClick(MouseEvent e); // method receives mouse input from user
	
	public abstract void onKeyPress(KeyEvent e); // method receives key input from users
	
	public abstract void onKeyRelease(KeyEvent e); // method receives key input from users
	
	public void setCurrentState(State newState){
		GameMain.sGame.setCurrentState(newState);
	}
	

}
