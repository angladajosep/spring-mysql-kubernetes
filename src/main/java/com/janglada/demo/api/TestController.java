package com.janglada.demo.api;

import com.janglada.demo.TestService;
import com.janglada.demo.repository.TestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(TestController.BASE_MAPPING)
public class TestController {

    public static final String BASE_MAPPING = "/api/test";

    private final TestService testService;

    public TestController(final TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public ResponseEntity<List<TestEntity>> getAll() {
        return ResponseEntity.ok(testService.getValues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TestEntity>> getValueId(@PathVariable("id") String id) {
        return ResponseEntity.ok(testService.getValue(id));
    }

    @PostMapping
    public ResponseEntity postValue(@RequestParam("value") String value) {

        testService.setValue(value);
        return ResponseEntity.ok().build();
    }
}
