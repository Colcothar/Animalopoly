/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Animals {
    private String name;
    private final double cost; 
    private final double[] stopCost={0,0,0,0};
    private int stopLevel,owner;
            
    public Animals(String name,int cost,int playerID){
        stopLevel=0;
        owner=playerID;
        this.name = name;
        this.cost = cost;
        generateStopCost();
        }        
           
    public final void generateStopCost(){
        stopCost[0]=(cost*0.1);
        stopCost[1]=(cost*0.3);
        stopCost[2]=(cost*0.7);
        stopCost[3]=(cost*1);
                
    }        
    
    public void upgrade(){
        if(stopLevel<3){
            stopLevel++;
        }
    }
    
    public String getAnimal(){
        return name;
    }
    
    public int getStopLevel(){
        return stopLevel;
    }
    
    public double getCost(){
        return stopCost[stopLevel];
    }
    
    public int getOwner(){
        return owner;
    }
    
    public void reset(){
        
        for(int x = 0; x<4;x++){
            stopCost[x]=0;
        }
        name="";
        owner=0;
        stopLevel=0;
    }
    
    
    
}

