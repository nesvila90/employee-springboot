package com.fonyou.employee.domain.model.entity.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Entity base.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Version
    private Integer version;
}
