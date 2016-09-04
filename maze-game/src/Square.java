import java.util.*;

/**
 * Class that contains all the logic to model the Squares within the Maze.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public class Square implements DelimitedTextIO
{
   // Constants
   public static final int SQUARE_SIZE = 50;
   public static final int UP = 0;
   public static final int RIGHT = 1;
   public static final int DOWN = 2;
   public static final int LEFT = 3;
   
   // Instance variables
   private boolean[] walls = new boolean[4];
   private boolean seen;
   private boolean inView;
   private int row;
   private int col;
   private Treasure treasure;

   // Constructors
   public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      walls[0] = up;
      walls[1] = right;
      walls[2] = down;
      walls[3] = left;
      this.row = row;
      this.col = col;
   }

   public Square(int row, int col)
   {
      this.row = row;
      this.col = col;
   }  

   // Methods
   public boolean wall(int direction)
   {
      return walls[direction];
   }

   public boolean seen()
   {
      return seen;
   }
 
   public boolean inView()
   {
      return inView;
   }

   public int row()
   {
      return row;
   }

   public int col()
   {
      return col;
   }

   public Treasure treasure()
   {
      return treasure;
   }

   public int x()
   {
      return (col*SQUARE_SIZE);
   }

   public int y()
   {
      return (row*SQUARE_SIZE);
   }

   public void setInView(boolean inView)
   {
      this.inView = inView;
      if (inView == true)
      {
         seen = true;
      }
   }

   public void setTreasure(Treasure t)
   {
      treasure = t;
   }

   public void enter()
   {
      if (treasure != null)
      {
         treasure.setFound();
      }
   }

   public String toText(char delimiter)
   {
      return getClass().getName() + delimiter + row + delimiter + col + delimiter + walls[0] + delimiter + walls[1] + delimiter + walls[2] + delimiter + walls[3] + delimiter + seen + delimiter + inView;
   }

   public void toObject(Scanner input)
   {
      this.walls[0] = input.nextBoolean();
      this.walls[1] = input.nextBoolean();
      this.walls[2] = input.nextBoolean();
      this.walls[3] = input.nextBoolean();
      this.seen = input.nextBoolean();
      this.inView = input.nextBoolean();
   }
}
