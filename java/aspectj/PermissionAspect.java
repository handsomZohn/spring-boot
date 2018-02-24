package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by zohn on 2018/1/24.
 */
@Aspect
@Component
public class PermissionAspect {
    @Autowired
    private AuthServiceImpl authService;

    @Pointcut("@annotation(PermissionCheck)")
    public void permissionCheck() {
    }

    @Before(value = "permissionCheck()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException, PermissionCheckException {
        //获取连接点的方法签名对象
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            //throw new PermissionCheckException("user permission check failed,  stop the request");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = joinPoint.getTarget();

        // 获取当前执行的方法
        Method method = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        // 获取方法的注解
        PermissionCheck annotation = method.getAnnotation(PermissionCheck.class);
        System.out.println(annotation);
        System.out.println("执行业务逻辑之前-----");
        authService.checkAccess();
    }

    public void after(JoinPoint joinPoint){
        System.out.println("执行业务逻辑之后-----");
    }
}
