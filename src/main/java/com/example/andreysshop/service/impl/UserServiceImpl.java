package com.example.andreysshop.service.impl;

import com.example.andreysshop.model.entity.User;
import com.example.andreysshop.model.service.UserServiceModel;
import com.example.andreysshop.repository.UserRepository;
import com.example.andreysshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean register(UserServiceModel userServiceModel) {

            Optional<User> userr = userRepository.findByUsername(userServiceModel.getUsername());
            if (userr.isPresent()){
                return false;
            }
        userRepository
                .save(modelMapper.map(userServiceModel , User.class));
            return true;
    }
}
