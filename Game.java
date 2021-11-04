import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/*Connor Chang
  List of errors (oh god):
 * -BOARD IS FIXED WAHOOO
 * -try to add a flashing light whenevrr somebody wins.             
 */
public class Game
{
   @SuppressWarnings("deprecation")
   public static void main (String[]args) throws ArrayIndexOutOfBoundsException
   {
   	//boolean value=false;
      String[] Options = getOptions(); 
   }

   @SuppressWarnings("deprecation")
   public static void game (String[] Options)
   {
     		JFrame f= new JFrame("Tic Tac Toe!");
      f.setExtendedState(f.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setCursor(0); 
		f.getContentPane().setBackground(new Color(130, 182, 217)); //sets the background to a pale dark blue 
		f.setDefaultLookAndFeelDecorated(true);
		f.setSize((int)(f.getWidth()*0.80),(int)(f.getHeight()*0.80));
      f.setLocationRelativeTo(null);
      f.setExtendedState(f.MAXIMIZED_BOTH);
   
      f.setBackground(Color.green); //does not work
   
   	/*
   int gamemode = message(f); //these 2 methods should be removed later on
   boolean isX = getChoice(f); */
      boolean isWinner = false;
      boolean isX;
   
      String ally;
      String opponent;
      String gamemode = Options[0];
   
      if (gamemode=="AI") //Options[0] is Gamemode
      {						  //Options[1] is player 1
         if (Options[1]=="X")
         {
            isX=true;
            ally="X";
            opponent="O";
         }
         else
         {
            isX=false;
            ally="O";
            opponent="X";
         }
      }
      else //assumes gamemode is 1v1
      {
         if  (Options[2]=="X") //if X will go first.
         {
            ally="X";
            opponent="O";
            isX=true;
         }
         else //if O will go first.
         {
            ally="O";
            opponent="X";
            isX=false;
         }
      }
   
   	//Debugging stuff
   	//System.out.println(gamemode);
   	//System.out.println(opponent+" against "+ally);
   	//System.out.println(Options[2]);
   
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
      JLabel Turn = new JLabel("");
      JLabel Win = new JLabel("");
   
      Random rand = new Random (); //For starting positions
   
   	//int depth = 0; //I have no idea what this is.
   
      clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
      JLabel Wins = new JLabel("");
      int moves = 0;
   	
      help.addActionListener(
         new ActionListener() //Lets pretend this doesn't exist for now
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
               //message(f);
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
   	//f.add(help);
   	
      cell1.setBackground(new Color (76, 187, 23));//setting the color of the buttons in an alternating pattern of green and yellow, this one is green
      cell2.setBackground(new Color (255, 233, 55));//this one is yellow....
      cell3.setBackground(new Color (76, 187, 23));//green...
      cell4.setBackground(new Color (255, 233, 55));
      cell5.setBackground(new Color (76, 187, 23));
      cell6.setBackground(new Color (255, 233, 55));
      cell7.setBackground(new Color (76, 187, 23));
      cell8.setBackground(new Color (255, 233, 55));
      cell9.setBackground(new Color (76, 187, 23));
      Reset.setBackground(new Color (76, 187, 23)); 
      help.setBackground(new Color (255, 233, 55));  
      rescale(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, f, Reset, Turn, Win, Wins);
      f.addWindowStateListener(new WindowStateListener()
      {
         @Override
         public void windowStateChanged(WindowEvent e){
         rescale(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, f, Reset, Turn, Win, Wins);
         }
         });
      char whoGoFirst=Options[2].charAt(0);
      char humanPlayer=Options[1].charAt(0);
      if (gamemode=="AI"&&humanPlayer!=whoGoFirst) //If AI Mode and human going 2nd
      {
         int[] startingAIMove = startingPositions(rand);
         System.out.println(startingAIMove[0]);
         System.out.println(startingAIMove[1]);
         AIMove(kandc, board, cell1, cell2, cell3, cell4, cell5, 
            cell6, cell7, cell8, cell9, startingAIMove, opponent);
      }
   
   	/*f.setExtendedState(f.MAXIMIZED_BOTH);
   	int boxDimensions = (int)(f.getHeight()*0.30);
   	int xVal = (int)((f.getWidth()/2)-(boxDimensions*1.5));
   	int yVal = (int)(f.getHeight()*0.025);
   	int resetXSize = boxDimensions;
   	int resetYSize = boxDimensions/4;
   	cell1.setBounds(xVal,yVal,boxDimensions, boxDimensions);
   	cell2.setBounds(xVal+boxDimensions,yVal,boxDimensions, boxDimensions);
   	cell3.setBounds(xVal+(boxDimensions*2),yVal,boxDimensions, boxDimensions);
   	cell4.setBounds(xVal,yVal+boxDimensions,boxDimensions, boxDimensions);
   	cell5.setBounds(xVal+boxDimensions,yVal+boxDimensions, boxDimensions, boxDimensions);
   	cell6.setBounds(xVal+(boxDimensions*2),yVal+boxDimensions,boxDimensions, boxDimensions);
   	cell7.setBounds(xVal,yVal+(boxDimensions*2),boxDimensions, boxDimensions);
   	cell8.setBounds(xVal+boxDimensions,yVal+(boxDimensions*2),boxDimensions, boxDimensions);
   	cell9.setBounds(xVal+(boxDimensions*2),yVal+(boxDimensions*2),boxDimensions, boxDimensions);
   	Reset.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/2)-resetYSize,resetXSize,resetYSize);
   	Turn.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/2)+resetYSize,resetXSize,resetYSize);
   	Win.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/3),resetXSize,resetYSize);
   	Wins.setBounds((xVal/2)-(resetXSize/2),((f.getHeight()/2)-resetYSize)+(int)(resetYSize*1.25),resetXSize,resetYSize);
   	help.setBounds(0,0,100,30);
   
   
   	Font font = new Font("Comic Sans MS", Font.BOLD,xVal/3);
   	Font smallFont = new Font("Comic Sans MS", Font.PLAIN,resetYSize/3);*/
      Reset.setText("Reset Board");
      Reset.addActionListener(
         new ActionListener() 
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
               Win.setText("");
               if (gamemode=="AI"&&humanPlayer!=whoGoFirst) //If AI Mode and human going 2nd
               {
                  int[] startingAIMove = startingPositions(rand);
                  System.out.println(startingAIMove[0]);
                  System.out.println(startingAIMove[1]);
                  AIMove(kandc, board, cell1, cell2, cell3, cell4, cell5, 
                     cell6, cell7, cell8, cell9, startingAIMove, opponent);
               }
            }
         });
   
      Turn.setBounds(50,400,400,50);
      Win.setBounds(200,10,400,50);
      Wins.setBounds(350,400,400,50);
   
      ActionListener e = (ActionListener) 
         new ActionListener()//oh lord
         {
            boolean player=true; //true = first player
            int XWins = 0;		 //false = second player/AI
            int YWins = 0; 
            boolean win=false;
         
            public void actionPerformed(ActionEvent e) //button press stuff
            {
               Object obj = e.getSource();
               if(obj==cell1) //0,0
               {
                  player = move(cell1,player,board,0,0,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell2) //1,0
               {
                  player = move(cell2,player,board,1,0,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell3) //2,0
               {
                  player = move(cell3,player,board,2,0,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell4) //0,1
               {
                  player = move(cell4,player,board,0,1,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell5) //1,1
               {
                  player = move(cell5,player,board,1,1,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell6) //2,1
               {
                  player = move(cell6,player,board,2,1,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell7) //0,2
               {
                  player = move(cell7,player,board,0,2,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell8) //1,2
               {
                  player = move(cell8,player,board,1,2,gamemode, isX,ally,opponent,Options);
               }
               else if (obj==cell9) //2,2
               {
                  player = move(cell9,player,board,2,2,gamemode, isX,ally,opponent,Options);
               }
            //Below are constants, that happen every time
            //somebody makes a move.
            //System.out.print(player); prints out the move.
               win=checkWinner();
               if (gamemode == "AI") //For AI Mode
               {
                  if (!player) //player 2 or AI
                  {
                     int x [] = bestMove(kandc, board, moves, isX, ally, opponent ); //changed player to moves
                     for (int i=0;i<=1;i++)
                     {
                     //System.out.print(x[i]); commented out for now
                     }
                     System.out.println();
                  //printBoard(board); 
                  
                     AIMove( kandc, board, cell1, cell2, cell3, cell4, cell5, 
                        cell6, cell7, cell8, cell9, x, opponent);
                     player = !player;
                  }
               }
               win=checkWinner();
               if (!positionsLeft(kandc, board)&&win!=true)
               {
                  JPanel panel = new JPanel();
                  JOptionPane.showMessageDialog(panel, "Tie Lmao you both dog water",
                     "Lol", JOptionPane.ERROR_MESSAGE);
                  clearboard(board,cell1,cell2,cell3,cell4,cell5,
                     cell6,cell7,cell8,cell9);
                  player=true;
               }
               if (cell1.isEnabled()){player=checkplayer(Turn,player,isX,ally, opponent);}
               Wins.setText("X:"+XWins+" Wins. O:"+YWins+" Wins.");
            //1101111011
            }
         
            private boolean checkWinner() 
            {
               if (kandc.checkWinner("O",board)==true)
               {
                  Win.setText("I KNEW YOU COULD DO IT, O");
                  Turn.setText("");
                  YWins++;
                  disableBoard(cell1, cell2, cell3, cell4, cell5, 
                     cell6, cell7, cell8, cell9);
                  player=true;
                  return true;
               } 
               else if (kandc.checkWinner("X",board)==true)
               {
                  Win.setText("wow bravo X");
                  Turn.setText("");
                  XWins++;
                  disableBoard(cell1, cell2, cell3, cell4, cell5, 
                     cell6, cell7, cell8, cell9);
                  player=true;
                  return true;
               }
               return false;
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
   
   			//Font font = new Font("Comic Sans MS", Font.PLAIN,40);
   			//Font smallFont = new Font("Comic Sans MS", Font.PLAIN,12);
   
      /*cell1.setFont(font);//Adds cell font to the buttons
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
      Reset.setFont(smallFont);*/
   
   }
   public static void rescale (JButton cell1,
   	   JButton cell2, JButton cell3, JButton cell4, JButton cell5, 
   	   JButton cell6, JButton cell7, JButton cell8, JButton cell9,
         JFrame f, JButton Reset, JLabel Turn, JLabel Win, JLabel Wins){
      int boxDimensions = (int)(f.getHeight()*0.30);
      int xVal = (int)((f.getWidth()/2)-(boxDimensions*1.5));
      int yVal = (int)(boxDimensions*0.025);
      System.out.println(yVal);
      int resetXSize = boxDimensions;
      int resetYSize = boxDimensions/4;
      cell1.setBounds(xVal,yVal,boxDimensions, boxDimensions);
      cell2.setBounds(xVal+boxDimensions,yVal,boxDimensions, boxDimensions);
      cell3.setBounds(xVal+(boxDimensions*2),yVal,boxDimensions, boxDimensions);
      cell4.setBounds(xVal,yVal+boxDimensions,boxDimensions, boxDimensions);
      cell5.setBounds(xVal+boxDimensions,yVal+boxDimensions, boxDimensions, boxDimensions);
      cell6.setBounds(xVal+(boxDimensions*2),yVal+boxDimensions,boxDimensions, boxDimensions);
      cell7.setBounds(xVal,yVal+(boxDimensions*2),boxDimensions, boxDimensions);
      cell8.setBounds(xVal+boxDimensions,yVal+(boxDimensions*2),boxDimensions, boxDimensions);
      cell9.setBounds(xVal+(boxDimensions*2),yVal+(boxDimensions*2),boxDimensions, boxDimensions);
      Reset.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/2)-resetYSize,resetXSize,resetYSize);
      Turn.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/2)+resetYSize,resetXSize*2, resetYSize);
      Win.setBounds((xVal/2)-(resetXSize/2),(f.getHeight()/3),resetXSize,resetYSize);
      Wins.setBounds((xVal/2)-(resetXSize/2),((f.getHeight()/2)-resetYSize)+(int)(resetYSize*1.25),resetXSize,resetYSize);
   
      
      Font font = new Font("Comic Sans MS", Font.BOLD,xVal/3);
      Font smallFont = new Font("Comic Sans MS", Font.PLAIN,resetYSize/3);
      cell1.setFont(font);//Adds cell font to the buttons
      cell2.setFont(font);
      cell3.setFont(font);
      cell4.setFont(font);
      cell5.setFont(font);
      cell6.setFont(font);
      cell7.setFont(font);
      cell8.setFont(font);
      cell9.setFont(font);
   	
      Turn.setFont(smallFont); //adds font to all the text
      Win.setFont(smallFont);
      Wins.setFont(smallFont);
      Reset.setFont(smallFont);
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
   

   public static boolean checkplayer(JLabel Turn,boolean player,boolean isX,String ally,String opponent)
   {
      if (player)
      {
         Turn.setText("Take your time,"+ally);
      }
      else
      {
         Turn.setText("Take your time,"+opponent);
      }
      return player;
   }

   public static int [] startingPositions  (Random rand) throws ArrayIndexOutOfBoundsException
   {
      int [] startCoords = new int [2];
      startCoords [0] = -1;
      startCoords [1] = -1;
      int starter = rand.nextInt(5);
   	//System.out.println(starter);
      if (starter == 0)
      {
         startCoords [0] = 0;
         startCoords [1] = 0; 
      }
      else if (starter == 1)
      {
         startCoords [0] = 0;
         startCoords [1] = 2;
      }
      else if (starter == 2)
      {
         startCoords [0] = 2;
         startCoords [1] = 0;
      }
      else if (starter == 3)
      {
         startCoords [0] = 2;
         startCoords [1] = 2;
      }
      else if (starter == 4)
      {
         startCoords [0] = 1;
         startCoords [1] = 1;
      }
      System.out.print(startCoords[0]);
      System.out.print(startCoords[1]);
      return startCoords;
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
	//AI Stuff Start
   public static int checkWinnerConverted (KnotsAndCrosses kandc, String [][] board, boolean isX, String ally, String opponent){
      int winScore = 0;
      if (kandc.checkWinner(ally, board)==true){
         winScore = 10;
      }else if (kandc.checkWinner(opponent, board)==true){
         winScore = -10;
      }
      return winScore;
   } 
	// the minimax function brought to life, returns values for different wins 
   public static int AI (KnotsAndCrosses kandc,String [][] board, boolean maximizer, int moves, boolean isX, String ally, String opponent){
      int winnerValue = checkWinnerConverted(kandc, board, isX, ally, opponent);
      if (winnerValue == 10){
      	//System.out.print(moves);   
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
                  board[i][j] = ally; 
                  score = Math.max(score, AI(kandc, board, false, moves+1, isX, ally, opponent));
                  board[i][j] = "why";
               	//moves++;
               }
            }
         }
         return score;
      }else {
         score = 1000;
         for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++){
               if (board [i][j]== "why"){
                  board [i][j] = opponent;
                  score = Math.min(score, AI(kandc, board, true, moves+1, isX, ally, opponent)); 
                  board [i][j] = "why";                 
               }
            }
         }      
         return score;
      }
   }
	
   public static int [] bestMove (KnotsAndCrosses kandc, String [][] board, int moves,boolean isX, String ally, String opponent){
      if (isX == true){
         ally = "O";
         opponent = "X";
      }else if (isX == false) {
         ally = "X";
         opponent = "O";
      }
      int [] bestMoveCoords= new int [2]; 
      bestMoveCoords [0] = -1;
      bestMoveCoords [1] = -1;
      int highScore = -1000;
      for (int i = 0; i <=2; i++) {
         for (int j = 0; j <=2; j++){
            if (board [i][j]== "why"){
               board [i][j] = ally;
               int moveValueIndex = AI(kandc, board, false, 0, isX, ally, opponent);
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
	//AI Stuff End
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
	
   public static void enableBoard (JButton cell1,
   		JButton cell2, JButton cell3, JButton cell4, JButton cell5, 
   		JButton cell6, JButton cell7, JButton cell8, JButton cell9)
   {
      cell1.setEnabled(true);
      cell2.setEnabled(true);
      cell3.setEnabled(true);
      cell4.setEnabled(true);
      cell5.setEnabled(true);
      cell6.setEnabled(true);
      cell7.setEnabled(true);
      cell8.setEnabled(true);
      cell9.setEnabled(true);
   }

   public static void AIMove (KnotsAndCrosses kandc,String [][] board,JButton cell1,
   		JButton cell2, JButton cell3, JButton cell4, JButton cell5, 
   		JButton cell6, JButton cell7, JButton cell8, JButton cell9,int[] x, String opponent) 
   {
      try 
      {
         int X=x[0];
         int Y=x[1];
         System.out.println(X+","+Y);
         if(X==0&&Y==0) //Cell1
         {
            cell1.setText(opponent);
         }
         else if(X==1&&Y==0) //Cell2
         {
            cell2.setText(opponent);
         }
         else if(X==2&&Y==0) //Cell3
         {
            cell3.setText(opponent);
         }
         else if(X==0&&Y==1) //Cell4
         {
            cell4.setText(opponent);
         }
         else if(X==1&&Y==1) //Cell5
         {
            cell5.setText(opponent);
         }
         else if(X==2&&Y==1) //Cell6
         {
            cell6.setText(opponent);
         }
         else if(X==0&&Y==2) //Cell7
         {
            cell7.setText(opponent);
         }
         else if(X==1&&Y==2) //Cell8
         {
            cell8.setText(opponent);
         }
         else if(X==2&&Y==2) //Cell9
         {
            cell9.setText(opponent);
         }
         board[X][Y]=opponent;
      }
      catch (Exception e)
      {
         JPanel panel = new JPanel();
         JOptionPane.showMessageDialog(panel, "Tie Lmao you both dog water",
            "Lol", JOptionPane.ERROR_MESSAGE);
         clearboard(board,cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9);
      
      }
   }

   public static boolean move(JButton cell,boolean turn,String[][] board,int x, int y,String gamemode,boolean isX,String ally, String opponent,String[]Options)
   {
      if (board[x][y] == "why") //boolean turn=player 1 or 2/AI Options[2] decides who goes first
      {						 //boolean isX is player 1 X or not. 
         if(Options[0]=="AI")
         {
            cell.setText(ally);
            board[x][y]=ally;
            return !turn;
         }
         else
         {
            if (turn) //If player 1
            {
               cell.setText(ally);
               board[x][y]=ally;
               System.out.println(ally);
               return !turn;
            }
            else //If player 2 
            {
               cell.setText(opponent);
               board[x][y]=opponent;
               return !turn;
            }
         }
      
      }
      else{error();}
      return turn;
   }

   public static boolean checkBoard(String[][] board)
   {
      for (int i=0; i<=2; i++)
      {
         for (int j=0; j<=2; j++)
         {
            if (board[j][i]=="why")
            {
               return true;
            }
         }
      }
      return false;
   }

   public static void printBoard(String[][] board)
   {
      for (int i=0; i<=2; i++)
      {
         for (int j=0; j<=2; j++)
         {
            if (board[j][i]!="why")
            {
               System.out.print(board[j][i]);
            }
            else
            {
               System.out.print("_");
            }
         }
         System.out.println();
      }
      System.out.println("-+-+-+-+-");
   }

   @SuppressWarnings("deprecation")
   public static String[] getOptions()
   {
      Font font = new Font("Comic Sans MS", Font.PLAIN,40);
      Font Smallfont = new Font("Comic Sans MS", Font.PLAIN,15);
      JFrame f = new JFrame("Pick stuff");
      f.getContentPane();
      f.setSize(500,700);
      f.setVisible(true);
      f.setLayout(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      f.setCursor(2);
      String[] Options = new String[3];
   
      JLabel chooseGamemode = new JLabel     ("Choose your gamemode"); //creates essential JLabels
      JLabel choosePlayer = new JLabel       ("If AI mode, who will you play");
      JLabel chooseStartingPlayer= new JLabel("Choose who will go first");
   
      JLabel currentGamemode = new JLabel     ("Current Selection:");
      JLabel currentPlayer = new JLabel       ("Current Selection:");
      JLabel currentStartingPlayer =new JLabel("Current Selection:"); 
   
      chooseGamemode.setFont(Smallfont);
      choosePlayer.setFont(Smallfont);
      chooseStartingPlayer.setFont(Smallfont);
      currentGamemode.setFont(Smallfont);
      currentPlayer.setFont(Smallfont);
      currentStartingPlayer.setFont(Smallfont);
   
   
      JLabel Preview = new JLabel ("You will play a");
   
      f.add(chooseGamemode);
      f.add(choosePlayer);
      f.add(chooseStartingPlayer);
      f.add(currentGamemode);
      f.add(currentPlayer);
      f.add(currentStartingPlayer);
      f.add(Preview);
   
      chooseGamemode.setBounds(30,10,200,50);
      choosePlayer.setBounds(30,210,400,50);
      chooseStartingPlayer.setBounds(30,410,400,50);
   
      currentGamemode.setBounds(300,100,200,50);
      currentPlayer.setBounds(300,300,200,50);
      currentStartingPlayer.setBounds(300,500,200,50);
   
      JButton duo = new JButton ("1v1");
      JButton AI = new JButton ("AI");
      f.add(duo);
      f.add(AI);
      duo.setFont(font);
      AI.setFont(font);
      duo.setBounds(50,60,100,100);
      AI.setBounds(150,60,100,100);
   
      JButton X = new JButton ("X");
      JButton O = new JButton ("O");
      f.add(X);
      f.add(O);
      X.setFont(font);
      O.setFont(font);
      X.setBounds(50,260,100,100);
      O.setBounds(150,260,100,100);
   
      JButton XFirst = new JButton ("X");
      JButton OFirst = new JButton ("O");
      f.add(XFirst);
      f.add(OFirst);
      OFirst.setFont(font);
      XFirst.setFont(font);
      XFirst.setBounds(50,460,100,100);
      OFirst.setBounds(150,460,100,100);
   
   
      ActionListener e = (ActionListener) 
         new ActionListener()//oh lord
         {
            public void actionPerformed(ActionEvent e) 
            {
               Object obj = e.getSource();
               if (obj==duo) {Options[0]=setOption(currentGamemode,"1v1");}
               else if (obj==AI) {Options[0]=setOption(currentGamemode,"AI");}
               else if (obj==X) {Options[1]=setOption(currentPlayer,"X");}
               else if (obj==O) {Options[1]=setOption(currentPlayer,"O");}
               else if (obj==XFirst) {Options[2]=setOption(currentStartingPlayer,"X First");}
               else if (obj==OFirst) {Options[2]=setOption(currentStartingPlayer,"O First");}
            }
         };
   
      duo.addActionListener((ActionListener) e);
      AI.addActionListener((ActionListener) e);
      X.addActionListener((ActionListener) e);
      O.addActionListener((ActionListener) e);
      XFirst.addActionListener((ActionListener) e);
      OFirst.addActionListener((ActionListener) e);
   
      JButton complete = new JButton("Done");
      complete.addActionListener(
         new ActionListener() 
         {
            boolean gameStart = false;
            public void actionPerformed(ActionEvent e) 
            {
               gameStart = confirmGame(f,Options);
            }
         });
      f.add(complete);
      complete.setBounds(200,600,100,50);
      return Options;
   }

   public static String setOption (JLabel text, String option) 
   {
      text.setText("Current Selection:"+option);
      return option;
   }

   @SuppressWarnings("deprecation")
   public static boolean confirmGame (JFrame f,String[] Options) throws ArrayIndexOutOfBoundsException
   {
      try 
      {
         Object[] options = 
            {
            		"Lets go",
            		"Nah",
            };
         int n = JOptionPane.showOptionDialog(f,
            	"You sure you want to play a "+Options[0]+" Game with player one playing "+Options[1]+
            	" And "+Options[2],
            	"You Good with this?"
            	,
            	JOptionPane.YES_NO_OPTION,
            	JOptionPane.QUESTION_MESSAGE,
            	null,
            	options,
            	options[1]);
         if(n == JOptionPane.YES_OPTION) 
         {
            f.dispose();
            JOptionPane.showMessageDialog(null, "Enjoy a life changing tic tac toe experience", 
               	null, JOptionPane.INFORMATION_MESSAGE);
            game(Options);
            return true;
         }
         else if(n == JOptionPane.NO_OPTION) 
         {
            JOptionPane.showMessageDialog(null, "Wow u bad", 
               	null, JOptionPane.INFORMATION_MESSAGE);
         	//Calls method again
         
         }
      }
      catch (Exception e)
      {
         System.out.println("oops");
      }
      return false;
   }
}


