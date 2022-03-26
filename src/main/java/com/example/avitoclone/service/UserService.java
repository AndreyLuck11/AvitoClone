package com.example.avitoclone.service;


import com.example.avitoclone.entity.UserEntity;
import com.example.avitoclone.exception.UserAlreadyExistException;
import com.example.avitoclone.exception.UserNotFoundException;
import com.example.avitoclone.model.User;
import com.example.avitoclone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public  User getOne(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
