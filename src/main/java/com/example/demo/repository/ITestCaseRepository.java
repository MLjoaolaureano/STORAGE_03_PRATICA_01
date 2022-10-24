package com.example.demo.repository;


import com.example.demo.model.TestCase;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ITestCaseRepository extends CrudRepository<TestCase, Long> {

    List<TestCase> findTestCaseByLastUpdateGreaterThanEqual(Date lastUpdated);
}
