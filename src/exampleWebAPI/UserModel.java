package exampleWebAPI;


import io.swagger.annotations.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class UserModel {
  private int id;
  private String username;
  private String firstName;
  private String lastName;

  @XmlElement(name = "id")
  public long getId() {
    return id;
  }
 
  public void setId(int id) {
    this.id = id;
  }

  @XmlElement(name = "firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @XmlElement(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @XmlElement(name = "lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}

  