package net.sophy.api.user.service;

import lombok.RequiredArgsConstructor;
import net.sophy.api.user.domain.User;
import net.sophy.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User signin(String username, String password) {
        return userRepository.signin(username, password);
    }

}
