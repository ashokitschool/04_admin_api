package com.jrtp.repos;

import com.jrtp.dto.OrderItemDTO;
import com.jrtp.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

    @Query("SELECT new com.jrtp.dto.OrderItemDTO(oi.id, oi.productName, oi.imageUrl, oi.quantity, oi.price) " +
            "FROM OrderItem oi WHERE oi.order.id = :orderId")
    List<OrderItemDTO> findByOrderOrderId(Integer orderId);
}
