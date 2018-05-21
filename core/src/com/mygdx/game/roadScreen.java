package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class roadScreen extends Stage implements Screen {
    MyGdxGame game;
    Stage stage;
    float screenWidth;
    float screenHeight;
    float X[]=new float[4];
    float Y[]=new float[4];
   FitViewport viewport;
    float ballX;
    float ballY;
    float elapsed=0;
boolean gamestarted=true;
    float timer;
    Background bg;

    public roadScreen(MyGdxGame kids){
        this.game=kids;
        long a = System.currentTimeMillis();
        this.screenWidth=kids.screenWidth;
        this.screenHeight=kids.screenHeight;
        ballX=screenWidth/2;
        ballY=screenHeight/10;
        int index=0;

        viewport = new FitViewport(screenWidth, screenHeight);
        stage = new Stage(new FitViewport(screenWidth, screenHeight));


        Gdx.app.log("1st"," "+X[0]+"   "+Y[0]);
        //timer= bg.gettime();
setUpBackground();

    }
    private void setUpBackground() {
        bg= (new Background(screenWidth,screenHeight));

        stage.addActor(bg);


    }

    @Override
    public void dispose() {

        stage.dispose();
        // Ball.dispose();

    }

    @Override
    public void render(float delta) {
elapsed +=delta;

        if(elapsed>3.89 && gamestarted){
            game.setScreen(new ballScreen(game));
gamestarted=false;
        }
            Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.draw();
            stage.act();
            Gdx.app.log("delta ", "" + delta);
     }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {
    }

}


