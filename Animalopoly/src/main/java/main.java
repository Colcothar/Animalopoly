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
        int num;

        Scanner reader = new Scanner(System.in);
        
        ArrayList<Animals> animal = new ArrayList<>();
        for(int x=0; x<26; x++ ){
             animal.add( new Animals(animals[x],cost[x],0));
        }
        //System.out.println(animal.get(25).getAnimal());
        
        
        do{ 
            System.out.println("How many players, max of 8, min of 4?");
            num = Integer.parseInt(reader.nextLine());
        }while ((num<4)||(num>8));
        
        
   
       

        }
}
