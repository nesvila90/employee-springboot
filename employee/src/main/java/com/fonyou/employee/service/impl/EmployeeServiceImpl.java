package com.fonyou.employee.service.impl;

import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.commons.exceptions.business.base.BusinessException;
import com.fonyou.employee.domain.model.entity.Employee;
import com.fonyou.employee.repository.EmployeeRepositoryFacade;
import com.fonyou.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Employee service.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryFacade employeeRepositoryFacade;

    /**
     * Instantiates a new Employee service.
     *
     * @param employeeRepositoryFacade the employee repository facade
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepositoryFacade employeeRepositoryFacade) {
        this.employeeRepositoryFacade = employeeRepositoryFacade;
    }

    @Override
    public Employee findEmployeeById(Long id) throws GeneralException, BusinessException {
        return employeeRepositoryFacade.findEmployeeById(id);
    }

    @Override
    public List<Employee> findAll() throws GeneralException {
        return employeeRepositoryFacade.findAll();
    }

    @Override
    public void registreEmployee(Employee employee) throws DataCorruptedException {
        employeeRepositoryFacade.registreEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) throws DataCorruptedException {
        employeeRepositoryFacade.delete(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) throws GeneralException, DataNotFoundedException {
        return employeeRepositoryFacade.updateEmployee(employee);
    }
}
