package me.finlayson.ryan.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.finlayson.ryan.game.main.Resources;

public class HelpState extends State {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.help,0,0,null);
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		//press 'Esc' to go back to the MenuState
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			//play sound
			Resources.menuSelect.play();
			setCurrentState(new MenuState());
		}	
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
