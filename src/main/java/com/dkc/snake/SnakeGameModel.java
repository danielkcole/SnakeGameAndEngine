package com.dkc.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.dkc.model.Model;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.Dot;
import com.dkc.snake.util.SnakeMath;
import com.dkc.view.Sprite;

public class SnakeGameModel extends Model {
	ArrayList<BodyPart> bodyParts = new ArrayList<>();
	Dot dot; 
	BodyPart head;
	int score = 0;
	int wonLost = 0; // -1 is lost, 0 is still playing, 1 is won
	static final int CHANGEINDEGREES = 5;
	Sprite backGround;
	
	public SnakeGameModel() 
	{
		head = new BodyPart(160, 160, 0, 1);
		dot = new Dot(new Random().nextInt(300), new Random().nextInt(300));
		
		sprites.add(head.getSprite());
		sprites.add(dot.getSprite());
	}
	
	void spawnNewDot() 
	{
		dot.setX(new Random().nextInt(300));
		dot.setY(new Random().nextInt(300));
		dot.refreshSprite();
	}
	
	void addBody()
	{
		double lastX; 
		double lastY; 
		double lastXDir; 
		double lastYDir; 
		int lastIndex;
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
	
	void checkWinLoss() {
		//TODO collision
		if (score >= 100 ) wonLost = 1;
		else if (false) wonLost = -1;
		else wonLost = 0;
	}
	
	void updateSnake()
	{
		//TODO change to update degrees
		for(int i = bodyParts.size()-1; i > 0; i--)
		{
			bodyParts.get(i).move();
			bodyParts.get(i).setDir( bodyParts.get(i-1).getXDir(),
								bodyParts.get(i-1).getYDir());
			bodyParts.get(i).setDegree( bodyParts.get(i-1).getDegree() );
		}
		if ( !bodyParts.isEmpty() )
		{
			bodyParts.get(0).move();
			bodyParts.get(0).setDir( head.getXDir(),
								head.getYDir());
			bodyParts.get(0).setDegree( head.getDegree() );
		}
		head.move();
	}
	
	public void goLeft()
	{
		head.setDegree( head.getDegree() + CHANGEINDEGREES );
		head.setDir(SnakeMath.degreesToX(head.getDegree()), SnakeMath.degreesToY(head.getDegree()));
	}
	
	public void goRight()
	{
		head.setDegree( head.getDegree() - CHANGEINDEGREES );
		head.setDir(SnakeMath.degreesToX(head.getDegree()), SnakeMath.degreesToY(head.getDegree()));
	}
	
	void checkDotCollision() 
	{
		//TODO collision
		if (true)
		{
			spawnNewDot();
			addBody();
		}
	}
	
	public int getScore() { return score; }
	public int getWonLost() { return wonLost; }

	public void tick() {
		checkWinLoss();
		if (wonLost != 0) return;
		updateSnake();
		checkDotCollision();
	}

	@Override
	public void setBackground() {
		try { backGround = new Sprite("Snake", 16, 16, 3, 3); } 
		catch (IOException e) { e.printStackTrace(); }
	}
}
