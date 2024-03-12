package com.gdepl.app.data.entity;

import com.gdepl.app.data.dto.UserRole;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator
    private UUID id;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String country;

    @Type(JsonType.class)
    private Set<UserRole> roles;
}
