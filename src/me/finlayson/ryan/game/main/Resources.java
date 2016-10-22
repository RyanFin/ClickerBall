package me.finlayson.ryan.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
	
	public static BufferedImage welcome, iconimage, line, help;
	public static AudioClip hit, bounce, menuSelect;
	public static Color darkBlue, darkGreen;
	
	public static void load(){ 
	//'static' means that the 'resources' object does not have to be initialised in order to use the load method
	//e.g. Resources r = new Resources(), r.load(); is not needed. you can just use the load method without 'r'
		
		welcome = loadImage("welcome.png");
		help = loadImage("HelpState.png");
		iconimage = loadImage("iconimage.png");
		line = loadImage("line.png");
		hit = loadSound("hit.wav");
		bounce = loadSound("bounce.wav");
		menuSelect = loadSound("menu_select.wav");
		
		darkBlue = new Color(10,38,112);
		darkGreen = new Color(43,106,77);
			
	}
	
	//create auxiliary methods loadSound() and loadImage()
		private static AudioClip loadSound(String filename){
			URL fileURL = Resources.class.getResource("/resources/"+ filename);
			return Applet.newAudioClip(fileURL);
			
		}
		
		private static BufferedImage loadImage(String filename){
			BufferedImage img = null;
			try {
				
				img = ImageIO.read(Resources.class.getResourceAsStream("/resources/"+filename));
			} catch (Exception e) {
				System.out.println("Error while reading:"+ filename);
				e.printStackTrace();
			}
			return img;
		}
		
	}


