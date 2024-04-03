package com.delete.Assignment.service;

import com.delete.Assignment.model.UserDto;
import com.delete.Assignment.model.UserEntity;
import com.delete.Assignment.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepo){
        this.userRepository = userRepo;
    }

    @Override
    public void createNewUser(UserDto userDto) {
        validateUserData(userDto);
        UserEntity userEntity = new UserEntity();
        if(userDto != null){
            userEntity.setName(userDto.getName());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setOccupation(userDto.getOccupation());
            userRepository.save(userEntity);
        }else{
            System.out.println("no user data found");
        }
    }

    private void validateUserData(UserDto userDto) {
        if(userDto.getEmail() == null || userDto.getEmail().isEmpty() || userDto.getEmail().isBlank()){
            System.out.println("no user email found");
            throw new RuntimeException("No Data");
        }
        //
    }
}
