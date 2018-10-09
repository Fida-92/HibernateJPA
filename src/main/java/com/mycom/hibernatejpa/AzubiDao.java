/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycom.hibernatejpa;

import com.mycom.hibernatejpa.utils.LogProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class AzubiDao extends BasisEntity implements Serializable {

     
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

    public List<Azubi> getAzubi() {
        Query query = em.createQuery("SELECT a FROM Azubi a");
        return query.getResultList();
    }

    public String readdata() throws Exception {
//        Class cls = Class.forName("com.mycom.hibernatejpa.AzubiDao");
//
//        // returns the ClassLoader object associated with this Class
//        ClassLoader cLoader = cls.getClassLoader();
//
//        System.out.println(cLoader.getClass());
//
//        // finds resource with the given name
//        URL url = cLoader.getResource("WEB-INF/web.xml");
//        System.err.println("Value: " + url);
        BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("META-INF/derJob.xml")));
//        System.err.println(url.getPath());
        String line = "";
        while ((line = br.readLine()) != null) {

            //    System.err.println(br.readLine());
        }
        List<InputStream> istream = loadResources("text.txt", getClass().getClassLoader());

        for (InputStream object : istream) {
            searchFile(object);
//            System.out.println("list.size() "+istream.size()+ " "+ object);
        }
        //   searchFile("META-INF/text.txt");
        return line;
    }

    public static List<InputStream> loadResources(
            final String name, final ClassLoader classLoader) throws IOException {
        final List<InputStream> list = new ArrayList<>();
        final Enumeration<URL> systemResources
                = (classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader)
                        .getResources(name);
        while (systemResources.hasMoreElements()) {
            list.add(systemResources.nextElement().openStream());
        }
        return list;
    }

    public void searchFile(InputStream is) throws IOException {

        if (is != null) {
            System.err.println("Search inputStream: ");

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (br.readLine() != null) {
            System.err.println(br.readLine());
        }
    }

    public void searchFile(String file) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);

        if (is == null) {
            System.err.println("for-schleife: ");
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (br.readLine() != null) {
            System.err.println(br.readLine());
        }
    }

}
