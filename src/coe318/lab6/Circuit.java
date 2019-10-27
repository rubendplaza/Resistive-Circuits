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

}









