/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;
/*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.
*/
/**
 *
 * @author vikka994
 */
public class Problem45 implements ProjectEulerProblem{
    private long solution;
    
    private static class ProblemMath{
        
        public final static long triangle(long n){
            return (n*(n+1))/2;
        }
        public final static long pentagonal(long n){
            return (n*(3*n - 1))/2;
        }
        public final static long hexagonal(long n){
            return n*(2*n - 1);
        }
    }

    @Override
    public int problem() {
        return 45;
    }

    @Override
    public void solution() {
        System.out.println("Solution is: " + solution);
    }

    @Override
    public void solve() {
        //System.currentTimeMillis();
        UtilityClass.startTimer();
        
        int amountOfNumbersToCheck = 50000; //amount - 1, so if we want 1000 we put 1001 (0 is included as a value)
        long[] triangles = new long[amountOfNumbersToCheck];
        long[] pentagonal = new long[amountOfNumbersToCheck];
        long[] hexagonal = new long[amountOfNumbersToCheck];
        
        for(int i = 0; i < amountOfNumbersToCheck; i++){
            triangles[i] = ProblemMath.triangle(i);
            pentagonal[i] = ProblemMath.pentagonal(i);
            hexagonal[i] = ProblemMath.hexagonal(i);
        }
        
        //Hexa > Penta > Triangle
        //All triangular numbers based on an odd N is also a hexagonal number, so only need to check hexa vs penta
        for(int h = 0; h < amountOfNumbersToCheck; h++){
            for(int p = 0; p < amountOfNumbersToCheck; p++){
                if(pentagonal[p] > hexagonal[h]) break;
                if(hexagonal[h] == pentagonal[p]){
                    solution = hexagonal[h];
                }
                    
                
            }
        }
        
        UtilityClass.endTimer(this);
    }
    
}