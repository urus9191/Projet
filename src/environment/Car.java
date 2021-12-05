package environment;

import java.awt.Color;

import frog.Frog;
import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;


	public Car(Game game , Case myCase , boolean leftToRight ){
		//TODO Constructeur(s)
		this.game = game;
		this.leftToRight = leftToRight;
		this.length = generateurRandom();
		if(leftToRight){
			this.leftPosition = new Case (myCase.absc - this.length, myCase.ord);
		} else{
			this.leftPosition = new Case (myCase.absc , myCase.ord);
		}

	}
	public void moveUp(){
		this.leftPosition = new Case(leftPosition.absc, leftPosition.ord +1 );
	}
	public void moveDown(){
		this.leftPosition = new Case(leftPosition.absc, leftPosition.ord -1 );
	}

	/*public boolean moveCar(boolean move){
		//if(move){
		//return true ;}
		//return false;
	}*/

	//TODO : ajout de methodes
	public void DeplaceVoiture(){
		if (this.leftToRight) {
			this.leftPosition = new Case(this.leftPosition.absc + 1, this.leftPosition.ord);
			this.addToGraphics();
		} else {
			this.leftPosition = new Case(this.leftPosition.absc - 1, this.leftPosition.ord);
			this.addToGraphics();
		}
	}
	public int generateurRandom(){
		return game.randomGen.nextInt(3)+1;
	}

	public int vitesseAleatoire(){
		return game.randomGen.nextInt(5);
	}
	public boolean testCase(Case c) {
		if (c.ord != leftPosition.ord) { // test la meme ligne
			return false;
		} else {
			if (c.absc >= leftPosition.absc && c.absc<leftPosition.absc+length){
				return true;
			}
		}
		return false;
	}






	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

	public void moveOrd(int i) {
		this.leftPosition=new Case(this.leftPosition.absc,i);
	}
}