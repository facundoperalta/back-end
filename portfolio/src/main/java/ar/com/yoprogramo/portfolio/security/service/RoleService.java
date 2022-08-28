package ar.com.yoprogramo.portfolio.security.service;

import ar.com.yoprogramo.portfolio.security.entity.Role;
import ar.com.yoprogramo.portfolio.security.enums.RoleName;
import ar.com.yoprogramo.portfolio.security.repository.RoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService implements IRoleService {
    
    @Autowired
    private RoleRepository roleRepository;
            
    @Override
    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
   
    @Override
    public void save(Role role){
        roleRepository.save(role);
    }

    
}