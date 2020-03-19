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
        
        if(owner==-1){
            for(int x =0; x<4; x++){
                System.out.println(" Level " + x + " stop: " + stopCost[x]);
            }
            System.out.println(" Cost: " + cost);
            System.out.println(" Not Owned");
        }
        else{
            System.out.println(" Owned by player " + owner);
            System.out.println(" You have to pay: " + stopCost[stopLevel]);
        }
        System.out.println("|-------------------------|");
    }
    
    //Setters
    public void setOwner(int owner){this.owner = owner;}

    //Getters
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
    
    //Reset
    public void reset(){
        owner=-1;
        stopLevel=0;
    }   
}

