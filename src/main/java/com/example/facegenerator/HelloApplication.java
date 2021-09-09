package com.example.facegenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.Random;

import java.io.IOException;

public class HelloApplication extends Application {
    static Canvas canvas = new Canvas(650, 700);
    static GraphicsContext gc = canvas.getGraphicsContext2D();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void start(Stage stage) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // This
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0,0,600,600);
        root.getChildren().add(canvas);
        // To that
        System.out.println("What kind of face would you like?\n1. : Selective face.\n2. : Random face.");
        while(true){
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch(userChoice){
                case 1:
                    drawSelectiveFace();
                    stage.show();
                    break;
                case 2:
                    drawRandomFace();
                    stage.show();
                    break;
                default:
                    System.out.println("Invalid argument.");
            }
        }

    }


    public static void drawSelectiveFace() {
        //drawSelectiveFaceColor();
        // scanner.nextLine();
        System.out.println("How big do you want the head?\n1. : BIG\n2. : MEDIUM\n3. : SMALL");
        drawSelectiveShape(scanner.nextLine());
        System.out.println("How big would you like the mouth?\n1. : BIG\n2. : MEDIUM\n3. : SMALL");
        drawSelectiveMouth(scanner.nextLine());
    }

    public static void drawRandomFace() {
        drawRandomShape();
        drawRandomFaceColor();
        drawRandomMouth(50);
        drawRandomEyes();
    }

        // Selective methods //
        //////////////////////


    // Drawing head
    /*
    public static void drawSelectiveShape(String headSize) {
        gc.setFill(Color.BEIGE);
        boolean loopBreaker = true;
        while(loopBreaker) {
            if (headSize.equalsIgnoreCase("BIG") || headSize.equals("1")) {
                gc.strokeOval(150, 150, 300, 300);
                gc.fillOval(150, 150, 300, 300);
            } else if (headSize.equalsIgnoreCase("MEDIUM") || headSize.equals("2")) {
                gc.strokeOval(150, 150, 250, 250);
                gc.fillOval(150, 150, 250, 250);
            } else if (headSize.equalsIgnoreCase("SMALL") || headSize.equals("3")) {
                gc.strokeOval(150, 150, 200, 200);
                gc.fillOval(150, 150, 200, 200);
            } else if (headSize != "BIG" || headSize != "MEDIUM" || headSize != "SMALL" || headSize != "1" || headSize != "2" || headSize != "3") {
                System.out.println("u suck");
            }
        }
    }
     */

    public static void drawSelectiveShape(String headSize) {
        switch(headSize){
            case "BIG":
                break;
            case "MEDIUM":
                break;
            case "SMALL":
                break;
            default:
                System.out.println("Invalid argument");
                drawSelectiveFace();
        }
    }


    // Drawing mouth
    public static void drawSelectiveMouth(String mouthSize) {
        gc.setFill(Color.BLACK);
        if(mouthSize.equalsIgnoreCase("BIG") || mouthSize.equals("1")){
            gc.fillOval(280, 370, 75, 75);
        }
        else if(mouthSize.equalsIgnoreCase("MEDIUM") || mouthSize.equals("2")){
            gc.fillOval(280,370,50,50);
        }
        else if(mouthSize.equalsIgnoreCase("SMALL") || mouthSize.equals("3")){
            gc.fillOval(280,370,25,25);
        }
        else{
            gc.fillOval(280,370,100,100);
        }

    }

    // Drawing eyes
    public static void drawSelectiveEyes(String leftEye, String rightEye) {
        gc.setFill(Color.BLACK);
        // Left eye
        gc.fillOval(220,220,100, 100);
        // Right eye
        gc.fillOval(360,220,100,100);
    }

    // Drawing nose
    public static void drawSelectiveNose() {
    //    gc.setFill(Color.BEIGE);
    //    gc.fillOval(150, 150, 300, 300);
    }

    // Drawing hair


        // Random methods //
        ///////////////////

    public static void drawRandomShape() {
            gc.strokeOval(150, 150, 300, 300);
        }

    public static void drawRandomMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        gc.fillOval(280,370,mouthSize,mouthSize);
    }

    public static void drawRandomEyes() {
        gc.setFill(Color.BLACK);
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
    }

    public static void drawRandomFaceColor() {
        gc.setFill(Color.BEIGE);
        gc.fillOval(150, 150, 300, 300);
    }

        // Main
    public static void main(String[] args) {
        launch();
    }
}