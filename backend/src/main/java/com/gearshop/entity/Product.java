package com.gearshop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_products")
public class Product implements Serializable {

    private static final long serialVersionUID = 4883769254114338196L;

    @Id
    @Column(name = "product_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int availableInStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableInStock() {
        return availableInStock;
    }

    public void setAvailableInStock(int availableInStock) {
        this.availableInStock = availableInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (price != product.price) return false;
        if (availableInStock != product.availableInStock) return false;
        if (!id.equals(product.id)) return false;
        if (!category.equals(product.category)) return false;
        if (!name.equals(product.name)) return false;
        return description.equals(product.description);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        result = 31 * result + description.hashCode();
        result = 31 * result + availableInStock;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
