package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.util.context.ContextView;
@Component
@Slf4j
public class LogUtil {
    public void addToMdc(ContextView contextView) {
        contextView.forEach(
                (key, value) -> {
                    MDC.put(key.toString(), value.toString());

                }
        );
    }
}
