package com.udacity.gamedev.stickfigure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * <p>
 * In this exercise you'll set up a ShapeRenderer, and use it to draw a stick figure. At minimum,
 * you'll need a circle for the head, and five lines for the torso, arms, and legs.
 * <p>
 * Remember to set up a ShapeRenderer you'll need to declare it, initialize it, and dispose of it.
 * Then to actually use the ShapeRenderer you'll need to start a batch of the appropriate type, draw
 * your shapes, and end the batch.
 * <p>
 * We don't have step-by-step TODOs for this one, since the aim is for you to remember the steps for
 * setting up a ShapeRenderer and be able to set one up on your own. Of course, the solution is
 * available if you run into anything confusing.
 */
public class StickFigure extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private int cX;
    private int cY;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        int h = Gdx.graphics.getHeight();
        int w = Gdx.graphics.getWidth();
        cX = w / 2;
        cY = h * 2 / 3;
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(cX, cY, 90);
        shapeRenderer.rectLine(cX, cY, cX, cY + 200, 20);
        shapeRenderer.rectLine(cX - 5, cY + 150, cX - 50, cY + 100, 10);
        shapeRenderer.rectLine(cX + 5, cY + 150, cX + 50, cY + 100, 10);
        shapeRenderer.rectLine(cX + 5, cY + 200, cX + 50, cY + 300, 10);
        shapeRenderer.rectLine(cX - 5, cY + 200, cX - 50, cY + 300, 10);
        shapeRenderer.end();
    }
}
