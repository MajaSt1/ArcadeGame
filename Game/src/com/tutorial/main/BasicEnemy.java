package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler){
		super(x,y,id);
		
		this. handler=handler;
		
		velX=5;
		velY=5;
	}
	public Rectangle getBounds() {
		return new Rectangle (x,y,16,16);
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		if(y<= 0 || y >= Game.HEIGHT -32) velY *= -1; // convert up/down
		if(x<= 0 || x >= Game.WIDTH -16) velX *= -1; //reverse
		
		handler.addObject(new Trail(x,y,ID.Trail, Color.red, 0.06f, 16, 16, handler));
	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
}
