package lession04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLDown {
    public static void main(String[] args) throws IOException {
        // 1. address
        URL url = new URL("http://localhost:8080/custom/doc.txt");

        // 2. connect to resource
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream is = connection.getInputStream();
        FileOutputStream fos = new FileOutputStream("down.txt");

        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        while (len != -1)
        {
            fos.write(buffer, 0, len);
            len = is.read(buffer);
        }

        fos.close();
        is.close();
        connection.disconnect();
    }
}
