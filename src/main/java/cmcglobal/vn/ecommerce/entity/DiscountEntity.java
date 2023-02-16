package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "discount", schema = "eCommerce", catalog = "")
public class DiscountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "code", nullable = false, length = 240)
    private String code;
    @Basic
    @Column(name = "discount_percent", nullable = false)
    private int discountPercent;
    @Basic
    @Column(name = "status", nullable = false)
    private byte status;
    @OneToMany(mappedBy = "discountByDiscountId")
    private Collection<CartEntity> cartsById;
    @OneToMany(mappedBy = "discountByDiscountId")
    private Collection<OrdersEntity> ordersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountEntity that = (DiscountEntity) o;
        return id == that.id && discountPercent == that.discountPercent && status == that.status && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, discountPercent, status);
    }

    public Collection<CartEntity> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<CartEntity> cartsById) {
        this.cartsById = cartsById;
    }

    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }
}
