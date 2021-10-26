package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.*;


public class Frog implements IFrog {

	private Game game;
	private Case position;
	private Direction direction;

	public Frog(Game game) {
		this.game = game;

	}

	@Override
	public Case getPosition() {
		return position;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}




}