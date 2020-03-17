import java.util.Scanner; 

/**
 * @author alexm
 */
public class Player {
    //Initialise variables
    private final String name, piece;
    private final int playerID;
    private int position, missTurn, bankrupt;
    private double money;

    //Initiailise class 
    public Player (int playerID){
        this.playerID = playerID;
        this.money = 50;
        this.position = 0;
        this.missTurn = 2;
        this.bankrupt = 1;

        //Take input from the player
        Scanner s = new Scanner(System.in);  // Create a Scanner object (s)
        System.out.println("Enter name");
        name = s.nextLine(); //scan input 
        System.out.println("Enter a charachter to use as a piece");
        piece = s.nextLine(); //scan input 
    }        

    //Misc Functions
    public void adjustMoney(double amount){money += amount;} //Add and remove money (negative val for remove)

    //Getters
    public double getMoney(){return money;}
    public String getName(){return name;}
    public String getPiece(){return piece;}
    public int getPlayerID(){return playerID;}
    public int getPosition(){return position;}
    public int getMissTurn(){return missTurn;}
    public int getBankrupt(){return bankrupt;}

    //Setters
    public void setPosition(int pos){position = pos;}
    public void setMissTurn(){missTurn = 2;}
    public void setBankrupt(){bankrupt = 0;}

}
