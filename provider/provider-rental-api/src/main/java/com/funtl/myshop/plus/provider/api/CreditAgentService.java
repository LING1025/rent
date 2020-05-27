package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CreditAgent;
import com.funtl.myshop.plus.provider.dto.SelfAgentListDto;
import com.funtl.myshop.plus.provider.dto.SelfAgentQueryParam;
import com.github.pagehelper.PageInfo;

public interface CreditAgentService{

    /**
     * 根据本人姓名获取代理数据
     * @param selfUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SelfAgentListDto> selectSelf(Long selfUser, Integer pageNum, Integer pageSize);

    /**
     * 根据代理人姓名获取代理数据
     * @param agentUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SelfAgentListDto> selectAgent(Long agentUser, Integer pageNum, Integer pageSize);


    /**
     * 新建代理人设置
     * @param creditAgent
     * @return
     */
    Long insert(CreditAgent creditAgent);

    /**
     * 编辑代理人设置
     * @param creditAgent
     * @return
     */
    Integer update(CreditAgent creditAgent);

    /**
     * 根据主键获取代理人设置数据
     * @param creditAgentAuto
     * @return
     */
    CreditAgent selectById(Long creditAgentAuto);
}
