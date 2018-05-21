package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by user on 5/19/2018.
 */

public class Background extends Actor {
    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed = 100*10;
    float screenHeight;
    float screenWidth;
float elapsed=0 ;
    int count=0;
    float timer;

    //float Rec1[]=new float[2];
    //float Rec2[]=new float[2];
long time=System.currentTimeMillis();
    public Background(float Width,float Height) {
        this.screenHeight=Height;
        this.screenWidth=Width;
       // Gdx.app.log("background","");
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("actions/road1.jpg")));
        textureRegionBounds1 = new Rectangle(0 , 0-screenHeight/2, screenWidth, screenHeight);
        textureRegionBounds2 = new Rectangle(0, 0, screenHeight/2, screenHeight);

    }
    @Override
    public void act(float delta) {
elapsed +=delta;
        //if (elapsed>7){

       // }
        if (leftBoundsReached(delta)) {
    if (count<2)
    {count++;}
if (count==2)
    timer = elapsed;
Gdx.app.log("time"," "+elapsed);
            resetBounds();

        } else {
            updateYBounds(-delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, screenWidth,
                screenHeight);
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, screenWidth,
                screenHeight);
    }

    private boolean leftBoundsReached(float delta) {
        return (textureRegionBounds2.y - (delta * speed)) <= 0;
    }

    private void updateYBounds(float delta) {
        textureRegionBounds1.y += delta * speed;
        textureRegionBounds2.y += delta * speed;
    }

    private void resetBounds() {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(0,screenHeight, screenWidth, screenHeight);


    }
    public float gettime () {


    return timer;}

}

