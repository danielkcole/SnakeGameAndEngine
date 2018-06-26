package com.dkc.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
	private int wonLost = 2; // -1 is lost, 0 is still playing, 1 is won, 2 is start state
	private static final int CHANGEINANGLE = 7;
	private static final int NEWBODYDISTANCE = 15;
	private static final int ADDEDBODIES = 2;
	private static final int FOLLOWDISTANCE = 10;
	private static final int COLLISIONDISTANCE = 15;

	public SnakeGameModel()
	{
		head = new BodyPart(160, 160, 0, 1);
		head.changeToHead();
		dot = new Dot(new Random().nextInt(300), new Random().nextInt(300));
		drawableObjects.add(head);
		drawableObjects.add(dot);

		bodyParts.add(new BodyPart( head.getX() - head.getXDir()*NEWBODYDISTANCE,
				head.getY() + head.getYDir()*NEWBODYDISTANCE,
				head.getXDir(),head.getYDir()));
		bodyParts.get( 0 ).setAngle(head.getAngle());
		drawableObjects.add( bodyParts.get( 0 ) );
		bodyParts.get(0).changeToTail();
		drawableObjects.add(bodyParts.get(0));
	}

	private void spawnNewDot()
	{
		for ( int i = 0; i < ADDEDBODIES; i++) addBody();
		dot.setX(new Random().nextInt(300));
		dot.setY(new Random().nextInt(300));
		score += 10;
	}

	private void addBody()
	{
		int lastIndex = bodyParts.size()-1;
		bodyParts.get(lastIndex).changeToBody();
		double lastX = bodyParts.get(lastIndex).getX();
		double lastY = bodyParts.get(lastIndex).getY();
		double lastXDir = bodyParts.get(lastIndex).getXDir();
		double lastYDir = bodyParts.get(lastIndex).getYDir();
		double lastAngle = bodyParts.get(lastIndex).getAngle();

		bodyParts.add(new BodyPart( lastX - lastXDir*NEWBODYDISTANCE,
				lastY + lastYDir*NEWBODYDISTANCE,
				lastXDir,lastYDir));
		bodyParts.get( lastIndex+1 ).setAngle(lastAngle);
		bodyParts.get( lastIndex+1 ).changeToTail();
		drawableObjects.add( bodyParts.get( lastIndex+1 ) );
	}

	private int checkWinLoss()
	{
		double headCenterX = head.getX() + head.getSprite().getWidth() / 2;
		double headCenterY = head.getY() + head.getSprite().getHeight() / 2;
		double bodyCenterX;
		double bodyCenterY;
		double distance;
		if (score >= 300 ) return 1;
		if (headCenterX < 7 || headCenterX > 314 || headCenterY < 7 || headCenterY > 314) return -1;
		for(int i = bodyParts.size()-1; i > 0; i--)
		{
			bodyCenterX = bodyParts.get(i).getX() + bodyParts.get(i).getSprite().getWidth() / 2;
			bodyCenterY = bodyParts.get(i).getY() + bodyParts.get(i).getSprite().getHeight() / 2;
			distance = Math.hypot(headCenterX - bodyCenterX, headCenterY - bodyCenterY);
			if (distance < COLLISIONDISTANCE && distance > -COLLISIONDISTANCE) return -1;
		}
		return 0;
	}

	private void updateSnake()
	{
		head.move();
		double changeInX = ( head.getX() - ( head.getXDir() * FOLLOWDISTANCE ) ) - bodyParts.get(0).getX();
		double changeInY = ( 0 - head.getY() - ( head.getYDir() * FOLLOWDISTANCE ) ) - (0-bodyParts.get(0).getY());
		double angle = SnakeMath.toAngle(changeInY, changeInX);
		bodyParts.get(0).setDir( SnakeMath.angleToXDir(angle), SnakeMath.angleToYDir(angle) );
		bodyParts.get(0).setAngle(angle);
		bodyParts.get(0).move();
		for(int i = bodyParts.size()-1; i > 0; i--)
		{
			changeInX = ( bodyParts.get(i-1).getX() -
					( bodyParts.get(i-1).getXDir() * FOLLOWDISTANCE ) ) - bodyParts.get(i).getX();
			changeInY = ( 0 - bodyParts.get(i-1).getY() -
					( bodyParts.get(i-1).getYDir() * FOLLOWDISTANCE ) ) - (0-bodyParts.get(i).getY());
			angle = SnakeMath.toAngle(changeInY, changeInX);
			bodyParts.get(i).setDir( SnakeMath.angleToXDir(angle), SnakeMath.angleToYDir(angle) );
			bodyParts.get(i).setAngle(angle);
			bodyParts.get(i).move();
		}
	}

	public void goLeft()
	{
		head.setAngle( head.getAngle() - CHANGEINANGLE);
		head.setDir(SnakeMath.angleToXDir(head.getAngle()), SnakeMath.angleToYDir(head.getAngle()));
	}

	public void goRight()
	{
		head.setAngle( head.getAngle() + CHANGEINANGLE);
		head.setDir(SnakeMath.angleToXDir(head.getAngle()), SnakeMath.angleToYDir(head.getAngle()));
	}

	private void checkDotCollision()
	{
		double headCenterX = head.getX() + head.getSprite().getWidth()/2;
		double headCenterY = head.getY() + head.getSprite().getHeight()/2;
		double dotCenterX = dot.getX() + dot.getSprite().getWidth()/2;
		double dotCenterY = dot.getY() + dot.getSprite().getHeight()/2;
		double distance = Math.hypot(headCenterX-dotCenterX, headCenterY-dotCenterY);
		if ( distance < COLLISIONDISTANCE && distance > -COLLISIONDISTANCE ) spawnNewDot();
	}

	public void tick()
	{
		if ( wonLost == 0 )
		{
			wonLost = checkWinLoss();
			if (wonLost != 0) return;
			updateSnake();
			checkDotCollision();
		}
	}

	public void start () { wonLost = 0; }

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