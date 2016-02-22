/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.lang.String;
import java.lang.Float;


/**
 *
 * @author vikka994
 */
/*

A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/
public class Problem26 implements ProjectEulerProblem{
    int largestRecurring;
    int d;
    
    public int problem(){
        return 26;
    }
    
    public Problem26() {
        this.largestRecurring = 1;
        this.d = 1;
    }
    
    //@Override only used when extending a class
    public void solve(){

        parse();

    }
    
    public void solution(){
        System.out.println("1/" + this.d + " produces a " + this.largestRecurring + " long recurrence. 1/" + this.d + " = " + 1.0d/this.d);
    }
    
    private void parse(){  
        
        int sequenceLength = 0;
 
        for (int i = 1000; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
                this.largestRecurring = sequenceLength;
                this.d = i;
            }
        }        
        
        
    }
    
    private int parse(String fraction){
        int recurring = 0;
        int prevRecurring = 0;
        String recStr = fraction.substring(2); //removes "0." from main string
        char[] tempArr = recStr.toCharArray();
        int recLength = recStr.length();
        boolean foundMatch = false;
        
        for(int i = 0; i < recLength; i++){
            
            for(int j = recLength-1; j > i; j--){
                
                /*
                [1][2][3][1][2][3]
                
                [1][1][1][1]
                
                
                
                
                [0][1][0][1][0][1][0][1]
                
                
                */
                
                if(tempArr[i] == tempArr[j]){ //tempArr[i] != '0'            
                   recurring = findRecurrence(tempArr, i, j, ((j-i > recLength-j) ? recLength-j : j-i) );
                }
                
                
            }
            
            if(prevRecurring < recurring){
                prevRecurring = recurring;
            }
            
        }
        
        return prevRecurring;
    }
    
    private int findRecurrence(char[] rec, int startIndex, int startIndex2, int maxLength){
        int counter = 0;
        //System.out.println("maxLength: " + maxLength + " | counter: "+ counter + " | startIndex: "+ startIndex + " | startIndex2: " + startIndex2);
        while(counter < maxLength){
            
            if(rec[startIndex+counter] == rec[startIndex2+counter]){
                counter++;
            }
            else{
                break;
            }

        }
        return counter;
        
    }

    
    
    
}
