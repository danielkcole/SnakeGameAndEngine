package com.dkc.snake;

import com.dkc.view.View;

public class SnakeGameView extends View
{
	@Override
	public void render()
	{
		drawScore( ((SnakeGameModel) model).getScore() );
		if ( ((SnakeGameModel) model).getWonLost() == 1) drawWin();
		else if ( ((SnakeGameModel) model).getWonLost() == -1) drawLose();
	}
	
	private void drawScore(int score) { graphicsContext.fillText("" + score, 10, 10); }

	private void drawLose() { graphicsContext.fillText("You Lose!", 100, 100); }
	
	private void drawWin() { graphicsContext.fillText("You Win!", 100, 100); }
}
