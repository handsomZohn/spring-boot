package aspectj;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zohn on 2018/1/24.
 */
@ControllerAdvice
public class PermissionAdvice {
    @ExceptionHandler(value = PermissionCheckException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String dealWithPermissionCheckException(PermissionCheckException exception){
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }
    public String dealWithPermissionCheckException(){
        return null;
    }

}
