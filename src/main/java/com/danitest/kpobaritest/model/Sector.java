package com.danitest.kpobaritest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sector")
@Getter
@Setter
public class Sector extends BaseEntity implements Serializable {
    private String name;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "sectors")
    @JsonIgnore
    private Set<User> users;

}
