package com.example.demo1;


import javafx.scene.Node;
import javafx.scene.paint.Color;

public class DistLogic {
    public static final int xlim = 11;
    public static final int ylim = 11;

    static Slot getSlot(double x, double y) {
        if(x%50.0 == 0.0 && y%50.0 == 0.0) {
            return new Slot((int)(x/50.0), (int)(y/50.0));
        } else {
            return new Slot((int)(DistLogic.calcNearByX(x)/50), (int)(DistLogic.calcNearByY(y)/50));
        }
    }
    static double calcNearByX(double x) {
        if(x - ((int)x/50)*50 > 25) {
            return ((int)(x/50))*50.0+50;
        } else {
            return ((int)(x/50))*50.0;
        }
    }
    static double calcNearByY(double y) {
        if(y - ((int)y/50)*50 > 25) {
            return ((int)(y/50))*50.0+50;
        } else {
            return ((int)(y/50))*50.0;
        }
    }
    static Slot move(PieceA piece, Slot slot) {
        // if(registerBoardMap) {node.setLayout} else {node.changeColor}
        if(DistLogic.registerBoardMap(piece, slot)) {
            System.out.println("Move to Slot"+"("+slot.x()+","+slot.y()+")");
            piece.setLayoutX(slot.x()*50);
            piece.setLayoutY(slot.y()*50);
            return slot;
        } else {
            piece.setFill(Color.DARKRED);
            return piece.getSlot();
        }
    }
    static boolean registerBoardMap(PieceA pieceA, Slot slot) {
        // 動けるかの判定
        // 盤面情報を登録
        return true; // debug
    }
    static Slot left(PieceA piece, Slot tmpSlot) {
        if(0 <= tmpSlot.x()-1) {
            return new Slot(tmpSlot.x()-1, tmpSlot.y());
        } else {
            return tmpSlot;
        }
    }
    static Slot right(PieceA piece, Slot tmpSlot) {
        if(xlim >= tmpSlot.x()+1) {
            return new Slot(tmpSlot.x()+1, tmpSlot.y());
        } else {
            return tmpSlot;
        }
    }
    static Slot up(PieceA piece, Slot tmpSlot) {
        if(0 <= tmpSlot.y()-1) {
            return new Slot(tmpSlot.x(), tmpSlot.y()-1);
        } else {
            return tmpSlot;
        }
    }
    static Slot down(PieceA piece, Slot tmpSlot) {
        if(ylim >= tmpSlot.y()+1) {
            return new Slot(tmpSlot.x(), tmpSlot.y()+1);
        } else {
            return tmpSlot;
        }
    }
}
