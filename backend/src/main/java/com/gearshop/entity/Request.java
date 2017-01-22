package com.gearshop.entity;

import com.gearshop.constant.Status;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_requests")
public class Request implements Serializable {

    private static final long serialVersionUID = -2825445073358492463L;

    @Id
    @Column(name = "request_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (!id.equals(request.id)) return false;
        if (!user.equals(request.user)) return false;
        return status == request.status;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
