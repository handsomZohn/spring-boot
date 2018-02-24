package aspectj;


/**
 * Created by zohn on 2018/1/24.
 */
public class PermissionCheckException extends Exception {

    private String message = "PermissionCheckError";

    public PermissionCheckException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
