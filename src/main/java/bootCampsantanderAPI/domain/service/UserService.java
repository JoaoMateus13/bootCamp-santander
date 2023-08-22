package bootCampsantanderAPI.domain.service;

import bootCampsantanderAPI.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

    User findAll();





}
