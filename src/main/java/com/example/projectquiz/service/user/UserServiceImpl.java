package com.example.projectquiz.service.user;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.dto.UserSession;
import com.example.projectquiz.entity.UserEntity;
import com.example.projectquiz.io.request.user.LoginRequest;
import com.example.projectquiz.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserSession login(LoginRequest req) {
        // Lấy thông tin user
        UserEntity userEntity = userRepository.findByAccountUser(req.getAccountUser());

        if (userEntity == null) {
            throw new RuntimeException("Email does not exist in the system");
        }

        // Kiểm tra password
        boolean result = BCrypt.checkpw(req.getPasswordUser(), userEntity.getPasswordUser());
        if (!result) {
            throw new RuntimeException("Password wrong");
        }

        return modelMapper.map(userEntity, UserSession.class);
    }

    @Override
    public List<UserDto> findAllUser() {

        try {
            List<UserEntity> userEntities = userRepository.findAll();
            List<UserDto> userDtos = new ArrayList<>();

            for (UserEntity userEntity : userEntities) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(userEntity, userDto);

                userDtos.add(userDto);
            }

            return userDtos;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDto findById(Long idUser) {
        try {
            UserEntity userEntity = userRepository.findByIdUser(idUser);
            if (userEntity == null) {
                return null;
            } else {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(userEntity, userDto);

                return userDto;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDto createUser(UserDto requestDto) {

        try {
            if (isAccountUserExist(requestDto.getAccountUser())) {
                return null;
            } else {

                UserEntity userEntity = modelMapper.map(requestDto, UserEntity.class);
//                UserEntity userEntity = new UserEntity();
//                BeanUtils.copyProperties(requestDto, userEntity);


                String hash = BCrypt.hashpw(requestDto.getPasswordUser(),
                        BCrypt.gensalt(12));
                userEntity.setPasswordUser(hash);
                userEntity.setRole("STUDENT");

                UserEntity createdUser = userRepository.save(userEntity);
                return modelMapper.map(createdUser, UserDto.class);

//                UserDto createdUser = new UserDto();
//                BeanUtils.copyProperties(userRepository.save(userEntity), createdUser);
//
//                return createdUser;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto requestDto) {

        UserEntity userEntity = userRepository.findByIdUser(id);
        if (userEntity == null) {
            return null;
        } else {
            if (isAccountUserExist(requestDto.getAccountUser())) {
                return null;
            } else {
                UserEntity updateEntity = new UserEntity();
                BeanUtils.copyProperties(requestDto, updateEntity);

                updateEntity.setIdUser(id);

                UserDto updatedUser = new UserDto();
                BeanUtils.copyProperties(userRepository.save(updateEntity), updatedUser);

                return updatedUser;
            }
        }
    }

    @Override
    public boolean deleteUser(Long idUser) {

        try {
            UserEntity userEntity = userRepository.findByIdUser(idUser);
            if (userEntity == null) {
                return false;
            } else {
                userRepository.delete(userEntity);
                return true;
            }
        } catch (Exception e) {
            return false;
        }

    }

    private boolean isAccountUserExist(String accountUser) {
        try {
            return userRepository.existsByAccountUser(accountUser);
        } catch (Exception e) {
            return true;
        }
    }

}
