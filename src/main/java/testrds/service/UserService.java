package testrds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testrds.entity.User;
import testrds.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(int userId) {
    return userRepository.findById(userId).get();
  }

  @Transactional
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Transactional
  public void deleteUserById(int userId) {
    userRepository.deleteById(userId);
  }

}
