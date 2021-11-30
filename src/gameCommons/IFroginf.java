package gameCommons;

import frog.FrogInf;
import util.Case;
import util.Direction;

public class IFroginf implements FrogInf {

    private Game game;
    private Case position;
    private Direction direction;

    public IFroginf(Game game ) {
        this.game = game;
        position = new Case(game.width / 2, 0);
    }

    @Override
    public Case getPosition() {
        return position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override public void move(Direction key) {
        if (key == Direction.up) {
            this.position = new Case(this.position.absc, this.position.ord + 1);
        }
        if (key == Direction.down) {
            if (this.position.ord != 0) {
                this.position = new Case(this.position.absc, this.position.ord - 1);
            }
        }
        if (key == Direction.right) {
            if (this.position.absc < game.width-1) {
                this.position = new Case(this.position.absc + 1, this.position.ord);
            }
        }
        if (key == Direction.left) {
            if (this.position.absc > 0) {
                this.position = new Case(this.position.absc - 1, this.position.ord);
            }
        }

    }
}
