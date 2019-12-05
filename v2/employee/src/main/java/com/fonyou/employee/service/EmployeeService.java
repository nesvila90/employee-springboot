package com.fonyou.employee.service;

import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.commons.exceptions.business.base.BusinessException;
import com.fonyou.employee.domain.model.entity.Employee;

import javax.validation.Valid;
import java.util.List;

/**
 * The interface Employee service.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
public interface EmployeeService {

    /**
     * Find employee by id employee.
     *
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
     * @param employee the employee
     * @throws DataCorruptedException the data corrupted exception
     */
    void registreEmployee(@Valid Employee employee) throws DataCorruptedException;

    /**
     * Delete employee.
     *
     * @param id the id
     * @throws DataCorruptedException the data corrupted exception
     */
    void deleteEmployee(Long id) throws DataCorruptedException;

    /**
     * Update employee employee.
     *
     * @param employee the employee
     * @return the employee
     * @throws GeneralException        the general exception
     * @throws DataNotFoundedException the data not founded exception
     */
    Employee updateEmployee(@Valid Employee employee) throws GeneralException, DataNotFoundedException;

}
