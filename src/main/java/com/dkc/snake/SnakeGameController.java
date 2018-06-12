package com.dkc.snake;

import java.util.ArrayList;
import java.util.List;

import com.dkc.controller.Controller;
import com.dkc.model.State;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.SnakeMath;;

public class SnakeGameController extends Controller {
	SnakeGameState currentState;
	ArrayList<BodyPart> body = currentState.getBody();
	BodyPart head = currentState.getHead();
	final int CHANGEINDEGREE = 5;
	double degree;
	
	public SnakeGameController(SnakeGameState sgs) { currentState = sgs; }
	
	public State tick(List<String> input) {
		updateSnake(input);
		collisions();
		
		nextState = currentState;
		return nextState;
	}

	void collisions()
	{
		if (checkLoseCollision()) ;
		else if (checkDotCollision())
		{
			currentState.spawnNewDot();
			currentState.addBody();
		}
		
	}
	
	private boolean checkDotCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkLoseCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	void updateSnake(List<String> input)
	{
		for(int i = body.size()-1; i > 0; i--)
		{
			body.get(i).move();
			body.get(i).setDir( body.get(i-1).getXDir(),
								body.get(i-1).getYDir());
		}
		body.get(0).move();
		body.get(0).setDir( head.getXDir(),
							head.getYDir());
		head.move();
		if (input.contains("VK_LEFT")) 
		{
			degree = SnakeMath.toDegrees(head.getXDir(), head.getYDir()) + CHANGEINDEGREE;
			head.setDir(SnakeMath.degreesToX(degree), SnakeMath.degreesToY(degree));
		}
		if (input.contains("VK_RIGHT")) 
		{
			degree = SnakeMath.toDegrees(head.getXDir(), head.getYDir()) - CHANGEINDEGREE;
			head.setDir(SnakeMath.degreesToX(degree), SnakeMath.degreesToY(degree));
		}
	}
}
