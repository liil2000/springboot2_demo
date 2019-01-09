package com.example.service;

import com.example.dao.StuRepository;
import com.example.pojo.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class StuService {

    @Autowired
    private StuRepository stuRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createStu() {
        Stu stu = Stu.builder().age(100).address("1111").name("周星星").build();
        Stu save = stuRepository.save(stu);
        log.info(save.toString());

        int a = 1/0;

        stu = Stu.builder().age(200).address("2222").name("周星星2").build();
        Stu save1 = stuRepository.save(stu);
        log.info(save1.toString());
    }
}