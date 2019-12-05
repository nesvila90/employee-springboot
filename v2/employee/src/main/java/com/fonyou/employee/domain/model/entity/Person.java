package com.fonyou.employee.domain.model.entity;

import com.fonyou.employee.domain.model.entity.base.EntityBase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private String names;
    @NotNull
    private String lastNames;
    @NotNull
    private String birthDate;

}
