package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by user on 5/19/2018.
 */

public class ballScreen implements Screen {
    MyGdxGame game;
    Stage stage;
    float screenWidth;
    float screenHeight;
    float X[]=new float[4];
    float Y[]=new float[4];
    private FitViewport viewport;
    private Texture one;
    private Texture two;
    private Texture three;
    private Texture four;
    float elapsed=0;
    float ballX;
    float ballY;
         private Texture road;
    int count=0;
public ballScreen(MyGdxGame kids){
    this.game=kids;

    this.screenWidth=kids.screenWidth;
    this.screenHeight=kids.screenHeight;
    ballX=screenWidth/2;
    ballY=screenHeight/10;
    int index=0;
    viewport = new FitViewport(screenWidth, screenHeight);
    stage = new Stage(new FitViewport(screenWidth, screenHeight));
    Gdx.input.setInputProcessor(stage);
    road=new Texture(Gdx.files.internal("actions/road1.jpg"));
    Image Road=new Image(road);
    Road.setFillParent(true);
    Road.setVisible(true);
    stage.addActor(Road);
    one= new Texture(Gdx.files.internal("actions/one.jpg"));
    two= new Texture(Gdx.files.internal("actions/one.jpg"));
    three= new Texture(Gdx.files.internal("actions/one.jpg"));
    four= new Texture(Gdx.files.internal("actions/one.jpg"));

    float row=screenHeight/10;
    float column=screenWidth/6;

    Image One=new Image(one);
    One.setPosition(column,(screenHeight-row*2));
    X[index]=column;
    Y[index]=(screenHeight-row*2);
    index++;
    stage.addActor(One);
    Image Two=new Image (two);
    Two.setPosition(column*3,(screenHeight-row*2));
    X[index]=column*3;
    Y[index]=(screenHeight-row*2);
    index++;
    stage.addActor(Two);
    Image Three=new Image(three);
    Three.setPosition(column,(screenHeight-row*5));
    X[index]=column;
    Y[index]=(screenHeight-row*5);
    index++;
    stage.addActor(Three);
    Image Four=new Image (four);
    Four.setPosition(column*3,(screenHeight-row*5));
    X[index]=column*3;
    Y[index]=(screenHeight-row*5);
    stage.addActor(Four);

    Gdx.app.log("1st"," "+X[0]+"   "+Y[0]);
    index++;
    Texture ball=new Texture(Gdx.files.internal("actions/ball.png"));
    Image Ball=new Image(ball);

    Ball.setPosition(ballX,ballY);
    stage.addActor(Ball);
    Ball.setName("ball");
   // move();
//Listners on every object
    One.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

            Gdx.app.log("Input Listener"," "+X[0]);
            //if (count==0){
               move(0);
            //count=1;
        //}
            return true;
        }
    });
    Four.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

            Gdx.app.log("Input Listener"," "+X[3]);
            Gdx.app.log("Input Listener"," "+Y[3]);
            //if (count==0) {
                move(3);
            //count=1;
            //}
            return true;
        }
    });
    Two.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

            Gdx.app.log("Input Listener"," "+X[1]);

                move(1);

            return true;
        }
    });
    Three.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

            Gdx.app.log("Input Listener"," "+X[2]);
            Gdx.app.log("Input Listener"," "+Y[2]);
                move(2);

            return true;
        }
    });

}


//Moving the ball to any tile (Only one jump)
    public void move(int i){
        if(count==0)
        {
         Actor actor=stage.getRoot().findActor("ball");

        SequenceAction sequence=new SequenceAction();

        MoveToAction move=new MoveToAction();
        move.setPosition((X[i]+ballX)/2,(Y[i]+ballY)/2);

        move.setDuration(1);

        ScaleToAction scaler=new ScaleToAction();
        scaler.setScale((float) 2);
        scaler.setDuration(1);

        ParallelAction both=new ParallelAction();
        both.addAction(move);
        both.addAction(scaler);

        MoveToAction move1=new MoveToAction();
        move1.setPosition(X[i],Y[i]);
        move1.setDuration(1);
        ScaleToAction scaler1=new ScaleToAction();
        scaler1.setScale(1);

        scaler1.setDuration(1);
        ParallelAction both1=new ParallelAction();

        both1.addAction(move1);
        both1.addAction(scaler1);

        sequence.addAction(both);
        sequence.addAction(both1);
        actor.addAction(sequence);
    count=1;
    }}
    @Override
    public void dispose() {
        one.dispose();
        two.dispose();
        three.dispose();
        four.dispose();
road.dispose();
        stage.dispose();
        // Ball.dispose();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
        // Gdx.app.log("delta ", "" + delta);



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



