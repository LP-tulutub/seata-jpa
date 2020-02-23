package com.lp.feign;

import com.lp.pojo.Table3;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "table3-consumer")
public interface Table3Feign {

    @RequestMapping("/table3/ins")
    int ins(@RequestBody Table3 table3);

}
