package p01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carLitersPerKm = Double.parseDouble(carInfo[2]);
        Vehicle car = new Car(carFuelQuantity, carLitersPerKm);

        String[] truckInfo = reader.readLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckLitersPerKm = Double.parseDouble(truckInfo[2]);
        Vehicle truck = new Truck(truckFuelQuantity, truckLitersPerKm);

        int numberOfCommands = Integer.parseInt(reader.readLine());
        while (numberOfCommands-- > 0){
            String[] commandTokens = reader.readLine().split("\\s+");
            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double value = Double.parseDouble(commandTokens[2]);

            try {
                switch (command){
                    case "Drive":
                        if ("Car".equals(vehicleType)){
                            car.drive(value);
                        }else if ("Truck".equals(vehicleType)){
                            truck.drive(value);
                        }
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        System.out.printf("%s travelled %s km%n", vehicleType, decimalFormat.format(value));
                        break;
                    case "Refuel":
                        if ("Car".equals(vehicleType)){
                            car.refuel(value);
                        }else if ("Truck".equals(vehicleType)){
                            truck.refuel(value);
                        }
                        break;
                }
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}