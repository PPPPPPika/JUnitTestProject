package com.example.junittestproject.Reposytorys;

import com.example.junittestproject.Models.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
