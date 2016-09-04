import java.util.*;

/**
 * Class that contains all the logic to model a Monster.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public class Monster extends RandomOccupant
{
   // Constructors
   public Monster(Maze maze)
   {
      super(maze);
   }
   
   public Monster(Maze maze, long seed)
   {
      super(maze, seed);
   }

   public Monster(Maze maze, Square location)
   {
      super(maze, location);
   }
}
