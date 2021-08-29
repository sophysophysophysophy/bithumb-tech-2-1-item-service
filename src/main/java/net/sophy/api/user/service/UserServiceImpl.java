package net.sophy.api.user.service;

import lombok.RequiredArgsConstructor;
import net.sophy.api.security.domain.SecurityProvider;
import net.sophy.api.security.exception.SecurityRuntimeException;
import net.sophy.api.user.domain.Role;
import net.sophy.api.user.domain.User;
import net.sophy.api.user.domain.UserDto;
import net.sophy.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final SecurityProvider provider;
    private final ModelMapper modelMapper;

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
    public UserDto signin(User user) {
        try {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = (encoder.matches(user.getPassword(),
                    userRepository.findByUsername(user.getUsername()).get().getPassword()))
                    ? provider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password" ;
            userDto.setToken(token);
            return userDto;
        } catch (Exception e) {
            throw new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String signup(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(encoder.encode(user.getPassword()));
            List<Role> roleList = new ArrayList<>();
            roleList.add(Role.USER);
            user.setRoles(roleList);
            System.out.println(user.toString());
            userRepository.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        }
        else {
            throw new SecurityRuntimeException("중복된 ID입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
