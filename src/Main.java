/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aima.core.search.framework.Problem;
import aima.core.search.uninformed.BreadthFirstSearch;

/**
 *
 * @author erich
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BreadthFirstSearch solver = new BreadthFirstSearch();
        int[][] s = {{3,2,1},{0,0,0},{0,0,0}};
        State start = new State(s);
        StateSpace space = new StateSpace();
        
        Problem p = new Problem(start, space, space, space);
        
        solver.search(p);
        System.out.println(solver.getMetrics());
    }
    
}
