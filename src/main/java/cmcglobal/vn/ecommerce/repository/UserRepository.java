package cmcglobal.vn.ecommerce.repository;

import cmcglobal.vn.ecommerce.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Page<UserEntity> findByEmailIsContaining(String email, Pageable pageable);
    Optional<UserEntity> findByEmail(String email);
}
