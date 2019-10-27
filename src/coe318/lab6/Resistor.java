package coe318.lab6;

public class Resistor {

    static private int resistorCounter = 1;
    private int resistorID;
    private double resistance;
    private Node node1;
    private Node node2;
    private Circuit circuit;

    /**
     * Constructor for resistor:
     * updates the static variable for the amount of resistors
     *
     * also accesses the instance of the circuit
     * if one is not created it will create one
     *
     * */
    public Resistor(double resistance, Node node1, Node node2){

        circuit = Circuit.getInstance();

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
            circuit.add(this);
        }
    }

    /**
     * Not really sure why i would need this method
     * not enough nodes for it to make sense for it
     * to be in an array
     **/
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
