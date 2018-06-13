package com.dkc.snake;

import java.util.List;

import com.dkc.view.Sprite;
import com.dkc.view.View;

@SuppressWarnings("restriction")
public class SnakeGameView extends View {
	final static int HEIGHT = 320;
	final static int WIDTH = 320;
	static final String WINDOWNAME = "Snake";
	
	public SnakeGameView() {
		super(HEIGHT, WIDTH, WINDOWNAME);
	}
	
	public void play() {launch();}

	@Override
	public void render() { // default implementation ignored 
	}

	public void render(Sprite backGround, List<Sprite> sprites, int score) 
	{
		graphicsContext.clearRect(0, 0, HEIGHT,WIDTH);
		fillBackground( backGround );
		drawSprites( sprites );
		drawScore( score );
	}
	
	
	void drawScore(int score) { graphicsContext.fillText("" + score, 0, 0); }

	public void drawLose() { graphicsContext.fillText("You Lose!", 10, 10); }
	
	public void drawWin() { graphicsContext.fillText("You Win!", 10, 10); }
}
