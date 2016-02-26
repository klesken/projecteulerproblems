/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;
/*
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
/**
 *
 * @author vikka994
 */
public class Problem6 implements ProjectEulerProblem{
    private long solution;
    private final int pNr = 6; //Number of problem
    @Override
    public int problem() {
        return pNr;
    }

    @Override
    public void solution() {
        System.out.println("Solution is: " + solution);
    }

    @Override
    public void solve() {
        UtilityClass.startTimer();
        
        long sumOfSquares = 0;
        long squareOfSums = 0;
        for(int i = 1; i <= 100; i++){
            sumOfSquares += (i*i);
            squareOfSums += i;
        }
        squareOfSums *= squareOfSums;
        
        solution = squareOfSums - sumOfSquares;
        
        
        UtilityClass.endTimer(this);
    }
    
}


