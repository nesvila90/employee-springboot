package com.fonyou.employee.domain.model.dto.request;


import com.fonyou.employee.domain.model.dto.generic.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * <p>
 * The type Employee dto.
 * @since 0.0.1 16/10/2019
 */
@Data
@EqualsAndHashCode(callSuper = true, of = {"id"})
@AllArgsConstructor
public class EmployeeDTORequest extends EmployeeDTO {

}
