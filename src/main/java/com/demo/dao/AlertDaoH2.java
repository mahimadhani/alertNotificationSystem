package com.demo.dao;


import com.demo.model.TeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertDaoH2  extends CrudRepository<TeamEntity,String> {

}
