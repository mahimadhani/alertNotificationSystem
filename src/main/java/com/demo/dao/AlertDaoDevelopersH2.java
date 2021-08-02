package com.demo.dao;

import com.demo.model.DevelopersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertDaoDevelopersH2 extends CrudRepository<DevelopersEntity,String> {
}
