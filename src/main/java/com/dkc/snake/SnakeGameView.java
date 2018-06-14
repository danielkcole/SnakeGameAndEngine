package com.dkc.snake;

import com.dkc.view.View;

public class SnakeGameView extends View {

	@Override
	public void render() { 
		graphicsContext.clearRect(0, 0, canvasHeight, canvasWidth);
		fillBackground( model.getBackground() );
		drawSprites( model.getSprites() );
		drawScore( ((SnakeGameModel) model).getScore() );
		if ( ((SnakeGameModel) model).getWonLost() == 1) drawWin();
		else if ( ((SnakeGameModel) model).getWonLost() == -1) drawLose();
	}
	
	void drawScore(int score) { graphicsContext.fillText("" + score, 0, 0); }

	public void drawLose() { graphicsContext.fillText("You Lose!", 10, 10); }
	
	public void drawWin() { graphicsContext.fillText("You Win!", 10, 10); }
}
