package edu.frostburg.cosc444.columns;

import edu.frostburg.cosc444.Record;

import java.util.ArrayList;
import java.util.HashMap;

public class Weekday implements Runnable {
    private ArrayList<Record> records;
    private int counter;
    private HashMap<Integer, Record> results;

    public Weekday(ArrayList<Record> records, HashMap<Integer, Record> results) {
        this.records = records;
        this.counter = 0;
        this.results = results;
    }

    @Override
    public void run() {
        for(Record r : records){
            if(results.containsKey(counter)) results.get(counter).setWeekday(r.getWeekday());

            else{
                Record record = new Record("", "","", "", r.getWeekday(), "", "",0);
                results.put(counter, record);
            }

            counter++;

        }

        System.out.println(counter);
    }
}
