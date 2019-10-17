package com.fonyou.employee.repository;

import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.commons.exceptions.business.base.BusinessException;
import com.fonyou.employee.domain.model.entity.Employee;

import java.util.List;

/**
 * @author Nestor Villar Lautero
 * @since 0.0.1 16/10/2019
 * @version 0.0.1 16/10/2019
 * The interface Employee repository facade.
 */
public interface EmployeeRepositoryFacade {

    /**
     * Find employee by id employee.
     *
     * @author Nestor Villar Lautero
     * @since 0.0.1 16/10/2019
     * @version 0.0.1 16/10/2019
     * @param id the id
     * @return the employee
     * @throws BusinessException the business exception
     * @throws GeneralException  the general exception
     */
    Employee findEmployeeById(final Long id) throws BusinessException, GeneralException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws GeneralException the general exception
     */
    List<Employee> findAll() throws GeneralException;

    /**
     * Registre employee.
     *
     * @author Nestor Villar Lautero
     * @since 0.0.1 16/10/2019
     * @version 0.0.1 16/10/2019
     * @param employee the employee
     * @throws DataCorruptedException the data corrupted exception
     */
    void registreEmployee(Employee employee) throws DataCorruptedException;

    /**
     * Update employee employee.
     *
     * @author Nestor Villar Lautero
     * @since 0.0.1 16/10/2019
     * @version 0.0.1 16/10/2019
     * @param employee the employee
     * @return the employee
     * @throws DataNotFoundedException the data not founded exception
     * @throws GeneralException        the general exception
     */
    Employee updateEmployee(Employee employee) throws DataNotFoundedException, GeneralException;

    /**
     * Delete.
     *
     * @author Nestor Villar Lautero
     * @since 0.0.1 16/10/2019
     * @version 0.0.1 16/10/2019
     * @param id the id
     * @throws DataCorruptedException the data corrupted exception
     */
    void delete(Long id) throws DataCorruptedException;
}
