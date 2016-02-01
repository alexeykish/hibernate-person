package by.pvt.kish.pojos.s3a;

/**
 * @author Kish Alexey
 */
public abstract class S3APerson {

    private int id;
    private int age;
    private String name;
    private String surname;

    public S3APerson() {
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
        return "S3Person{" +
                "id=" + id +
                ",\n age=" + age +
                ",\n name='" + name + '\'' +
                ",\n surname='" + surname + '\'' +
                '}';
    }
}
