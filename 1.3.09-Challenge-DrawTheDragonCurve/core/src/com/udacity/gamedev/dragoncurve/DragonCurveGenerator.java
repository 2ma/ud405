package com.udacity.gamedev.dragoncurve;

import com.badlogic.gdx.math.Vector2;

import java.util.Collections;
import java.util.LinkedList;

import static com.udacity.gamedev.dragoncurve.DragonCurveGenerator.Direction.LEFT;
import static com.udacity.gamedev.dragoncurve.DragonCurveGenerator.Direction.RIGHT;
import static com.udacity.gamedev.dragoncurve.DragonCurveGenerator.Direction.turn;

public class DragonCurveGenerator {

    enum Direction {
        LEFT,
        RIGHT;

        public static Vector2 turn(Vector2 heading, Direction turn) {
            Vector2 newHeading = new Vector2();
            switch (turn) {
                case LEFT:
                    newHeading.x = -heading.y;
                    newHeading.y = heading.x;
                    break;
                case RIGHT:
                    newHeading.x = heading.y;
                    newHeading.y = -heading.x;
            }
            return newHeading;
        }
    }

    static LinkedList<Direction> dragonTurns(int recursions) {
        LinkedList<Direction> turns = new LinkedList<Direction>();
        turns.add(Direction.LEFT);

        for (int i = 0; i < recursions; i++) {
            LinkedList<Direction> rev = new LinkedList<>();
            rev.addAll(turns);
            Collections.reverse(rev);

            turns.add(Direction.LEFT);

            for (Direction d : rev) {
                switch (d) {
                    case LEFT: {
                        turns.add(RIGHT);
                        break;
                    }
                    case RIGHT: {
                        turns.add(LEFT);
                        break;
                    }
                }
            }
        }
        return turns;
    }

    static float[] generateDragonCurve(int width, int height, int recursions) {

        LinkedList<Direction> turns = DragonCurveGenerator.dragonTurns(recursions);

        Vector2 head = new Vector2(width / 2, height / 2);
        Vector2 heading = new Vector2(5, 0);

        float[] curve = new float[(turns.size() + 1) * 2];

        int i = 0;
        curve[i++] = head.x;
        curve[i++] = head.y;

        for (Direction d : turns) {
            heading = turn(heading, d);
            head.x += heading.x;
            head.y += heading.y;
            curve[i++] = head.x;
            curve[i++] = head.y;
        }

        return curve;

    }


}
