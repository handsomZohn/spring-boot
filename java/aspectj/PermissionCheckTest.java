package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

/**
 * Created by zohn on 2018/1/24.
 */
public class PermissionCheckTest {
    public static void main(String[] args) throws Exception {
        new PermissionAspect().before(new JoinPoint() {
            @Override
            public String toShortString() {
                return null;
            }

            @Override
            public String toLongString() {
                return null;
            }

            @Override
            public Object getThis() {
                return null;
            }

            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }

            @Override
            public Signature getSignature() {
                return null;
            }

            @Override
            public SourceLocation getSourceLocation() {
                return null;
            }

            @Override
            public String getKind() {
                return null;
            }

            @Override
            public StaticPart getStaticPart() {
                return null;
            }
        });
    }
}
