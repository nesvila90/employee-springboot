package com.fonyou.employee.domain.model.entity;

import com.fonyou.employee.domain.model.entity.base.EntityBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * The type Person.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
@Data
@Entity
@NoArgsConstructor
public class Person extends EntityBase {

    private String names;
    private String lastNames;
    private String birthDate;

}
