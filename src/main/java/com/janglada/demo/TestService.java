package com.janglada.demo;

import com.janglada.demo.repository.TestEntity;
import com.janglada.demo.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TestService {

    private static final String TEST_ENTITY = "TEST_ENTITY";
    private final TestRepository testRepository;

    public TestService(final TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestEntity> getValues() {
        log.info("get all values");

        return testRepository.findAll();
    }

    public Optional<TestEntity> getValue(final String id) {
        log.info("get value {}", id);
        return testRepository.findById(id);
    }

    public void setValue(final String value) {
        log.info("set value {}", value);
        TestEntity testEntity = new TestEntity();
        testEntity.setValue(value);
        testRepository.save(testEntity);
    }

}
