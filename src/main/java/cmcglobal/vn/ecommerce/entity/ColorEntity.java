package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "color", schema = "eCommerce", catalog = "")
public class ColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "hex", nullable = false, length = 50)
    private String hex;
    @OneToMany(mappedBy = "colorByColorId")
    private Collection<ProductVariantEntity> productVariantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorEntity that = (ColorEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(hex, that.hex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hex);
    }

    public Collection<ProductVariantEntity> getProductVariantsById() {
        return productVariantsById;
    }

    public void setProductVariantsById(Collection<ProductVariantEntity> productVariantsById) {
        this.productVariantsById = productVariantsById;
    }
}
