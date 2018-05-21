package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game  {
    SpriteBatch batch;
    Texture img;
    float screenWidth;
    float screenHeight;
  //  boolean gamestarted = true;
    boolean flag=true;

 //   Timer timer=new Timer();
    boolean road=true;

    public MyGdxGame(int width) {
        screenWidth = width;
        screenHeight = (float) 16 * screenWidth / 9;

    }

    @Override
    public void create() {


        this.setScreen(new roadScreen(this));
        long elapsed= System.currentTimeMillis();


        }

    @Override
    public void render() {
         super.render();
}

    @Override
    public void dispose() {

    }
}
