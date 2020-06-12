package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Performance]")
public class Performance implements Serializable {
    /**
     * 业绩编号
     */
    @Id
    @Column(name = "Performance_Auto")
    private Long performanceAuto;

    /**
     * 业务员编号
     */
    @Column(name = "Sales_Auto")
    private Long salesAuto;

    /**
     * 年
     */
    @Column(name = "P_Year")
    private Integer pYear;

    /**
     * 月
     */
    @Column(name = "P_Month")
    private Integer pMonth;

    /**
     * 目标数量
     */
    @Column(name = "P_Count")
    private Integer p_Count;

    private static final long serialVersionUID = 1L;
}
