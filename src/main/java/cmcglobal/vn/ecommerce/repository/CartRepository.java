package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    @Query(value = "SELECT x.* FROM cart x WHERE user_id = :userId ", nativeQuery = true)
    Collection<CartEntity> findCartByUserId(long userId);
}
