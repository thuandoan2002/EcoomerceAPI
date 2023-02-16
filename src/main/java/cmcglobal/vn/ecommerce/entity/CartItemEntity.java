package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private CartEntity cartByCartId;
    @ManyToOne
    @JoinColumn(name = "product_variant_id", referencedColumnName = "id")
    private ProductVariantEntity productVariantByProductVariantId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemEntity that = (CartItemEntity) o;
        return id == that.id  && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    public CartEntity getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(CartEntity cartByCartId) {
        this.cartByCartId = cartByCartId;
    }

    public ProductVariantEntity getProductVariantByProductVariantId() {
        return productVariantByProductVariantId;
    }

    public void setProductVariantByProductVariantId(ProductVariantEntity productVariantByProductVariantId) {
        this.productVariantByProductVariantId = productVariantByProductVariantId;
    }
}
