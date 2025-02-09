package com.ocean.react;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AComponent {
    public String getA() {
        log.info("AComponent.getA() called");
        return "A";
    }
}
