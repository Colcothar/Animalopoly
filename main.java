/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalopoly;
import java.util.*;
/**
 *
 * @author 201901580
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Players> arraylist = new ArrayList<Players>();
        Scanner reader = new Scanner(System.in);
                 
        //String[] Animals = new Animals[6];
        //Animals = {"Animal1", "2", "3", "dfg", "dfg", "dfg"};
        
        String[] fruitArray = {"", "Cow", "Pig", "Chicken", "Sheep", "Dolphin"};
        int[] cost = {0,12,15,20,40,50,60};
        
        for(int i = 0; i < 5; i++){
            //String name = reader.nextLine();
            arraylist.add(new Players(fruitArray[i]));
        }
        
        for(int i = 0; i < 5; i++){
            arrayList.add(new Animal( fruitarray[x], cost ))
        }
        
       
        
        
        
        
        System.out.println(arraylist.get(0).getName());
              
        System.out.println(arraylist.get(1).getName());
              
        System.out.println(arraylist.get(2).getName());
        

    }
    
}
