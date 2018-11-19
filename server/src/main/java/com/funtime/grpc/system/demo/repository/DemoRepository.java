package com.funtime.grpc.system.demo.repository;

import com.funtime.grpc.system.demo.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Integer> {
}
