package actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by user on 5/18/2018.
 */
public class myScreen implements Screen {
    SpriteBatch batch;
    Texture one;
    Texture two;
    Texture three;
    Texture four;
    int index=0;
    float X[]=new float[4];
    float Y[]=new float[4];

    Stage stage;
    private FitViewport viewport;

    public  MyGdxGame() {
        float screenWidth=1000;
        float screenHeight=1500;
        float ballX=screenWidth/2;
        float ballY=screenHeight/10;
        viewport = new FitViewport(screenWidth, screenHeight);
        //initialising the screen for objects
        stage = new Stage(new FitViewport(screenWidth, screenHeight));
        //	batch = new SpriteBatch();
        one= new Texture("one.jpg");
//cards.add (one);
        two= new Texture("one.jpg");
//		cards.add(two);
        three= new Texture("one.jpg");
//		cards.add(three);
        four= new Texture("one.jpg");
//		cards.add(four);

        float row=screenHeight/10;
        float column=screenWidth/6;

        Image One=new Image(one);
        One.setPosition(column*2,(screenHeight-row));
        X[index]=One.getImageX();
        Y[index]=One.getImageY();
        index++;
        stage.addActor(One);
        Image Two=new Image (two);
        Two.setPosition(column*4,(screenHeight-row));
        X[index]=Two.getImageX();
        Y[index]=Two.getImageY();
        index++;
        stage.addActor(Two);
        Image Three=new Image(three);
        Three.setPosition(column*2,(screenHeight-row)*4);
        X[index]=Two.getImageX();
        Y[index]=Two.getImageY();
        index++;
        stage.addActor(Three);
        Image Four=new Image (four);
        Four.setPosition(column*4,(screenHeight-row)*4);
        X[index]=Four.getImageX();
        Y[index]=Four.getImageY();
        index++;
        stage.addActor(Four);
        One.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //stage.getRoot().removeActor(label);
                //generatenewno();
                one();
                return true;
            }


        });

        Texture ball=new Texture("ball.png");
        Image Ball=new Image(ball);

        Ball.setPosition(ballX,ballY);

        stage.addActor(Ball);
        Ball.setName("ball");
    }

    public void one(){
        Texture smile=new Texture("smile card.png");
        Image Smile=new Image(smile);
        Smile.setPosition(X[0],Y[0]);
    }
    public void move(float ballX,float ballY){
        Actor actor=stage.getRoot().findActor("ball");

        SequenceAction sequence=new SequenceAction();
        MoveToAction move=new MoveToAction();
        move.setPosition((X[0]+ballX)/2,(Y[0]+ballY)/2);
        move.setDuration(1);
        ScaleToAction scaler=new ScaleToAction();
        scaler.setScale(2);
        scaler.setDuration(1);
        sequence.addAction(move);
        sequence.addAction(scaler);
        actor.addAction(sequence);
        stage.addActor(actor);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
    };

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }}
