package no.hvl.dat250.jpa.basicexample;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();




        PollUserDAO PUDAO = new PollUserDAO(em);
        PollDAO PDAO = new PollDAO(em);

        //createSampleData(PUDAO,PDAO);

/*
        PUDAO.getUserbyName("Frank").ifPresent(pu -> {
            System.out.println("found: " +pu.toString());
            PUDAO.deletePollUser(pu);});




        PUDAO.getUserbyEmail("hild@email.com").ifPresent(pu ->PDAO.createNewPoll(pu,"Default poll","desc"));
        PUDAO.getUserbyEmail("hild@email.com").ifPresent(pu -> {
            try {
                PDAO.createNewPoll(pu,"Default poll","desc",new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

*/
        printData(em);
        em.close();
    }

    private  static  void printData(EntityManager em){
        Query q1 = em.createQuery("select u from PollUser u");
        List<PollUser> userList = q1.getResultList();
        for (PollUser user : userList) {
            System.out.println(user);
        }
        System.out.println("Size: " + userList.size());

        Query q2 = em.createQuery("select u from Poll u");
        List<Poll> pollList = q2.getResultList();
        for (Poll poll : pollList) {
            System.out.println(poll);
        }
        System.out.println("Size: " + pollList.size());
    }

    private static void createSampleData(PollUserDAO PUDAO, PollDAO PDAO){

        PollUser jan = PUDAO.createNewPollUser("jan@email.com","mlk","Jan");
        PollUser peter = PUDAO.createNewPollUser("peter@email.com","azerty","Peter");
        PollUser hild = PUDAO.createNewPollUser("hild@email.com","qwerty","Hild");
        PollUser tiril = PUDAO.createNewPollUser("tiril@email.com","tiril1","Tiril");
        PollUser frank = PUDAO.createNewPollUser("frank@email.com","frank1","Frank");



        PDAO.createNewPoll(jan, "Sports Poll","description of sports poll");
        PDAO.createNewPoll(hild, "Music Poll","description of music poll");
        PDAO.createNewPoll(peter, "Golf Poll","description of golf poll");
        PDAO.createNewPoll(tiril, "Beer Poll","description of beer poll");
        PDAO.createNewPoll(jan, "f1 Poll","description of f1 poll");

    }
}
