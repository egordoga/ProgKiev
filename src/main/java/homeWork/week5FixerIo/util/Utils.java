package homeWork.week5FixerIo.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static byte[] requestToArray(InputStream in) throws IOException {

        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        byte[] buff = new byte[10240];
        int r;

        do {
            if ((r = in.read(buff)) > 0) arr.write(buff, 0, r);
        } while (r != -1);

        return arr.toByteArray();
    }
}
