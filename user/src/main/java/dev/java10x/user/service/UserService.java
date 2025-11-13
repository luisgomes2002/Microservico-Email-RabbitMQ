package dev.java10x.user.service;

import dev.java10x.user.domain.UserModel;
import dev.java10x.user.producer.UserProducer;
import dev.java10x.user.repositorie.UserRepositorie;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepositorie userRepositorie;
    private final UserProducer userProducer;

    public UserService(UserRepositorie userRepositorie, UserProducer userProducer) {
        this.userRepositorie = userRepositorie;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel saveAndPublish(UserModel userModel){
        userModel = userRepositorie.save(userModel);
        userProducer.publishEvent(userModel);
        return userModel;
    }

    public List<UserModel> findAll(){
        return userRepositorie.findAll();
    }
}