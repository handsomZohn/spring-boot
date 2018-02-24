package designPattern.zhuangshizhemoshi.IOZhuangshizhe;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zohn on 2017/12/20.
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public int read(byte[] b, int offset, int len ) throws IOException{
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++){
            b[i] = (byte) Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
