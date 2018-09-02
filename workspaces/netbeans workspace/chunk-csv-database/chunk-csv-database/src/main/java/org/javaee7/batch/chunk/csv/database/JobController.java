/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.batch.chunk.csv.database;

import java.io.Serializable;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named
public class JobController implements Serializable {

    JobOperator jo;
     FacesContext facesContext=FacesContext.getCurrentInstance();

    @PostConstruct
    public void init() {
        jo = BatchRuntime.getJobOperator(); 

    }
 
    public void startJob() {
        jo.start("myJob", new Properties()); 
        facesContext.addMessage("form1:jobstart",new FacesMessage( " Alle Daten erfolgreich importiert"));
    }

   
}
