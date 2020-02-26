package com.test;

import org.alanhou.service.StuService;
import org.alanhou.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

//    @Test
    public void myTest(){
        testTransService.testPropagationTrans();
    }
}
