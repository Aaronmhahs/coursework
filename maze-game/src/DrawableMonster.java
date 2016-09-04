/**
 * Class that contains all the logic to model a Drawable Monster.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public class DrawableMonster extends Monster implements Drawable
{
   // Constructors
   public DrawableMonster(Maze maze)
   {
      super(maze);
   }

   public DrawableMonster(Maze maze, long seed)
   {
      super(maze, seed);
   }
   
   public DrawableMonster(Maze maze, Square location)
   {
      super(maze, location);
   }

   // Methods
   public void draw()
   {
 
   }
}
