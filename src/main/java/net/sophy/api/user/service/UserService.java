package net.sophy.api.user.service;


import net.sophy.api.user.domain.User;
import net.sophy.api.user.domain.UserDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
    boolean existById(long id);
    int count();
    void save(User entity);
    void deleteById(long id);
    void deleteAll();
    User getById(long id);      //없을 수가 없는 값에는 optional 걸지 않음 (있는게 확실할 때 )
    boolean existsByUsername(String username);
    UserDto signin(User user);
    String signup(User user);
}
