package me.finlayson.ryan.framework.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import me.finlayson.ryan.game.state.State;

public class InputHandler implements KeyListener, MouseListener {

	//create InputHandlers own currentState variable to receive user input
	private State currentState;
	
	public void setCurrentState(State currentState){
		this.currentState = currentState;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		currentState.onClick(e); //calls the currentState's own version of this method from State superclass
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentState.onKeyPress(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentState.onKeyRelease(e);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
