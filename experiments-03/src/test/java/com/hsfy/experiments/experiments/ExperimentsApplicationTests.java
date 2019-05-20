package com.hsfy.experiments.experiments;

import com.hsfy.experiments.experiments.entity.UserAddress;
import com.hsfy.experiments.experiments.repository.AddressRepository;
import com.hsfy.experiments.experiments.repository.UserAddressRepository;
import com.hsfy.experiments.experiments.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExperimentsApplicationTests {
    @Autowired
    UserAddressRepository userAddressRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void contextLoads() {
        System.out.println("开始工作-----");
        System.out.println("查询用户Id为2的用户信息-----");
        System.out.println(userRepository.findById(2).getName());
        System.out.println("查询地址detail为824的地址信息-----");
        System.out.println("地址id为"+addressRepository.findByDetail("824").getId());
        System.out.println("查询用户Id为233,detail为233的信息-----");
        UserAddress userAddress = userAddressRepository.findByUserNameAndAddressDetail("233", "233");
        System.out.println("用户id为"+userAddress.getUser().getId());
        System.out.println("地址id为"+userAddress.getAddress().getId());
    }

}
