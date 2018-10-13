/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import com.mycom.hibernatejpa.BasisEntity;

/**
 *
 * @author User
 */
 
public class LoginDAO extends BasisEntity {

    public boolean validate(String user, String password) {
//        Query q = em.createQuery("Select s.uname from Users s where s.uname ='"+user+"'");
//        Object o = q.getSingleResult();
//        if (o != null) {
//            System.err.println("not null "+o.toString());
//            return true;
//        }
        return true;
    }
}
