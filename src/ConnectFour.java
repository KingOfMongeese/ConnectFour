/*
KingOfMongeese
Feb 18, 2022
ConnectFour Main
 
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class ConnectFour extends Application
{
	private static Label lblStatus = new Label("Red goes first");
	
	private static Cell[][] cells = new Cell[7][6];
	
	private static String whoseTurn = "red";
	
	private Button[] buttons = new Button[7];
	
	
	
	@Override
	public void start(Stage primaryStage)  
	{   
	    
		lblStatus.setFont(Font.font(16));
		
		GridPane pane = new GridPane();
		for ( int b = 0; b < 7; b++ )
		{
			//adds the buttons in the first row
			pane.add(buttons[b] = new Button(), b, 0);
			String buttonText = "Add to Column: ";
			buttons[b].setText(buttonText + Integer.toString(b + 1));
			buttons[b].setOnAction(new ButtonHandler(b));
		}
		
		for (int h = 0; h < 7; h++)
		{
			for (int v = 0; v < 6; v++) 
			{
				//adds the "cells"
				pane.add(cells[h][v] = new Cell(lblStatus), h  , v + 1);
			}
		}
		
		
		//creating the border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		
		//loading the scene
		Scene scene = new Scene(borderPane, 900, 900);
		primaryStage.setTitle("ConnectFour");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	
	}

	public static void main(String[] args)
	{
		ConnectFour.launch();
	}
	
	public static String getWhoseTurn()
	{
		return whoseTurn;
	}
	
	public static void setWhoseTurn(String turn)  
	{
		whoseTurn = turn;
	}
	public static Cell[][] getCells() 
	{
		return cells;
	}
	public static Label getlblStatus()
	{
		return lblStatus;
	}
	
	public static void endOfGame()
	{
		for (int row = 0; row <= 5; row++)
		{
			for (int col = 0; col <= 6; col++)
			{
				if(("empty".equals(cells[col][row].getToken())))
				{
					cells[col][row].endGameCircle();
				}
			}
		}
	}
	
	
	
	
	

}


