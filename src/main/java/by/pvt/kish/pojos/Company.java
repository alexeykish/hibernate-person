package by.pvt.kish.pojos;

import java.io.Serializable;

/**
 * @author Kish Alexey
 */
public class Company implements Serializable{
    private int id;
    private String name;
    private String owner;
    private String customName;

    public Company() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (owner != null ? !owner.equals(company.owner) : company.owner != null) return false;
        return customName != null ? customName.equals(company.customName) : company.customName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (customName != null ? customName.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ",\n name='" + name + '\'' +
                ",\n owner='" + owner + '\'' +
                ",\n customName='" + customName + '\'' +
                '}';
    }
}
