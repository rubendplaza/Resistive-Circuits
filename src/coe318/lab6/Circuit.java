package coe318.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Circuit {

    private static Circuit instance = null;
    private ArrayList <Resistor> resistors;

    private Circuit(){

        resistors = new ArrayList<Resistor>();

    }

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

        /*Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        Resistor res1 = new Resistor(101, node0, node1);
        Resistor res2 = new Resistor(102, node1, node2);
        Resistor res3 = new Resistor(103, node1, node4);
        Resistor res4 = new Resistor(104, node1, node3);
        Resistor res5 = new Resistor(105, node2, node3);
        Resistor res6 = new Resistor(106, node3, node4);
        Resistor res7 = new Resistor(107, node3, node4);

        System.out.println(circuit);*/

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

            System.out.println("What is the value of R" + x+1 + ":");
            valueOfResistor = input.nextDouble();

            if(valueOfResistor <= 0){
                throw new IllegalArgumentException("Resistor value cannot be negative");
            }

            /*resistorArray[x] = new Resistor()*/
        }

    }

}









