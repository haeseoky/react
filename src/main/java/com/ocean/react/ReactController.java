package com.ocean.react;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController(value = "/react")
@RequiredArgsConstructor
public class ReactController {
    private final ReactService reactService;

    @GetMapping(value = "/")
    public Mono<String> getReact() {
        return reactService.getReact();
    }
}
