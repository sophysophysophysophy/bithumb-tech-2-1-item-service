package net.sophy.api.user.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sophy.api.user.domain.User;
import net.sophy.api.user.domain.UserDto;
import net.sophy.api.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 403, message = "승인 거절"),
            @ApiResponse(code = 422, message = "중복된 ID"),
    })
    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                         @RequestBody UserDto userDto) {
        System.out.println("회원가입 정보: " + userDto.toString());
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")           //swagger
    @ApiResponses(value = {                                     //swagger
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디 / 비밀번호"),
    })
    public ResponseEntity<UserDto> signin(@ApiParam("Signup User")
                                             @RequestBody UserDto userDto) {
        System.out.println("로그인 정보: " + userDto.toString());
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public Optional<User> findById(long id) {
        return userService.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }

    public boolean existById(long id) {
        return userService.existById(id);
    }

    public int count() {
        return (int) userService.count();
    }

    public void save(User entity) {
        userService.save(entity);
    }

    public void deleteById(long id) {
        userService.deleteById(id);
    }

    public void deleteAll() {
        userService.deleteAll();
    }

    public User getById(long id) {
        return userService.getById(id);
    }

    public boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }

}
