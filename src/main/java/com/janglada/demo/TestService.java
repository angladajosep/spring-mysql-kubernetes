package com.janglada.demo;

import com.janglada.demo.repository.TestEntity;
import com.janglada.demo.repository.TestRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(final TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void setValue(final String value) {
        TestEntity testEntity = new TestEntity();
        testEntity.setValue(value);
        testRepository.save(testEntity);
    }

    public List<TestEntity> getValues() {
        return testRepository.findAll();
    }

    public Optional<TestEntity> getValue(final String id) {
        return testRepository.findById(id);
    }

}
