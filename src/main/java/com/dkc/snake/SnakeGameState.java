package com.dkc.snake;

import java.util.ArrayList;
import java.util.Random;

import com.dkc.model.Sprite;
import com.dkc.model.State;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.Dot;

public class SnakeGameState extends State {
	ArrayList<BodyPart> bodyParts;
	Dot dot; BodyPart head;
	double lastX; double lastY; double lastXDir; double lastYDir; int lastIndex; int score = 0;
	
	public SnakeGameState()
	{
		head = new BodyPart(246, 246, 0, 1, null);
		sprites.add(head.getSprite());
		dot = new Dot(new Random().nextInt(502), new Random().nextInt(502), null);
		sprites.add(dot.getSprite());
		sprites.add(new Sprite("a", 16, 16, 3, 3)); //background
	}
	
	void spawnNewDot() 
	{
		dot.setX(new Random().nextInt(502));
		dot.setY(new Random().nextInt(502));
		dot.refreshSprite();
	}
	
	void addBody()
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
									lastXDir,lastYDir, null));
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
