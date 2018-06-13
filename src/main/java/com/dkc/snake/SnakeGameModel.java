package com.dkc.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.dkc.model.Sprite;
import com.dkc.model.Model;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.Dot;

public class SnakeGameModel extends Model {
	ArrayList<BodyPart> bodyParts;
	Dot dot; BodyPart head;
	double lastX; double lastY; double lastXDir; double lastYDir; int lastIndex; int score = 0;
	
	public SnakeGameModel() throws IOException
	{
		sprites.add(new Sprite("Snake", 16, 16, 3, 3)); //background
		head = new BodyPart(160, 160, 0, 1);
		sprites.add(head.getSprite());
		dot = new Dot(new Random().nextInt(502), new Random().nextInt(502));
		sprites.add(dot.getSprite());
	}
	
	void spawnNewDot() 
	{
		dot.setX(new Random().nextInt(502));
		dot.setY(new Random().nextInt(502));
		dot.refreshSprite();
	}
	
	void addBody() throws IOException
	{
		if (bodyParts.isEmpty()) 
		{ 
			lastX = head.getX(); 
			lastY = head.getY();
			lastXDir = head.getXDir();
			lastYDir = head.getYDir();
		}
		else
		{
			lastIndex = bodyParts.size()-1;
			lastX = bodyParts.get(lastIndex).getX(); 
			lastY = bodyParts.get(lastIndex).getY();
			lastXDir = bodyParts.get(lastIndex).getXDir();
			lastYDir = bodyParts.get(lastIndex).getYDir();
		}
		
		bodyParts.add(new BodyPart( lastX - lastXDir,
									lastY - lastYDir,
									lastXDir,lastYDir));
		score += 10;
	}
	
	public void tick() 
	{ 
		head.move(); 
		for (BodyPart bp : bodyParts) bp.move(); 
	}
	
	public BodyPart getHead() { return head; }
	public ArrayList<BodyPart> getBody() { return bodyParts; }
}
