package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;
import java.util.Random;

public class EnvInf implements IEnvironment {
    private Game game;
    private ArrayList<Lane> lanes;
    public final Random randomGen = new Random();

    //constructeur
    public EnvInf(Game game) {
        this.game = game;
        this.lanes = new ArrayList<Lane>(this.game.height);
        lanes.add(new Lane(game, 0, 0.0D));
        for(int i = 1; i < game.height-1; i++) {
            Double density = game.randomGen.nextDouble() * (0.7-0.2);
            Lane e = new Lane(game, i, density);
            lanes.add(e);
        }
        lanes.add(new Lane(game, game.height-1, 0.0D));
    }

    @Override
    public boolean isSafe(Case c) {
        for (Lane l : lanes){
            if (!(l.isSafe(c))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return this.lanes.size()-1 == c.ord;
    }

    public void update() {
        for(Lane lane : lanes) {
            lane.update();
        }
    }


    @Override
    public void addLane() {this.lanes.add(new Lane(this.game,this.lanes.size()));

    }

    @Override
    public void moveLane(int val){
        for (int i = 0; i< lanes.size()-1; i++){
            Lane tmp= lanes.get(i);
            tmp.moveOrd(i-val);
        }
    }
}