/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author vikka994
 */
public final class UtilityClass {
    public static boolean[] isPrime;
    static{
        isPrime = createPrimes();
    }
    //Creating primes via The Prime Sieve
    private static boolean[] createPrimes(){
        //Size of array and therefore the maximum prime checked is this number
        int nPrimes = 1000000;
        
        System.out.println("Building prime array...");
        
        boolean[] primes = new boolean[nPrimes];
        Arrays.fill(primes, true);
        
        primes[0] = primes[1] = false;
        
        for(int i = 2; i < nPrimes; i++){
            
            if(isPrime(i)){
                for(int j = 2; j*i < nPrimes; j++){
                    primes[j*i] = false;
                }
            }
            
        }
        
        System.out.println("...prime array built.");
        
        return primes;
    }
    
    //Get all primes < max
    public static final Integer[] getPrimes(int max){
        ArrayList<Integer> tempArrList = new ArrayList<Integer>();
        
        int index = 0;
        for(int i = 0; i < max; i++){
            if(isPrime[i]){
                tempArrList.add(index, i);
                index++;
            }
        }
        
        return tempArrList.toArray(new Integer[tempArrList.size()]);
        
    }
    public static final Long[] getPrimes(long max){
        ArrayList<Long> tempArrList = new ArrayList<Long>();
        
        int index = 0;
        for(long i = 0; i < max; i++){
            if(isPrime[(int)i]){ //explicit conversion for problem50, no more than 1000000
                tempArrList.add(index, i);
                index++;
            }
        }
        
        Long[] tempArr = new Long[tempArrList.size()];
        return tempArrList.toArray(tempArr);
                
    }
    
    public static final boolean isPrime(int n){
        
        //Check if multiple of 2 == if even, if so it is not a prime (unless 2 itself)
        if(n%2 == 0 && n != 2) return false;
        
        //Know that 2 is the only even prime so only check odds
        for(int i = 3; i*i < n; i+=2){
            if(n%i == 0) 
                return false;
        }
        
        return true;
        

    }
    
}
