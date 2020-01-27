/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.GoalTest;
import aima.core.search.framework.ResultFunction;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author erich
 */
public class StateSpace implements GoalTest, ActionsFunction, ResultFunction{
    
    
    @Override
    public boolean isGoalState(Object o){
        State state = (State) o;
        
        for(int i = 0; i<state.rods.length-1;i++){
            if(getTopLevel(state,i)>=0)
                return false;
        }
        return true;
    }
    
    private int pop(State s, int rod){
        int ret = 0;
        
        for(int i = s.rods[rod].length-1; i >= 0; i--){
            if(s.rods[rod][i]>0){
                ret = s.rods[rod][i];
                s.rods[rod][i]=0;
                return ret;
            }
        }
        
        return ret;
    }
    
    private void push(State s, int rod, int disk){
        s.rods[rod][getTopLevel(s,rod)+1]=disk;
    }
    
    private int getTopDisk(State s, int rod){
        int topLevel = getTopLevel(s,rod);
        if(topLevel<0)
            return 0;
        else
            return s.rods[rod][topLevel];
    }
    
    private int getTopLevel(State s, int rod){
        int ret = -1;
        
        for(int i = s.rods[rod].length-1; i >= 0; i--){
            if(s.rods[rod][i]>0){
                return i;
            }
        }
        
        return ret;
    }
    
    @Override
    public Set<Action> actions(Object o){
        State state = (State) o;
        HashSet<Action> set = new HashSet();
        int topDisk = 0;
        for(int i = 0; i < state.rods.length; i++){
            topDisk = getTopDisk(state,i);
            if(topDisk > 0 ){
                for(int j = 0; j < state.rods.length; j++){
                    if(topDisk < getTopDisk(state,j) || getTopDisk(state,j)==0){
                        set.add(new Move(i,j));
                    }
                }
            }
        }
        
        return set;
    }
    
    @Override
    public Object result(Object o, Action action){

        State state = (State) o;
        state = state.clone();
        Move move = (Move) action;

//        System.out.format("Try to move Rod %d to Rod %d%n",move.srcRod,move.dstRod);
//        System.out.println(state);

        int disk = pop(state, move.srcRod);

        push(state, move.dstRod, disk);

        return state;
    }
}
