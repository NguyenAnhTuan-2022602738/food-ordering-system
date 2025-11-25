package com.foodordering.auth.infrastructure.messaging;

import com.foodordering.auth.domain.event.UserRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventListener {

    private static final Logger logger = LoggerFactory.getLogger(UserRegisteredEventListener.class);
    private static final String EXCHANGE_NAME = "auth.exchange";

    private final RabbitTemplate rabbitTemplate;

    public UserRegisteredEventListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @EventListener
    public void handleUserRegistered(UserRegisteredEvent event) {
        logger.info("EVENT PUBLISHED: user.registered ID={} EMAIL={}",
                   event.getUserId(), event.getEmail());

        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "user.registered", event);
    }
}