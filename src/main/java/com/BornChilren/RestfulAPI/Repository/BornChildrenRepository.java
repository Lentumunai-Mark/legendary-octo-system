package com.BornChilren.RestfulAPI.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BornChilren.RestfulAPI.Model.BornChildren;

public interface BornChildrenRepository extends JpaRepository<BornChildren, Long>{
    Page<BornChildren> findByRegistrationNumber(Long registrationNumber, Pageable pageable);
    List<BornChildren> findAllBynameOfTheChild(String nameOfTheChild);
    List<BornChildren> findBynameOfTheChild(String nameOfTheChild);
}
