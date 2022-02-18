//KingOfMongeese

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;



public class Cell extends Pane
{
	private String token = "empty";
	private Label lblStatus = new Label();
	
  public Cell(Label lblStatus)  
  {
	  this.lblStatus = lblStatus;
	  setStyle("-fx-border-color: black");
	  this.setPrefSize(2000, 2000);
	  
  }
  
  public String getToken()  
  {
	  return this.token;
  }
  
  private void setToken(String turn)  
  {
	  //logic for which color of circle to spawn
	  this.token = turn;
	  
	  if (this.token.equals("red"))
	  {
		  Circle circle = new Circle(this.getWidth() / 2.1);
		  circle.setFill(Color.RED);
		  circle.setCenterX(this.getWidth() / 2);
		  circle.setCenterY(this.getHeight() / 2);
		  
		  this.getChildren().add(circle);
	  }
	  
	  else if (this.token.equals("blue")) 
	  {
		  Circle circle = new Circle(this.getWidth() / 2.1);
		  circle.setFill(Color.BLUE);
		  circle.setCenterX(this.getWidth() / 2);
		  circle.setCenterY(this.getHeight() / 2);
		  
		  this.getChildren().add(circle);
	  }
  }
  
  
  public void handleMouseClick()
  {
	  //logic for what to do when a button is clicked
	  setToken(ConnectFour.getWhoseTurn());
	  
	  if (isGameOver()) 
	  {
  		String turn = ConnectFour.getWhoseTurn();
  		Label label = ConnectFour.getlblStatus();
  		label.setText(turn + " won! Game Over");
  		ButtonHandler.setGameOver(true);
  		ConnectFour.endOfGame();
  		
  	  }
	  else
	  {
		  advanceTurn();
	  }
	  
	  
	  
   }
  
   private void advanceTurn() 
   {
	   if (ConnectFour.getWhoseTurn().equals("red")) 
		  {
			  
			  ConnectFour.setWhoseTurn("blue");
			  this.lblStatus.setText("Blue's Move");
		  }
		  else if (ConnectFour.getWhoseTurn().equals("blue"))
		  {
			  ConnectFour.setWhoseTurn("red");
			  this.lblStatus.setText("Red's Move");
		  }
   }
   
   private boolean isGameOver()
   {
   	boolean gameOver = false;
   	
   	String turnColor = ConnectFour.getWhoseTurn();
   	
   	Cell[][] cells = ConnectFour.getCells();
   	
   	
   	for (int row = 0; row <= 5; row++)
   	{
   		//determines Horizontal Victory
   		int hCount = 0;
   		
   		for (int col = 0; col <= 6; col++)
   		{
   			if (turnColor.equals(cells[col][row].getToken()))
   			{
   				hCount++;
   				if(hCount >= 4)
   				{
   					gameOver = true;
   				}
   			
   			}
   			else 
   			{
   				hCount = 0;  //reset hCount to zero as they are no longer in a row
   			}
   		}
   	
   	}
   	
   	for (int col = 0; col <= 6; col++) 
   	{
   		//determines Vertical victory
   		int vCount = 0;
   		
   		for (int row = 0; row <= 5; row++)
   		{
   			if(turnColor.equals(cells[col][row].getToken()))
   			{
   				vCount++;
   				if(vCount >= 4)
   				{
   					gameOver = true;
   				}
   			}
   			else 
   			{
   				vCount = 0;
   			}
   		}
   	}
   	
   	
   	//I could not figure out how to check the matrix diagonally
   	//I used this https://gist.github.com/jonathan-irvin/97537512eb65a8bbcb9a as a reference, it has been adapted to fit a UI model
   
   	
   	
   	for(int row = 3; row < cells.length; row++)
   	{
   		//upward diagonal
		for(int col = 0; col < cells[0].length - 3; col++)
		{
			if (turnColor.equals(cells[row][col].getToken())   && 
				turnColor.equals(cells[row-1][col+1].getToken()) &&
				turnColor.equals(cells[row-2][col+2].getToken()) &&
				turnColor.equals(cells[row-3][col+3].getToken()))
			{
				gameOver = true;
			}
		}
	}
   	
   	for(int row = 0; row < cells.length - 3; row++)
   	{
   		//downward diagonal
		for(int col = 0; col < cells[0].length -3; col++)
		{
			if (turnColor.equals(cells[row][col].getToken())   && 
				turnColor.equals(cells[row+1][col+1].getToken()) &&
				turnColor.equals(cells[row+2][col+2].getToken()) &&
				turnColor.equals(cells[row+3][col+3].getToken()))
			{
				return true;
			}
		}
	}
   	
   	
   	
   	
   	return gameOver;
   }
   
   public void endGameCircle()
   {
	   Circle circle = new Circle(this.getWidth() / 2.1);
	   circle.setFill(Color.BLACK);
	   circle.setCenterX(this.getWidth() / 2);
	   circle.setCenterY(this.getHeight() / 2);
		  
	   this.getChildren().add(circle);
   }
	  
}
		  
  
  
