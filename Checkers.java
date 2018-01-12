/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsassessment;

/**
 *
 * @author landini-a
 */



public class Checkers {
    private int jumpMax = 0;
    private int count = 0;
    private int player = 0;
    private final int[][] visited = new int[10][2];
    private int place = 0;
    
    private boolean isLegal(int[][] board, int row, int col){
        int locale = board[row][col];
        return !(locale == player || locale == 0);
    }
    
    private boolean wasVisited(int[] val){
        boolean flag;
        for(int[] i : visited){
            flag = true;
            for(int j=0;j<2;j++){
                if(i[j] != val[j]){
                    flag = false;
                }
                
            }
            if(flag){
                return false;
            }
        }
        return true;
    }
    
    private void jumpCounterHelper(int[][] board, int[] pos){
        int row = pos[0];
        int col = pos[1];
        
        //jump down
        if(row + 2 < board.length && isLegal(board,row+1,col) && board[row+2][col] == 0 && wasVisited(new int[]{row+2,col})){
            count++;
            int[] nupos = {row+2,col};
            visited[place] = nupos;
            place++;
            jumpCounterHelper(board,nupos);
        }
        //jump up
        if(row - 2 >= 0 && isLegal(board,row-1,col) && board[row-2][col] == 0 && wasVisited(new int[]{row-2,col})){
            count++;
            int[] nupos = {row-2, col};
            visited[place] = nupos;
            place++;
            jumpCounterHelper(board,nupos);
        }
        //jump left
        if(col - 2 >= 0 && isLegal(board,row,col-1) && board[row][col-2] == 0 && wasVisited(new int[]{row,col-2})){
            count++;
            int[] nupos = {row, col-2};
            visited[place] = nupos;
            place++;
            jumpCounterHelper(board,nupos);
        }
        //jump right
        if( col + 2 < board[0].length && isLegal(board,row,col+1) && board[row][col+2] == 0 && wasVisited(new int[]{row,col+2})){
            count++;
            int[] nupos = {row, col+2};
            visited[place] = nupos;
            place++;
            jumpCounterHelper(board,nupos);
        }
        
        if(count > jumpMax){
            jumpMax = count;
            count--;
        }
        
    }
    
    public int jumpCounter(int[][] board, int[] pos){
        player = board[pos[0]][pos[1]];
        jumpCounterHelper(board,pos);
        return jumpMax;
    }
    

}
