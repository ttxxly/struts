package com.orm.domain.jpa.onetoone;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_card")
public class IDCard {
    private String cardId;
    private String cardInfo;
    private Person person;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2") // UUID定制生成
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "card_id")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Column(name = "card_info")
    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    @OneToOne(mappedBy = "card")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
