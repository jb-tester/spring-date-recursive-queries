package com.mytests.spring.springdaterecursivequeries.recursiveQueries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "parents")
public class ParentsAndChildren {
    @Id
    private Long id;

    String name;
    String childname;
    String birthyear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ParentsAndChildren(Long id, String name, String childname, String birthyear) {
        this.id = id;
        this.name = name;
        this.childname = childname;
        this.birthyear = birthyear;
    }

    public ParentsAndChildren() {
    }

    @Override
    public String toString() {
        return "ParentsAndChildren{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", childname='" + childname + '\'' +
               ", birthyear='" + birthyear + '\'' +
               '}';
    }
}
