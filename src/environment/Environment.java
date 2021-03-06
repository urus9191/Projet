package environment;

import java.util.ArrayList;
import java.util.Random;

import frog.Frog;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {

    private Game game;
    private ArrayList<Lane>lanes;
    public final Random randomGen = new Random();

    //constructeur
    public Environment(Game game) {
        this.game = game;
        this.lanes = new ArrayList<Lane>(this.game.height);
        lanes.add(new Lane(game, 0, 0.0D));
        for(int i = 1; i < game.height-1; i++) {
            Double density = game.randomGen.nextDouble() * (0.5);
            Lane e = new Lane(game, i, density);
            lanes.add(e);
        }
        lanes.add(new Lane(game, game.height-1, 0.0D));
    }

    @Override
    public boolean isSafe(Case c) {
        return this.lanes.get(c.ord).isSafe(c);
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
    public void moveLane(int actualScore) {

    }

    @Override
    public void addLane() {

    }



}
