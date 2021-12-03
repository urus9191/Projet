package frog;

import gameCommons.Game;
import gameCommons.IFrogInf;
import util.Case;
import util.Direction;

public class FrogInf implements IFrogInf {

    private Case position;
    private Direction direction;
    private Game game;

    public FrogInf(Game jeu){
        this.position= new Case(jeu.width/2, 0);
        this.game=jeu;
    }

    public Case getPosition(){
        return this.position;
    }
    public Direction getDirection(){
        return this.direction;
    }

    public void move(Direction key) {
        this.direction = key;
        if (key == Direction.up ) {
            game.setScore(1);
        }
        if (key == Direction.down) {
            game.setScore(-1);
        }
        if (key == Direction.left && (position.absc - 1 >= 0)) {
            this.position = new Case(position.absc - 1, 0);
        }
        if (key == Direction.right && (position.absc + 1 < this.game.width)) {
            this.position = new Case(position.absc + 1, 0);
        }
    }


}
