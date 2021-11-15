/*
Game.java creates an object from the class KnotsAndCrosses

*/



import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class KnotsAndCrosses{
   String[][] board; //board positions are stored as a 2d array
   String x = "X";
   String o = "O";
   
   public KnotsAndCrosses(){
   board = new String[3][3];
   }
   
   public boolean checkWinner(String player,String[][] board){ //called after a move is played, takes in the player (X or O) and the current board,  and returns wether the player has one 
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
            
            if(checkrow == 3){ //checks if the player has won horizontally
               return true;
               
            }
            
            for(int k = 0; k < 3; k++){ //checks if the player has won vertically
               if(checkColumn[k] == 3){
                  return true; 
                  
               }
            }
            if(diagonal1 == 3 ){//checks if the player has won on the negative diagonal 
               return true;
               
            }
            
            if(diagonal2 == 3){//checks if the player has won on the positive diagonal 
               return true;
               
            }
            
               
         }
      }
      
      return false; 
   }
   
   public ArrayList<Integer> lineCord(String player,String[][] board){//called after a move is played, takes in the player (X or O) and the current board, returns integers that help Game.java draw a line 
      
      ArrayList<Integer> cordsDirection = new ArrayList<Integer>(); //first cell: x cord , second cell: y cord, thrid cell: direction
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
               //fills the arraylist with coordinates and direction that help place the line in the right place and at the correct angle
               
               cordsDirection.add(0, j); //x cordinate
               cordsDirection.add(1, i); //y coordinate
               cordsDirection.add(2, 1); //dirction: horizontal
               return cordsDirection;
            }
            
            for(int k = 0; k < 3; k++){
               if(checkColumn[k] == 3){
                  
                  cordsDirection.add(0, j);
                  cordsDirection.add(1, i);
                  cordsDirection.add(2, 2); //dircetion: vertical
                  return cordsDirection;            
                  
               }
            }  
            if(diagonal1 == 3 ){
              
               cordsDirection.add(0, j);
               cordsDirection.add(1, i);
               cordsDirection.add(2, 3); //direction: negative diagonal
               return cordsDirection;             
            }
            
            if(diagonal2 == 3){
             
               cordsDirection.add(0, j);
               cordsDirection.add(1, i);
               cordsDirection.add(2, 4); //direction: positive diagnoal 
               return cordsDirection;  
                
            }
            
               
         }
      }
      return cordsDirection;
   
   }

}
