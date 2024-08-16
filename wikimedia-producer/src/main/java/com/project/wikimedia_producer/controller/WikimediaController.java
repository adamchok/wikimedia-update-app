package com.project.wikimedia_producer.controller;

import com.project.wikimedia_producer.stream_consumer.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wikimedia")
@Slf4j
public class WikimediaController {
    private final WikimediaStreamConsumer streamConsumer;

    @GetMapping
    public ResponseEntity<HttpStatus> startPublishing() {
        streamConsumer.consumeStreamAndPublish();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
