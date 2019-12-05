package com.fonyou.employee.repository;

import com.fonyou.employee.domain.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * The interface Employee repository.
 *
 * @author Nestor Villar Lautero
 * @since 0.0.1 16/10/2019
 * @version 0.0.1 16/10/2019
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
