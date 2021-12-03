package gameCommons;

import util.Case;
import util.Direction;

public interface IFrogInf {
   public Case getPosition();

   public Direction getDirection();

   public void move(Direction key);
}

