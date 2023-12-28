package com.mytests.spring.springdaterecursivequeries.recursiveQueries;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Long id;
    String person;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Payment(Long id, String person) {
        this.id = id;
        this.person = person;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
               "id=" + id +
               ", person='" + person + '\'' +
               '}';
    }
}
