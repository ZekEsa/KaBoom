
import model.AudioReader;
import processing.core.PApplet;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class WavePlotter extends PApplet {
    Plot plt;
    int time = 0;
    AudioReader reader;
    ByteArrayOutputStream out;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        reader = AudioReader.getMicStream(5000);
        out = reader.getOutputStream();
        plt = new TimeSeriesPlot(0, 0, 800, 800, 200);

        plt.set(Plot.Setting.show_axes, true);
        plt.set(Plot.Setting.show_border, true);

    }

    public void draw() {
        background(255);
        // TODO: use AudioReader to get an audio stream
        // TODO: plot raw data

        byte[] raw = out.toByteArray();
        out.reset();
        
        for (int i = 0; i < raw.length; i++) {
            plt.plot(0, time, raw[i]).strokeColor("blue").style("-");
            time++;
        }


        plt.draw(this);
    }

    public static void main(String[] args) {
        PApplet.main("WavePlotter");
    }
}
