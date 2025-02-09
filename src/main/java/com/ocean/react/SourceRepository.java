package com.ocean.react;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SourceRepository {
    public List<String> getSources(String param) {
        log.info("SourceRepository.getSources() called");
        return List.of("A", "B", "C", "D", "E", param);
    }
}
