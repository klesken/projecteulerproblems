/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;
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

    @Override
    public int problem() {
        return 49;
    }

    @Override
    public void solution() {
        System.out.println("Solution is: " + 42);
    }

    @Override
    public void solve() {
        
    }
    
    private int[] permutations(int base){
        int[] fourDigit = new int[4];
        int[] permutations = new int[4];
        permutations[0] = base;
        for(int i = 0; i < 4; i++){
            fourDigit[i] = base % 10;
            base /= 10;
        }
        
        
        return permutations;
    }
    
    
}
