package dev.java10x.user.service;

import dev.java10x.user.domain.UserModel;
import dev.java10x.user.repositorie.UserRepositorie;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositorie userRepositorie;

    public UserService(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Transactional
    public UserModel createUser(UserModel userModel){
       return userModel = userRepositorie.save(userModel);
    }
}
