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
        System.out.println(SnakeMath.angleToXDir(0));
    }
}