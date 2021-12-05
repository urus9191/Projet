package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
//import java.util.Timer;
//import java.util.TimerTask;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private int temp=0;

	// TODO : Constructeur(s)
	public Lane(Game game , int ord, double density){
		this.game = game ;
		this.ord = ord;
		this.speed =vitesseAleatoire();
		this.cars = new ArrayList<>();
		this.leftToRight = RandomAleatoire();
		this.density=density;
		for(int i=1 ; i<game.height-1 ; i++) {
			mayAddCar();
			for (Car maVoiture : cars) {
				maVoiture.DeplaceVoiture();
			}
		}
	}

	public Lane(Game game , int ord){
		this(game,ord, game.defaultDensity);
	}
	public int vitesseAleatoire(){
		return game.randomGen.nextInt(2)+1;
	}
	public boolean RandomAleatoire(){
		return Math.random()<0.5;
	}
	public boolean isSafe(Case x){
		for(Car maVoiture : cars){
			if(maVoiture.testCase(x)) {
				return false;
			}
		}
		return true;
	}


	public void update() {
		temp++;
		if(temp >= speed) {
			for (Car maVoiture : cars) {
				maVoiture.DeplaceVoiture();
			}    //temp++;
			mayAddCar();
			temp = 0;
			//if(RandomAleatoire()){ mayAddCar();}
		}
		for(Car maVoiture : cars) {
			maVoiture.addToGraphics();
		}
	}


	public void addLaneUp(){
		new Lane(game , game.height , game.defaultDensity);
	}
	public void addLaneDown(){
		new Lane(game , game.height , game.defaultDensity);
	}
	// TODO
	// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
	// d'horloge" �gal � leur vitesse
	// Notez que cette m�thode est appel�e � chaque tic d'horloge

	// Les voitures doivent etre ajoutes a l interface graphique meme quand
	// elle ne bougent pas

	// A chaque tic d'horloge, une voiture peut �tre ajout�e



	// TODO : ajout de methodes

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight ));
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
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}
	public void moveOrd(int i) {
		this.ord=i;
		for (Car tmp: cars){
			tmp.moveOrd(i);
		}
	}

}