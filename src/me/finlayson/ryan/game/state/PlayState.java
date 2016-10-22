package me.finlayson.ryan.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.finlayson.ryan.game.main.GameMain;
import me.finlayson.ryan.game.main.Resources;
import me.finlayson.ryan.game.model.Ball;
import me.finlayson.ryan.game.model.Paddle;

public class PlayState extends State {

	private Paddle paddleLeft, paddleRight;
	private final int PADDLE_WIDTH = 15, PADDLE_HEIGHT = 60;
	private Font scoreFont;
	private int playerScore = 0; //represents the score;
	private Ball ball;
	private static final int BALL_DIAMETER = 20;
	
	
	@Override
	public void init() {
		// load objects for gameplay here!
		
		paddleLeft = new Paddle(0,195,PADDLE_WIDTH,PADDLE_HEIGHT); //(x,y,w,h)
		paddleRight = new Paddle(785,195,PADDLE_WIDTH,PADDLE_HEIGHT);
		scoreFont = new Font("SansSerif",Font.BOLD,25);
		ball = new Ball(300,200,BALL_DIAMETER,BALL_DIAMETER);
	
	}

	@Override
	public void update() {
		paddleLeft.update();
		paddleRight.update();
		ball.update();
		
		if(ballCollides(paddleLeft)){
			playerScore++;
			ball.onCollideWith(paddleLeft);
			Resources.hit.play();
		} else if(ballCollides(paddleRight)){
			playerScore++;
			ball.onCollideWith(paddleRight);
			Resources.hit.play();
		}else if(ball.isDead()){
			playerScore -= 3;
			ball.reset();
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Resources.darkBlue); //select color
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT); //paint
		g.setColor(Resources.darkGreen); //set colour first before drawing (fillRect) rectangle block
		g.fillRect(GameMain.GAME_WIDTH/2, 0, GameMain.GAME_WIDTH/2, GameMain.GAME_HEIGHT); //(x,y,w,h);
		
		//Draw Line Separator
		g.drawImage(Resources.line, (GameMain.GAME_WIDTH/2)-2, 0 , null);
		
		//Draw Paddles on-screen
		g.setColor(Color.WHITE);
		g.fillRect(paddleLeft.getX(), paddleLeft.getY(), PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(paddleRight.getX(), paddleRight.getY(), PADDLE_WIDTH, PADDLE_HEIGHT);
		
		//draw ball
		g.drawRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
				
		//Draw UI
		g.setFont(scoreFont);
		g.drawString(""+playerScore, 350, 40);
		
		
		
		
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			System.out.println("Up Pressed...");
			paddleLeft.accelUp();
			paddleRight.accelDown();
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("Down Pressed....");
			paddleLeft.accelDown();
			paddleRight.accelUp();
		}
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		//determine which key was released
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("key released");
			paddleLeft.stop();
			paddleRight.stop();
		}
		
	}
	
	public boolean ballCollides(Paddle p){
		return ball.getRect().intersects(p.getRect());
	}

}
