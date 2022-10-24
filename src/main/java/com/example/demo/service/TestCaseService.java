package com.example.demo.service;

import com.example.demo.model.TestCase;
import com.example.demo.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {

    @Autowired
    ITestCaseRepository testCaseRepository;

    public TestCase create(TestCase testCase) {
        TestCase newTestCase = testCaseRepository.save(testCase);

        return newTestCase;
    }

    public List<TestCase> listAll() {
        List<TestCase> testCases = new ArrayList<>();
        testCaseRepository.findAll().forEach(testCases::add);
        return testCases;
    }

    public TestCase findById(long idTestCase) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(idTestCase);
        return testCaseOptional.get();
    }

    public List<TestCase> findByLastUpdatedAfter(Date lastUpdated) {
        List<TestCase> testCaseList = testCaseRepository.findTestCaseByLastUpdateGreaterThanEqual(lastUpdated);
        return testCaseList;
    }

    public Boolean remove(Long idTestCase) {
        testCaseRepository.deleteById(idTestCase);
        return true;
    }

    public TestCase update(long idTestCase, TestCase newTestCase) {
        newTestCase.setId_case(idTestCase);
        TestCase updatedTestCase = testCaseRepository.save(newTestCase);

        return updatedTestCase;
    }
}
