package com.fonyou.employee.web.rest.api;

import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.commons.exceptions.business.base.BusinessException;
import com.fonyou.employee.domain.model.dto.generic.EmployeeDTO;
import com.fonyou.employee.domain.model.dto.request.EmployeeDTORequest;
import com.fonyou.employee.domain.model.dto.response.EmployeeDTOResponse;
import com.fonyou.employee.domain.model.entity.Employee;
import com.fonyou.employee.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Employee api.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
@RestController
@RequestMapping("api/persona/v1")
@CrossOrigin(origins = "*")
@Api(value = "Employee Management System")
public class EmployeeApiImpl {

    private final EmployeeService employeeService;

    /**
     * Instantiates a new Employee api.
     *
     * @param employeeService the employee service
     */
    @Autowired
    public EmployeeApiImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Register person response entity.
     *
     * @param employee the employee
     * @return the response entity
     * @throws DataCorruptedException the data corrupted exception
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @ApiOperation(value = "Update a Employee avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful registration of the employee in the repository."),
            @ApiResponse(code = 400, message = "The resource that you were trying to registry is already exist.")
    })
    @PostMapping
    public ResponseEntity<Void> registerPerson(
            @ApiParam(value = "Employee object store in database table", required = true)
            @RequestBody EmployeeDTORequest employee) throws DataCorruptedException {
        Employee employeeEntity = mapperEmployeeDTOToEmployeeEntity(employee);
        employeeService.registreEmployee(employeeEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update person response entity.
     *
     * @param employee the employee
     * @return the response entity
     * @throws DataNotFoundedException the data not founded exception
     * @throws GeneralException        the general exception
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @ApiOperation(value = "Update a Employee avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully updated of the employee in the repository."),
            @ApiResponse(code = 404, message = "The resource you were trying to remove is not found")
    })
    @PutMapping
    public ResponseEntity<Void> updatePerson(@RequestBody EmployeeDTORequest employee) throws DataNotFoundedException, GeneralException {
        Employee employeeEntity = mapperEmployeeDTOToEmployeeEntity(employee);
        employeeService.updateEmployee(employeeEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /**
     * Remove person response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws DataCorruptedException the data corrupted exception
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @ApiOperation(value = "Remove a Employee avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully removed of the employee in the repository."),
            @ApiResponse(code = 404, message = "The resource you were trying to remove is not found.")
    })
    @DeleteMapping
    public ResponseEntity<Void> removePerson(@RequestBody Long id) throws DataCorruptedException {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Find person by id response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws BusinessException the business exception
     * @throws GeneralException  the general exception
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @ApiOperation(value = "View a Employee avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found.")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDTOResponse> findPersonById(
            @PathVariable("id") Long id) throws BusinessException, GeneralException {
        return ResponseEntity.ok().body(mapperEmployeeEntityToEmployeeDTO(employeeService.findEmployeeById(id)));
    }


    /**
     * Find all response entity.
     *
     * @return the response entity
     * @throws GeneralException the general exception
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @ApiOperation(value = "View a list of Employee avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of employee."),
            @ApiResponse(code = 404, message = "The resources that you're trying to find. They're were not founded.")
    })
    @GetMapping
    public ResponseEntity<List<EmployeeDTOResponse>> findAll() throws GeneralException {
        return ResponseEntity.ok().body(employeeService.findAll().stream()
                .filter(Objects::nonNull)
                .map(employee -> mapperEmployeeEntityToEmployeeDTO(employee))
                .collect(Collectors.toList()));
    }


    private Employee mapperEmployeeDTOToEmployeeEntity(@RequestBody @ApiParam(value = "Employee object store in database table", required = true) EmployeeDTORequest employee) {
        Employee employeeEntity = new Employee();

        if (!ObjectUtils.isEmpty(employee.getId())) {
            employeeEntity.setId(employee.getId());
        }

        employeeEntity.setNames(employee.getNames());
        employeeEntity.setLastNames(employee.getLastNames());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setBirthDate(employee.getBirthDate());
        return employeeEntity;
    }


    private EmployeeDTOResponse mapperEmployeeEntityToEmployeeDTO(Employee employee) {
        EmployeeDTOResponse employeeEntity = new EmployeeDTOResponse();

        if (!ObjectUtils.isEmpty(employee.getId())) {
            employeeEntity.setId(employee.getId());
        }
        employeeEntity.setNames(employee.getNames());
        employeeEntity.setLastNames(employee.getLastNames());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setBirthDate(employee.getBirthDate());
        return employeeEntity;
    }
}
