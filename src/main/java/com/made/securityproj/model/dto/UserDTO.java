package com.made.securityproj.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserDTO {
    private String id;

    private String pwd;
}
