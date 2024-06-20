package testrds.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import testrds.dto.UserCreateDTO;
import testrds.dto.UserResponseDTO;
import testrds.entity.User;
import testrds.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<UserResponseDTO> getUsers() {
    List<UserResponseDTO> users = userService.getUserList()
        .stream()
        .map(u -> new UserResponseDTO(u.getId(), u.getName(), u.getEmail()))
        .collect(Collectors.toList());
    return users;
  }

  @PostMapping("/add")
  public UserResponseDTO createNewUser(@RequestBody UserCreateDTO userDto){
    User user = userService.createUser(userDto);
    return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
  }

}
