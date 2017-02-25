package br.com.nutriproapp.image;

import java.io.ByteArrayInputStream;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.imgproc.Imgproc.*;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nu.pattern.OpenCV;

public class ImageLab extends Application {

    public Pane root;
    
    public static void main(String[] args) {
        OpenCV.loadLocally();
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new HBox();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        imageProc();
        
        primaryStage.show();
    }
    
    public void imageProc() {
        
        Mat m = Imgcodecs.imread("prato1.jpg");
        addToWindow(m);
        
        Mat gray = new Mat();
        cvtColor(m, gray, COLOR_BGRA2GRAY);
        addToWindow(gray);
        
        Mat blur = new Mat();
        GaussianBlur(gray, blur, new Size(9.0,9.0), 2.0, 2.0);
        addToWindow(blur);
        
        Mat circles = new Mat();
        HoughCircles(blur, circles, CV_HOUGH_GRADIENT, 1.0, 200.0);
        addToWindow(circles);
    }
    

    private void addToWindow(Mat m) {
        Image image = mat2Image(m);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(480);
        root.getChildren().add(imageView);
    }
    
    public Image mat2Image(Mat mat) {
        MatOfByte byteMat = new MatOfByte();
        Imgcodecs.imencode(".bmp", mat, byteMat);
        return new Image(new ByteArrayInputStream(byteMat.toArray()));
    }


    
}
