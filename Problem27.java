/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;


/*

Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000


where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.


*/
/**
 *
 * @author vikka994
 */
public class Problem27 implements ProjectEulerProblem   {   
    @Override
    public int problem(){ return 27; }
    
    private int consecutivePrimes = 0;
    private int aSolution = 0, bSolution = 0;
    
    //public Problem27(){
        //this.consecutivePrimes = 0;
        //this.aSolution = 0; this.bSolution = 0;
    //}
    
    @Override
    public void solution(){
        System.out.println("a = " + aSolution + ", b = " + bSolution + " produces " + consecutivePrimes + " consecutive primes. a*b = " + aSolution*bSolution);
    }
       
    @Override
    public void solve(){
        int formula = 0;
        for(int a = -999; a < 1000; a++){
            for(int b = -999; b < 1000; b++){
                
                int n = 0;
                int consecutiveCounter = 0;
                boolean continueCheck = true;
                while(continueCheck){
                    formula = formula(n,a,b);
                    continueCheck = (formula >= 0) ? UtilityClass.isPrime(Math.abs(formula(n,a,b))) : false;
                    consecutiveCounter++;
                    n++;
                }
                
                if(consecutiveCounter > this.consecutivePrimes){
                    this.consecutivePrimes = consecutiveCounter;
                    this.aSolution = a;
                    this.bSolution = b;
                }
                
            }
        }
        
        
    }
    
    // n² + an + b, where |a| < 1000 and |b| < 1000
    private int formula(int n, int a, int b){
        //System.out.println("a: "+a + " b: " + b + " n: "+ n + " test: " + 999*999);
        return (int)(Math.pow(n,2) + a*n + b);
        
    }
    
}
