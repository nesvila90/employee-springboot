package com.fonyou.employee.domain.model.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Nestor Villar Lautero
 * @since 0.0.1 16/10/2019
 * @version 0.0.1 16/10/2019
 *
 * The type Employee dto.
 */
@Data
@NoArgsConstructor
public class EmployeeDTOResponse {

    @NotNull
    @ApiModelProperty(value = "Id of employee", example = "1")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Names of employee", example = "NESTOR")
    private String names;

    @NotNull
    @ApiModelProperty(value = "LastNames of employee", example = "VILLAR LAUTERO")
    private String lastNames;

    @NotNull
    @ApiModelProperty(value = "Birthdate of employee", example = "1990-04-06")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private String birthDate;

    @NotNull
    @ApiModelProperty(value = "Salary of employee", example = "4500000.00")
    private BigDecimal salary;
}
