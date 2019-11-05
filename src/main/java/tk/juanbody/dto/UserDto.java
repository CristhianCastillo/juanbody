package tk.juanbody.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String age;
    private String height;
    private String weight;
    private String token;
    private List<PracticeDto> practiceEntities;

    public UserDto() {

    }

    public UserDto(Long id, String firstName, String lastName, String userName, String password, String age, String height, String weight, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.token = token;
    }

    public UserDto(Long id, String firstName, String lastName, String userName, String password, String age, String height, String weight, String token, List<PracticeDto> practiceEntities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.token = token;
        this.practiceEntities = practiceEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PracticeDto> getPracticeEntities() {
        return practiceEntities;
    }

    public void setPracticeEntities(List<PracticeDto> practiceEntities) {
        this.practiceEntities = practiceEntities;
    }
}
