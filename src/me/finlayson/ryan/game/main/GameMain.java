package me.finlayson.ryan.game.main;

import javax.swing.JFrame;

public class GameMain {

	
	private static final String GAME_TITLE = "ClickerBall";
	
	public static final int GAME_WIDTH = 800; //800
	public static final int GAME_HEIGHT = 450; //450
	
	public static Game sGame; //Game Variable
	
	public static void main(String[] args){  //(main thread)
		JFrame frame = new JFrame(GAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.err.println("Exiting Window");
			}
			
		});
		*/
		
		//Setup Screen
		sGame = new Game(GAME_WIDTH, GAME_HEIGHT);
		frame.add(sGame); // sets to 'BorderLayout.CENTRE' by default
		frame.setResizable(false);
		frame.pack(); // resize to accommodate the preferred size of its content (set in setPreferredSize() method)	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(Resources.iconimage);
		
	
	}
}
