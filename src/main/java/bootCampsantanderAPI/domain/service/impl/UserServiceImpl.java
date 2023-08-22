package bootCampsantanderAPI.domain.service.impl;

import bootCampsantanderAPI.domain.model.User;
import bootCampsantanderAPI.domain.repository.UserRepository;
import bootCampsantanderAPI.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsById(user.getId()) && user.getId()!=null){
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findAll() {
        return null;
    }
}
