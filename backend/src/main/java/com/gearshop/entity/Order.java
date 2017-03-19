package com.gearshop.entity;

import com.gearshop.constant.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -4552359336237479989L;

    public Order(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Order(LocalDate createDate, String phone) {
        this.createDate = createDate;
        this.phone = phone;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column(nullable = false)
    private String phone;

    @Column
    private User user;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.BUILDING;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
