

CREATE DATABASE `fonyou_employee` /*!40100 DEFAULT CHARACTER SET UTF-8*/
CREATE TABLE `person`
(
    `dtype`         varchar(31) NOT NULL,
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `creation_time` datetime(6)    DEFAULT NULL,
    `update_time`   datetime(6)    DEFAULT NULL,
    `version`       int(11)        DEFAULT NULL,
    `birth_date`    varchar(255)   DEFAULT NULL,
    `last_names`    varchar(255)   DEFAULT NULL,
    `names`         varchar(255)   DEFAULT NULL,
    `salary`        decimal(19, 2) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = UTF-8;
        names varchar(255),
        salary decimal(19,2),
        primary key (id)
    ) type=InnoDB";
 


