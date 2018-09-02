/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.batch.chunk.csv.database;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named
public class LineCounter implements Serializable {

    public static int number;
    private int recordNumber=5  ;

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public int incrementNumberOfLines() {
        //System.out.println(number+ " recordNumber: " + recordNumber);
        return recordNumber;
    }
}
