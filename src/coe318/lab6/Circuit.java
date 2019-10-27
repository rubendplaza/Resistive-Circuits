package coe318.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Circuit {

    private static Circuit instance = null;
    private ArrayList <Resistor> resistors;

    private Circuit(){

        resistors = new ArrayList<Resistor>();

    }

    /**
     * Creating the single instance of the circuit
     * if no instance exists then it creates one
     * */
    public static Circuit getInstance(){

        if(instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    public boolean add(Resistor r){

        if(r instanceof Resistor) {
            resistors.add(r);
            return true;
        }
        else{
            System.out.println("Resistor was not an instanceof of resistor class");
            return false;
        }
    }

    @Override

    public String toString(){

        String returnString = "";

        for(int x = 0; x < resistors.size(); x++){

            returnString += resistors.get(x) + "\n";

        }

        return returnString;

    }


    public static void main(String[] args) {

        int numOfNodes;
        int numOfResistors;
        double valueOfResistor;
        int node1;
        int node2;

        Scanner input = new Scanner(System.in);

        Circuit circuit = Circuit.getInstance();

        Node[] nodeArray;

        Resistor[] resistorArray;

        System.out.println("How many nodes do you have? ");
        numOfNodes = input.nextInt();

        if(numOfNodes < 1){
            throw new IllegalArgumentException("You cannot have less than 1 node.");
        }

        System.out.println("\nInitializing nodes...");

        nodeArray = new Node[numOfNodes];
        for(int x = 0; x < numOfNodes; x++){
                nodeArray[x] = new Node();
        }

        System.out.println("\nDone initializing nodes.");

        System.out.println("\nHow many resistors do you have? ");
        numOfResistors = input.nextInt();

        if(numOfResistors < 1){
            throw new IllegalArgumentException("You cannot have less than 1 resistor.");
        }

        System.out.println("Initializing resistors...");

        resistorArray = new Resistor[numOfResistors];
        for (int x = 0; x < numOfResistors; x++){

            System.out.println("What is the value of R" + (x+1) + ":");
            valueOfResistor = input.nextDouble();

            if(valueOfResistor <= 0){
                throw new IllegalArgumentException("Resistor value cannot be negative");
            }

            System.out.println("What is the number of the first node its connected to?");
            node1 = input.nextInt();

            if(node1 < 0 || node1 > numOfNodes-1){
                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
            }

            System.out.println("What is the number of the second node its connected to?");
            node2 = input.nextInt();

            if(node2 < 0 || node2 > numOfNodes-1){
                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
            }
            resistorArray[x] = new Resistor(valueOfResistor, nodeArray[node1], nodeArray[node2]); // finally initializing the resistor after given resistance and its two connected nodes
        }

        System.out.println(circuit); // prints out all the resistors in the resistor arraylist
        input.close();
    }

}









