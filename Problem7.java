/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;
/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/
/**
 *
 * @author vikka994
 */
public class Problem7 implements ProjectEulerProblem{
    private long solution;
    private final int pNr = 7; //Number of problem
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
        
        solution = UtilityClass.getNthPrime(10001);
        
        UtilityClass.endTimer(this);
    }
    
}


