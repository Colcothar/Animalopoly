
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Game {
    private ArrayList<Animals> animal = new ArrayList<>();
    private ArrayList<Player> player = new ArrayList<>();
    Scanner reader = new Scanner(System.in);
            
    public Game(ArrayList animal, ArrayList player){
        this.animal=animal;         
        this.player=player;
    } 
    
    public int numOfPlayer(){ //asks how many player in the game 
        int numOfPlayers = 0;
        do{ 
            System.out.println("How many players, max of 8, min of 4?");
            numOfPlayers = Integer.parseInt(reader.nextLine());
        }while (( numOfPlayers<4)||( numOfPlayers>8));
        return numOfPlayers;
  
    }
    
    public void move(int playerID){
        int temp=0, money =0, noAnimal=0,square=0, owner;

        System.out.println("Press enter to roll");
        
        temp = player.get(playerID).getPosition() + dice.roll();
        
        money = checkSquare(temp, playerID); //checks if passed start. Works out the money given
        player.get(playerID).addMoney(money); // adds the money given to player.
        
        square = player.get(playerID).getPosition(); //gets player position on the board
        
        
        
        noAnimal=CheckForAnimal(playerID); //checks if the player is on a miss turn or star
        
        
        if(noAnimal==1){
            
        }
        else{ // if not on miss turn or start
            getInfo(square);
            owner = getOwner(square);
            
            
            if(owner==playerID){
                System.out.println("You are the proud owner of " + animal.get(square).getAnimal());
            }
            
            
        }        
    }
    
    public int CheckForAnimal(int playerID){
        int pos = player.get(playerID).getPosition();
        
        if(pos==0||pos==13){
            return 1;
        }
        else{
            return 0;
        }
        
    }
    
    public int getOwner(int sqaure){
        return animal.get(sqaure).getOwner();
        
    }
    
    public int checkSquare(int temp, int playerNum){
        if(temp==26){
            temp =0;
            player.get(playerNum).setPosition(temp); 
            System.out.println("You land on start and earn £1000");
            return 1000;
        }
        else if(temp>25){
            System.out.println("You pass start and earnh £500");
            player.get(playerNum).setPosition(temp); 
            temp = temp-26;
            return 500;
        }
        else{
            player.get(playerNum).setPosition(temp); 
            return 0;
        }     
    }
        
    public void CheckMissedTurn(int playerID){
        
        if(player.get(playerID).getPosition()==13){       
            player.get(playerID).missTurn();
        }
    }
    
    public void getInfo(int square){   
        animal.get(square).getCard();
    }
    

}
