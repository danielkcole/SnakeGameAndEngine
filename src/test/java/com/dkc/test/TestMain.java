package com.dkc.test;

import com.dkc.controller.Controller;
import com.dkc.view.InputHandler;
import com.dkc.view.Sprite;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class TestMain extends Application
{
    Controller controller;
    protected GraphicsContext graphicsContext;
    Group rootGroup;
    Scene scene;
    Canvas canvas;
    InputHandler inputHandler;

    public void start(Stage stage) {
        stage.setTitle("Test");
        rootGroup = new Group();
        scene = new Scene(rootGroup);
        canvas = new Canvas(320, 320);
        rootGroup.getChildren().add( canvas );
        graphicsContext = canvas.getGraphicsContext2D();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
        try {
            drawSprite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void drawSprite() throws IOException {
        Sprite sprite = new Sprite("Snake", 16, 16, 0, 0);
        Image image = sprite.getImage();
        ImageView iv = new ImageView(image);
        iv.setRotate(180);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        graphicsContext.drawImage(rotatedImage, 0, 0);
    }
}