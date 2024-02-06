package org.example;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.another.Another;
import org.example.demo.DemoClass;
import org.example.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Main {
    final private LogUtil logUtil;
    final private Another another;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
    @PostConstruct
    void init()
    {
        System.out.println("Hello world!");
        Map<String, String> headerDetails = Map.of(
                "Passing_entry_key", "Passing_entry_value"
        );
        DemoClass demoObject=new DemoClass("demoValue");

        Mono<DemoClass> demoClassMono=Mono.just(demoObject).doOnEach((signal)->{logUtil.addToMdc(signal.getContextView());}).transform(
                demoClassMono1 -> {
                    log.info("inside main post init  {}",demoClassMono1.toString());
                    return another.anotherDemoProcess(demoClassMono1);
                }

        ).contextWrite(context->{
            return context.putAllMap(headerDetails);
        });
        Disposable disposable= demoClassMono.subscribe();


    }
}