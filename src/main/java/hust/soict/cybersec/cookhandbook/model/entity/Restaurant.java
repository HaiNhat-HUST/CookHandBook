package hust.soict.cybersec.cookhandbook.model.entity;

public class Restaurant {
    private int id;
    private String name;
    private String address;
    private int ownerId;
    private String phoneNumber;

    public Restaurant(int id, String name, String address, int owner_id, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.ownerId = owner_id;
        this.phoneNumber = phoneNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int owner_id) {
        this.ownerId = owner_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}