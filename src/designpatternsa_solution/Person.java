package designpatternsa_solution;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author CPP_Curriculum
 */
public class Person implements Observer{
    
    private String personName;
    //bingo numbers for each player
    private List<Integer> bingoSet = new ArrayList<Integer>(); 
    //to control how many numbers left to match, when = 0, BINGO!
    private int matchesLeft = 3;
    private NumberCallout numberCallout;
 
    // constructor
    public Person(String pName) {            
            
            personName = pName;
            bingoSet = createBingoSet();           
            System.out.print(personName + " has entered the game, their bingo card numbers are ");
            //displays numbers in Person's bingo set
            for (int i:bingoSet){
                System.out.print(i + ", ");
            }
            System.out.println();
            
    }
 
    //creates bingo set of 3 random numbers from 1 to 10 inclusive
    private ArrayList<Integer> createBingoSet(){
        ArrayList<Integer> newBingoSet = new ArrayList<Integer>();
        for (int i=0; i<3; i++){
            int randNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            newBingoSet.add(randNum);                    
        }
        return newBingoSet;
    }
    
    // mandatory method because implements Observer
    @Override
    public void update(Observable o, Object numberCallout) {
        this.numberCallout = (NumberCallout)numberCallout;        
        //checks through the person't bingo set. If number matched the one called out, the amount of numbers to match is reduced
        for (int num:bingoSet){
            if (num == this.numberCallout.getCalloutNumber()){
                matchesLeft--;
            }
        }  
        // Person matched all the numbers, print out victory message and set victory condition to be true
        if (matchesLeft == 0){
            System.out.println("BINGO! " + personName + " has all the numbers called! " + personName + " is the WINNER!");
            this.numberCallout.victory = true;            
        }
    }
}

   
