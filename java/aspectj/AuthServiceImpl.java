package aspectj;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zohn on 2018/1/24.
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean checkAccess() {
        return false == false;
    }
}
