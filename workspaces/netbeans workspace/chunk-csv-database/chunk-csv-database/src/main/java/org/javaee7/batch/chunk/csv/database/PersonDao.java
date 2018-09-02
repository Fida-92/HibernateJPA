/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.batch.chunk.csv.database;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

@Named
@ApplicationScoped
public class PersonDao implements Serializable {

    @PersistenceContext //(type = PersistenceContextType.TRANSACTION)
    EntityManager em;
    @Inject
    private UserTransaction userTransaction;

    public List<Person> getPersonen() {
        Query query = em.createQuery("SELECT a FROM Person a");
        return query.getResultList();
    }
    
    public EntityManager getEntityManager(){
        return this.em;
    }
    
    public void deleteAll() throws Exception{
        userTransaction.begin();
        em.createNativeQuery("truncate table chunk_csv_database").executeUpdate();
        userTransaction.commit();
    }
}
