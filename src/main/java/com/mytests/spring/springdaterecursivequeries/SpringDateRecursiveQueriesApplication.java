package com.mytests.spring.springdaterecursivequeries;

import com.mytests.spring.springdaterecursivequeries.recursiveQueries.AccountsRepo;
import com.mytests.spring.springdaterecursivequeries.recursiveQueries.FlightsRepo;
import com.mytests.spring.springdaterecursivequeries.recursiveQueries.ParentsAndChildrenRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDateRecursiveQueriesApplication implements CommandLineRunner {

    private final FlightsRepo flightsRepo;
    private final AccountsRepo accountsRepo;
    private final ParentsAndChildrenRepo parentsAndChildrenRepo;

    public SpringDateRecursiveQueriesApplication(FlightsRepo flightsRepo, AccountsRepo accountsRepo, ParentsAndChildrenRepo parentsAndChildrenRepo) {
        this.flightsRepo = flightsRepo;
        this.accountsRepo = accountsRepo;
        this.parentsAndChildrenRepo = parentsAndChildrenRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDateRecursiveQueriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        flightsRepo.populateFlights();
        System.out.println(flightsRepo.testQuery());
        accountsRepo.populateAccounts();
        System.out.println(accountsRepo.testQuery());
        parentsAndChildrenRepo.populateTable();
        System.out.println(parentsAndChildrenRepo.testQuery());
    }
}
