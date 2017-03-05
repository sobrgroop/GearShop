/*
package com.gearshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "t_orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -4552359336237479989L;

    @Id
    @Column(name = "order_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @Column(nullable = false)
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Order order = (Order) object;

        return id.equals(order.id) && request.equals(order.request) && date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + request.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
*/

package com.gearshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -4552359336237479989L;

    @Id
    @Column(name = "order_id")
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private User user;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
