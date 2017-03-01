package com.sburkett.flappygame.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sburkett.flappygame.FlappyGame;

/**
 * Created by Sam on 6/13/2016.
 */
public class Menu extends State
{
    private Texture background;
    private Texture playBtn;

    public Menu(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyGame.WIDTH / 2, FlappyGame.HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("menu state disposed.");

    }
}
