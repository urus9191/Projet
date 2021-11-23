package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.*;


public class Frog implements IFrog {

	private Game game;
	private Case position;
	private Direction direction;

	public Frog(Game game ) {
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

	 public void move(Direction key) {
		if (key == Direction.up) {
			this.position = new Case(this.position.absc, this.position.ord + 1);
		}
		if (key == Direction.down) {
			this.position = new Case(this.position.absc, this.position.ord - 1);
		}

		if (key == Direction.right) {
			this.position = new Case(this.position.absc + 1, this.position.ord);
		}

		if (key == Direction.left) {
			this.position = new Case(this.position.absc - 1, this.position.ord);
		}


	}
}