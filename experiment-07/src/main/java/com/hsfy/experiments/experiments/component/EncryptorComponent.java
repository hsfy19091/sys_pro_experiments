package com.hsfy.experiments.experiments.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Component
@Slf4j
public class EncryptorComponent {
    @Value("${my.secretkey}")
    private String secretkey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    ObjectMapper objectMapper;
    //加密
    public String encrypt(Map map){
        try {
            //map转字符串加密
            String s = objectMapper.writeValueAsString(map);
            return Encryptors.text(secretkey, salt).encrypt(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    //解密
    public Map decrypt(String encryptString){
        try {
            //字符串解密转map
            String s = Encryptors.text(secretkey,salt ).decrypt(encryptString);
            return objectMapper.readValue(s, Map.class);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"未登录");
        }

    }
}
