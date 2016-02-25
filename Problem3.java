/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

*/
package projecteulerproblems;

import java.math.BigInteger;

/**
 *
 * @author vikka994
 */
public class Problem3 implements ProjectEulerProblem{
    private int solution;
    private final int pNr = 3; //Number of problem
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
        
        int maxPrime = 10000000 - 1;
        int[] primes = UtilityClass.getPrimes(maxPrime);
        BigInteger number = new BigInteger("600851475143");
        for(int i = primes.length-1; i >= 0; i--){
            if(number.remainder(BigInteger.valueOf(primes[i])) == BigInteger.ZERO){
                solution = primes[i];
                break;               
            }
        }
        
        
        UtilityClass.endTimer(this);
    }
    
}


