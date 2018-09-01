/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycom.hibernatejpa;

import com.mycom.hibernatejpa.utils.LogProducer;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class AzubiDao implements Serializable {

    @PersistenceContext //(type = PersistenceContextType.TRANSACTION)
    EntityManager em;
    @Resource
    private UserTransaction userTransaction;

    @Inject
    private LogProducer LOG;
    
    //@Transactional
    public String persist() throws Exception {

        Azubi az = new Azubi();

        az.setName("Bader");
        az.setAdresse("Adresse");
        userTransaction.begin();
        em.persist(az);
        userTransaction.commit();
       LOG.createLog().log(Level.INFO, "Entity wurde persistiert {0}", az);
        return "/index.html";
    }
    
    
    public List<Azubi> getAzubi(){
         Query query = em.createQuery("SELECT a FROM Azubi a");
        return query.getResultList();
    }

}
