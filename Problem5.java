/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/
/**
 *
 * @author vikka994
 */
public class Problem5 implements ProjectEulerProblem{
    private long solution;
    private final int pNr = 5; //Number of problem
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
        
        
        int[] primes = UtilityClass.getPrimes(20);
        int smallestCommonDivisor = scd(primes);
        
        
        /*
        Create a general solution later, this problem could ALMOST be seen with the naked eye
        */
        solution = 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19;
        
        
        UtilityClass.endTimer(this);
    }
    
    private class SCD{
        private int[] divisors;
        private int[] amountOfEachDivisor;
        public int number;
        
        SCD(int number, int[] primes){
            this.number = number;
            int value = number;
            
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            
            for(int i = 0; i < primes.length; i++){
                while(value % primes[i] == 0 && value > 0){
                    if(!tmp.add(primes[i])) throw new UnsupportedOperationException("Could not add into ArrayList");
                    value /= primes[i];
                }
                
                if(value < primes[i]) break;
                
            }
            
            /*
            Very ugly solution...
            DONT LOOK AT THIS CODE :'(
            */
            
            
            divisors = tmp.stream().mapToInt(t -> t).toArray();
            amountOfEachDivisor = new int[divisors.length];
            for(int i = 0; i < divisors.length; i++){
                int timesFound = 1;
                for(int j = i; j < divisors.length; j++){
                    if(divisors[i] == divisors[j]) timesFound++;
                }
                amountOfEachDivisor[i] = timesFound;
            }
            
        }
        
        public boolean contains(SCD scd){
            int prod = scd.number;
//          int prod = 1;
//            for(int i = 0; i < scd.divisors.length; i++){
//                prod *= scd.divisors[i];
//            }
            return (number >= prod && number % prod == 0);
        }
        
        public boolean contains(int value){
            return (number >= value && number % value == 0);
        }
        

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Arrays.hashCode(this.divisors);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final SCD other = (SCD) obj;
            if (!Arrays.equals(this.divisors, other.divisors)) {
                return false;
            }
            return true;
        }
        
    }
    
    //Smallest Common Divisor 
    private int scd(int[] primes){
        //Map<Integer, Integer> minimumNumberOfEachPrime = new Map<Integer, Integer>();        
        
        SCD[] divisors = new SCD[20];
        for(int i = 0; i < 20; i++){
            divisors[i] = new SCD(i, primes);
        }
        
        
        int scd = 1;
        for(int i = 0; i < 20; i++){
            
        }
        
        
        return 0;
    }
    
    
    private boolean noRemainder(BigInteger value){
        for(int i = 20; i > 1; i--){
            if(value.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) > 0){
                return false;
            }
        }
        return true;
    }
    
    private boolean noRemainder(int value){
        
        //Alltid delbart med 1
        //Om delbart med 20 = 2 * 10 = 2 * 2 * 5
        //Om delbart med 19 = 19
        //Om delbart med 18 = 2 * 9 = 2 * 3 * 3
        //Om delbart med 17 = 17
        //Om delbart med 16 = 2 * 8 = 2 * 2 * 4 = 2 * 2 * 2 * 2
        //Om delbart med 15 = 3 * 5
        //Om delbart med 14 = 2 * 7
        //Om delbart med 13 = 13
        //Om delbart med 12 = 2 * 6 = 2 * 2 * 3
        //Om delbart med 11 = 11
        //Om delbart med 10 = 2 * 5
        //Om delbart med 9 = 3 * 3
        //Om delbart med 8 = 2 * 2 * 2
        //Om delbart med 7 = 7
        //Om delbart med 6 = 2 * 3
        //Om delbart med 5 = 5
        //Om delbart med 4 = 2 * 2
        //Om delbart med 3 = 3
        //Om delbart med 2 = 2
        
        
        
        for(int i = 20; i > 1; i--){
            if(value % i > 0){
                return false;
            }
        }
        

        return true;
    }
    
}


