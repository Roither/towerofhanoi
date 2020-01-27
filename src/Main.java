/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aima.core.search.framework.Problem;
import aima.core.search.uninformed.BreadthFirstSearch;

import java.util.List;

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
        //DepthFirstSearch solver = new DepthFirstSearch(new GraphSearch());
        int[][] s = {{3,2,1},{0,0,0},{0,0,0},{0,0,0}};
        State start = new State(s);
        StateSpace space = new StateSpace();
        /*
            protected Object initialState;
            protected ActionsFunction actionsFunction;
            protected ResultFunction resultFunction;
            protected GoalTest goalTest;
            protected StepCostFunction stepCostFunction;
         */
        Problem p = new Problem(start, space, space, space);
        
        List steps = solver.search(p);

        System.out.println("Steps to result:");
        System.out.format("Start with: %n" + start.toString());
        for(int i = 0; i<steps.size();i++) {
            Move step = (Move) steps.get(i);
            System.out.format("Rod %d to Rod %d%n",step.srcRod,step.dstRod);
            start = (State)space.result(start,step);
            System.out.format(start.toString());
        }

        System.out.println(solver.getMetrics());

    }
    
}
