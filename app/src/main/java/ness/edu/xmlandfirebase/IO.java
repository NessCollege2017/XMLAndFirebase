package ness.edu.xmlandfirebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Android2017 on 6/2/2017.
 */

class IO {
    public static String read(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder builder = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine())!=null){
                builder.append(line);
            }
        }
        finally {
            reader.close();
        }
        return builder.toString();
    }
}
