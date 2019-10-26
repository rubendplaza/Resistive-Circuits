package coe318.lab5;

public class Node {

    private int nodeNum;
    static private int nodeCounter = 0;

    public Node(){

        nodeNum = nodeCounter;
        nodeCounter++;

    }

    @Override

    public String toString(){

        return String.valueOf(this.nodeNum);

    }

}
