package com.gearshop.controller;

import com.gearshop.dto.OrderBody;
import com.gearshop.entity.CartItem;
import com.gearshop.entity.Order;
import com.gearshop.repository.CartItemRepository;
import com.gearshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.gearshop.constant.Status.NEW;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/cartItems")
public class CartRestController {

    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public CartRestController(CartItemRepository cartItemRepository,
                              OrderRepository orderRepository) {
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> createOrderAndSaveCartItems(@RequestBody OrderBody body) {
        Order order = orderRepository.save(new Order(LocalDate.now(), body.getPhone()));
        for (CartItem cartItem : body.getCartItems()) {
            cartItem.setOrder(order);
            cartItemRepository.save(cartItem);
        }
        order.setStatus(NEW);
        orderRepository.save(order);
        return new ResponseEntity<>(CREATED);
    }

}
