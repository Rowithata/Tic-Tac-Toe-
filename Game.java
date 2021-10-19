import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
/*Connor Chang
 * notes to self:
 *DONT LET THE AI CHEAT
 */
public class Game 
{
	@SuppressWarnings("deprecation")
	public static void main (String[]args)
	{
		JOptionPane.showMessageDialog(null, "Enjoy a life changing tic tac toe experience", 
		null, JOptionPane.INFORMATION_MESSAGE);
		JFrame f= new JFrame("Tic Tac Toe!");
		f.setSize(500,500);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setCursor(3);

		
		f.setBackground(Color.green); //does not work
		
		
		int gamemode = message(f); //finds the game mode
		//System.out.println(gamemode);
		
		String[][] board = new String [3][3]; //Declaring board.
		ImageIcon img = new ImageIcon("C:\\Users\\rowit\\Downloads\\download.png");
		f.setIconImage(img.getImage());
		
	   KnotsAndCrosses kandc = new KnotsAndCrosses();
				
		JButton cell1= new JButton(""); //Creating all buttons for players
		JButton cell2= new JButton(""); //to click.
		JButton cell3= new JButton("");
		JButton cell4= new JButton("");//Also declaring all other things
		JButton cell5= new JButton("");
		JButton cell6= new JButton("");
		JButton cell7= new JButton("");
		JButton cell8= new JButton("");
		JButton cell9= new JButton("");
		
		JButton Reset= new JButton("");
		JButton help= new JButton("Help");
		JLabel Turn = new JLabel("Take your time, O");
		JLabel Win = new JLabel("");
		
		clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
		JLabel Wins = new JLabel("");
		int moves = 0;
		 help.addActionListener(new ActionListener() 
		 {
		      @Override
		      public void actionPerformed(ActionEvent e) 
		      {
		  		Object[] options = 
		  			{
		  				"Change Gamemode",
		  				"Nevermind lol",
		  				"Close Game"
		  	        };
		  			int n = JOptionPane.showOptionDialog(f,
		  					"Ya?",
		  					"Whatdya want",
		  					JOptionPane.YES_NO_CANCEL_OPTION,
		  					JOptionPane.QUESTION_MESSAGE,
		  					null,
		  				options,
		  				options[2]);
		  			if(n == JOptionPane.CANCEL_OPTION)
		  			{
		  				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		  			}
		  			else if(n == JOptionPane.YES_OPTION) 
		  			{
		  				clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
		  			    message(f);
		  			}
		  			else if(n == JOptionPane.NO_OPTION) 
		  			{
		  			}
		      }
		  });
		
		f.add(cell1); //Adding all needed buttons and text to JFrame
		f.add(cell2);
		f.add(cell3);
		f.add(cell4);
		f.add(cell5);
		f.add(cell6);
		f.add(cell7);
		f.add(cell8);
		f.add(cell9);
		
		f.add(Reset); //Adds all non board buttons and labels.	
		f.add(Turn);
		f.add(Win);
		f.add(Wins);
		f.add(help);
		
		cell1.setBounds(100,50,100,100);
		cell2.setBounds(200,50,100,100);
		cell3.setBounds(300,50,100,100);
		cell4.setBounds(100,150,100,100);
		cell5.setBounds(200,150,100,100);
		cell6.setBounds(300,150,100,100);
		cell7.setBounds(100,250,100,100);
		cell8.setBounds(200,250,100,100);
		cell9.setBounds(300,250,100,100);
		Reset.setBounds(150,350,200,50);
		help.setBounds(0,0,100,30);
		Reset.setText("Reset Board");
	    Reset.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
	        	Win.setText("");
	        }
	    });
	    
	    Turn.setBounds(50,400,400,50);
	    Win.setBounds(200,10,400,50);
	    Wins.setBounds(350,400,400,50);
		
		ActionListener e = (ActionListener) new ActionListener()//oh lord
		{
			int player=1; 
			boolean error;
			int XWins = 0;
			int YWins = 0; 
			public void actionPerformed(ActionEvent e) 
			{
				Object obj = e.getSource();
				if(obj==cell1) //0,0
				{
					error = move(cell1,player,board,0,0,gamemode);
				}
				else if (obj==cell2) //1,0
				{
					error = move(cell2,player,board,1,0,gamemode);
				}
		    	else if (obj==cell3) //2,0
		    	{
		    		error = move(cell3,player,board,2,0,gamemode);
		    	}
		    	else if (obj==cell4) //0,1
		    	{
		    		error = move(cell4,player,board,0,1,gamemode);
		    	}
		    	else if (obj==cell5) //1,1
		    	{
		    		error = move(cell5,player,board,1,1,gamemode);
		    	}
		    	else if (obj==cell6) //2,1
		    	{
		    		error = move(cell6,player,board,2,1,gamemode);
		    	}
		    	else if (obj==cell7) //0,2
		    	{
		    		error = move(cell7,player,board,0,2,gamemode);
		    	}
		    	else if (obj==cell8) //1,2
		    	{
		    		error = move(cell8,player,board,1,2,gamemode);
		    	}
		    	else if (obj==cell9) //2,2
		    	{
		    		error = move(cell9,player,board,2,2,gamemode);
		    	}
				//Below are constants, that happen every time
				//somebody makes a move.
				if (error!=true)
				{
					if (gamemode == 2/*&&checkBoard(board)*/) //For AI Mode
					{
						if (player%2 == 1)
						{
							int x [] = bestMove(kandc, board, cell1, cell2, cell3, cell4, cell5, 
									            cell6, cell7, cell8, cell9, moves); //changed player to moves
							x.toString();
							for (int i = 0; i <x.length; i++) //Prints out best move.
							{
								System.out.print(x[i]);
							}
	                     	AIMove(kandc, board, cell1, cell2, cell3, cell4, cell5, 
	       	                cell6, cell7, cell8, cell9,x);
	                     	 player++;
						}
					}
					
					if (kandc.checkWinner("X",board)==true)
					{
						Win.setText("wow bravo X");
						Turn.setText("");
						XWins++;
						disableBoard(cell1, cell2, cell3, cell4, cell5, 
			       	    cell6, cell7, cell8, cell9);
						player=0;
					}
					else if (kandc.checkWinner("O",board)==true)
				    {
						Win.setText("I KNEW YOU COULD DO IT, O");
						Turn.setText("");
						YWins++;
						disableBoard(cell1, cell2, cell3, cell4, cell5, 
		       	        cell6, cell7, cell8, cell9);
						player=0;
					} 
					
				  	 player++;
	                 if (cell1.isEnabled()/*&&gamemode!=2*/){player=checkplayer(Turn,player);}
	                 Wins.setText("X:"+XWins+" Wins. O:"+YWins+" Wins.");
	               //1101111011
	            }
				else {error=false;}
				}
		};
		
		cell1.addActionListener((ActionListener) e);//Adds action listener to all buttons 
		cell2.addActionListener((ActionListener) e);
		cell3.addActionListener((ActionListener) e);
		cell4.addActionListener((ActionListener) e);
		cell5.addActionListener((ActionListener) e);
		cell6.addActionListener((ActionListener) e);
		cell7.addActionListener((ActionListener) e);
		cell8.addActionListener((ActionListener) e);
		cell9.addActionListener((ActionListener) e);
		
		Font font = new Font("Comic Sans MS", Font.PLAIN,40);
		Font smallFont = new Font("Comic Sans MS", Font.PLAIN,12);
		
		cell1.setFont(font);//Adds cell font to the buttons
		cell2.setFont(font);
		cell3.setFont(font);
		cell4.setFont(font);
		cell5.setFont(font);
		cell6.setFont(font);
		cell7.setFont(font);
		cell8.setFont(font);
		cell9.setFont(font);
		
		Turn.setFont(smallFont);
		Win.setFont(smallFont);
		Wins.setFont(smallFont);
		Reset.setFont(smallFont);
		
	}
	
	public static void error ()
	{
		 JPanel panel = new JPanel();
		 JOptionPane.showMessageDialog(panel, "This spot is already taken!",
		 "Woah Buddy", JOptionPane.ERROR_MESSAGE);
	}
	
	public static String[][] clearboard(String[][] board,JButton cell1, JButton cell2, 
			JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, 
			JButton cell8, JButton cell9)
	{
		for (int i=0;i<=2;i++) //Changing all values to "Why"
		{
			for (int j=0;j <=2;j++)
			{
			board[j][i]="why";
			}
		}
    	cell1.setText("");
    	cell2.setText("");
    	cell3.setText("");
    	cell4.setText("");
    	cell5.setText("");
    	cell6.setText("");
    	cell7.setText("");
    	cell8.setText("");
    	cell9.setText("");
    	
		cell1.setEnabled(true);
		cell2.setEnabled(true);
		cell3.setEnabled(true);
		cell4.setEnabled(true);
		cell5.setEnabled(true);
		cell6.setEnabled(true);
		cell7.setEnabled(true);
		cell8.setEnabled(true);
		cell9.setEnabled(true);
		return board;
	}
	
	public static int checkplayer(JLabel Turn,int player)
	{
     	 if (player%2==0)
		{
			Turn.setText("Hurry up X, make your move");
		}
		else
		{
			Turn.setText("Take your time, O");
		}
		return player;
	}
	
	public static int message (JFrame f)
	{
		Object[] options = 
		{
			"1v1",
			"Fite me bot",
			"take me back"
        };
		int n = JOptionPane.showOptionDialog(f,
				"How do you want to play?",
				"Welcome",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
			options,
			options[2]);
		if(n == JOptionPane.CANCEL_OPTION)//take me back
		{
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
		else if(n == JOptionPane.YES_OPTION) //1v1
		{
			//Starts a 1v1 gamemode
			return 1;
		}
		else if(n == JOptionPane.NO_OPTION) //fite me bot
		{
			return 2;
		}
		else if (n== JOptionPane.CLOSED_OPTION)
		{
			message(f);
		}
		return 0;
	}
	
		   public static boolean positionsLeft (KnotsAndCrosses kandc, String [][] board)throws ArrayIndexOutOfBoundsException{
		      for (int c = 0; c <=2; c++){
		         for (int d = 0; d <=2; d++){
		            if (board [c][d] == "why"){
		               return true;
		            }
		         }
		      }
		      return false;
		   }
		   
		   public static int checkWinnerConverted (KnotsAndCrosses kandc, String [][] board){
		      int winScore = 0;
		      if (kandc.checkWinner("X", board)==true){
		         winScore = 10;
		      }else if (kandc.checkWinner("O", board)==true){
		         winScore = -10;
		      }
		      return winScore;
		   } 
		  
		   public static int AI (KnotsAndCrosses kandc,String [][] board,JButton cell1, JButton cell2, JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, JButton cell8, JButton cell9, boolean maximizer, int moves){
		      int winnerValue = checkWinnerConverted(kandc, board);
		      if (winnerValue == 10){
		         return winnerValue;
		      }else if (winnerValue == -10){
		         return winnerValue;
		      }else if (positionsLeft(kandc, board) == false){
		         return 0; 
		      }
		      int score = 0;
		      if (maximizer == true) {
		         score = -1000;
		         for (int i = 0; i <=2; i++){
		            for (int j = 0; j <=2; j++){
		               if (board [i][j] == "why" ){
		                  board[i][j] = "X"; 
		                  score = Math.max(score, AI(kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, false, moves+1));
		                  board[i][j] = "why";
		                  moves++;
		               }
		            }
		         }
		         return score;
		      }else {
		         score = 1000;
		         for (int i = 0; i <=2; i++) {
		            for (int j = 0; j <=2; j++){
		               if (board [i][j]== "why"){
		                  board [i][j] = "O";
		                  score = Math.min(score, AI(kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, true, moves+1)); 
		                  board [i][j] = "why";                 
		               }
		            }
		         }      
		         return score;
		      }
		   }
		   
		   public static int [] bestMove (KnotsAndCrosses kandc,String [][] board,JButton cell1, JButton cell2, JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, JButton cell8, JButton cell9, int player) throws ArrayIndexOutOfBoundsException {
		      int [] bestMoveCoords= new int [2]; 
		      bestMoveCoords [0] = -1;
		      bestMoveCoords [1] = -1;
		      int highScore = -1000;
		      for (int i = 0; i <=2; i++) {
		         for (int j = 0; j <=2; j++){
		            if (board [i][j]== "why"){
		               board [i][j] = "X";
		               int moveValueIndex = AI(kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, false, 0);
		               board[i][j] = "why";
		               if (moveValueIndex > highScore){
		                  bestMoveCoords [0] = i;
		                  bestMoveCoords [1] = j;
		                  highScore = moveValueIndex;
		               }  
		               //System.out.println(highScore);
		            }
		         }
		      }
		      return bestMoveCoords;
		   }
		   
		   public static void disableBoard (JButton cell1,
		   JButton cell2, JButton cell3, JButton cell4, JButton cell5, 
		   JButton cell6, JButton cell7, JButton cell8, JButton cell9)
		   {
				cell1.setEnabled(false);
				cell2.setEnabled(false);
				cell3.setEnabled(false);
				cell4.setEnabled(false);
				cell5.setEnabled(false);
				cell6.setEnabled(false);
				cell7.setEnabled(false);
				cell8.setEnabled(false);
				cell9.setEnabled(false);
		   }
		   
		   public static void AIMove ( KnotsAndCrosses kandc,String [][] board,JButton cell1,
		   JButton cell2, JButton cell3, JButton cell4, JButton cell5, 
		   JButton cell6, JButton cell7, JButton cell8, JButton cell9,int[] x) 
		   {
			   try 
			   {
				   int X=x[0];
				   int Y=x[1];		
				   //System.out.print(X+""+Y);
				   if(X==0&&Y==0) //Cell1
				   {
					   cell1.setText("X");
				   }
				   else if(X==1&&Y==0) //Cell2
				   {
					   cell2.setText("X");
				   }
				   else if(X==2&&Y==0) //Cell3
				   {
					   cell3.setText("X");
				   }
				   else if(X==0&&Y==1) //Cell4
				   {
					   cell4.setText("X");
				   }
				   else if(X==1&&Y==1) //Cell5
				   {
					   cell5.setText("X");
				   }
				   else if(X==2&&Y==1) //Cell6
				   {
					   cell6.setText("X");
				   }
				   else if(X==0&&Y==2) //Cell7
				   {
					   cell7.setText("X");
				   }
				   else if(X==1&&Y==2) //Cell8
				   {
					   cell8.setText("X");
				   }
				   else if(X==2&&Y==2) //Cell9
				   {
					   cell9.setText("X");
				   }
			   board[X][Y]="X";
			   }
			   catch (Exception e)
			   {
					 JPanel panel = new JPanel();
					 JOptionPane.showMessageDialog(panel, "Tie Lmao you both dog water",
					 "Lol", JOptionPane.ERROR_MESSAGE);
					 clearboard(board,cell1,cell2,cell3,cell4,cell5,
							    cell6,cell7,cell8,cell9);
					 
			   }
		   }
		   
		   public static boolean move(JButton cell,int turn,String[][] board,int x, int y,int gamemode)
		   {
			   if (board[x][y] == "why")
			   {
				   if (turn%2==0 && gamemode!=2)//X
				   {
					   cell.setText("X");
					   board[x][y]="X";
					   return false;
				   }
				   else//X
				   {
					   cell.setText("O");
					   board[x][y]="O";
					   return false;
				   }
			   }
			   else{error(); return true;}
		   }
		   
		   public static boolean checkBoard(String[][] board)
		   {
			   for (int i=0; i<=2; i++)
			   {
				   for (int j=0; j<=2; j++)
				   {
					   if (board[i][j]=="why")
					   {
						   return true;
					   }
				   }
			   }
			   return false;
		   }
}

