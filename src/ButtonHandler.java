//KingOfMongeese


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ButtonHandler implements EventHandler<ActionEvent>
{
	private static boolean gameOver = false;
	
	private int column = 0;
	
	public ButtonHandler(int col)
	{
		//button overwatches their specified columns
		this.column = col;
	}
	  
    @Override
    public void handle(ActionEvent e)
    {
	 
    	
    	if(!(gameOver))
    	{
    		Cell[][] cells = ConnectFour.getCells();
        	
        	
        	for (int row = 5; row >= 0; row--)
        	{
        		//checks the from the bottom of the column up if the token already claimed
        		//then adds if it isn't
        		String token = cells[column][row].getToken();
        		if (token.equals("empty"))
        		{
        			
        			cells[column][row].handleMouseClick();
        			break;
        		}
        		
        	}
    	 }
    	
   
  	 
    }
    
    public static void setGameOver(boolean c)
    {
    	gameOver = c;
    }
  

}