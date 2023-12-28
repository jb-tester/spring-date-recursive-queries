package com.mytests.spring.springdaterecursivequeries.recursiveQueries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity()
public class Account {
    @Id
    private Integer id;
    String owner;
    @OneToMany(targetEntity = Payment.class, mappedBy = "id")
    List<Payment> payment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public Account(Integer id, String owner, List<Payment> payment) {
        this.id = id;
        this.owner = owner;
        this.payment = payment;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
               "id=" + id +
               ", owner='" + owner + '\'' +
               ", payment=" + payment +
               '}';
    }
}
