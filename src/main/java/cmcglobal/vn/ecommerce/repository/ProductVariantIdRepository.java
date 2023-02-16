package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.ProductVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantIdRepository extends JpaRepository<ProductVariantEntity, Long> {
}
