package org.javaee7.batch.chunk.csv.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MyItemReader extends AbstractItemReader{

    private BufferedReader reader;
     private int recordNumber;
    @Inject LineCounter lineCounter;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                new InputStreamReader(
                        this
                                .getClass()
                                .getClassLoader()
                                .getResourceAsStream("/META-INF/mydata.csv")
                )
        );
    }

    @Override
    public String readItem() {
        System.out.println("readItem: "+ reader);
        try {
            recordNumber++;
            return reader.readLine();
            
        } catch (IOException ex) {
            Logger.getLogger(MyItemReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {

        return recordNumber;
    }
    
  

   
}
