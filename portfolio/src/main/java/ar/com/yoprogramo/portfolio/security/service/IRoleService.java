package ar.com.yoprogramo.portfolio.security.service;

import ar.com.yoprogramo.portfolio.security.entity.Role;
import ar.com.yoprogramo.portfolio.security.enums.RoleName;
import java.util.Optional;

public interface IRoleService {
       
    public Optional<Role> getByRoleName(RoleName roleName);

    public void save(Role role);
    
}
