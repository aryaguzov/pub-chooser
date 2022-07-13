package com.example.pubchooser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "pubs")
public class Pub {

    @Id
    @Column(name = "id", nullable = false)
    @NotBlank
    private String id;

    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(min = 5, max = 128)
    private String address;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @Column(name = "type", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String type;

    @Column(name = "rating", nullable = false)
    private double rating;

    public Pub() {
    }

    public Pub(String id, String address, String name, String type, double rating) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.type = type;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Pub{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pub pub = (Pub) o;
        return Double.compare(pub.rating, rating) == 0 && Objects.equals(id, pub.id) && Objects.equals(address, pub.address) && Objects.equals(name, pub.name) && Objects.equals(type, pub.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name, type, rating);
    }
}
