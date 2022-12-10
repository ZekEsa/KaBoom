import model.AudioReader;

import java.io.ByteArrayOutputStream;

public class test {
    public static void main(String[] args) throws InterruptedException {
        AudioReader reader = AudioReader.getMicStream(5000);

        ByteArrayOutputStream raw = reader.getOutputStream();

        Thread.sleep(100);

        while (reader.isRunning()){
            byte[] data = raw.toByteArray();
            raw.reset();

            Thread.sleep(100);

            for (int i = 0; i < data.length; i= i + 500) {
                System.out.print(data[i]+" ");
            }
        }
    }
}
