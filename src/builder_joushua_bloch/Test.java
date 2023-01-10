package builder_joushua_bloch;

import java.io.*;




// use try with resources instead of try-finally when writing code
// using closed resources it is preferable and less verbose
public class Test {

    static final int BUFFER_SIZE = 1;
    static void copy(String src, String dest) throws IOException {
//        InputStream in = new FileInputStream(src);
//        try {
//            OutputStream out = new FileOutputStream(dest);
//            try {
//                byte[] buf = new byte[BUFFER_SIZE];
//                int n;
//                while((n = in.read(buf)) >= 0) {
//                    out.write(buf, 0, n);
//                }
//
//            }
//            finally{
//                out.close();
//            }
//
//        }
//        finally {
//            in.close();
//        }

        // same above code using try with resources

        try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dest)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            copy("/home/appinventiv/Desktop/designpattern/src/builder_joushua_bloch/input.txt", "/home/appinventiv/Desktop/designpattern/src/builder_joushua_bloch/output.txt");
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
