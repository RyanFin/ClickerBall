package me.finlayson.ryan.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import me.finlayson.ryan.framework.util.InputHandler;
import me.finlayson.ryan.game.state.LoadState;
import me.finlayson.ryan.game.state.State;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable {  //Game is a subclass of Jpanel superclass and implements the Runnable interface
	private int gameWidth;
	private int gameHeight;
	private Image gameImage;
	
	private Thread gameThread;
	private volatile boolean running;
	
	private volatile State currentState; //create a variable to represent the current state of the game
	//volatile means that there can only be ONE instance of this variable in the code
	
	//Create an object of InputHandler class
	private InputHandler inputHandler;
	
	public Game(int gameWidth, int gameHeight) {
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		setPreferredSize(new Dimension(gameWidth, gameHeight));
		setBackground(Color.BLACK);
		setFocusable(true); //keyboard and mouse events now available to our game object
		requestFocus();
	}
	
	public void setCurrentState(State newState){
		System.gc(); // garbage collection
		newState.init(); // calls the init() method of the particular state
		currentState = newState; //sets the current state of the game to the specified new state
		inputHandler.setCurrentState(currentState);
	}
	
	
	//We want the game to start at the LoadState; therefore we require addNotify() method
	@Override
	public void addNotify(){
		super.addNotify();
		initInput();
		setCurrentState(new LoadState());
		initGame();
	}
	
	private void initGame(){
		running = true;
		gameThread = new Thread(this,"Game Thread"); //parameterised constructor initialising new thread called "Game Thread"
		gameThread.start();  //perform run() method
		
	}

	@Override
	public void run() { //multi-tasking. This is the gameThread run
		while(running){
			//update
			currentState.update();
			//render
			prepareGameImage();
 			currentState.render(gameImage.getGraphics());
			repaint();
			
			try {
				Thread.sleep(14);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			
		}
		
		System.exit(0); //end game loop immediately when running becomes false
		
	}
	
	//double buffering
	public void  prepareGameImage(){
		if(gameImage == null){
			gameImage = createImage(gameWidth, gameHeight);
		}
		Graphics g = gameImage.getGraphics(); //prepares off-screen image on 'g' canvas
		g.clearRect(0, 0, gameWidth, gameHeight);// clears empty image
		
	}
	
	public void exit(){
		running = false;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(gameImage == null){
			return;
		}
		g.drawImage(gameImage, 0, 0, null);
	}
	
	public void initInput(){
		inputHandler = new InputHandler();
		addKeyListener(inputHandler); //addKeyListener method is inherited from Panel superclass
		addMouseListener(inputHandler);
		
	}
	
	
	
	

}
