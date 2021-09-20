package no.hvl.dat250.jpa.basicexample;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PollDAO {

    private EntityManager entityManager;

    public PollDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    /**
     * @param PU
     * @param title
     * @param description
     */
    public void createNewPoll(PollUser PU, String title, String description){

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);

        createNewPoll(PU,title, description, c.getTime());

    }

    /**
     * @param PU
     * @param title
     * @param description
     * @param dateClosed If not provided default is 7 days
     */
    public void createNewPoll(PollUser PU, String title, String description, Date dateClosed){
        entityManager.getTransaction().begin();
        Poll user = new Poll();
        user.setUser(PU);
        user.setTitle(title);
        user.setDescription(description);
        user.setCreated(new Date());
        user.setClosed(dateClosed);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public Optional<Poll> getPollbyTitle(String title){
        Query q = entityManager.createQuery("select u from Poll u");
        List<Poll> pollList = q.getResultList();

        return pollList.stream().filter(pu -> pu.getTitle().equals(title)).findFirst();
    }

    public List<Poll> getPollsbyUser(PollUser PU){
        Query q = entityManager.createQuery("select u from Poll u");
        List<Poll> pollList = q.getResultList();

        return pollList.stream().filter(p -> p.getUser().equals(PU)).collect(Collectors.toList());
    }

    public Poll editPoll(Poll P,String title, String description, java.util.Date dateClosed){
        entityManager.getTransaction().begin();
        Poll poll = P;
        poll.setTitle(title);
        poll.setDescription(description);
        poll.setClosed(dateClosed);

        entityManager.persist(poll);
        entityManager.getTransaction().commit();

        return poll;
    }

    public void deletePollUser(Poll P){
        entityManager.getTransaction().begin();
        entityManager.remove(P);

        entityManager.getTransaction().commit();
    }
}
