package com.janglada.demo.api;

import com.janglada.demo.TestService;
import com.janglada.demo.repository.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CacheTestService {

    private static final String TEST_ENTITY = "TEST_CACHE";

    private final TestService testService;

    public CacheTestService(final TestService testService) {
        this.testService = testService;
    }

    @Cacheable(TEST_ENTITY)
    public TestEntity getValue(final String id) {
        log.info("cache test service get value id {}", id);
        Optional<TestEntity> entity = testService.getValue(id);

        return entity.isPresent()? entity.get():null;
    }
}
