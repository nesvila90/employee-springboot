package com.fonyou.employee.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fonyou.employee.domain.model.entity.base.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User extends EntityBase {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

}
