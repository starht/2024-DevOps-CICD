package testrds.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import testrds.entity.User;
import testrds.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/info")
  public User getUserById(int userId) {
    return userService.getUserById(userId);
  }

  @PostMapping("/add")
  public User addUser(User user) {
    User newUser = new User();
    newUser.setName(user.getName());
    newUser.setEmail(user.getEmail());
    return userService.addUser(newUser);
  }

  @DeleteMapping("/delete")
  public void deleteUserById(int userId) {
    userService.deleteUserById(userId);
  }



}
