package testrds.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import testrds.dto.UserCreateDTO;
import testrds.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserServiceTest {
  @Autowired
  UserService userService;

  @Test
  void 사용자생성테스트(){
    //given
    UserCreateDTO userDto = new UserCreateDTO("홍길동", "a@naver.com");
    //when
    User user = userService.createUser(userDto);
    //then
    assertThat(user.getId()).isGreaterThan(0);
  }

}
