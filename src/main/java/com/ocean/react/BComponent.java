package com.ocean.react;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BComponent {
    public String getB() {
        log.info("BComponent.getB() called");
        return "B";
    }

}
