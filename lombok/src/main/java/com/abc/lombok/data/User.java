package com.abc.lombok.data;

import java.util.Objects;

public class User {

  private Integer id;
  private Integer age;
  private String realName;

  public User() {
  }

  public User(Integer id, Integer age, String realName) {
    this.id = id;
    this.age = age;
    this.realName = realName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (!Objects.equals(id, user.id)) {
      return false;
    }
    if (!Objects.equals(age, user.age)) {
      return false;
    }
    return Objects.equals(realName, user.realName);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (age != null ? age.hashCode() : 0);
    result = 31 * result + (realName != null ? realName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", age=" + age +
        ", realName='" + realName + '\'' +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }
}
