package com.lp.controller;

import com.lp.dao.Table3Repository;
import com.lp.pojo.Table3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table3")
public class Table3Controller {

    @Autowired
    private Table3Repository table3Repository;

    @Transactional
    @RequestMapping("/ins")
    public int ins(@RequestBody Table3 table3){

        this.table3Repository.save(table3);

        return 0;
    }




}
