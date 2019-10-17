package com.fonyou.employee.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type Employee.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true, of = {"id"})
@NoArgsConstructor
public class Employee extends Person {

    @NotNull
    private BigDecimal salary;

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public BigDecimal getSalary() {
        salary = salary.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(BigDecimal salary) {
        salary = salary.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        this.salary = salary;
    }
}
