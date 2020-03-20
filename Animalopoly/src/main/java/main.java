/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Admin
 */
class main {    
    public static void main(String[] args) {    
        
        String animals[]={"0","Dog","Cat","Fish","Parrot","Cow","Goat","Sheep","Chicken","Pig","Geese","Fox","Dingo","0","Octopus","Doplhin","Whale","Narwhale","Flamingo", "Panda","Rhino","Giraffe","Cheetah","Elephant","Tiger","lion"};
        int cost[]={0,20,30,50,60,100,120,140,200,250,260,300,350,0,390,410,460,500,510,560,600,640,670,700,800,850} ;   
        int numOfPlayers,total;

        Scanner reader = new Scanner(System.in);       

        ArrayList<Animals> animal = new ArrayList<>();
        ArrayList<Player> player = new ArrayList<>();
        
        for(int x=0; x<26; x++ ){
             animal.add( new Animals(animals[x],cost[x]));
        }
        
        Game game = new Game(animal, player);
        numOfPlayers = game.numOfPlayer();
        
        for(int x=0; x< numOfPlayers;x++){
            player.add( new Player(x));
            System.out.println("You are player number " + x + "\n");
        }
        
        total = numOfPlayers;
        
        while(total>1){
            for(int x=0; x< numOfPlayers;x++){
                int Bankrupt = player.get(x).getBankrupt(), missTurn = player.get(x).getMissTurn();
                int roll;
                
                if((Bankrupt==1) && (0==missTurn)){
                    System.out.println("\n\n");
                    System.out.println(player.get(x).getName() + "'s turn");
                    
                    game.move(x);
                }
            }
            total=0;
            for(int x=0; x< numOfPlayers;x++){
                total+= player.get(x).getBankrupt();
                player.get(x).missTurn();
            } 
        }
            
        for(int x=0; x< numOfPlayers;x++){
            if(player.get(x).getBankrupt()==1){
                System.out.println("Congrats " + player.get(x).getName() + " you won!");
            }                        
        }
    }
}

