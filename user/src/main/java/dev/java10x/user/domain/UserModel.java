package dev.java10x.user.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "USER_TB")
public class UserModel {
  private static final long SerialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;
  private String name;
  private String email;

  public UserModel() {
  }

  public UserModel(UUID userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
