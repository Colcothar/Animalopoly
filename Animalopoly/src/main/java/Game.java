import java.util.*;



public class Game {
    
    //Init classes
    Dice dice = new Dice();
    Cards cards = new Cards();
    
    
    private ArrayList<Animals> animal = new ArrayList<>();
    private ArrayList<Player> player = new ArrayList<>();
    Scanner reader = new Scanner(System.in);
            
    public Game(ArrayList animal, ArrayList player){
        this.animal=animal;         
        this.player=player;
    } 

    public int numOfPlayer(){ //asks how many player in the game 
        int numOfPlayers = 0;
        while (numOfPlayers<2 || numOfPlayers>8 || numOfPlayers==0) {
            System.out.println("How many players? (2-8)");
            numOfPlayers = Integer.parseInt(reader.nextLine());
        }
        return numOfPlayers;
    }
    
    public void promptEnterKey(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
     }
    
    public void loadingAnimation() {
         
    }
    
    public void checkDouble(int playerID) {
        //Init vars
        Random random = new Random();
        int randCard;
        
        if (dice.Double() == true) {
            //gives card and sort out money
            //Pick a card
            System.out.println("You rolled a double! Press enter to pick a card");
            promptEnterKey();
            
            int cardNum = random.nextInt(18);
            String card = cards.getCard(cardNum);
            System.out.println("Your card is: " + card );
            int cardVal = cards.getCardAmount(cardNum);
            if (cardVal >= 0) {
                System.out.println("You have gained: £" + cardVal);
            } else {
                System.out.println("You have lost: £" + cardVal);
            }
            player.get(playerID).adjustMoney(cardVal);
        }
        
    }
    
    public void animalBuy(int square, int playerID) {
        int owner;
        
        getInfo(square);
            owner = getOwner(square);
            if(owner==playerID){
                System.out.println("You are the proud owner of " + animal.get(square).getAnimal());
                upgrade(square, playerID);
            }
            else if(owner==-1){
                //code to buy animal
                int money = player.get(playerID).getMoney();
                int cost = animal.get(square).getCost();
                boolean ansYN = false;
                while (ansYN == false) {
                    System.out.println("Do you want to buy an animal? (y/n)");
                    String buyYN = reader.nextLine(); //scan input 
                    if ("y".equals(buyYN) || "Y".equals(buyYN)) {
                        ansYN = true;
                        if (money > cost) {
                            //set new owner
                            animal.get(square).setOwner(playerID);
                            //take money 
                            player.get(playerID).adjustMoney(-(animal.get(square).getCost()));
                        } else {
                            System.out.println("Sorry you don't have enough money to buy this animal");
                        }
                    } else if ("n".equals(buyYN) || "N".equals(buyYN)) {
                        ansYN = true;
                    } else {
                        System.out.println("Please enter y or n \n");
                    }
                }
            } else {
                payStopCost(playerID,square,owner);
            }
    }
    
    public void move(int playerID){
        int temp=0, money =0, noAnimal=0, square=0, roll;
        
        //Roll the dice
        System.out.println("Press enter to roll");
        promptEnterKey();
        roll = dice.Roll();
        
        temp = player.get(playerID).getPosition() + roll;
        money = checkSquare(temp, playerID); //checks if passed start. Works out the money given
        player.get(playerID).adjustMoney(money); // adds the money given to player.
        
        square = player.get(playerID).getPosition(); //gets player position on the board
        noAnimal=CheckForAnimal(playerID); //checks if the player is on a miss turn or start
        
        System.out.println("You are currently on square " + square);
        checkDouble(playerID); //Checks for a double
        
        System.out.println("You currently have £" + player.get(playerID).getMoney());
        
        if(noAnimal!=1){ // if not on miss turn or start
            animalBuy(square, playerID);
        }
        
        if(checkBankruptcy(playerID)){
            System.out.println("Uh oh, you have " + player.get(playerID).getMoney() );
            System.out.println("You've gone bankrupt!");
            System.out.println("Thanks for playing, you've been retired from the game.");
            fileBankruptcy(playerID);                                                        
        }
        
    }
    
    public void payStopCost(int playerID, int square, int owner){
        int moneyToPay = animal.get(square).getStopCost();
        
        player.get(playerID).adjustMoney(-moneyToPay);
        player.get(owner).adjustMoney(moneyToPay);
    }
    
    public void fileBankruptcy(int playerID){
        for(int x =0; x<26; x++){
            if((animal.get(x).getOwner())==playerID){
                animal.get(x).reset();
            } 
        }
    }
    
    public boolean checkBankruptcy(int playerID){
        int money = money = player.get(playerID).getMoney();
        if(money<0){
            player.get(playerID).setBankrupt();
            return true;
        }
        else{
            return false;
        }
    }
    
    public void upgrade(int square, int playerID){
        int money =0, upgradeCost=0;
        String input="";
                
        money = player.get(playerID).getMoney();
        upgradeCost = animal.get(square).getCost();
        
        System.out.println("Cash: £" + money);
        System.out.println("It costs £" + upgradeCost + " to upgrade");
        
        if(animal.get(square).getStopLevel()<3){
            System.out.println("Would you like to upgrade? y,n: ");
            input = reader.nextLine();
            if(input.equals("y")){
                if((money-upgradeCost)<0){
                    System.out.println("You do not have sufficent funds to upgrade");
                }
                else{
                    player.get(playerID).adjustMoney(-upgradeCost);
                    animal.get(square).upgrade();
                }
            }
        }
    }
    
    public int CheckForAnimal(int playerID){
        int pos = player.get(playerID).getPosition();
        switch (pos) {
            case 0:
                return 1;
            case 13:
                player.get(playerID).setMissTurn(); //sets a miss turn
                System.out.println("You landed on miss a turn!");
                return 1;
            default:
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
            temp = temp-26;
            player.get(playerNum).setPosition(temp);            
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
    
    public int cost(){
        return animal.get(1).getCost();
    }
}
