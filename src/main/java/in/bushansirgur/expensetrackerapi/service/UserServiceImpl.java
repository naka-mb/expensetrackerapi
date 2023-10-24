package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import in.bushansirgur.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserModel user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("User is already register with email: " + user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user,newUser);
        return userRepository.save(newUser);
    }
}
