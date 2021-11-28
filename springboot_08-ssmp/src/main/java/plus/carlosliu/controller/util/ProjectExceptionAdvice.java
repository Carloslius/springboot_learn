package plus.carlosliu.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doOtherException(Exception ex){
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员 ,ex 对象发送给开发人员
        ex.printStackTrace();
        return new R(false, "系统错误，请稍后再试！");
    }
}
