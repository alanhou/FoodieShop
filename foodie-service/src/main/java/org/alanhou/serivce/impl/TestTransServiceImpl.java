package org.alanhou.serivce.impl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.alanhou.pojo.Stu;
import org.alanhou.serivce.StuService;
import org.alanhou.serivce.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    /**
     * 事务传播 - Propagation
     *      REQUIRED:
     *      SUPPORTS:
     *      MANDATORY:
     *      REQUIRES_NEW:
     *      NOT_SUPPORTED:
     *      NEVER:
     *      NESTED:
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans(){
        stuService.saveParent();

        try {
            // save point
            stuService.saveChildren();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
