package com.briup.cms.service.impl;

import com.briup.cms.bean.Customer;
import com.briup.cms.dao.ICustomerDao;
import com.briup.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;


    @Override
    public Customer findById(int id) {
        return customerDao.queryById(id);
    }
}
