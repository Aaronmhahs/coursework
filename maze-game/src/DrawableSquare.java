/**
 * Class that contains all the logic to model a Drawable Square.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public class DrawableSquare extends Square implements Drawable
{
   // Constructors
   public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col)
   {
      super(up, right, down, left, row, col);
   }
   
   // Methods
   public void draw()
   {
   }
}
