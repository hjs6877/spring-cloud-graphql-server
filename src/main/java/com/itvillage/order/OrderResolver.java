package com.itvillage.order;

import com.itvillage.delivery.Delivery;
import com.itvillage.delivery.DeliveryService;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class OrderResolver {
    private final OrderService orderService;
    private final DeliveryService deliveryService;

    public OrderResolver(OrderService orderService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.deliveryService = deliveryService;
    }

    public DataFetcher<Mono<Order>> getOrder() {
        return environment -> {
            String orderId = environment.getArgument("orderId");
            return orderService.getOrder(orderId);
        };
    }

    public DataFetcher<Mono<Delivery>> getDelivery() {
        return environment -> {
            String orderId = environment.getArgument("orderId");
            return deliveryService.getDelivery(orderId);
        };
    }
}
