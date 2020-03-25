package com.janglada.demo.api;

import com.janglada.demo.TestService;
import com.janglada.demo.repository.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(TestController.BASE_MAPPING)
@Slf4j
public class TestController {

    public static final String BASE_MAPPING = "/api/test";

    private final TestService testService;
    private final CacheTestService cacheTestService;


    public TestController(final TestService testService, final CacheTestService cacheTestService) {
        this.testService = testService;
        this.cacheTestService = cacheTestService;
    }

    @GetMapping
    public ResponseEntity<List<TestEntity>> getAll() {
        log.info("getAll Controller");
        return ResponseEntity.ok(testService.getValues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestEntity> getValueId(@PathVariable("id") String id) {
        log.info("getValueId Controller : {}", id);
        TestEntity testEntity = cacheTestService.getValue(id);
        return ResponseEntity.ok(testEntity);
    }

    @PostMapping
    public ResponseEntity postValue(@RequestParam("value") String value) {
        log.info("postValue Controller : {}", value);
        testService.setValue(value);
        return ResponseEntity.ok().build();
    }
}
