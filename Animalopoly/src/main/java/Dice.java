
import java.util.Random;

public class Dice {
    public int die1, die2, total;
    
    public Dice() {
    
    }
    
    public int Roll() {
        Random random = new Random();
        die1 = random.nextInt(5)+1;
        die2 = random.nextInt(5)+1;
        System.out.println("You rolled a " + die1 + " and a " + die2);
        total = die1 + die2;
        return total;
    }
    
    public boolean Double() {
        boolean DieDouble = false;
        if (die1 == die2) {
            DieDouble = true;
        }
        return DieDouble;
    }
    
}
