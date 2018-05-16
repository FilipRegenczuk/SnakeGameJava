import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class Snake extends Board implements KeyListener, ActionListener{		// Jak siê pozbyæ dziedziczenia? 

	
	private Timer timer;
	private int delay = 150;
	
	
	public Snake()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);			// timer for snake speed
		timer.start();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {		// TODO resize board (down)
		timer.start();
		if (right)
		{
			for (int i = snakeLength-1; i>=0; i--)
			{
				snakeYlength[i+1] = snakeYlength[i];
			}
			for (int i = snakeLength; i>=0; i--)
			{
				if(i==0)
				{
					snakeXlength[i] = snakeXlength[i] + 40;
				}
				else
				{
					snakeXlength[i] = snakeXlength[i-1];
				}
				if (snakeXlength[i] > 960)
				{
					snakeXlength[i] = 0;
				}
			}
			repaint();
			
		}
		if (left)
		{
			for (int i = snakeLength-1; i>=0; i--)
			{
				snakeYlength[i+1] = snakeYlength[i];
			}
			for (int i = snakeLength; i>=0; i--)
			{
				if(i==0)
				{
					snakeXlength[i] = snakeXlength[i] - 40;
				}
				else
				{
					snakeXlength[i] = snakeXlength[i-1];
				}
				if (snakeXlength[i] < 0)
				{
					snakeXlength[i] = 960;
				}
			}
			repaint();
		}
		if (up)
		{
			for (int i = snakeLength-1; i>=0; i--)
			{
				snakeXlength[i+1] = snakeXlength[i];
			}
			for (int i = snakeLength; i>=0; i--)
			{
				if(i==0)
				{
					snakeYlength[i] = snakeYlength[i] - 40;
				}
				else
				{
					snakeYlength[i] = snakeYlength[i-1];
				}
				if (snakeYlength[i] < 0)
				{
					snakeYlength[i] = 680;
				}
			}
			repaint();
			
		}
		if (down)
		{
			for (int i = snakeLength-1; i>=0; i--)
			{
				snakeXlength[i+1] = snakeXlength[i];
			}
			for (int i = snakeLength; i>=0; i--)
			{
				if(i==0)
				{
					snakeYlength[i] = snakeYlength[i] + 40;
				}
				else
				{
					snakeYlength[i] = snakeYlength[i-1];
				}
				if (snakeYlength[i] > 680)
				{
					snakeYlength[i] = 0;
				}
			}
			repaint();
		}	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			moves++;
			right = true;
			
			if (!left)
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			moves++;
			left = true;
			
			if (!right)
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			moves++;
			up = true;
			
			if (!down)
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			
			left = false;
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			moves++;
			down = true;
			
			if (!up)
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			
			left = false;
			right = false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
