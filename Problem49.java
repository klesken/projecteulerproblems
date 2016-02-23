/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.util.ArrayList;
import java.util.Arrays;

/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and,
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/

/**
 *
 * @author vikka994
 */
public class Problem49 implements ProjectEulerProblem{
    
    Permutations solution;

    @Override
    public int problem() {
        return 49;
    }

    @Override
    public void solution() {
        System.out.println("Solution is: " + solution);
        
        
        
        //Solution to problem 20, doesn't deserve its own class
        //UtilityClass.factorialSum(100);        
    }

    @Override
    public void solve() {
        final int size = 4;
        int[] fourDigitPrimes = getFourDigitPrimes();
        Permutations tempP;
        for(int i = 0; i < fourDigitPrimes.length; i++){
            
            tempP = new Permutations(size, fourDigitPrimes[i]);
            if(tempP.checkPermutations(tempP.calculatePermutations())){
                solution = tempP;
            }
            
        }
        
        
    }
    private int[] getFourDigitPrimes(){
        ArrayList<Integer> aLTemp = new ArrayList<>();
        int size = 0;
        for(int i = 1000; i < 10000; i++){
            if(UtilityClass.isPrime[i]){
                aLTemp.add(i);
                size++;
            }
        }
        int[] tempArr = new int[size];
        for(int i = 0; i < size; i++){
            tempArr[i] = aLTemp.get(i);
        }
        
        return tempArr;
    }
    

    
    private class Permutations{
        int[] permutationNumbers;
        int[] permutations;
        int[] indices;
        
        Permutations(int size, int number){
            permutationNumbers = new int[size];
            permutations = new int[UtilityClass.factorial(size)];
            //permutations[0] = number;
            for(int i = size-1; i >= 0; i--){
                permutationNumbers[i] = number % 10;
                number /= 10;
            }
            
        }
        
        @Override
        public String toString(){
            String s = new String();
            for(int i = 0; i < indices.length; i++){
                s += String.valueOf(permutations[indices[i]]) + " ";
                //System.out.print(permutations[i] + "");
            }
            //s += " | " + indices[0] + " , " + indices[1] + " , " + indices[2];
            return s;
        }
        
        //Returns true iff a permutation with 2 primes is found
        public int calculatePermutations(){
            
            int finishedNumber;
            int permutationIndex = 0;
            for(int a = 0; a < 4; a++){
                for(int b = 0; b < 4; b++){
                    if(a == b) continue;
                    for(int c = 0; c < 4; c++){
                        if(b == c || a == c) continue;
                        for(int d = 0; d < 4; d++){
                            if(a == d || b == d || c == d) continue;
                            //System.out.println(a + " " + b + " " + c + " " + d);
                            finishedNumber = (permutationNumbers[a] * 1000) + (permutationNumbers[b] * 100) + (permutationNumbers[c] * 10) + permutationNumbers[d];
                            //System.out.println(finishedNumber);
                            if(UtilityClass.isPrime[finishedNumber] && !containsOrSmaller(permutations, finishedNumber)){
                                //System.out.println(finishedNumber);
                                permutations[permutationIndex] = finishedNumber;
                                permutationIndex++;
                            }

                        }
                    }
                }
            }
              
            return permutationIndex+1;
        }
        private boolean containsOrSmaller(int[] arr, int value){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == value || value < arr[i]) return true;
            }
            return false;
        }
        
        public boolean checkPermutations(int permFound){
            int difference;
            for(int i = 0; i < permFound; i++){
                for(int j = i+1; j < permFound; j++){
                    difference = permutations[j] - permutations[i];
                    for(int k = j+1; k < permFound; k++){
                        if(difference == permutations[k] - permutations[j]){
                            //System.out.println(i + " " + j + " " + k + " 8))");
                            indices = new int[]{i, j, k};
                            return true;
                        }
                    }
                }
            }
            
            
            return false;
        }
        
        
    }
    
    
}
