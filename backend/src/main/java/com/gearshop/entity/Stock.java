package com.gearshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "t_stock")
public class Stock implements Serializable {

    private static final long serialVersionUID = 7966866207494781731L;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Min(1)
    @Column(nullable = false)
    private int count;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Stock stock = (Stock) object;

        return product.equals(stock.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public String toString() {
       return String.format("Stock [count:%d, product:%s]", count, product.getName());
    }
}
