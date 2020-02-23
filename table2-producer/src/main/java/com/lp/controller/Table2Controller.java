package com.lp.controller;

import com.lp.dao.Table2Repository;
import com.lp.pojo.Table2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table2")
public class Table2Controller {

    @Autowired
    private Table2Repository table2Repository;

    @Transactional
    @RequestMapping("/ins")
    public int ins(@RequestBody Table2 table2){

        this.table2Repository.save(table2);

        return 0;
    }




}
