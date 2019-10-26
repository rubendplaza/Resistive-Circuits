package coe318.lab5;

import java.lang.reflect.Constructor;

public class Resistor {

    static private int resistorCounter = 1;
    private int resistorID;
    private double resistance;
    private Node node1;
    private Node node2;

    /**
     * Constructor for resistor:
     * updates the static variable for the amount of resistor
     * */
    public Resistor(double resistance, Node node1, Node node2){

        if(resistance < 0){
            throw new IllegalArgumentException("Resistance cannot be negative.");
        }
        else if(node1 == null || node2 == null){
            throw new IllegalArgumentException("One of your nodes is null. They cannot be.");
        }
        else {
            this.resistance = resistance;
            this.node1 = node1;
            this.node2 = node2;
            resistorID = resistorCounter;
            resistorCounter++;
        }
    }

    public Node[] getNodes(){

        Node[] nodeArray = new Node[2];

        nodeArray[0] = node1;
        nodeArray[1] = node2;

        return nodeArray;

    }

    @Override

    public String toString(){

        return "R" + resistorID + " " + node1 + " " + node2 + " " + resistance;

    }

    public static void main(String[] args) {

        Node node1 = new Node();
        Node node2 = new Node();

        Resistor resistor = new Resistor(50, node1, node2);

        System.out.println(resistor);

    }


}
