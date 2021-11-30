package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.YELLOW;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)


		public Car(Game game, Case leftPosition, boolean leftToRight) {
			this.game = game;
			this.leftPosition = leftPosition;
			this.length = game.randomGen.nextInt((3-1)+1);
			this.leftToRight = leftToRight;
			if (leftToRight){
				this.leftPosition = new Case( leftPosition.absc- this.length , leftPosition.ord);
			} else {
				this.leftPosition = new Case( leftPosition.absc, leftPosition.ord);
			}
		}

	public Case getPosition() {
		return this.leftPosition;
	}

	public boolean sameCase(Case c) {
		if(leftPosition.ord != c.ord) {
			return false;
		} else {
			if( leftPosition.absc <= c.absc && leftPosition.absc + this.length > c.absc ) {
				return true;
			}
		}
		return false;
	}

	public void move() {
		if( leftToRight ) {
			this.leftPosition = new Case(this.leftPosition.absc+1, this.leftPosition.ord);
		} else {
			this.leftPosition = new Case(this.leftPosition.absc-1, this.leftPosition.ord);
		}
	}

	//TODO : ajout de methodes


	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}
	public void toGraphics() {
		addToGraphics();
	}


}