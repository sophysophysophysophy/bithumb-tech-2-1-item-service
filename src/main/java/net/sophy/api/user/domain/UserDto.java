package net.sophy.api.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

//외부 노출위한 DTO(UI와 접촉하는 DTO) 보안을 위한 실 User DTO와 구분
@Data @Component
public class UserDto {
    @ApiModelProperty(position = 0) private long userId;
    @ApiModelProperty(position = 1) private String username;
    @ApiModelProperty(position = 2) private String password;
    @ApiModelProperty(position = 3) private String name;
    @ApiModelProperty(position = 4) private String email;
    @ApiModelProperty(position = 5) private String reqDate;
    @ApiModelProperty(position = 6) private String token;
    @ApiModelProperty(position = 7) private List<Role> roles;


}
