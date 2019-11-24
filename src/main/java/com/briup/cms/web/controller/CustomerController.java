package com.briup.cms.web.controller;

import com.briup.cms.bean.Customer;
import com.briup.cms.service.ICustomerService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@Api(description = "客户相关接口")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    private  Customer customer;
    @GetMapping("/queryById")
    @ApiOperation("根据用户id查询")
    @ApiImplicitParam(name = "id",value = "客户id",paramType = "query",dataType = "int",required = true)
    public Customer queryById(int id) {
        return  customerService.findById(id);

    }

    @PostMapping("/queryH")
    @ApiOperation("测试2个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "客户id",required = true,paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "name",value = "客户名字",required = true,paramType = "query",dataType = "String")
    })
    public String queryH() {
        return "c";
    }
    @GetMapping("/queryQ")
    @ApiOperation("测试参数为对象")
    public  Customer queryQ(Customer customer) {
        return customer;

    }
    @GetMapping("/queryL")
    @ApiOperation("测试自定义响应结构")
    public Message queryL() {
        return new Message<>(200,"success",customer,new Date().getTime());

    }
    @GetMapping("/queryL")
    @ApiOperation("测试自定义响应结构")
    public Message<Customer> queryL(Customer customer) {
        return MessageUtil.success(customer);
    }
}
