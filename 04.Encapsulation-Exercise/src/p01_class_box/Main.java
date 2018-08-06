package p01_class_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double inputLength = Double.parseDouble(reader.readLine());
        double inputWidth = Double.parseDouble(reader.readLine());
        double inputHeight = Double.parseDouble(reader.readLine());

        Box box = new Box(inputLength, inputWidth, inputHeight);

        double surfaceArea = box.calcSurfaceArea();
        double lateralSurfaceArea = box.calcLateralSurfaceArea();
        double volume = box.volume();

        System.out.println(
                String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n",
                surfaceArea, lateralSurfaceArea, volume));
    }
}