package testrds.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="name", nullable=false, length=10)
  private String name;

  @Column(name = "email", nullable = false, length = 30)
  private String email;

public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
