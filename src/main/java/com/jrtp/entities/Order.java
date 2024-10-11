package com.jrtp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;

    @Column(name = "order_tracking_num")
    private String orderTrackingNum;

    @Column(name = "razorpay_order_id")
    private String razorPayOrderId;

    @Column(name = "email")
    private String email;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "totalprice")
    private double totalPrice;

    @Column(name = "totalquantity")
    private int totalQuantity;

    @Column(name = "razorpay_payment_id")
    private String razorPayPaymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
