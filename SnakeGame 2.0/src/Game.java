import java.awt.Color;
import javax.swing.JFrame;


public class Game {
	
	public Game() {
		
		JFrame gameScene = new JFrame();
		Board board = new Board();
		Snake snake = new Snake();
		
		// creating frame and adding board and snake
		gameScene.setBounds(25, 25, 1000, 720);
		gameScene.setBackground(Color.DARK_GRAY);
		gameScene.setResizable(false);
		gameScene.setVisible(true);
		gameScene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScene.add(board);
		gameScene.add(snake);
		
	}
	
}
