package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;

@Repository("customerdao")
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
