package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PollUser user;

    private String title;
    private String description;

    private int votes_green;
    private int votes_red;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date closed;


}
