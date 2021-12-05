package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import graphicalElements.FroggerGraphic;
import util.Direction;

import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.awt.event.KeyListener;

public class Frog implements IFrog   {

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
		if (key == Direction.up && this.position.ord < this.game.height - 1) {
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
