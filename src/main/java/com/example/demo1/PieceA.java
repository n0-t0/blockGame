package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class PieceA extends Group {

    @FXML private Rectangle a0;
    @FXML private Rectangle a1;
    @FXML private Rectangle a2;
    @FXML private Rectangle a3;
    @FXML private Rectangle a4;

    private PieceACtrl selfCtrl;
    private Paint paint;
    private Slot slot;

    public void setFill(Paint paint) {
        this.paint = paint;
        for(Node node: this.getChildren()) {
            Rectangle rectangle = (Rectangle) node;
            rectangle.setFill(paint);
        }
    }
    public Slot getSlot() {
        return this.slot;
    }
    void setSlot(Slot slot) {
        this.slot = slot;
    }

    public PieceA() {
        System.out.println("Constructed PieceA!");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pieceA.fxml"));
        fxmlLoader.setRoot(this);
        selfCtrl = new PieceACtrl(this);
        fxmlLoader.setController(selfCtrl);
        try { fxmlLoader.load(); } catch(IOException exception) { throw new RuntimeException(exception); }
    }
    public PieceACtrl getSelfCtrl() {
        return selfCtrl;
    }

}
