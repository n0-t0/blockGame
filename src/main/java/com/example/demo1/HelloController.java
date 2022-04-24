package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML PieceA pieceA1;
    @FXML PieceA pieceA2;

    public void initialize(URL url, ResourceBundle bundle) {
        System.out.println("HelloCtrl initialized");

        pieceA1.setFill(Color.CYAN);
        pieceA2.setFill(Color.CORAL);
    }
}