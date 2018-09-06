package com.orm.domain.jpa.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "tb_person")
public class Person {
    private Long personId;
    private String personName;
    private IDCard card;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Column(name = "person_name")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @OneToOne
    @JoinColumn(name = "card_id",unique = true)
    public IDCard getCard() {
        return card;
    }

    public void setCard(IDCard card) {
        this.card = card;
    }
}
