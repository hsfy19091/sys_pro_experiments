package com.hsfy.experiments.experiments.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    // 仅序列化时忽略
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
