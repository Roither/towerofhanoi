/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.GoalTest;
import aima.core.search.framework.ResultFunction;
import aima.core.agent.Action;
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
        
        if(state.rods[0][0]==0 && state.rods[1][0]==0){
            return true;
        }
        
        return false;
    }
    
    private int pop(State s, int r){
        int ret = 0;
        
        for(int i = s.rods[r].length-1; i >= 0; i--){
            if(s.rods[r][i]>0){
                ret = s.rods[r][i];
                s.rods[r][i]=0;
                break;
            }
        }
        
        return ret;
    }
    
    private void push(State s, int r, int d){
        s.rods[r][getTopLevel(s,r)+1]=d;
    }
    
    private int getTopDisk(State s, int r){
        for(int i = 0; i < s.rods[r].length; i++){
            if(s.rods[r][i]>0){
                return s.rods[r][i];
            }
        }
        return 0;
    }
    
    private int getTopLevel(State s, int r){
        int ret = -1;
        
        for(int i = s.rods[r].length-1; i >= 0; i--){
            if(s.rods[r][i]>0){
                ret = i;
                break;
            }
        }
        
        return ret;
    }
    
    @Override
    public Set<Action> actions(Object o){
        State state = (State) o;
        HashSet<Action> set = new HashSet();
        
        for(int i = 0; i < state.rods.length; i++){
            
        }
        
        return set;
    }
    
    @Override
    public Object result(Object o, Action action){

        State state = (State) o;
        Move move = (Move) action;
        State result;
        
        //to be implemented
        //return results;
        return null;
    }
}
