package com.cleanarch.infra.domain.model;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "users")
@SequenceGenerator(
    name = "seq_user",
    sequenceName = "seq_user",
    allocationSize = 1)
public class User implements UserDetails, Serializable {
  @Serial
  private static final long serialVersionUID = -4823560267175762698L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

//  Todo: create Picture, UserPicture and PetPicture entities
//  private Picture picture;

//  Todo: create Address, UserAddress, PetAddress entities
//  private Address address;

  private Boolean isActive = Boolean.TRUE;

  private String phone;
  private String phone2;

  @Temporal(TemporalType.DATE)
  private Date lastSeen;

  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @UpdateTimestamp
  @Temporal(TemporalType.DATE)
  private Date updatedAt;

  private Date deletedAt;

  @ManyToMany
  @JoinTable(
      name = "user_roles",
      uniqueConstraints = @UniqueConstraint(
          columnNames = {"user_id", "role_id"},
          name = "unique_user_role"
      ),
      joinColumns = @JoinColumn(
          name = "user_id",
          referencedColumnName = "id",
          table = "users",
          foreignKey = @ForeignKey(
              name = "user_fk",
              value = ConstraintMode.CONSTRAINT)
      ),
      inverseJoinColumns = @JoinColumn(
          name = "role_id",
          referencedColumnName = "id",
          table = "roles",
          foreignKey = @ForeignKey(
              name = "role_fk",
              value = ConstraintMode.CONSTRAINT
          )
      )
  )
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(
      Long id,
      String firstName,
      String lastName,
      String email,
      String password,
      Boolean isActive,
      String phone,
      String phone2,
      Date lastSeen,
      Date createdAt,
      Date updatedAt,
      Date deletedAt,
      Set<Role> roles
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.isActive = isActive;
    this.phone = phone;
    this.phone2 = phone2;
    this.lastSeen = lastSeen;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public Date getLastSeen() {
    return lastSeen;
  }

  public void setLastSeen(Date lastSeen) {
    this.lastSeen = lastSeen;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
