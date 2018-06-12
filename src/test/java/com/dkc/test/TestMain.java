package com.dkc.test;
import java.io.IOException;
import java.net.URISyntaxException;

import com.dkc.model.Sprite;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class TestMain extends Application {

	final int HEIGHT = 320; final int WIDTH = 320;
	
	
  public static void main(String[] args) { launch(args); }


@Override public void start(Stage primaryStage) throws IOException, URISyntaxException {
    primaryStage.setTitle("Test");
    Group root = new Group();
    Scene scene = new Scene(root);
    Canvas canvas = new Canvas(WIDTH, HEIGHT);
    root.getChildren().add( canvas );
    GraphicsContext gc = canvas.getGraphicsContext2D();
    
    int h = 16; int w = 16;
    String name = "Snake";
    
    Sprite head = new Sprite(name, h, w, 0, 0);
    Sprite body = new Sprite(name, h, w, 0, 3);
    Sprite bg = new Sprite(name, h, w, 3, 3);
    fillBackground(gc, bg);
    drawRotatedImage(gc, head.getImage(), 45, 16, 0);
    drawRotatedImage(gc, body.getImage(), 45, 4, 12);
    
	primaryStage.setScene(scene);
	primaryStage.show();
  }
  
  void drawSprite(Sprite sprite, GraphicsContext gc) 
  { 
	  drawRotatedImage(gc, sprite.getImage(), sprite.getDegree(), sprite.getX(), sprite.getY()); 
  }
  
  private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
      gc.save(); // saves the current state on stack, including the current transform
      rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
      gc.drawImage(image, tlpx, tlpy);
      gc.restore(); // back to original state (before rotation)
  }
  
  private void rotate(GraphicsContext gc, double angle, double px, double py) {
      Rotate r = new Rotate(angle, px, py);
      gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
  }
  
  @SuppressWarnings("unused")
private void fillBackground(GraphicsContext gc, Sprite sprite)
  {
	  for (int i = 0; i < HEIGHT; i+=16) {
		  for (int j = 0; j < WIDTH; j+=16) {
			  gc.drawImage(sprite.getImage(), i, j);
		  }
	  }
  }
}