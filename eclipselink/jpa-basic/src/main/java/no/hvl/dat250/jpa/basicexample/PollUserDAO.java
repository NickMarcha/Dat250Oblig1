package no.hvl.dat250.jpa.basicexample;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class PollUserDAO {

    private EntityManager entityManager;

    public PollUserDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public PollUser createNewPollUser(String email, String password, String name){
        entityManager.getTransaction().begin();
        PollUser user = new PollUser();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return user;
    }

    public Optional<PollUser> getUserbyEmail(String email){
        Query q = entityManager.createQuery("select u from PollUser u");
        List<PollUser> userList = q.getResultList();

        return userList.stream().filter(pu -> pu.getEmail().equals(email)).findFirst();
    }

    public Optional<PollUser> getUserbyName(String name){
        Query q = entityManager.createQuery("select u from PollUser u");
        List<PollUser> userList = q.getResultList();

        return userList.stream().filter(pu -> pu.getName().equals(name)).findFirst();
    }

    public PollUser editPollUser(PollUser PU,String email, String password, String name){
        entityManager.getTransaction().begin();
        PollUser user = PU;
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return user;
    }

    public void deletePollUser(PollUser PU){
        entityManager.getTransaction().begin();
        entityManager.remove(PU);

        entityManager.getTransaction().commit();
    }
}
