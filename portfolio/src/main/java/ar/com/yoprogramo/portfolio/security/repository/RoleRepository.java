package ar.com.yoprogramo.portfolio.security.repository;

import ar.com.yoprogramo.portfolio.security.entity.Role;
import ar.com.yoprogramo.portfolio.security.enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByRoleName(RoleName roleName);
}
