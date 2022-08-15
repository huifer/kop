package com.github.kop.gateway;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

@Configuration
public class Conf {

  private static final Logger log = LoggerFactory.getLogger(Conf.class);
  private static final String CONTEXT_MAP = "context-map";
  ThreadLocal<Integer> t = new InheritableThreadLocal<>();

  @Bean
  @Order(-1)
  public GlobalFilter a() {
    return (exchange, chain) -> {

      log.info("first pre filter");
      return chain.filter(exchange).then(
          Mono.fromRunnable(() -> {
            log.info("third post filter");
          })).contextWrite(context -> context.put("a", "1laksjfalsj")).then();
    };
  }

  @Bean
  @Order(0)
  public GlobalFilter b() {
    return (exchange, chain) -> {
      log.info("second pre filter");
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        log.info("second post filter");
      })).contextWrite(new Function<Context, Context>() {
        @Override
        public Context apply(Context context) {
          Object aaaaa = context.get("");
          log.info("1  =   {}", aaaaa);
          return context;
        }
      }).then()

          ;

    };
  }


  public Function<Context, Context> put(String key, String value) {
    return ctx -> {
      Optional<Map<String, String>> maybeContextMap =
          ctx.getOrEmpty(CONTEXT_MAP);

      if (maybeContextMap.isPresent()) {
        maybeContextMap.get().put(key, value);
        return ctx;
      } else {
        Map<String, String> ctxMap = new HashMap<>();
        ctxMap.put(key, value);

        return ctx.put(CONTEXT_MAP, ctxMap);
      }
    };
  }

  public <T> Consumer<Signal<T>> logOnNext(
      Consumer<T> log) {
    return signal -> {
      if (signal.getType() != SignalType.ON_NEXT) {
        return;
      }

      Optional<Map<String, String>> maybeContextMap
          = signal.getContext().getOrEmpty(CONTEXT_MAP);

      if (maybeContextMap.isEmpty()) {
        log.accept(signal.get());
      } else {
        MDC.setContextMap(maybeContextMap.get());
        try {
          log.accept(signal.get());
        } finally {
          MDC.clear();
        }
      }
    };
  }

  public <T> Consumer<Signal<T>> logOnError(
      Consumer<Throwable> log) {
    return signal -> {
      if (!signal.isOnError()) {
        return;
      }

      Optional<Map<String, String>> maybeContextMap
          = signal.getContext().getOrEmpty(CONTEXT_MAP);

      if (maybeContextMap.isEmpty()) {
        log.accept(signal.getThrowable());
      } else {
        MDC.setContextMap(maybeContextMap.get());
        try {
          log.accept(signal.getThrowable());
        } finally {
          MDC.clear();
        }
      }
    };
  }


}
