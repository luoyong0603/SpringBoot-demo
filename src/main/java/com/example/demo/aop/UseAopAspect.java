package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 作用是把当前类标识为一个切面供容器读取
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/24 15:32
 */
@Aspect
@Component
public class UseAopAspect {


    /*针对所有控制器的方法添加aop
     * 1,* com.nl.demo.controllers.*.*(..))解析
     * 2，第一个*是返回任意类型
     * 3，com.nl.demo.controllers是包路径，针对所有的控制器
     * 4，第二个*是任意类
     * 5，第三个*是任意方法
     * 6，(..)的任意参数
     * */
    /* @Pointcut("execution (* com.nl.demo.controllers.*.*(..))")*/
    /*针对特定控制器，AopTestController的特定方法，*/
//    @Pointcut("execution (* com.example.demo.controller.UserController.getUserList2(..))")
//    public void test() {
//
//    }

    /**
     * 定义切点 @Pointcut ;在注解的位置切入代码
     *
     * @annotation 表示标注了某个注解的所有方法
     *
     */
    @Pointcut("@annotation( com.example.demo.annotation.UseAop)")
    public void printWord() {

    }


    /**
     * 标识一个前置增强方法，相当于BeforeAdvice的功能
     */
    @Before("printWord()")
    public void beforeAdvice() {
        System.out.println("---执行3：@Before---");
    }

    /**
     * final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("printWord()")
    public void afterAdvice() {
        System.out.println("---执行4：@After---");
    }

    /**
     * 在目标方法成功执行之后调用通知
     */
    @AfterReturning("printWord()")
    public void afterReturningAdvice() {
        System.out.println("---执行5：@AfterReturning---");
    }

    /**
     * 在目标方法抛出异常后调用通知。
     */
    @AfterThrowing("printWord()")
    public void afterAdviceThrowingAdvice() {
        System.out.println("---执行6：@AfterThrowing---");
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("printWord()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("---执行1：@Around---");
        try {
            Object result = proceedingJoinPoint.proceed();
            //注意，如果不return 则接口无返回值！
            return result;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("---执行2：@Around:异常报错---");
        return new Object();
    }


}
