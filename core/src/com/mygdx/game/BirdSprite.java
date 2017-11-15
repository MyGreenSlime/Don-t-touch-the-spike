package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by GreenSlime on 15/11/2560.
 */
public class BirdSprite {
    private boolean Check = FALSE;
    private int Speedy = 0;
    private static final int Garvity = 3;
    private float Time = 0;
    private int Flip = 0;
    private int Speedx = 1;
    private int Status =0;
    private Vector2 position;
    public BirdSprite(int x,int y){
        position = new Vector2(x,y);
    }
    public Vector2 getPosition(){
        return position;
    }
    public int getStatus(){
        return Status;
    }
    public void move(float delta) {
        Time += delta;
        position.x += Speedx;
        position.y += Speedy;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Check == FALSE) {
            if (Flip == 0)
                //spriteImg = new Texture("bird2.png");
                Status = 2;
            else
                //spriteImg = new Texture("bird2flip.png");
                Status = 3;
            Speedy = 3;
            position.y += 40;
            Check = TRUE;
            Time = 0;

        }
        if (Time > 0.2) {
            Speedy -= Garvity;
            if (Check) {
                if (Flip == 0)
                    //spriteImg = new Texture("bird1.png");
                    Status = 0;
                else
                    //spriteImg = new Texture("bird1flip.png");
                    Status = 1;
                Check = FALSE;
            }
            Time = 0;
        }
        if (340 - position.x < 0) {
            Speedx *= -1;
            Flip = 1;
            //spriteImg = new Texture("bird1flip.png");
            Status = 1;
        } else if (position.x < 0) {
            Speedx *= -1;
            Flip = 0;
            //spriteImg = new Texture("bird1.png");
            Status = 0;
        }
    }
}