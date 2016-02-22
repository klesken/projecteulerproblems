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
public interface ProjectEulerProblem {
    //Shows which problem this class is working on
    public int problem();
            
    //Shows the solution to the problem
    public void solution();
    
    //Solves the problem
    public void solve();    
}
