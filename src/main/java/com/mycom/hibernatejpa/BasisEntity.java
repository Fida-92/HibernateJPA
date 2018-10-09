/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycom.hibernatejpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
public class BasisEntity {
    @PersistenceContext //(type = PersistenceContextType.TRANSACTION)
 public    EntityManager em;
}
