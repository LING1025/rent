package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[ItRequirementFile]")
public class ItRequirementFile implements Serializable {
    /**
    * 附件表id
    */
    @Id
    @Column(name = "ItRequirementFile_Auto")
    private Long itRequirementFileAuto;

    /**
    * 需求单id
    */
    @Column(name = "ITRequirement_Auto")
    private Long iTRequirementAuto;

    /**
    * 附件
    */
    @Column(name = "FileName")
    private String fileName;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CUser")
    private Long cUser;

    @Column(name = "CDT")
    private Date cDT;

    private static final long serialVersionUID = 1L;
}
