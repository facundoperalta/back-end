package ar.com.yoprogramo.portfolio.security.service;

import ar.com.yoprogramo.portfolio.security.entity.User;
import java.util.Optional;

public interface IUserService {
    
    public Optional<User> getByUserName(String userName);
    
    public boolean existsByUserName(String userName);
    
    public boolean existsByEmail(String email);
    
    public void save(User user);
    
}
