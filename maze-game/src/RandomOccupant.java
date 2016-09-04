import java.util.*;

/**
 * Class that contains all the logic to model a Random Occupant.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public abstract class RandomOccupant extends Occupant
{
   // Instance variables
   private Random random;
   private Maze maze;
 
   // Constructors
   public RandomOccupant(Maze maze)
   {
      this.maze = maze;
      random = new Random();
      Square s = maze.getSquare(random.nextInt(maze.rows()), random.nextInt(maze.cols()));

      super.moveTo(s);
   }   

   public RandomOccupant(Maze maze, long seed)
   {
      this.maze = maze;
      random = new Random(seed);
      Square s = maze.getSquare(random.nextInt(maze.rows()), random.nextInt(maze.cols()));
      super.moveTo(s);  
   }
 
   public RandomOccupant(Maze maze, Square location)
   {
      super(location);
      this.maze = maze; 
      random = new Random();  
   }

   // Methods
   public void move()
   {
      int r = super.location().row();
      int c = super.location().col();
      boolean done = false;
      while (done != true)
      {
         int n = this.random.nextInt(4);
         if (n == Square.UP && super.location().wall(0) == false)
         {
            Square s = maze.getSquare(r - 1, c);
            this.moveTo(s);
            done = true;
         }

         if (n == Square.RIGHT && super.location().wall(1) == false)
         {
            Square s = maze.getSquare(r, c + 1);
            this.moveTo(s);
            done = true;
         }

         if (n == Square.DOWN && super.location().wall(2) == false)
         {
            Square s = maze.getSquare(r + 1, c);
            this.moveTo(s);
            done = true;
         }

         if (n == Square.LEFT && super.location().wall(3) == false)
         {
            Square s = maze.getSquare(r, c - 1);
            this.moveTo(s);
            done = true;
         }
      }
   }
 
   public void toObject(Scanner input)
   {
      moveTo(maze.getSquare(input.nextInt(), input.nextInt())); 
   }
}
