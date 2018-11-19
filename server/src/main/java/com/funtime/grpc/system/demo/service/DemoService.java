package com.funtime.grpc.system.demo.service;

import com.funtime.grpc.system.demo.domain.Demo;
import com.funtime.grpc.system.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> getAll() {
        return demoRepository.findAll();
    }
}
