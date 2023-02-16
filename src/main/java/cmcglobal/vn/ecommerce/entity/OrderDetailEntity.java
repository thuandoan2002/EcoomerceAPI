package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "amount", nullable = false)
    private double amount;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private OrdersEntity ordersByOrderId;
    @ManyToOne
    @JoinColumn(name = "product_variant_id", referencedColumnName = "id")
    private ProductVariantEntity productVariantByProductVariantId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity entity = (OrderDetailEntity) o;
        return id == entity.id && amount == entity.amount ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    public OrdersEntity getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(OrdersEntity ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    public ProductVariantEntity getProductVariantByProductVariantId() {
        return productVariantByProductVariantId;
    }

    public void setProductVariantByProductVariantId(ProductVariantEntity productVariantByProductVariantId) {
        this.productVariantByProductVariantId = productVariantByProductVariantId;
    }
}
