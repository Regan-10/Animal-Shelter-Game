package base.gameobjects.animals;

import base.gameobjects.Animal;

public class Mouse extends Animal {

    public static final String NAME = "mouse";

    public Mouse(int startX, int startY, int speed) {
        super(NAME, startX, startY, speed, 32);
    }
}
