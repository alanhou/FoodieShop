package org.alanhou.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {

    public static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * AOP通知
     * 1. 前置通知：在方法调用之前执行
     * 2. 后置通知：在方法正常调用之后执行
     * 3. 环绕通知：在方法调用之前和之后分别执行
     * 4. 异常通知：如果在方法调用过程中发生异常，则通知
     * 5. 最终通知： 在方法调用之后执行
     */

    /**
     * 切面表达式
     *
     * execution 代表所要执行的表达式主体
     * 第一处 * 代表方法返回类型 * 代表所有类型
     * 第二处 包名代表 AOP 监控的类所在的包
     * 第三处 .. 代表该包及其子包下的所有类方法
     * 第四处 * 代表类名，* 表示所有类
     * 第五处 *(..) *表示类中的方法名，(..) 表示方法中的任何参数
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* org.alanhou..service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("====== 开始执行 {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 执行目标 service
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long taketime = end - begin;

        if (taketime > 3000) {
            log.error("====== 执行结束，耗时：{} 毫秒 ======", taketime);
        } else if (taketime > 2000) {
            log.warn("====== 执行结束，耗时：{} 毫秒 ======", taketime);
        } else {
            log.info("====== 执行结束，耗时：{} 毫秒 ======", taketime);
        }

        return result;
    }
}
