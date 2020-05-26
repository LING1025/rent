package com.funtl.myshop.plus.provider.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
@Data
public class EmpRoleName implements Serializable {
    private Long rolesAuto;
    private String roleName;
}
