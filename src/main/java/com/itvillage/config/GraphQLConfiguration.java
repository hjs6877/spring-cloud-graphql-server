package com.itvillage.config;

import com.itvillage.order.Order;
import com.itvillage.order.OrderResolver;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfiguration {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(OrderResolver orderResolver) {
        return builder -> builder
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getOrder", orderResolver.getOrder())
                        .dataFetcher("getDelivery", orderResolver.getDelivery())
                );
    }
}
