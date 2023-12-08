package com.danitest.kpobaritest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private boolean agreedToTerms;
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
           name = "user_sectors",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "sector_id")
   )
   private Set<Sector> sectors;
}
