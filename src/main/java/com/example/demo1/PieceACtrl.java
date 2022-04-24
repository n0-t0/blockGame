package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;

public class PieceACtrl {
    private PieceA self;
    private int x = 0;
    private int y = 0;
    private int mouseX=0;
    private int mouseY=0;
    private FXMLLoader fxmlLoader;

    private Node game;
    private Bounds gameBounds;
    private double gamePaneOffsetX;
    private double gamePaneOffsetY;
    private double mouseInGameX;
    private double mouseInGameY;
    private Slot slot;


    @FXML
    void initialize() {

        System.out.println("initialized PieceACtrl!");

        self.setOnMouseDragged(event -> {
            self.setLayoutX(x+event.getSceneX()-mouseX);
            self.setLayoutY(y+event.getSceneY()-mouseY);
//            System.out.println("@("+(x+event.getSceneX()-mouseX)+","+(y+event.getSceneY()-mouseY)+")");
        });

        self.setOnMousePressed(event -> {
            mouseX = (int) event.getSceneX();
            mouseY = (int) event.getSceneY();
            x = (int)self.getLayoutX();
            y = (int)self.getLayoutY();

            self.requestFocus();
        });

        self.setOnMouseReleased(event -> {
            this.game = self.getParent().getParent();
            this.gameBounds = game.getBoundsInParent();
            this.gamePaneOffsetX = gameBounds.getMinX();
            this.gamePaneOffsetY = gameBounds.getMinY();
            System.out.println(gamePaneOffsetX);
            this.mouseInGameX = event.getSceneX() + x - mouseX;
            this.mouseInGameY = event.getSceneY() + y - mouseY;
            System.out.println("Released @"+"("+mouseInGameX+","+mouseInGameY+")");

            slot = DistLogic.move(self, DistLogic.getSlot(mouseInGameX, mouseInGameY));

            mouseX = 0;
            mouseY = 0;
        });

        self.setOnKeyPressed(event -> {
            System.out.print("pressed: ");
            switch(event.getCode()) {
                case ENTER:
                    System.out.println("Enter");
                    break;
                case A:
                    System.out.println("A");
                    self.setRotate(self.getRotate()-90);
                    break;
                case D:
                    System.out.println("D");
                    self.setRotate(self.getRotate()+90);
                    break;
                case S:
                    System.out.println("S");
                    self.setScaleX(self.getScaleX()*(-1));
                    break;
                case W:
                    System.out.println("W");
                    self.setScaleY(self.getScaleY()*(-1));
                    break;
                case LEFT:
                    System.out.println("Left");
                    slot = DistLogic.move(self, DistLogic.left(self, slot));
                    break;
                case RIGHT:
                    System.out.println("Right");
                    slot = DistLogic.move(self, DistLogic.right(self, slot));
                    break;
                case UP:
                    System.out.println("up");
                    slot = DistLogic.move(self, DistLogic.up(self, slot));
                    break;
                case DOWN:
                    System.out.println("Down");
                    slot = DistLogic.move(self, DistLogic.down(self, slot));
                    break;
                default:
                    break;
            }
        });
    }
    public PieceACtrl(PieceA self) {
        this.self = self;
        System.out.println("Constructed PieceACtrl!");
    }
}
