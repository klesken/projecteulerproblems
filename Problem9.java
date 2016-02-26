/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;
/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/
/**
 *
 * @author vikka994
 */
public class Problem9 implements ProjectEulerProblem{
    private int[] solution;
    private final int pNr = 9; //Number of problem
    @Override
    public int problem() {
        return pNr;
    }

    @Override
    public void solution() {
        System.out.println("The solution to Problem" + problem() + " is: " + solution[0]*solution[1]*solution[2]);
    }

    @Override
    public void solve() {
        UtilityClass.startTimer();
        final int maxVal = 500;
        
        for(int a = 1; a < maxVal; a++){
            for(int b = a+1; b < maxVal; b++){
                for(int c = b+1; c < maxVal; c++){
                    if(a+b+c == 1000){
                        if(pythTriplet(a,b,c)){
                            solution = new int[]{a,b,c};
                        }
                    }
                }
            }
        }

        UtilityClass.endTimer(this);
    }
    
    private boolean pythTriplet(int a, int b, int c){
        return ((a*a)+(b*b) == (c*c));
    }
    
}


