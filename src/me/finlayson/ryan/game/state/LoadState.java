
package me.finlayson.ryan.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.finlayson.ryan.game.main.Resources;

public class LoadState extends State {

	@Override
	public void init() {
		Resources.load();
		System.out.println("Loaded successfully");
		
	}

	@Override
	public void update() {
		System.out.println("Transitioning from loadState to MenuState");
		setCurrentState(new MenuState()); //setCurrentState from superclass AND game.java
		// creates new menu state and transitions to it + calls init and sets currentState to equal MenuState
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
