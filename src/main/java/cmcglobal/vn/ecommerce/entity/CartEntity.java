package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "total_cart_price", nullable = false, precision = 0)
    private BigDecimal totalCartPrice;
    @Basic
    @Column(name = "total_cargo_price", nullable = false, precision = 0)
    private BigDecimal totalCargoPrice;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private BigDecimal totalPrice;
    @Basic
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private DiscountEntity discountByDiscountId;
    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartItemEntity> cartItemsById;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(BigDecimal totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    public BigDecimal getTotalCargoPrice() {
        return totalCargoPrice;
    }

    public void setTotalCargoPrice(BigDecimal totalCargoPrice) {
        this.totalCargoPrice = totalCargoPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalCartPrice, totalCargoPrice, totalPrice, dateCreated);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public DiscountEntity getDiscountByDiscountId() {
        return discountByDiscountId;
    }

    public void setDiscountByDiscountId(DiscountEntity discountByDiscountId) {
        this.discountByDiscountId = discountByDiscountId;
    }

    public Collection<CartItemEntity> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItemEntity> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

}
