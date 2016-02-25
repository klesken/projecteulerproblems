/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;

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
        
        
        UtilityClass.endTimer(this);
    }
    
}


