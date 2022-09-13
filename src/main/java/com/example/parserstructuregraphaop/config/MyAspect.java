package com.example.parserstructuregraphaop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {


    @Pointcut("execution(* com.example.parserstructuregraphaop.*.*.*(..))")
    public void pointCut() {
    }


    //@Around("pointCut()")
    public Object aroundchifan(ProceedingJoinPoint pjp) throws Throwable {

//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//
//        for (StackTraceElement stackTraceElement : stackTrace) {
//            String className = stackTraceElement.getClassName();
//            String getMethodName = stackTraceElement.getMethodName();
//            System.out.println(className+"."+getMethodName+"(..)");
//        }

//
//        for (
//                Map.Entry<Thread,StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet())
//        {
//            Thread thread = entry.getKey();
//
//            StackTraceElement[] stackTraceElements = entry.getValue();
//
//            if (thread.equals(Thread.currentThread()))
//            {
//                continue;
//            }
//
//            System.out.println("\n线程： " + thread.getName() + "\n");
//            for (StackTraceElement element : stackTraceElements)
//            {
//                System.out.println("\t" + element + "\n");
//            }
//        }


//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//        Method method = signature.getMethod();
//        String name = method.getName();

        List<StackTraceElement> stackTrace = Arrays.stream(Thread.currentThread().getStackTrace()).filter(
                o -> {
                    String className = o.getClassName();
                    String methodName = o.getMethodName();
                    return className.startsWith("com.example.parserstructuregraphaop") && className.contains("CGLIB$$") && !methodName.equals("invoke");
                }
        ).collect(Collectors.toList());
        Collections.reverse(stackTrace);
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            String methodName = stackTraceElement.getMethodName();
            String methodName2 = split[split.length - 1].replaceAll("\\$\\$EnhancerBySpringCGLIB\\$\\$", "@");
            System.out.print(methodName2 + "." + methodName + " -> ");
        }
        System.out.println();
//        StackTraceElement stackTraceElement = stackTrace[1];
//        StackTraceElement stackTraceElement2 = stackTrace[2];
//        String className = stackTraceElement.getClassName();
//        String getMethodName = stackTraceElement.getMethodName();
//        System.out.println( stackTraceElement2.getMethodName()+"()" + " -> " + getMethodName+"()");
//        System.out.println(2);
        //System.out.println(simpleName+"."+name);
        return pjp.proceed();


    }


}