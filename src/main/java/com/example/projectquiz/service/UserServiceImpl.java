package com.example.projectquiz.service;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.model.User;
import com.example.projectquiz.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private RestTemplate restTemplate = new RestTemplate();

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDto findById(Integer idUser) {

        Optional<User> user = userRepository.findById(idUser);
        if (user == null) return null;
        else {
            Integer loyalty = getinfouserloyalty(idUser);

            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user.get(), userDto);
            userDto.setLoyalty(loyalty);

            return userDto;
        }
    }

    @Override
    public Integer getinfouserloyalty(Integer idUser) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "simple_api_key_for_authentication");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Integer> response = restTemplate.exchange("http://localhost:8081/user/" + idUser + "/loyalty",
                HttpMethod.GET, entity, Integer.class);

        if (null == response.getBody()) return 0;
        else {
            return response.getBody();
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

}
