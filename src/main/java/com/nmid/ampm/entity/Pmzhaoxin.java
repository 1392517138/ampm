package com.nmid.ampm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aaron
 * @since 2020-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Pmzhaoxin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String phone;


}
