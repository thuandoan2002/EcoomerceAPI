package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product_variant", schema = "eCommerce", catalog = "")
public class ProductVariantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "width", nullable = true, length = 100)
    private String width;
    @Basic
    @Column(name = "height", nullable = true, length = 100)
    private String height;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "composition", nullable = true, length = 259)
    private String composition;
    @Basic
    @Column(name = "cargo_price", nullable = false, precision = 2)
    private double cargoPrice;
    @Basic
    @Column(name = "tax_percent", nullable = true)
    private Integer taxPercent;
    @Basic
    @Column(name = "sell_count", nullable = true)
    private Integer sellCount;
    @Basic
    @Column(name = "stock", nullable = false)
    private int stock;
    @Basic
    @Column(name = "live", nullable = false)
    private byte live;
    @Basic
    @Column(name = "image", nullable = true, length = 250)
    private String image;
    @Basic
    @Column(name = "thumb", nullable = true, length = 250)
    private String thumb;
    @OneToMany(mappedBy = "productVariantByProductVariantId")
    private Collection<CartItemEntity> cartItemsById;
    @OneToMany(mappedBy = "productVariantByProductVariantId")
    private Collection<OrderDetailEntity> orderDetailsById;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity productByProductId;
    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
    private ColorEntity colorByColorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public double getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(double cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public Integer getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Integer taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public byte getLive() {
        return live;
    }

    public void setLive(byte live) {
        this.live = live;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariantEntity that = (ProductVariantEntity) o;
        return id == that.id && Double.compare(that.cargoPrice, cargoPrice) == 0 && stock == that.stock && live == that.live  && Objects.equals(width, that.width) && Objects.equals(height, that.height) && Objects.equals(composition, that.composition) && Objects.equals(taxPercent, that.taxPercent) && Objects.equals(sellCount, that.sellCount) && Objects.equals(image, that.image) && Objects.equals(thumb, that.thumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height, price, composition, cargoPrice, taxPercent, sellCount, stock, live, image, thumb);
    }

    public Collection<CartItemEntity> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItemEntity> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public Collection<OrderDetailEntity> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Collection<OrderDetailEntity> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    public ColorEntity getColorByColorId() {
        return colorByColorId;
    }

    public void setColorByColorId(ColorEntity colorByColorId) {
        this.colorByColorId = colorByColorId;
    }
}
