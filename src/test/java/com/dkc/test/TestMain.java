package com.dkc.test;

import com.dkc.snake.util.SnakeMath;

//public class TestMain extends Application
//{
//    Controller controller;
//    protected GraphicsContext graphicsContext;
//    Group rootGroup;
//    Scene scene;
//    Canvas canvas;
//    InputHandler inputHandler;
//
//    public void start(Stage stage) {
//        stage.setTitle("Test");
//        rootGroup = new Group();
//        scene = new Scene(rootGroup);
//        canvas = new Canvas(320, 320);
//        rootGroup.getChildren().add( canvas );
//        graphicsContext = canvas.getGraphicsContext2D();
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.sizeToScene();
//        stage.show();
//        try {
//            drawSprite();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void drawSprite() throws IOException {
//        Sprite sprite = new Sprite("Snake", 16, 16, 0, 0);
//        Image image = sprite.getImage();
//        ImageView iv = new ImageView(image);
//        iv.setRotate(180);
//        SnapshotParameters params = new SnapshotParameters();
//        params.setFill(Color.TRANSPARENT);
//        Image rotatedImage = iv.snapshot(params, null);
//        graphicsContext.drawImage(rotatedImage, 0, 0);
//    }
//}

class TestMain
{
    public static void main(String[] args)
    {
        double x1 = 0; double y1 = 0;
        double x2 = -1; double y2 = 0;
//        double angle = Math.toDegrees( Math.atan2(y2 - y1, x2 - x1));
//		if (angle < 0) angle += 360; if (angle >360) angle -= 360;
//		angle += 90; if (angle < 0) angle += 360; if (angle >360) angle -= 360;
//        System.out.println("Angle: " + angle + "\n" );

        double changeInX = x2-x1; double changeInY = y2-y1;
        double angle = SnakeMath.toAngle(changeInY, changeInX);
		if (angle < 0) angle += 360; if (angle > 360) angle -= 360;
		System.out.println("Angle: " + angle + "\n" );
    }
}