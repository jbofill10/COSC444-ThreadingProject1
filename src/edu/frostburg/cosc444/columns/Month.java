package edu.frostburg.cosc444.columns;

import edu.frostburg.cosc444.Record;

import java.util.ArrayList;
import java.util.HashMap;

public class Month implements Runnable {
    private ArrayList<Record> records;
    private int counter;
    private HashMap<Integer, Record> results;

    public Month(ArrayList<Record> records, HashMap<Integer, Record> results) {
        this.records = records;
        this.results = results;
        this.counter = 0;
    }

    @Override
    public void run() {
        for(Record r : records){
            if(results.containsKey(counter)) results.get(counter).setMonth(r.getMonth());

            else{
                Record record = new Record("", "", "", "", "", r.getMonth(), "",0);
                results.put(counter, record);
            }

            counter++;

        }

        System.out.println(counter);
    }
}
