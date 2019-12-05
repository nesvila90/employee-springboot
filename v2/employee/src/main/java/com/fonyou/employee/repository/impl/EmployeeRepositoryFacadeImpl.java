package com.fonyou.employee.repository.impl;

import com.fonyou.employee.commons.enums.ErrorCode;
import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.builder.ExceptionBuilder;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.domain.model.entity.Employee;
import com.fonyou.employee.repository.EmployeeRepository;
import com.fonyou.employee.repository.EmployeeRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * The type Employee repository facade.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
@Component
class EmployeeRepositoryFacadeImpl implements EmployeeRepositoryFacade {

    private final EmployeeRepository employeeRepository;

    /**
     * Instantiates a new Employee repository facade.
     *
     * @param employeeRepository the employee repository
     */
    @Autowired
    public EmployeeRepositoryFacadeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findEmployeeById(Long id) throws GeneralException {
        try {
            return employeeRepository.findById(id)
                    .orElseThrow(() -> ExceptionBuilder.newBuilder()
                            .withCode(ErrorCode.BUSINESS_EXCEPTION)
                            .withMessage("not founded employee")
                            .buildBusinessException());
        } catch (Exception e) {
            throw ExceptionBuilder.newBuilder()
                    .withRootException(e)
                    .withCode(ErrorCode.PERSISTENCE_EXCEPTION)
                    .withMessage("Error get all Employees")
                    .buildGeneralException();
        }

    }

    @Override
    public List<Employee> findAll() throws GeneralException {
        try {
            return Optional.ofNullable(employeeRepository.findAll()).orElseThrow(() -> ExceptionBuilder.newBuilder()
                    .withCode(ErrorCode.NOT_FOUND_ENTITY_EXCEPTION)
                    .withMessage("Employees not found")
                    .buildDataNotFoundedException());
        } catch (Exception e) {
            throw ExceptionBuilder.newBuilder()
                    .withRootException(e)
                    .withCode(ErrorCode.PERSISTENCE_EXCEPTION)
                    .withMessage("Error get all Employees")
                    .buildGeneralException();
        }

    }

    @Override
    public void registreEmployee(Employee employee) throws DataCorruptedException {
        try {
            employeeRepository.saveAndFlush(employee);
        } catch (Exception e) {
            throw ExceptionBuilder.newBuilder()
                    .withRootException(e)
                    .withCode(ErrorCode.PERSISTENCE_EXCEPTION)
                    .withMessage("Error registry Employee")
                    .buildDataCorruptedException();
        }

    }

    @Override
    public Employee updateEmployee(Employee employee) throws DataNotFoundedException, GeneralException {
        Employee employeeFonded = employeeRepository.findById(employee.getId()).orElseThrow(() -> ExceptionBuilder.newBuilder()
                .withCode(ErrorCode.NOT_FOUND_ENTITY_EXCEPTION)
                .withMessage("Employee not Found.").buildDataNotFoundedException());
        employeeFonded.setNames(employee.getNames());
        employeeFonded.setLastNames(employee.getLastNames());
        employeeFonded.setBirthDate(employee.getBirthDate());
        employeeFonded.setSalary(employee.getSalary());
        try {
            employeeRepository.saveAndFlush(employeeFonded);
            return employeeFonded;
        } catch (Exception e) {
            throw ExceptionBuilder.newBuilder()
                    .withRootException(e)
                    .withCode(ErrorCode.PERSISTENCE_EXCEPTION)
                    .withMessage("Error updated Employee")
                    .buildGeneralException();
        }

    }

    @Override
    public void delete(Long id) throws DataCorruptedException {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw ExceptionBuilder.newBuilder()
                    .withRootException(e)
                    .withCode(ErrorCode.PERSISTENCE_EXCEPTION)
                    .withMessage("Error removing Employee")
                    .buildDataCorruptedException();
        }
    }
}
