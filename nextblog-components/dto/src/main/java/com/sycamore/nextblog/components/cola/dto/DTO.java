package com.sycamore.nextblog.components.cola.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * Data Transfer object, including Command, Query and Response,
 * <p>
 * Command and Query is CQRS concept.
 * @author 桑运昌
 */
public abstract class DTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}