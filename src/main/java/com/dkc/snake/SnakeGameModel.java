package com.dkc.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.dkc.model.GameObject;
import com.dkc.model.Model;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.Dot;
import com.dkc.snake.util.SnakeMath;
import com.dkc.view.Sprite;

public class SnakeGameModel extends Model
{
	private final ArrayList<BodyPart> bodyParts = new ArrayList<>();
	private final Dot dot;
	private final BodyPart head;
	private int score = 0;
	private int wonLost = 0; // -1 is lost, 0 is still playing, 1 is won
	private static final int CHANGEINANGLE = 5;
	
	public SnakeGameModel() 
	{
		head = new BodyPart(160, 160, 0, 1);
		head.changeToHead();
		dot = new Dot(new Random().nextInt(300), new Random().nextInt(300));
		
		drawableObjects.add(head);
		drawableObjects.add(dot);
	}

	private void spawnNewDot()
	{
		dot.setX(new Random().nextInt(300));
		dot.setY(new Random().nextInt(300));
		score += 10;
	}

	private void addBody()
	{
		double lastX; 
		double lastY; 
		double lastXDir; 
		double lastYDir; 
		//int lastIndex;
		if (bodyParts.isEmpty()) 
		{ 
			lastX = head.getX(); 
			lastY = head.getY();
			lastXDir = head.getXDir();
			lastYDir = head.getYDir();
		}
		else
		{
			int lastIndex = bodyParts.size()-1;
			lastX = bodyParts.get(lastIndex).getX(); 
			lastY = bodyParts.get(lastIndex).getY();
			lastXDir = bodyParts.get(lastIndex).getXDir();
			lastYDir = bodyParts.get(lastIndex).getYDir();
		}
		
		bodyParts.add(new BodyPart( lastX - lastXDir*15,
									lastY + lastYDir*15,
									lastXDir,lastYDir));
		drawableObjects.add( bodyParts.get( bodyParts.size()-1 ) );
	}

	private int checkWinLoss()
	{
		double headCenterX = head.getX() + head.getSprite().getWidth() / 2;
		double headCenterY = head.getY() + head.getSprite().getHeight() / 2;
		double bodyCenterX;
		double bodyCenterY;
		double distance;
		if (score >= 150 ) return 1;
		if (headCenterX < 7 || headCenterX > 314 || headCenterY < 7 || headCenterY > 314) return -1;
		for(int i = bodyParts.size()-1; i > 0; i--)
		{
			bodyCenterX = bodyParts.get(i).getX() + bodyParts.get(i).getSprite().getWidth() / 2;
			bodyCenterY = bodyParts.get(i).getY() + bodyParts.get(i).getSprite().getHeight() / 2;
			distance = Math.hypot(headCenterX - bodyCenterX, headCenterY - bodyCenterY);
			if (distance < 14 && distance > -14) return -1;
		}
		return 0;
	}

	private void updateSnake()
	{
		for(int i = bodyParts.size()-1; i > 0; i--)
		{
			bodyParts.get(i).move();
			double changeInX = bodyParts.get(i-1).getX()-bodyParts.get(i).getX();
			double changeInY = (0-bodyParts.get(i-1).getY()) - (0-bodyParts.get(i).getY());
			double angle = SnakeMath.toAngle(changeInY, changeInX);
			bodyParts.get(i).setDir( SnakeMath.angleToXDir(angle), SnakeMath.angleToYDir(angle) );
			bodyParts.get(i).setAngle(angle);
		}
		if ( !bodyParts.isEmpty() )
		{
			bodyParts.get(0).move();
			double changeInX = head.getX()-bodyParts.get(0).getX();
			double changeInY = (0-head.getY()) - (0-bodyParts.get(0).getY());
			double angle = SnakeMath.toAngle(changeInY, changeInX);
			bodyParts.get(0).setDir( SnakeMath.angleToXDir(angle), SnakeMath.angleToYDir(angle) );
			bodyParts.get(0).setAngle(angle);
		}
		head.move();
	}
	
	public void goLeft()
	{
		head.setAngle( head.getAngle() - CHANGEINANGLE);
		head.setDir(SnakeMath.angleToXDir(head.getAngle()), SnakeMath.angleToYDir(head.getAngle()));
		head.moveH();
	}
	
	public void goRight()
	{
		head.setAngle( head.getAngle() + CHANGEINANGLE);
		head.setDir(SnakeMath.angleToXDir(head.getAngle()), SnakeMath.angleToYDir(head.getAngle()));
		head.moveH();
	}

	private void checkDotCollision()
	{
		double headCenterX = head.getX() + head.getSprite().getWidth()/2;
		double headCenterY = head.getY() + head.getSprite().getHeight()/2;
		double dotCenterX = dot.getX() + dot.getSprite().getWidth()/2;
		double dotCenterY = dot.getY() + dot.getSprite().getHeight()/2;

		double distance = Math.hypot(headCenterX-dotCenterX, headCenterY-dotCenterY);

		if ( distance < 15 && distance > -15 )
		{
			spawnNewDot();
			addBody();
			addBody();
			addBody();
		}
	}

	public void tick()
	{
		wonLost = checkWinLoss();
		if (wonLost != 0) return;
		updateSnake();
		checkDotCollision();
	}

	@Override
	public Sprite setBackground()
	{
		try { return new Sprite("Snake", 16, 16, 3, 3); }
		catch (IOException e) { e.printStackTrace(); }
		return null;
	}

	public int getScore() { return score; }

	public int getWonLost() { return wonLost; }
}
