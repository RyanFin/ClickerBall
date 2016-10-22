package me.finlayson.ryan.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.finlayson.ryan.game.main.Resources;


public class MenuState extends State {

	@Override
	public void init() {
		// This stuff occurs during the transition between previous state and this one:
		System.out.println("Entered MenuState");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Resources.welcome,0,0,null); 
		// welcome belongs to the class itself, using the static keyword
		//therefore it does not require an instance variable
		
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// should run menustate at the moment
		System.out.println("OnClick...");
		Resources.menuSelect.play(); //play sound
		setCurrentState(new PlayState());
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		//press 'H' to enter the HelpState
		System.out.println("On KeyPress..."+ e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_H){ //could use 72 rather than 'KeyEvent.VK_H'
			Resources.menuSelect.play(); //play music
			setCurrentState(new HelpState());
		}
		
		//click 'enter' to start game
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ 
			Resources.menuSelect.play(); //play sound
			setCurrentState(new PlayState());
		}
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		System.out.println("On KeyRelease...");
		
	} //inherit from superclass State
	

}
