package concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in) , "printThread");
        printThread.start();
        int rec = 0;
        while ( (rec =System.in.read() )!= -1){
            out.write(rec);
        }
    }


    static class Print implements Runnable{
        PipedReader in ;

        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int rec = 0;
            while (true){
                try {
                    if (!((rec = in.read() )!= -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println((char) rec);
            }
        }
    }

}
