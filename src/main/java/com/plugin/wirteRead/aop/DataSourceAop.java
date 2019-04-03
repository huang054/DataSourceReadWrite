package com.plugin.wirteRead.aop;


import com.plugin.wirteRead.bean.DBContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

  /*  @Pointcut("!@annotation(com.plugin.wirteRead.annotation.Master) " +
            "&& (execution(* com.plugin.wirteRead.mapper.*.select*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.get*(..)))")*/
    @Pointcut(" (execution(* com.plugin.wirteRead.mapper.*.select*(..)))"+
              // "|| execution(* com.plugin.wirteRead.mapper.*.get*(..))"+
              "or (!@annotation(com.plugin.wirteRead.annotation.Master))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.plugin.wirteRead.annotation.Master) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.insert*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.add*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.update*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.edit*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.delete*(..)) " +
            "|| execution(* com.plugin.wirteRead.mapper.*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}