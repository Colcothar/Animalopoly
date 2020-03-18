/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.random;
import java.util.*;

/**
 *
 * @author Admin
 */

 public class Cards {
    


    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    int num = 0;
    Random random = new Random();

    
    
    public Cards(){
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


        list2.add(50);

        list2.add(-100);

        list2.add(-150);

        list2.add(-140);

        list2.add(75);

        list2.add(150);

        list2.add(100);

        list2.add(60);

        list2.add(-100);

        list2.add(-100);

        list2.add(100);

        list2.add(100);

        list2.add(69);

        list2.add(-200);

        list2.add(200);

        list2.add(-50);

        list2.add(11);


        list2.add(-200);

        list2.add(-100);

        list2.add(100);
    }
    
    public void getCard(){
        num = random.nextInt(list.size());
        System.out.println(list.get(num) );
    }
    
    public int getCardAmount(){
       return list2.get( num );
    }
    
    


}
