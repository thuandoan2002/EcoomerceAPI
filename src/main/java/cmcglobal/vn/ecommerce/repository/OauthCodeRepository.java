package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.OauthCodeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OauthCodeRepository extends JpaRepository<OauthCodeEntity,Long> {
    @Query(value = "SELECT x.* FROM eCommerce.oauth_code x WHERE code = :code", nativeQuery = true)

    Optional<OauthCodeEntity> findOauthCode(String code);
    Page<OauthCodeEntity> findByCodeIsContaining(String code, Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM oauth_code WHERE code = :code", nativeQuery = true)
    void delete(String code);

}
