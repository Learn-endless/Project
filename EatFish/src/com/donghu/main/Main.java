package com.donghu.main;

import com.donghu.game.GameWin;

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
