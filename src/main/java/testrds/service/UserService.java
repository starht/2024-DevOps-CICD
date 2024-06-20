package testrds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testrds.dto.UserCreateDTO;
import testrds.entity.User;
import testrds.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getUserList() {
    return userRepository.findAll();
  }

  public User createUser(UserCreateDTO userDto) {
    User user = new User();
    user.setEmail(userDto.getEmail());
    user.setName(userDto.getName());

    return userRepository.save(user);
  }
}