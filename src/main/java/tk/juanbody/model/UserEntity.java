package tk.juanbody.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, name = "firstName")
    private String firstName;
    @Column(nullable = true, name = "lastName")
    private String lastName;
    @Column(nullable = false, name = "userName")
    private String userName;
    @Column(nullable = false, name = "password")
    private String password;
    @Column(nullable = false, name = "age")
    private String age;
    @Column(nullable = false, name = "height")
    private String height;
    @Column(nullable = false, name = "weight")
    private String weight;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PracticeEntity> practiceEntities;

    public UserEntity() {

    }

    public UserEntity(Long id, String firstName, String lastName, String userName, String password, String age, String height, String weight) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public UserEntity(String firstName, String lastName, String userName, String password, String age, String height, String weight, List<PracticeEntity> practiceEntities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
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

    public List<PracticeEntity> getPracticeEntities() {
        if (practiceEntities != null) {
            List<PracticeEntity> result = new ArrayList<>();
            for (PracticeEntity practiceEntity : practiceEntities) {
                result.add(new PracticeEntity(practiceEntity.getId(), practiceEntity.getExerciseEntity(), practiceEntity.getTime(), practiceEntity.getGoalEntity()));
            }
            return result;
        } else return null;
    }

    public void setPracticeEntities(List<PracticeEntity> practiceEntities) {
        this.practiceEntities = practiceEntities;
    }
}
