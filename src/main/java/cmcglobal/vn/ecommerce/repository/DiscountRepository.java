package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {

    @Query(value = "SELECT x.* FROM eCommerce.discount x WHERE code = :code", nativeQuery = true)
    Optional<DiscountEntity> exitsByCode(String code);
}
