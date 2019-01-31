package me.snowdrop.vertx.core;

import io.vertx.core.Vertx;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Vertx.class)
public class VertxAutoConfiguration {

    @Bean(destroyMethod = "") // Leave destruction to VertxDisposingBean
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean // TODO find a better way to dispose a Vertx instance asynchronously
    public VertxDisposingBean vertxDisposingBean(Vertx vertx) {
        return new VertxDisposingBean(vertx);
    }

}