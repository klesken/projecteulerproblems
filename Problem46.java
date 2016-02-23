/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;
/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*/
/**
 *
 * @author vikka994
 */
public class Problem46 implements ProjectEulerProblem{
    
    private int smallestOddComposite;
    
    private class ProblemMath{
        private final int amountOfNumbersToCheck = 10000;
        public final int[] squares;
        public final int[] nonPrimes;
        public final int[] primes;
        
        ProblemMath(){
            squares = new int[(int)Math.round(Math.sqrt(amountOfNumbersToCheck))]; //if maximum number checked is 1000 then the squares can't exceed that number ~31
            for(int i = 1; i <= squares.length; i++){
                squares[i-1] = i*i;
            }
            nonPrimes = new int[amountOfNumbersToCheck];
            primes = new int[amountOfNumbersToCheck];
            int iNP = 0;
            int iP = 0;
            int value = 3;
            while(iNP < amountOfNumbersToCheck && iP < amountOfNumbersToCheck){
                if(UtilityClass.isPrime[value] == false){
                    nonPrimes[iNP] = value;
                    iNP++;
                }
                else{
                    primes[iP] = value;
                    iP++;
                }
                value+=2;                
            }
            //System.out.println(nonPrimes[amountOfNumbersToCheck-1]); // 1002 when amount... == 1000
            //System.out.println(squares[(int)Math.round(Math.sqrt(amountOfNumbersToCheck)) - 1]); // 1024 when amount... == 1000
            
        }
        
        public int formula(int prime, int square){
            return prime + 2*square;
        }
        
        public int solve(){
            
            boolean found;
            for(int i = 0; i < amountOfNumbersToCheck; i++){
                found = false;
                for(int j = 0; j < squares.length; j++){
                    if(squares[j] > nonPrimes[i]) break;
                    for(int k = 0; k < primes.length; k++){
                        if(primes[k] > nonPrimes[i]) break;

                        if(nonPrimes[i] == formula(primes[k], squares[j])){
                            found = true;
                            break;
                        }
                        
                    }
                    if(found) break;
                    
                }
                if(!found){
                    return nonPrimes[i];
                }
                
            }
            
            return 0;
        }
        
    }

    @Override
    public int problem() {
        return 46;
    }

    @Override
    public void solution() {
        System.out.println("Solution is: " + smallestOddComposite);
    }

    @Override
    public void solve() {
        ProblemMath maths = new ProblemMath();
        
        smallestOddComposite = maths.solve();
        
        
    }
    
}
