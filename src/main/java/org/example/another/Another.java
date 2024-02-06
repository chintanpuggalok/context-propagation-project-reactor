package org.example.another;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.DemoClass;
import org.example.util.LogUtil;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class Another {
    final private LogUtil logUtil;
    public Mono<DemoClass> anotherDemoProcess(Mono<DemoClass> demoClassMono)
    {
        return demoClassMono.doOnEach(signal->{logUtil.addToMdc(signal.getContextView());}).map(
                demoClass -> {
                    log.info("info inside another demo class {}",demoClass.toString());
                    return demoClass;
                }

        );
    }
}
