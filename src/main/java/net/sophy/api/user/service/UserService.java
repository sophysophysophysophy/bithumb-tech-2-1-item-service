package net.sophy.api.user.service;


import net.sophy.api.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAll();
    //    Item getById(long id);
    Optional<User> findById(long id);
    boolean existById(long id);
    int count();
    void save(User entity);
    void deleteById(long id);
    void deleteAll();
}
