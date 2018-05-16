import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel {
	
	// SNAKE //
	protected int[] snakeXlength = new int[750];		// start position of the snake
	protected int[] snakeYlength = new int[750];
	
	protected boolean left = false;		// control of the snake
	protected boolean right = false;
	protected boolean up = false;
	protected boolean down = false;
	
	private ImageIcon headLeft;		// position of the head
	private ImageIcon headRight;
	private ImageIcon headUp;
	private ImageIcon headDown;
	
	private ImageIcon snakeImage;
	
	protected int snakeLength = 3;
	protected int moves = 0;
	
	// FOOD //
	private int[] foodXposition = {0,40,80,120,160,200,240,280,320,360,400,440,480,520,560,600,640,680,720,760,800,840,880,920,960,1000};
	private int[] foodYposition = {0,40,80,120,160,200,240,280,320,360,400,440,480,520,560,600,640,680,720};
	
	private ImageIcon apple;
	private ImageIcon pineapple;
	
	private Timer appleTimer;
	private Timer pineappleTimer;
	private int delay = 150;
	
	private Random generator = new Random();
	private int xpos = generator.nextInt(26);
	private int ypos = generator.nextInt(19);
	
	
	
	private boolean check = true;
	
	
	public void paint (Graphics g)
	{
		if (moves == 0)
		{
			snakeXlength[2] = 80;
			snakeXlength[1] = 120;
			snakeXlength[0] = 160;
			
			snakeYlength[2] = 120;
			snakeYlength[1] = 120;
			snakeYlength[0] = 120;
		}
		
		
		g.setColor(Color.BLACK);		// creating black background
		g.fillRect(0, 0, 1000, 700);
		
		
		headRight = new ImageIcon("headright.png");		// TODO why is head turned?
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
				snakeImage = new ImageIcon("left-right.png");
				snakeImage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
		}
		
		apple = new ImageIcon("apple.png");
		
		if (foodXposition[xpos] == snakeXlength[0] && foodYposition[ypos] == snakeYlength[0])
		{
			snakeLength++;
			//score++;
			xpos = generator.nextInt(21);
			ypos = generator.nextInt(13);
			
		}
		//appleTimer = new Timer(delay, Board);			// timer for snake speed
		//appleTimer.start();
		//apple.paintIcon(this, g, foodXposition[xpos], foodYposition[ypos]);
	}
}
