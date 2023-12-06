package com.mlorenzo.demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "customers")
public class Customer {

    // En vez de serializar esta propiedad con el nombre "id", usamos el nombre "customer_id".
    // No puede usarse en la deserialización, es decir, esta propiedad no puede establecerse desde fuera, es decir,
    // desde la petición http hecha por algún cliente externo.
    @JsonProperty(value = "customer_id", access = JsonProperty.Access.READ_ONLY)
    @Id
    private Long id;

    @NotBlank(message = "name must not be empty or blank")
    private String name;

    @NotBlank(message = "password must not be empty or blank")
    // No puede usarse en la serialización, es decir, esta propiedad no puede ser enviada hacia fuera, es decir, no
    // puede ser enviada en la respuesta de la petición http hecha por algún cliente externo.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty(message = "email must not be empty")
    @Email
    private String email;

    public Customer() {
    }

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
