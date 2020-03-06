import java.awt.Color;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BoxBallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BoxBallDemo   
{
    private Canvas myCanvas;
    
    int boxHeight = 500;
    int boxWidth = 500; 
    int canvasWidth = 600;
    int canvasHeight = 600;
    int xPos = 10;
    int yPos = 10; 
    Color color; 
    private int numberGenerated; 
    Random randomNumbers = new Random();
     private Random randomGen;
    
    private Color getColor()
    {
    
    Random rand = new Random();
    // Java 'Color' class takes 3 floats, from 0 to 1.
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);
    return randomColor;
    } 
    
    HashSet<BoxBall> balls = new HashSet<BoxBall>(); 
    
   
    
    /**
     * Create a BoxBallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BoxBallDemo()
    {
        myCanvas = new Canvas("Box Ball Demo", canvasWidth, canvasHeight);
        
        randomGen = new Random();
    }

   
    public void bounce(int numberOfBalls)
    {
        // position of the ground line
        

        myCanvas.setVisible(true);
        
        boxBounce(numberOfBalls);
        
        boolean finished = false;
        
        while(!finished)
        {
            myCanvas.wait(50);
            
            for(BoxBall boxBall : balls)
            {
                boxBall.move();
                
                if(boxBall.getXPosition() >= boxHeight + 30* numberOfBalls) 
                {
                    finished = true; 
                }
            }
        }
    }
    
    
    private void boxBounce(int numberOfBalls)
    {
     myCanvas.drawRectangle(xPos, yPos, boxWidth, boxHeight); 
     
     for (int i = 0; i < numberOfBalls; i ++)
     {
        
         BoxBall boxBall = new BoxBall(xPos, yPos, randomDiameter(), getColor(), boxWidth, boxHeight, myCanvas);
         
         balls.add(boxBall);
         
         boxBall.draw(); 
    }
}


 public int randomDiameter() 
    {
       
       numberGenerated = randomNumbers.nextInt(25); 
       int r1 = numberGenerated +1;
       int r2 = (10-r1) + 10; 
       
       if (numberGenerated <10)
    {
        return r2;
    }
    else {
        return r1;
    } 
}

 
     private int randomPosition()
   {
       int pos = (int) (boxHeight);
       
       return randomGen.nextInt(pos); 
       
    }
   
    
}
  

        // draw the box
       
 
    
