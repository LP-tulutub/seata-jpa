package com.lp.service;

import com.lp.feign.Table2Feign;
import com.lp.feign.Table3Feign;
import com.lp.pojo.Table2;
import com.lp.pojo.Table3;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TableService {

    @Resource
    private Table2Feign table2Feign;
    @Resource
    private Table3Feign table3Feign;

    /**
     * 正常插入
     * @param table2
     * @param table3
     * @return
     */
    public int insByRight(Table2 table2, Table3 table3){
        this.table2Feign.ins(table2);
        this.table3Feign.ins(table3);
        return 0;
    }

    /**
     * table2能插入，table3不能插入
     * @param table2
     * @param table3
     * @return
     */
    public int insByError(Table2 table2, Table3 table3){
        this.table2Feign.ins(table2);
        if (table3!=null){
            throw new RuntimeException();
        }
        this.table3Feign.ins(table3);
        return 0;
    }

    /**
     * 全局回滚正常插入
     * @param table2
     * @param table3
     * @return
     */
    @GlobalTransactional
    public int insByGTRight(Table2 table2, Table3 table3){
        this.table2Feign.ins(table2);
        this.table3Feign.ins(table3);
        return 0;
    }

    /**
     * 全局回滚都没有插入
     * @param table2
     * @param table3
     * @return
     */
    @GlobalTransactional
    public int insByGTError(Table2 table2, Table3 table3){
        this.table2Feign.ins(table2);
        if (table3!=null){
            throw new RuntimeException();
        }
        this.table3Feign.ins(table3);
        return 0;
    }


}
