/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.util.Arrays;

/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

/**
 *
 * @author vikka994
 */
public class Problem50 implements ProjectEulerProblem{
    private long largestPrimeSum = 0;
    private ConsecutivePrimes largestPrime = new ConsecutivePrimes();
    
    @Override
    public int problem(){ return 50; }
    
    @Override
    public void solution(){
        //System.out.print("The primes ");
        //largestPrime.printPrimes();
        //System.out.println(" produces the sum " + largestPrime.result + " which is a prime number.");
        System.out.println(largestPrimeSum);
    }
    
    @Override
    public void solve(){
        anotherSolution2();
/*        
        int maxPrime = 1000000;
        
        ConsecutivePrimes[] consPrimes = new ConsecutivePrimes[maxPrime];
        
        Integer[] primeArr = UtilityClass.getPrimes(maxPrime);
        
        //for(Integer prime : primeArr){
        int sum = 0;
        int consPrimesIndex = 0;
        for(int i = 0; i < primeArr.length; i++){
            sum = primeArr[i];
            for(int j = i+1; j < primeArr.length; j++){
                sum += primeArr[j];
                if(sum >= maxPrime){
                    break;
                }
                else if(UtilityClass.isPrime[sum]){
                    //System.out.println("sum: " + sum + " i:" + i + " j:" + j);
                    //System.out.println("start prime[" + i + "] = "  + primeArr[i] + " end prime[" + j + "] = " + primeArr[j] + " sum = " + sum);
                    
                    
                    consPrimes[consPrimesIndex] = new ConsecutivePrimes( Arrays.copyOfRange(primeArr,i,j+1), j-i+1, sum);
                    consPrimesIndex++;
                }
                
            }

        }
        
        for(int k = 0; k < consPrimesIndex; k++){
            if(consPrimes[k].result > largestPrime.result){
                //System.out.println("k = " + k);
                largestPrime = consPrimes[k];
            }
        }
*/       
    }
    
    private void anotherSolution(){
        int maxPrime = 1000000;
        
        int[] primeArr = UtilityClass.getPrimes(maxPrime);
        final int indexMax = primeArr.length;
        long[] primeSums = new long[indexMax + 1]; //+1 to have the first element be 0
        primeSums[0] = 0;
        for(int i = 0; i < indexMax; i++){
            primeSums[i+1] = primeSums[i] + primeArr[i];
            //System.out.println(primeSums[i]);
        }
        
        long primeSum = 0;
        for(int x = 0; x < indexMax; x++){
            for(int y = x-1; y >= 0; y--){
                primeSum = primeSums[x] - primeSums[y];
                //System.out.println(primeSum + "   " + indexMax);
                if(primeSum >= maxPrime)
                    break;
                
                if(UtilityClass.isPrime[(int)primeSum]){ //explicit conversion because we know int can hold 1000000
                    largestPrimeSum = primeSum; //explicit conversion because we know int can hold 1000000
                }
                
            }
        }
        
        
    }
    
    private void anotherSolution2(){
            final long limit = 1000000;
            long result = 0;
            int numberOfPrimes = 0;
            Long[] primes = UtilityClass.getPrimes(limit);
            long[] primeSum = new long[primes.length+1];

            
            primeSum[0] = 0;            
            for (int i = 0; i < primes.length; i++) {                
                primeSum[i+1] = primeSum[i] + primes[i];                
            }
                                                
            for (int i = numberOfPrimes; i < primeSum.length; i++) {
                for (int j = i-(numberOfPrimes+1); j >= 0; j--) {               
                    
                    if (primeSum[i] - primeSum[j] > limit) {                        
                        break;
                    }

                    if (UtilityClass.isPrime[(int)(primeSum[i] - primeSum[j])]) {
                        numberOfPrimes = i - j;                        
                        result = primeSum[i] - primeSum[j];                                                
                    }                    
                }                
            }
            
            System.out.println("result: " + result);
    }
    
    private class ConsecutivePrimes{
        public int[] consPrimes;
        public int result;
        
        ConsecutivePrimes(){
            consPrimes = new int[0];
            result = 0;
        }
        
        ConsecutivePrimes(Integer[] subArr, int size, int result){
            //int size = subArr.length;
            //System.out.println((size == _size) + " | " + size + " | " + _size);
            consPrimes = new int[size];
            for(int i = 0; i < size; i++){
                consPrimes[i] = subArr[i];
            }
            this.result = result;
            
        }
        
        public void printPrimes(){
            for(int prime : consPrimes){
                System.out.print(prime + ", ");
            }            
        }
        
       //public int getResult()
        //public int[] getPrimes()
        
        
    }    
    
}
