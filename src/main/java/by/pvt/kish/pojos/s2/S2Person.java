package by.pvt.kish.pojos.s2;

/**
 * @author Kish Alexey
 */
public class S2Person {

    private int id;
    private int age;
    private String name;
    private String surname;

    public S2Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "S2Person{" +
                "id=" + id +
                ",\n age=" + age +
                ",\n name='" + name + '\'' +
                ",\n surname='" + surname + '\'' +
                '}';
    }
}
