package com.BornChilren.RestfulAPI.Config;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.BornChilren.RestfulAPI.Model.BornChildren;
import com.BornChilren.RestfulAPI.Repository.BornChildrenRepository;
/*This class is purely for testing purposes */
@Component
public class BornChildrenLoader implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(BornChildrenLoader.class);

    @Autowired
    BornChildrenRepository bornChildrenRepository;


    public void run(String... args) throws Exception{
        System.out.println("hi there");
        loadSeedData();
    }
    
    public void loadSeedData(){
        if(bornChildrenRepository.count() == 0){
            BornChildren child1 = new BornChildren("carren", "Bomet", LocalDate.of(2000, Month.OCTOBER, 8), "female", 58, "Mama Cherono", 50, "Farmer", "Married");
            BornChildren child2 = new BornChildren("Vicky Chelangat Rono", "Bomet", LocalDate.of(2009, Month.APRIL, 28), "female", 50, "Mama Cherono", 50, "Farmer", "Married");
            BornChildren child3 = new BornChildren("Sharleen Chepchumba", "Bomet", LocalDate.of(2014, Month.DECEMBER, 24), "female", 36, "Mama Cherono", 50, "Farmer", "Married");
            bornChildrenRepository.save(child1);
            bornChildrenRepository.save(child2);
            bornChildrenRepository.save(child3);
        }
        logger.info("Number of born children registered in the DB is {} ", bornChildrenRepository.count());
    }
    
}
