package edu.frostburg.cosc444.columns;

import edu.frostburg.cosc444.Record;

import java.util.ArrayList;
import java.util.HashMap;

public class DistrictName implements Runnable{
    private ArrayList<Record> records;
    private int counter;
    private HashMap<Integer, Record> results;

    public DistrictName(ArrayList<Record> records, HashMap<Integer, Record> results) {
        this.records = records;
        this.counter = 0;
        this.results = results;
    }

    @Override
    public void run() {
        for(Record r : records){
            if(results.containsKey(counter)) results.get(counter).setDistrictName(r.getDistrictName());

            else{
                Record record = new Record("", r.getDistrictName(), "", "", "", "", "",0);
                results.put(counter, record);
            }

            counter++;

        }

        System.out.println(counter);
    }
}
