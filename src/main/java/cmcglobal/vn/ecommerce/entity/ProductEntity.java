package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "sku", nullable = false, length = 50)
    private String sku;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "url", nullable = false, length = 100)
    private String url;
    @Basic
    @Column(name = "long_desc", nullable = false, length = -1)
    private String longDesc;
    @Basic
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;
    @Basic
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;
    @Basic
    @Column(name = "unlimited", nullable = true)
    private Byte unlimited;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategoryEntity productCategoryByCategoryId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<ProductVariantEntity> productVariantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Byte getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(Byte unlimited) {
        this.unlimited = unlimited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id  && Objects.equals(sku, that.sku) && Objects.equals(name, that.name) && Objects.equals(url, that.url) && Objects.equals(longDesc, that.longDesc) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(unlimited, that.unlimited);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, url, longDesc, dateCreated, lastUpdated, unlimited);
    }

    public ProductCategoryEntity getProductCategoryByCategoryId() {
        return productCategoryByCategoryId;
    }

    public void setProductCategoryByCategoryId(ProductCategoryEntity productCategoryByCategoryId) {
        this.productCategoryByCategoryId = productCategoryByCategoryId;
    }

    public Collection<ProductVariantEntity> getProductVariantsById() {
        return productVariantsById;
    }

    public void setProductVariantsById(Collection<ProductVariantEntity> productVariantsById) {
        this.productVariantsById = productVariantsById;
    }
}
