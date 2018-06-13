package com.dkc.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dkc.controller.Controller;
import com.dkc.engine.State;
import com.dkc.snake.util.BodyPart;
import com.dkc.snake.util.SnakeMath;;

public class SnakeGameController extends Controller {
	SnakeGameModel model;
	ArrayList<BodyPart> body = model.getBody();
	BodyPart head = model.getHead(); 
	double degree;
	static final int CHANGEINDEGREES = 5;
	
	public SnakeGameController(SnakeGameModel sgm) { model = sgm; }
	
	public State tick(List<String> input) throws IOException {
		updateSnake(input);
		checkDotCollision();
		if (checkLoss()) nextState = null; //change to loss output
		return nextState;
	}
	
	private void checkDotCollision() throws IOException {
		model.spawnNewDot();
		model.addBody();
	}

	private boolean checkLoss() {
		return false;
	}

	void updateSnake(List<String> input)
	{
		//change to update degrees
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
			degree = SnakeMath.toDegrees(head.getXDir(), head.getYDir()) + CHANGEINDEGREES;
			head.setDir(SnakeMath.degreesToX(degree), SnakeMath.degreesToY(degree));
		}
		if (input.contains("VK_RIGHT")) 
		{
			degree = SnakeMath.toDegrees(head.getXDir(), head.getYDir()) - CHANGEINDEGREES;
			head.setDir(SnakeMath.degreesToX(degree), SnakeMath.degreesToY(degree));
		}
	}
}
