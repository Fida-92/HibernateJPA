
package org.javaee7.batch.chunk.csv.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class MyItemProcessor implements ItemProcessor {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Person processItem(Object t) {
        System.out.println("processItem: " + t);
        
        StringTokenizer tokens = new StringTokenizer((String)t, ",");

        String name = tokens.nextToken();
        String date;
        
        try {
            date = tokens.nextToken();
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            return null;
        }
        
        return new Person(name, date);
    }
}
