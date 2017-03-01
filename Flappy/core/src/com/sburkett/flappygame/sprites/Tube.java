package com.sburkett.flappygame.sprites;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Sam on 6/13/2016.
 */
public class Tube
{
    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int GAP = 100;
    private static final int LOWEST_OPENING = 120;


    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Rectangle boundsTop, boundsBottom;
    private Random rand;

    public Tube(float x)
    {
        topTube = new Texture("toptube.png");
        bottomTube = new Texture ("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + GAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x, posTopTube.y - GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBottom = new Rectangle(posBottomTube.x, posBottomTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public void reposition(float x)
    {
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + GAP + LOWEST_OPENING);
        posBottomTube.set(x, posTopTube.y - GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBottom.setPosition(posBottomTube.x, posBottomTube.y);
    }

    public boolean collides(Rectangle player)
    {
        return player.overlaps(boundsTop) || player.overlaps(boundsBottom);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void dipose()
    {
        topTube.dispose();
        bottomTube.dispose();
    }
}
