import java.awt.*;
import java.awt.geom.*;
import java.util.Random; 


/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Angelina Joy
 *
 * @version 2011.07.31
 */

public class BoxBall
{

    
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter; 
    private int xPosition;
    private int yPosition;
    private final int width;
    private final int height;
    private Canvas canvas;
    private int distance = 30; // so box doesn't chip 
    private int xSpeed; 
    private int ySpeed;
    private int numberGenerated; 
    Random randomNumbers = new Random();
    
    
     // This is the constructor for the Box ball 
    
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int boxWidth, int boxHeight, Canvas boxCanvas) 
    {
    xPos= xPosition;
    yPos = yPosition; 
    diameter = ballDiameter; 
    color = ballColor;
    width = boxWidth;
    height = boxHeight;
    canvas = boxCanvas;
    xSpeed = randomSpeed(); 
    ySpeed =  randomSpeed(); 
   
    yPos = randomNumbers.nextInt(500); // gives random position limited to 500 for x and y
    xPos = randomNumbers.nextInt(500);
    
    if (xPos >= boxWidth)
        xPosition = xPos - distance;
    else 
        xPosition = xPos;
        
    if (yPos >= boxHeight)
        yPosition = yPos - distance; 
    else 
        yPosition = yPos; 
     
    }

     public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
     public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    
    
    public void move()
    {
       erase();
       
       
       
       yPosition += ySpeed;
       xPosition += xSpeed; 
       
       int r = diameter+5; 
       
       if (xPosition - r - distance < 0 )
        {
            
        xSpeed = -xSpeed;
        xPosition = r + distance;
        }
            else if (xPosition + r >= width)
            {
                xSpeed =-xSpeed;
                xPosition = width - r;
            }
     
       if(yPosition - r - distance<=0)
       {
        ySpeed = -ySpeed;
        yPosition = r + distance;
        }
                else if (yPosition + r >=height)
                {
                    ySpeed =-ySpeed;
                    yPosition = height - r;
                   
                }
        
       
                
        draw(); 
        

        // draw again at new position
       
        
    }
   
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    public int randomSpeed() 
    {
        numberGenerated = randomNumbers.nextInt(10) +1 ;
        int r =  numberGenerated * 5; 
        return r; 
    }
    
    
    //extra credit
   // gives random diameter 
   
    public int randomDiameter(int newDiameter) 
    {
       numberGenerated = randomNumbers.nextInt(25)+1;
      
       int max = 10; 
       int min = 25;
       
       if (numberGenerated <=25 && numberGenerated >=10) {
           
        newDiameter = numberGenerated; 
        
        }
        else if (numberGenerated <10)
        {
        newDiameter = numberGenerated + (10 - numberGenerated); 
        }
      
        return newDiameter; 
         
       
}

    // gives random color 
   public Color getColor()
    {
    
    Random rand = new Random();
    // Java 'Color' class takes 3 floats, from 0 to 1.
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);
    return randomColor;
    } 
    
   
    
}