package designpatternsa_solution;

/**
 *
 * @author CPP_Curriculum
 */
public class DesignPatternSA_Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting the simple bingo game...");
        
        //Creating obervable and observer objects
        NumberCallout observable = new NumberCallout();
        Person observer1 = new Person("Jim");
        Person observer2 = new Person("Svetlana");
        Person observer3 = new Person("Arthur");
        
        //subscribing observers to the observable object that will call out the numbers
        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);
        //the object will call out the numbers until the vicrtory condition is achieved by one of the subscribed objects
        while(observable.checkVictoryCondition() == false){
            observable.generateRandomNumber();        
        }
        //the program terminates when a winner is announced
        System.exit(0);
    }
    
}
