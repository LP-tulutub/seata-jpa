package com.lp.controller;

import com.lp.dao.Table1Repository;
import com.lp.pojo.Table1;
import com.lp.pojo.Table2;
import com.lp.pojo.Table3;
import com.lp.service.TableService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table1")
public class Table1Controller {

    @Autowired
    private Table1Repository table1Repository;
    @Autowired
    private TableService tableService;

    @Transactional
    @RequestMapping("/ins")
    public int ins(@RequestBody Table1 table1){
        this.table1Repository.save(table1);
        return 0;
    }

    /**
     * 23都插入
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        Table2 table2 = new Table2();
        table2.setName("1");
        table2.setContent("1");
        Table3 table3 = new Table3();
        table3.setName("1");
        table3.setContent("1");
        this.tableService.insByRight(table2, table3);
        return "over1";
    }

    /**
     * 2插入成功，3没有插入
     * @return
     */
    @RequestMapping("/test2")
    public String test2(){
        Table2 table2 = new Table2();
        table2.setName("2");
        table2.setContent("2");
        Table3 table3 = new Table3();
        table3.setName("2");
        table3.setContent("2");
        this.tableService.insByError(table2, table3);
        return "over2";
    }

    /**
     * 23都插入
     * @return
     */
    @RequestMapping("/test3")
    public String test3(){
        Table2 table2 = new Table2();
        table2.setName("3");
        table2.setContent("3");
        Table3 table3 = new Table3();
        table3.setName("3");
        table3.setContent("3");
        this.tableService.insByGTRight(table2, table3);
        return "over3";
    }

    /**
     * 23都没有插入，全局回滚成功
     * @return
     */
    @RequestMapping("/test4")
    public String test4(){
        Table2 table2 = new Table2();
        table2.setName("4");
        table2.setContent("4");
        Table3 table3 = new Table3();
        table3.setName("4");
        table3.setContent("4");
        this.tableService.insByGTError(table2, table3);
        return "over4";
    }

    /**
     * 1插入，23没有插入
     * @return
     */
    @RequestMapping("/test5")
    public String test5(){
        Table1 table1 = new Table1();
        table1.setName("5");
        table1.setContent("5");
        this.table1Repository.save(table1);
        Table2 table2 = new Table2();
        table2.setName("5");
        table2.setContent("5");
        Table3 table3 = new Table3();
        table3.setName("5");
        table3.setContent("5");
        this.tableService.insByGTError(table2, table3);
        return "over3";
    }

    /**
     * 123都没有插入，全局回滚成功
     * @return
     */
    @GlobalTransactional
    @RequestMapping("/test6")
    public String test6(){
        Table1 table1 = new Table1();
        table1.setName("6");
        table1.setContent("6");
        this.table1Repository.save(table1);
        Table2 table2 = new Table2();
        table2.setName("6");
        table2.setContent("6");
        Table3 table3 = new Table3();
        table3.setName("6");
        table3.setContent("6");
        this.tableService.insByGTError(table2, table3);
        return "over3";
    }

}
