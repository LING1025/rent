package com.funtl.myshop.plus.provider.domain;

import com.funtl.myshop.plus.provider.dto.PCountMoneyLast;
import com.funtl.myshop.plus.provider.dto.PCountMoneys;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class YearMonthList implements Serializable {
    private List<PCountMoneys> thisMonth;
    private List<PCountMoneyLast> lastMonth;
}
