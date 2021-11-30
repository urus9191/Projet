package frog;

import util.Case;
import util.Direction;

public interface FrogInf {
    Case getPosition();

    Direction getDirection();

    void move(Direction key);
}
