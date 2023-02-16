package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "oauth_code", schema = "eCommerce", catalog = "")
public class OauthCodeEntity {
    @Basic
    @Column(name = "code", nullable = true, length = 255)
    private String code;
    @Basic
    @Column(name = "authentication", nullable = true, length = -1)
    private String authentication;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthCodeEntity that = (OauthCodeEntity) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(authentication, that.authentication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, authentication, id);
    }
}
