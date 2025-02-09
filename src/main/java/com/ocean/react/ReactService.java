package com.ocean.react;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReactService {

    private final SourceRepository sourceRepository;
    private final AComponent aComponent;
    private final BComponent bComponent;


    public Mono<String> getReact() {
        String param = "param";
        Mono<String> stringMono = Mono.fromSupplier(() -> sourceRepository.getSources(param))
            .flatMap(source -> Mono.just(aComponent.getA() + bComponent.getB()));

        return stringMono;
    }
}
