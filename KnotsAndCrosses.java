import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class KnotsAndCrosses{
   String[][] board; 
   String x = "X";
   String o = "O";
   
   public KnotsAndCrosses(){
   board = new String[3][3];
   }
   
   public boolean checkWinner(String player,String[][] board){
   int checkrow = 0; 
   int direction = -1;
   int[] checkColumn = new int[3];
   int diagonal1 = 0;
   int diagonal2 = 0; 
   
      for(int i = 0; i <3; i++){
         checkrow = 0; 
         
         for(int j = 0; j < 3; j++){
            if ( board[j][i] == null ){
               continue;
            }
            
            else if (board[j][i].equals(player)){
               checkrow++;
               checkColumn[j]++;
               if(i == j){
                  diagonal1++;
               }
               if(i + j == 2){
                  diagonal2++;
               }
            }
            
            if(checkrow == 3){
               return true;
               
            }
            
            for(int k = 0; k < 3; k++){
               if(checkColumn[k] == 3){
                  return true; 
                  
               }
            }
            if(diagonal1 == 3 ){
               return true;
               
            }
            
            if(diagonal2 == 3){
               return true;
               
            }
            
               
         }
      }
      
      return false; 
   }
   
   public ArrayList<Integer> lineCord(String player,String[][] board){//Coen look here
      
      ArrayList<Integer> cordsDirection = new ArrayList<Integer>();
      int checkrow = 0; 
      int direction = -1;
      int[] checkColumn = new int[3];
      int diagonal1 = 0;
      int diagonal2 = 0; 
   
      for(int i = 0; i <3; i++){
         checkrow = 0; 
         
         for(int j = 0; j < 3; j++){
            if ( board[j][i] == null ){
               continue;
            }
            
            else if (board[j][i].equals(player)){
               checkrow++;
               checkColumn[j]++;
               if(i == j){
                  diagonal1++;
               }
               if(i + j == 2){
                  diagonal2++;
               }
            }
            
            if(checkrow == 3){
               
               
               cordsDirection.add(0, j);
               cordsDirection.add(1, i);
               cordsDirection.add(2, 1);
               return cordsDirection;
            }
            
            for(int k = 0; k < 3; k++){
               if(checkColumn[k] == 3){
                  
                  cordsDirection.add(0, j);
                  cordsDirection.add(1, i);
                  cordsDirection.add(2, 2);
                  return cordsDirection;            
                  
               }
            }  
            if(diagonal1 == 3 ){
              
               cordsDirection.add(0, j);
               cordsDirection.add(1, i);
               cordsDirection.add(2, 3);
               return cordsDirection;             
            }
            
            if(diagonal2 == 3){
               //commented out return statements
               cordsDirection.add(0, j);
               cordsDirection.add(1, i);
               cordsDirection.add(2, 4);
               return cordsDirection;  
                
            }
            
               
         }
      }
      return cordsDirection;
   
   
   }
   
   public void printBoard(){
      for(int i = 0; i < 3; i++){
         
         for(int j = 0; j < 3; j++){
            if(board[j][i] == null ){
            
               System.out.print("_");
               
                  
               
            }
            else{
              System.out.print(board[j][i]);
            }
            if( j < 2){
              System.out.print("|");
            }
         }
         System.out.println();
      }
   
   
   }
   
   public void makeMove(Scanner console, String s){
            
      System.out.println("Enter coordinates");
      int xcord = console.nextInt();
      int ycord = console.nextInt();
      
      board[xcord][ycord] = s;
     
               
      
 }
   
   
   
   
   
   
   public static void main(String[] args){
      KnotsAndCrosses kandc = new KnotsAndCrosses();
      Scanner console = new Scanner(System.in);
      kandc.printBoard();
      
      boolean turn = true; 
      
      
      int moves = 0; 
      while(moves < 9){
         if(turn){
            kandc.makeMove(console, kandc.x);
            
            kandc.printBoard();
            /*
            if(kandc.checkWinner(kandc.x)){
               System.out.println("bruh how");
               break;
            }
            moves++;
            turn = false;
         }
         
         if(!turn){
            kandc.makeMove(console,kandc.o);
            
            kandc.printBoard();
            
            if(kandc.checkWinner(kandc.o)){
               System.out.println("your opponent is dogwater"); 
               break; 
            }
            moves++;
           
            turn = true; 
         }
         */
      }
      
      
   }
} 
}
