package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.OrdersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    Page<OrdersEntity> findByUserByUserId(long userId, Pageable pageable);

    @Query(value = "SELECT x.* FROM orders x WHERE ship_name = :shipName AND ship_address = :shipAddress AND billing_address = :billingAddress order by id asc ", nativeQuery = true)
    Collection<OrdersEntity> filterOrder(String shipName, String shipAddress, String billingAddress);
}
