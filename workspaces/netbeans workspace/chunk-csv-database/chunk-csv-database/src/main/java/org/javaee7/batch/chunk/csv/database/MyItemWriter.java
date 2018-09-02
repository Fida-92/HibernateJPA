package org.javaee7.batch.chunk.csv.database;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MyItemWriter extends AbstractItemWriter {

    @Inject
    PersonDao personDao;

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
        for (Object person : list) {
            personDao.getEntityManager().persist(person);
        }
    }

}
