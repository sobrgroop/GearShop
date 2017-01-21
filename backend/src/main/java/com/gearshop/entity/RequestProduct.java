package com.gearshop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_request_products")
public class RequestProduct implements Serializable {

    private static final long serialVersionUID = -3439139043763101249L;

    @Id
    @Column(name = "request_product_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @Column
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestProduct that = (RequestProduct) o;

        if (count != that.count) return false;
        if (!id.equals(that.id)) return false;
        if (!product.equals(that.product)) return false;
        return request.equals(that.request);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + request.hashCode();
        result = 31 * result + count;
        return result;
    }
}
