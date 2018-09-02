package org.javaee7.batch.chunk.csv.database;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@Named
@Entity
@Table(name = "CHUNK_CSV_DATABASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT c FROM Person c"),
    @NamedQuery(name = "Person.findByName", query = "SELECT c FROM Person c WHERE c.name = :name"),
    @NamedQuery(name = "Person.findByHiredate", query = "SELECT c FROM Person c WHERE c.hiredate = :hiredate")})
@SessionScoped
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hiredate")
    private String hiredate;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String hiredate) {
        this.name = name;
        this.hiredate = hiredate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", hiredate=" + hiredate + '}';
    }
 
    
}
