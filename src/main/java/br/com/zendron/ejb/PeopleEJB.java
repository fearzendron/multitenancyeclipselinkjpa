package br.com.zendron.ejb;

import br.com.zendron.model.People;
import org.eclipse.persistence.config.EntityManagerProperties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Collection;
import java.util.List;

@Stateless
public class PeopleEJB implements PeopleRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    //@PersistenceContext
    //private EntityManager em;

    @Override
    public Collection<People> getAll(String tenant) {
        EntityManager em = emf.createEntityManager();

        List<People> listOfPeople = null;

        try {
            em.getTransaction().begin();
            em.setProperty(EntityManagerProperties.MULTITENANT_PROPERTY_DEFAULT, tenant);
            listOfPeople = em.createNamedQuery("People.all", People.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfPeople;
    }
}