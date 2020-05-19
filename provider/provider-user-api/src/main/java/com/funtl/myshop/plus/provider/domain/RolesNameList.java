package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class RolesNameList implements Serializable {
    /**
     * 角色id
     */
    private Long rolesAuto;
    /**
     * 角色名
     */
    private String roleName;
}
