package com.fonyou.employee.commons.exceptions.builder;

import com.fonyou.employee.commons.enums.ErrorCode;
import com.fonyou.employee.commons.exceptions.GeneralException;
import com.fonyou.employee.commons.exceptions.business.DataCorruptedException;
import com.fonyou.employee.commons.exceptions.business.DataNotFoundedException;
import com.fonyou.employee.commons.exceptions.business.base.BusinessException;

/**
 * The type Exception builder.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 *
 */
public class ExceptionBuilder {

    private ErrorCode errorCode;
    private String message;
    private Throwable rootException;

    private ExceptionBuilder() {

    }

    /**
     * New builder exception builder.
     *
     * @return the exception builder
     */
    public static ExceptionBuilder newBuilder() {
        return new ExceptionBuilder();
    }


    /**
     * With code exception builder.
     *
     * @param errorCode the error code
     * @return the exception builder
     */
    public ExceptionBuilder withCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * With message exception builder.
     *
     * @param message the message
     * @return the exception builder
     */
    public ExceptionBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * With root exception exception builder.
     *
     * @param exception the exception
     * @return the exception builder
     */
    public ExceptionBuilder withRootException(Throwable exception) {
        this.rootException = exception;
        return this;
    }

    /**
     * Build business exception business exception.
     *
     * @return the business exception
     */
    public final BusinessException buildBusinessException() {
        return new BusinessException(this.message, this.rootException, this.errorCode);
    }

    /**
     * Build data corrupted exception data corrupted exception.
     *
     * @return the data corrupted exception
     */
    public final DataCorruptedException buildDataCorruptedException() {
        return new DataCorruptedException(this.message, this.rootException, this.errorCode);
    }


    /**
     * Build data not founded exception data not founded exception.
     *
     * @return the data not founded exception
     */
    public final DataNotFoundedException buildDataNotFoundedException() {
        return new DataNotFoundedException(this.message, this.rootException, this.errorCode);
    }


    /**
     * Build general exception general exception.
     *
     * @return the general exception
     */
    public final GeneralException buildGeneralException() {
        return new GeneralException(this.message, this.rootException, this.errorCode);
    }

}
