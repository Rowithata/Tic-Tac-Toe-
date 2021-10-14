import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
//import src.KnotsAndCrosses;
/*Connor Chang
 * notes to self:
 */
public class Game1
{
   public static void main (String[]args)
   {
   	//JOptionPane.showMessageDialog(null, "I HAVE NO IDEA WHAT IM DOING", null, JOptionPane.INFORMATION_MESSAGE);
      JFrame f= new JFrame("Tic Tac Toe!");
      f.setSize(1000,1000);
      f.setVisible(true);
      f.setLayout(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
      String[][] board = new String [3][3]; //Declaring board.
      ImageIcon img = new ImageIcon("C:\\Users\\rowit\\Downloads\\download.png");
      f.setIconImage(img.getImage());
   	
      clearboard(board); //method used to clear board
   	
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
      JLabel Turn = new JLabel("Hurry up X");
      JLabel Win = new JLabel("");
      JLabel Wins = new JLabel("");
      int moves = 0;
   	
      f.add(cell1); //Adding all needed buttons and text to JFrame
      f.add(cell2);
      f.add(cell3);
      f.add(cell4);
      f.add(cell5);
      f.add(cell6);
      f.add(cell7);
      f.add(cell8);
      f.add(cell9);
      f.add(Reset);
      f.add(Turn);
      f.add(Win);
      f.add(Wins);
   	
      cell1.setBounds(400,100,100,100); //I don't feel like calculating
      cell2.setBounds(500,100,100,100);// every single button placement to be perfect.
      cell3.setBounds(600,100,100,100);
      cell4.setBounds(400,200,100,100);
      cell5.setBounds(500,200,100,100);
      cell6.setBounds(600,200,100,100);
      cell7.setBounds(400,300,100,100);
      cell8.setBounds(500,300,100,100);
      cell9.setBounds(600,300,100,100);
      Reset.setBounds(450,400,200,50);
      Reset.setText("Reset Board");
      
      cell1.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell2.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell3.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell4.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell5.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell6.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell7.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell8.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
      cell9.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
   
      Reset.addActionListener(
         new ActionListener() 
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               clearboard(board);
               cell1.setText("");
               cell2.setText("");
               cell3.setText("");
               cell4.setText("");
               cell5.setText("");
               cell6.setText("");
               cell7.setText("");
               cell8.setText("");
               cell9.setText("");
            
               Turn.setText("Wow you guys suck at this");
               Win.setText("");
            
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
         }); 
       
      Turn.setBounds(450,500,400,50);
      Win.setBounds(450,600,400,50);
      Wins.setBounds(450,650,400,50);
   	
      ActionListener e = (ActionListener) 
         new ActionListener()//oh lord
         {
            int player=1; //even number = X, Odd = O
            boolean error;
            int XWins = 0;
            int YWins = 0;
            public void actionPerformed(ActionEvent e) 
            {
               Object obj = e.getSource();
               if(obj==cell1) 
               {
                  if(board[0][0]=="why")
                  {
                     if (player%2==0)
                     {
                        board[0][0]="X";
                        cell1.setText("X");
                     }
                     else
                     {
                        board[0][0]="O";
                        cell1.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell2) 
               {
                  if(board[1][0]=="why")
                  {
                     if (player%2==0)
                     {
                        board[1][0]="X";
                        cell2.setText("X");
                     }
                     else
                     {
                        board[1][0]="O";
                        cell2.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell3) 
               {
                  if(board[2][0]=="why")
                  {
                     if (player%2==0)
                     {
                        board[2][0]="X";
                        cell3.setText("X");
                     }
                     else
                     {
                        board[2][0]="O";
                        cell3.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell4) 
               {
                  if(board[0][1]=="why")
                  {
                     if (player%2==0)
                     {
                        board[0][1]="X";
                        cell4.setText("X");
                     }
                     else
                     {
                        board[0][1]="O";
                        cell4.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell5) 
               {
                  if(board[1][1]=="why")
                  {
                     if (player%2==0)
                     {
                        board[1][1]="X";
                        cell5.setText("X");
                     }
                     else
                     {
                        board[1][1]="O";
                        cell5.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell6) 
               {
                  if(board[2][1]=="why")
                  {
                     if (player%2==0)
                     {
                        board[2][1]="X";
                        cell6.setText("X");
                     }
                     else
                     {
                        board[2][1]="O";
                        cell6.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell7) 
               {
                  if(board[0][2]=="why")
                  {
                     if (player%2==0)
                     {
                        board[0][2]="X";
                        cell7.setText("X");
                     }
                     else
                     {
                        board[0][2]="O";
                        cell7.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell8) 
               {
                  if(board[1][2]=="why")
                  {
                     if (player%2==0)
                     {
                        board[1][2]="X";
                        cell8.setText("X");
                     }
                     else
                     {
                        board[1][2]="O";
                        cell8.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
               else if (obj==cell9) 
               {
                  if(board[2][2]=="why")
                  {
                     if (player%2==0)
                     {
                        board[2][2]="X";
                        cell9.setText("X");
                     }
                     else
                     {
                        board[2][2]="O";
                        cell9.setText("O");
                     }
                  }
                  else {error(); error=true;}
               }
            //Below are constants, that happen every time
            //somebody makes a move.
               if (error!=true)
               {
                  if (player%2==0)
                  {
                     if (kandc.checkWinner("X",board)==true)
                     {
                        Win.setText("wow bravo X");
                        Turn.setText("");
                        XWins++;
                        cell1.setEnabled(false);
                        cell2.setEnabled(false);
                        cell3.setEnabled(false);
                        cell4.setEnabled(false);
                        cell5.setEnabled(false);
                        cell6.setEnabled(false);
                        cell7.setEnabled(false);
                        cell8.setEnabled(false);
                        cell9.setEnabled(false);
                        player=0;
                     }
                  }
                  else
                  {
                     if (kandc.checkWinner("O",board)==true)
                     {
                        Win.setText("I KNEW YOU COULD DO IT, O");
                        Turn.setText("");
                        YWins++;
                        cell1.setEnabled(false);
                        cell2.setEnabled(false);
                        cell3.setEnabled(false);
                        cell4.setEnabled(false);
                        cell5.setEnabled(false);
                        cell6.setEnabled(false);
                        cell7.setEnabled(false);
                        cell8.setEnabled(false);
                        cell9.setEnabled(false);
                        player=0;
                     }
                  }
               
                  player++;
                  if (player%2 == 0){
                     int x [] = bestMove(kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, moves);
                     for (int i = 0; i <x.length; i++){
                        System.out.print(x[i]);
                     }
                     System.out.println();
                  }
                  if (cell1.isEnabled()){player=checkplayer(Turn,player);}
                  Wins.setText("X:"+XWins+" Wins. O:"+YWins+" Wins.");
               //1101111011
               }
               else {error=false;}
            //System.out.println(player);	//also for debugging			//end
            }
         };
   	
      cell1.addActionListener((ActionListener) e);
      cell2.addActionListener((ActionListener) e);
      cell3.addActionListener((ActionListener) e);
      cell4.addActionListener((ActionListener) e);
      cell5.addActionListener((ActionListener) e);
      cell6.addActionListener((ActionListener) e);
      cell7.addActionListener((ActionListener) e);
      cell8.addActionListener((ActionListener) e);
      cell9.addActionListener((ActionListener) e);
      //more debugging
      //boolean x = areMovesLeft(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9);
      //System.out.println(x);
      //AI(kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, true);
      //System.out.println(bestMove (kandc, board, cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9));
   }
	
   public static void error ()
   {
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel, "This spot is already taken!", "Woah Buddy", JOptionPane.ERROR_MESSAGE);
   }
	
   public static String[][] clearboard(String[][] board)
   {
      for (int i=0;i<=2;i++) //Changing all values to "Why"
      {
         for (int j=0;j <=2;j++)
         {
            board[j][i]="why";
         }
      }
      return board;
   }
	
   public static int checkplayer(JLabel Turn,int player)
   {
   	
      if (player>=9)
      {
         Turn.setText("Tie. You both tried hard, but O is cooler");
         player=0;
         return player;
      }
      
      else if (player%2==0)
      {
         Turn.setText("Hurry up X, make your move");
      }
      else
      {
         Turn.setText("Take your time, O");
      }
      return player;
   }
   // a method to search all the cells and check if there are anu moves left to be made, does not check which moves specifically can be made
   public static boolean areMovesLeft (JButton cell1, JButton cell2, JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, JButton cell8, JButton cell9){
      if (cell1.getText().isEmpty()){
         return true;
      }else if (cell2.getText().isEmpty()){
         return true;
      }else if (cell3.getText().isEmpty()){
         return true;
      }else if (cell4.getText().isEmpty()){
         return true;
      }else if (cell5.getText().isEmpty()){
         return true;
      }else if (cell6.getText().isEmpty()){
         return true;
      }else if (cell7.getText().isEmpty()){
         return true;
      }else if (cell8.getText().isEmpty()){
         return true;
      }else if (cell9.getText().isEmpty()){
         return true;
      }
      return false;
   }
   public static boolean positionsLeft (KnotsAndCrosses kandc, String [][] board){
      for (int c = 0; c <=2; c++){
         for (int d = 0; d <=2; d++){
            if (board [c][d] == "why"){
               return true;
            }
         }
      }
      return false;
   }
   // takes the checkwinner method from KnotsAndCrosses and gives it 10 for x win -10 for o win and 0 for tie
   public static int checkWinnerConverted (KnotsAndCrosses kandc, String [][] board){
      int winScore = 0;
      if (kandc.checkWinner("X", board)==true){
         winScore = 10;
      }else if (kandc.checkWinner("O", board)==true){
         winScore = -10;
      }
      return winScore;
   } 
   // the minimax function brought to life, returns values for different wins 
   public static int AI (KnotsAndCrosses kandc,String [][] board,JButton cell1, JButton cell2, JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, JButton cell8, JButton cell9, boolean maximizer, int moves){
      int winnerValue = checkWinnerConverted(kandc, board);
      if (winnerValue == 10){
         return winnerValue;
      }else if (winnerValue == -10){
         return winnerValue;
      }else if (positionsLeft(kandc, board) == false /*areMovesLeft(cell1,cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9) == false*/ ){
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
   public static int [] bestMove (KnotsAndCrosses kandc,String [][] board,JButton cell1, JButton cell2, JButton cell3, JButton cell4, JButton cell5, JButton cell6, JButton cell7, JButton cell8, JButton cell9, int player){
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
   
}


