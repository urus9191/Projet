package gameCommons;

import java.awt.Color;
import java.util.Random;
import java.lang.System;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import frog.Frog;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int score = 0;
	public int maxScore =0;


	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;
	private int actualScore=0;
	private int finalScore=0;
	Timer chrono = new Timer();
	float temps = 0;
	int compt =0;




	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
		chrono.schedule(new TimerTask() {
			@Override
			public void run() {
				temps++;
			}
		},1000,1000);

	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}




	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		// TODO
		if(environment.isSafe(frog.getPosition())== false){
			chrono.cancel();
			this.graphic.clear();
			this.graphic.endGameScreen("defaite"+ " "+ "time: "+ temps);
			return true ;
		}

		return false;
	}
	final int f = actualScore;
	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		// TODO
		if(environment.isWinningPosition(frog.getPosition()))	{
			graphic.endGameScreen("victoire");
			return true ;
		}
		return false;
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
		testLose();
		//testWin();
	}

	public void setScore(int i) {

		this.actualScore+=i;
		if (actualScore<0){
			actualScore=0;
		}
		if (this.actualScore>this.finalScore){
			this.finalScore=this.actualScore;
			compt++;
			environment.addLane();
		}
		if ( (this.height+this.actualScore) >= this.height)
			environment.moveLane(this.actualScore);

	}

}

