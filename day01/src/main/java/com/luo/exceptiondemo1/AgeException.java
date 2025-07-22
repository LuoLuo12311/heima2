package com.luo.exceptiondemo1;
//做成自定义编译时异常
//第一步先继承Exception
//第二步重写父类异常的构造方法
//第三步，哪里需要用这个异常返回，哪里就throw
//自定义运行时异常继承RuntimeException,编译时不报错，但是运行时异常会自动抛出，导致程序崩溃
public class AgeException extends   Exception {
    public AgeException(String message) {
        super(message);
    }

    public AgeException() {
    }
    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
