package com.mytests.spring.springdaterecursivequeries.recursiveQueries;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FlightsRepo {

    private final EntityManager entityManager;

    public FlightsRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateFlights(){

        Flights f1 = new Flights(1L, "Prague", "London", "BA", "859", 10);
        Flights f2 = new Flights(2L, "Prague", "New York", "Delta", "100", 50);
        Flights f3 = new Flights(3L, "London", "Paris", "BA", "860", 50);
        Flights f4 = new Flights(4L, "Istambul", "Munich", "Pegasus", "200", 100);
        Flights f5 = new Flights(5L, "Munich", "New York", "Lufthansa", "300", 30);
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(f3);
        entityManager.persist(f4);
        entityManager.persist(f5);
        for (Object flightsF : entityManager.createQuery("select f from flights f").getResultList()) {
            System.out.println(flightsF);
        }
    }

    public List<String> testQuery(){

        String query = """
                WITH destinations AS(
                  SELECT  f.departure departure , f.arrival arrival, 0 as connects, f.ticket cost
                  FROM flights f
                  WHERE f.departure = 'Prague'
                  UNION ALL
                  SELECT
                      r.departure, f.arrival, r.connects + 1,
                      r.cost + f.ticket
                  FROM  destinations r
                  JOIN flights f on f.departure = r.arrival
                  WHERE f.departure = r.arrival
                  ) cycle departure set cycleMark
                SELECT DISTINCT s.departure||' -> '||s.arrival||' connects: '||s.connects||';cost: '||s.cost||'   '|| s.cycleMark
                FROM destinations s
                """;
        return entityManager.createQuery(query ).getResultList();
    }
}
