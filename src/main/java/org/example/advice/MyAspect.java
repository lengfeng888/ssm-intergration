package org.example.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)//值越小优先级越高，前置通知先执行，后置通知后执行
public class MyAspect {

    /*
    @Before   joinpoint参数 方法信息
    @AfterReturning
    @AfterThrowing
    @After
    @Around peoceedingJoinPoint 方法信息 控制方法执行

    @PointCut("execute(* *..*.*(..)") 修饰符和返回类型 包 类 方法 参数
     */
}
