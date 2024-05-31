package org.example;

public class Client {
    private long id;
    private String name;


    public void setName(String name) {
        this.name = name;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
