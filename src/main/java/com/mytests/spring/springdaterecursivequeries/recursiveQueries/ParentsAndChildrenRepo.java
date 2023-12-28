package com.mytests.spring.springdaterecursivequeries.recursiveQueries;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParentsAndChildrenRepo {

    private final EntityManager entityManager;

    public ParentsAndChildrenRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateTable(){
        ParentsAndChildren f1 = new ParentsAndChildren(1L,"Vera","Natalia", "1926");
        ParentsAndChildren f2 = new ParentsAndChildren(2L,"Nikolay","Natalia", "1923");
        ParentsAndChildren f3 = new ParentsAndChildren(3L,"Nikolay","Alexander", "1923");
        ParentsAndChildren f4 = new ParentsAndChildren(4L,"Vera","Alexander", "1926");
        ParentsAndChildren f5 = new ParentsAndChildren(5L,"Alexander","Anastasia", "1959");
        ParentsAndChildren f6 = new ParentsAndChildren(6L,"Elena","Anastasia", "1986");
        ParentsAndChildren f7 = new ParentsAndChildren(7L,"Anastasia","Nikita", "2010");
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(f3);
        entityManager.persist(f4);
        entityManager.persist(f5);
        entityManager.persist(f6);
        entityManager.persist(f7);
        for (Object flightsF : entityManager.createQuery("select f from parents f").getResultList()) {
            System.out.println(flightsF);
        }
    }

    public List<String> testQuery(){

        String query = """
                WITH inheritance
                AS ( SELECT p.name || '(' || p.birthyear || ') -> ' || p.childname  AS line, p.childname AS c
                      FROM parents p
                      UNION ALL
                      SELECT dd.line || '('|| pp.birthyear || ') -> '  || pp.childname, pp.childname as c
                      FROM  inheritance dd
                       JOIN parents pp ON dd.c = pp.name
                      WHERE dd.c = pp.name
                      )
                SELECT d.line c FROM inheritance d
                """;
        return entityManager.createQuery(query , String.class).getResultList();
    }
}
