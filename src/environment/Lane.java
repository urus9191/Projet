package environment;

import java.util.ArrayList;
import graphicalElements.Element;
import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private Case positon;
	private int time = 0;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops)+1;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
	}

	public Lane(Game game, int size) {
	}


	// TODO : ajout de methodes
	public boolean isSafe(Case c) {
		// TODO Auto-generated method stub
		for(Car  car : cars)//On regarde pour chaque voiture si elle n'est pas sur la case considérée
			if( car.sameCase(c) ) // si la voiture est dans la meme case que la grenouille  pas safe
				return false;
		return true;
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}



	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			Case c  = new Case(-1, ord);
			return c;
		} else {
			Case c = new Case(game.width, ord);
			return c;
		}

	}

	public void update() {
		time++;
		if( this.time >= this.speed ) {
			for( Car car  : cars ) {
				car.move();
			}
			this.mayAddCar();
			this.time = 0;
		}
		for( Car car : cars) {
			car.toGraphics();
		}

	}

	public void moveOrd(int i) {
		this.ord=i;
		for (Car tmp: cars){
			tmp.moveOrd(i);
		}
	}
}