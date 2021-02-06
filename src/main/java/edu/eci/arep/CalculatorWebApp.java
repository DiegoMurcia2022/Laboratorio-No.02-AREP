package edu.eci.arep;

import edu.eci.arep.linkedlist.MyOwnLinkedList;
import edu.eci.arep.linkedlist.exception.LinkedListException;

public class CalculatorWebApp {
    private static MyOwnLinkedList linkedList = new MyOwnLinkedList();

    public static void readJSON (String json) {
        String[] jsonList = json.replace("\"", "").replace("]", "").replace("[", "").split(",");

        for (String value:jsonList) {
            linkedList.add(Double.parseDouble(value));
        }
    }

    public static Double mean() throws LinkedListException {
        double summation = 0;
        Double value;

        for(int i=0;i<linkedList.size();i++) {
            value = linkedList.get(i);

            if(value!=null) {
                summation += linkedList.get(i);
            }
        }

        return Math.round((summation/linkedList.size())*100.0)/100.0;
    }

    public static Double standardDeviation() throws LinkedListException {
        double meanCalculation = mean(), summation = 0, value, deviationCalculation;

        for(int i=0;i<linkedList.size();i++) {
            value = linkedList.get(i)-meanCalculation;

            summation += Math.pow(value, 2);
        }

        deviationCalculation = Math.sqrt(summation/(linkedList.size()-1));

        return Math.round(deviationCalculation*100.0)/100.0;
    }
}
