package com.hsfy.experiments.experiments.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Size(min = 2, max = 6,
            message = "您输入的用户名为${validatedValue}，长度必须大于{min}小于{max}")
    private String userName;
    @Size(min = 6,message = "您的密码长度不够.")
    private String password;
    @Max(value = 60, message = "您的年龄必须小于{value}")
    @Min(value = 18, message = "您的年龄必须大于{value}")
    private int age;
    @Email(message = "您的E妹格式有问题哦.")
    private String email;

    public User(String userName){
        this.userName = userName;
    }
}