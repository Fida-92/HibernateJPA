/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycom.hibernatejpa.utils;

import com.mycom.hibernatejpa.Azubi;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;

 
@ManagedBean
public class LogProducer {
        Logger log;
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }



    
    public Logger createLog() {
        log = Logger.getLogger(Azubi.class.getName());
        return log;
    }
}
