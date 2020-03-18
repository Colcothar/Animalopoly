import java.util.*;

 public class Cards {
    
    private ArrayList<String> list = new ArrayList<>();
    int cardVal[] = {50,-100,-150,-140,75,150,100,60,-100,-100,100,100,-69,-200,200,-50,11,-200,-100,100};
    
    public Cards(){
        //Add cards to array
        list.add("Bank pays you dividend");
        list.add("Pay speeding fine");
        list.add("Pay parking fine ");
        list.add("Pay general repirs");
        list.add("You have been elected Chairman of the Board");
        list.add("Your building and loan matures");
        list.add("You have won a crossword competition");
        list.add("You have won a beauty competition");
        list.add("Drunk driving" );
        list.add("Pay CFD overnight charges");
        list.add("The stock market booms");
        list.add("Receive a mysterious cash prize");
        list.add("Pay library fines");
        list.add("You’ve been caught avoiding tax" );
        list.add("you’ve won the lottery");
        list.add("You’ve got ransomware");
        list.add("Netflix Premium Subscription");
        list.add("Brexit fees");
        list.add("Accidental Car damage");
        list.add("Pay rise ");
    }
    
    public String getCard(int num1){
        return list.get(num1);
    }
    
    public int getCardAmount(int num2){
       return cardVal[num2];
    }
    
}
