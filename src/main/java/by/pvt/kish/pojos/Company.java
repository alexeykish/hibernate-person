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
    private Address homeAddress;
    private Address billingAddress;

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
        if (customName != null ? !customName.equals(company.customName) : company.customName != null) return false;
        if (homeAddress != null ? !homeAddress.equals(company.homeAddress) : company.homeAddress != null) return false;
        return billingAddress != null ? billingAddress.equals(company.billingAddress) : company.billingAddress == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (customName != null ? customName.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", customName='" + customName + '\'' +
                ", homeAddress=" + homeAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
