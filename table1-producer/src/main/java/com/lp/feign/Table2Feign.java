package com.lp.feign;

import com.lp.pojo.Table2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "table2-consumer")
public interface Table2Feign {

    @RequestMapping("/table2/ins")
    int ins(@RequestBody Table2 table2);

}
