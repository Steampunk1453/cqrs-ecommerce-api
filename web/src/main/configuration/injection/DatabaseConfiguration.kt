package cqrs.ecommerce.api.web.configuration.injection

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EntityScan(basePackages = ["cqrs.ecommerce.api.infrastructure.entities", "org.axonframework.eventhandling.saga.repository.jpa"])
@EnableJpaRepositories(basePackages = ["cqrs.ecommerce.api.infrastructure.repositories"])
class DatabaseConfiguration