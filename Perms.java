/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonesense;
import java.util.*;
/**
 *
 * @author landini
 */
public class Perms {
    GuideBook mybook = new GuideBook();
    String[][] Guide = mybook.getGuide();
    
    private int[] digCollect(int number){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(number > 0){
           
            stack.push(number % 10);
            number = number / 10;
            
        }
        int[] digits = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            digits[i] = stack.pop();
            i++;
     
        }
        return digits;
    }
     String output = "";
     int pos = 0;
    
    private void permHelper(int[] number){
        if(pos > number.length-1){
            System.out.println(output);
            output = output.substring(0,output.length()-1);
            pos--;
            
            return;
        }
        int page = number[pos];
        String[] GuidePage = Guide[page];
        for(int s = 0;s<GuidePage.length;s++){
            
            output += GuidePage[s];
            pos++;
            permHelper(number);
           if(GuidePage.length-1 != s || output.length()== 0){
            } else {
               pos--;
               output = output.substring(0,output.length()-1);
            }
            
        }
    }
    
    
    public void Permutations(int number){
        int[] digits = digCollect(number);
        permHelper(digits);
    }
    
}
