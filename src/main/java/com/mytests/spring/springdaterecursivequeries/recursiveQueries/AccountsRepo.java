package com.mytests.spring.springdaterecursivequeries.recursiveQueries;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AccountsRepo {

    private final EntityManager entityManager;

    public AccountsRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateAccounts() {

        Account f1 = new Account(1, "ivan", Arrays.asList(new Payment(1L, "maria"), new Payment(2L, "ivan")));
        Account f2 = new Account(2, "vasily", Arrays.asList(new Payment(3L, "ivan"), new Payment(4L, "maria")));
        Account f3 = new Account(3, "maria", Arrays.asList(new Payment(5L, "vasily"), new Payment(6L, "ivan")));
        Account f4 = new Account(4, "elena", Arrays.asList(new Payment(5L, "vasily"), new Payment(6L, "ivan")));
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(f3);
        entityManager.persist(f4);
        for (Object accounts : entityManager.createQuery("select f from Account f").getResultList()) {
            System.out.println(accounts);
        }
    }

    public List<String> testQuery() {

        String query = """
                with paymentConnectedPersons as(
                    
                    select a.owner owner
                    from Account a
                    union all
                    select a2.owner owner
                    from paymentConnectedPersons d
                    join Account a on a.owner = d.owner
                    join a.payment p
                    join Account a2 on a2.owner = p.person
                    where a2.owner = p.person
                )
                select d.owner
                from paymentConnectedPersons d
                """;
        return entityManager.createQuery(query).getResultList();
    }

    public List<String> testQuery2() {

        String hql = """
                SELECT
                COUNT (app.id) AS count
                FROM
                AppEntity app
                LEFT JOIN AppAccessPolicyEntity aap ON app.id = aap.appId
                WHERE
                
                aap.subjectId IN (
                SELECT
                id
                FROM
                UserGroupMemberEntity
                WHERE userId = :userld
                UNION ALL
                SELECT id
                
                FROM
                OrganizationMemberEntity
                WHERE userId = :userld
                ) 
               """;
        return entityManager.createQuery(hql).getResultList();
    }
}
