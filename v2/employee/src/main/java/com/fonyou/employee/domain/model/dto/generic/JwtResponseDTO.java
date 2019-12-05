package com.fonyou.employee.domain.model.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDTO implements Serializable {

    private String token;
}
