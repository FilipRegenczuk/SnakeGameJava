// Class dealing with graphical interface (creating a board, snake and food)

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Board extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// SNAKE //
	protected int[] snakeXlength = new int[750];	// snake's parts
	protected int[] snakeYlength = new int[750];
	
	protected boolean left = false;		// direction of the snake
	protected boolean right = false;
	protected boolean up = false;
	protected boolean down = false;
	
	private ImageIcon headLeft;		// position of the head
	private ImageIcon headRight;
	private ImageIcon headUp;
	private ImageIcon headDown;
	private ImageIcon body;
	
	protected int snakeLength = 3;
	protected int moves = 0;
	protected int score = 0;
	
	// FOOD //
	private int[] foodXposition = {0,40,80,120,160,200,240,280,320,360,400,440,480,520,560,600,640,680,720,760,800,840,880,920,960};
	private int[] foodYposition = {0,40,80,120,160,200,240,280,320,360,400,440,480,520,560,600,640,680};
	
	private ImageIcon apple;
	
	private Random generator = new Random();	// generator of random position of food
	private int xpos = generator.nextInt(25);
	private int ypos = generator.nextInt(18);
	
	
	protected boolean check = true;		// check correct start head's position
	
	
	public void paint (Graphics g)
	{
		
		g.setColor(Color.BLACK);		// creating black background
		g.fillRect(0, 0, 1000, 700);
		
		g.setColor(Color.WHITE);		// creating score on the board
		g.setFont(new Font("arial", Font.PLAIN, 24));
		g.drawString("Score: " + score, 10, 40);
		
		g.setColor(Color.WHITE);		// creating pause information on the board
		g.setFont(new Font("arial", Font.PLAIN, 24));
		g.drawString("Press SPACE to pause", 720, 40);
		
		
		if (moves == 0)
		{
			snakeXlength[2] = 80;		// start position of the snake
			snakeXlength[1] = 120;
			snakeXlength[0] = 160;
			
			snakeYlength[2] = 120;
			snakeYlength[1] = 120;
			snakeYlength[0] = 120;
		}
		
		// creating snake appearance
		headRight = new ImageIcon("headright.png");	
		if (check)
		{
			headRight.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
			check = false;
		}
		
		for (int i = 0; i < snakeLength; i++)
		{
			if (i==0 && right)
			{
				headRight = new ImageIcon("headRight.png");
				headRight.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && left)
			{
				headLeft = new ImageIcon("headLeft.png");
				headLeft.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && up)
			{
				headUp = new ImageIcon("headUp.png");
				headUp.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i==0 && down)
			{
				headDown = new ImageIcon("headDown.png");
				headDown.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if (i!=0)
			{
				body = new ImageIcon("body.png");
				body.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
		}
		
		
		apple = new ImageIcon("apple.png");
		
		// eating food
		if (foodXposition[xpos] == snakeXlength[0] && foodYposition[ypos] == snakeYlength[0])
		{
			snakeLength++;
			score++;
			xpos = generator.nextInt(21);
			ypos = generator.nextInt(13);
			
		}
		apple.paintIcon(this, g, foodXposition[xpos], foodYposition[ypos]);
		
		
		// collision reaction
		for (int i=1; i<snakeLength; i++)
		{
			if (snakeXlength[i] == snakeXlength[0] && snakeYlength[i] == snakeYlength[0])
			{
				right = false;
				left = false;
				up = false;
				down = false;
				check = true;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 350, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("press R to RESTART", 380, 340);
				
			}
		}
		
	}
}
