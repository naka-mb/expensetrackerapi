package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import in.bushansirgur.expensetrackerapi.exceptions.ResourceNotFoundException;
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

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id : " + id));
    }

    @Override
    public User updateUser(UserModel user, Long id) {
        User existingUser = readUser(id);
        existingUser.setName(user.getName() != null ? user.getName(): existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail(): existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? user.getPassword(): existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge(): existingUser.getAge());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = readUser(id);
        userRepository.delete(existingUser);
    }
}
