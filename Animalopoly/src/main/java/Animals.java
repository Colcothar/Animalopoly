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
    private final int cost; 
    private final int [] stopCost={0,0,0,0};
    private int stopLevel,owner=-1;
            
    public Animals(String name,int cost){
        stopLevel=0;
        this.name = name;
        this.cost = cost;
        generateStopCost();
        }        
           
    public final void generateStopCost(){
        stopCost[0]=(int) (cost*0.1);
        stopCost[1]=(int) (cost*0.3);
        stopCost[2]=(int) (cost*0.7);
        stopCost[3]=(cost*1);
                
    }        
    
    public void upgrade(){
        if(stopLevel<3){
            stopLevel++;
        }
    }
    
    public void getCard(){
        System.out.println("|-------------------------|");
        System.out.println("    " + name);
        System.out.println(" Level: " + stopLevel);
        for(int x =0; x<4; x++){
            System.out.println(" Level " + x + " stop: " + stopCost[x]);
        }
        System.out.println(" Cost: " + cost);
        if(owner==-1){
            System.out.println(" Not Owned");
        }
        else{
            System.out.println(" Owned by player " + owner);
        }
        System.out.println("|-------------------------|");
        
    }
    
    public void setOwner(int owner){
        this.owner = owner;
    }
    
    
    public String getAnimal(){
        return name;
    }
    
    public int getStopLevel(){
        return stopLevel;
    }
    
    public int getCost(){
        return cost;
    }
    
    public int getStopCost(){
        return stopCost[stopLevel];
    }
    
    public int getOwner(){
        return owner;
    }
    
    public void reset(){
        owner=-1;
        stopLevel=0;
    }   
}

