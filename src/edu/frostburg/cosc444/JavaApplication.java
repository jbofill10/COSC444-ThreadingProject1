package edu.frostburg.cosc444;

import edu.frostburg.cosc444.columns.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaApplication {

    public static void main(String[] args) {
        // Results where we print the records from after being read and stored in a parallel manner
        HashMap<Integer, Record> results = new HashMap<>();
        String line = "";
        ArrayList<Record> records = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("accidents_2017.csv"));

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s+", "");
                String[] temp = line.split(",");
                Record r = new Record(temp[0],
                        temp[1],
                        temp[2],
                        temp[3],
                        temp[4],
                        temp[5],
                        temp[6],
                        Integer.parseInt(temp[7]));
                records.add(r);
            }
        }catch (Exception e){
            System.out.println(e);
        }




        ExecutorService pool = Executors.newFixedThreadPool(8);

        DistrictName districtName = new DistrictName(records,results);
        ID id = new ID(records,results);
        Month month = new Month(records,results);
        NeighborhoodName neighborhoodName = new NeighborhoodName(records,results);
        PartOfDay partOfDay = new PartOfDay(records,results);
        Street street = new Street(records,results);
        Victims victims = new Victims(records,results);
        Weekday weekday = new Weekday(records,results);

        //Execute threads
        pool.execute(districtName);
        pool.execute(id);
        pool.execute(month);
        pool.execute(neighborhoodName);
        pool.execute(partOfDay);
        pool.execute(street);
        pool.execute(victims);
        pool.execute(weekday);

        pool.shutdown();

        for(Map.Entry<Integer, Record> entry : results.entrySet()){
            System.out.println(entry.getValue());
        }


    }
}
