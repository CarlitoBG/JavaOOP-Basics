package p02_vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Vehicle car = getCar(reader);
        Vehicle truck = getTruck(reader);
        Vehicle bus = getBus(reader);

        int numberOfCommands = Integer.parseInt(reader.readLine());
        while (numberOfCommands-- > 0){
            String[] commandTokens = reader.readLine().split("\\s+");
            String command = commandTokens[0];
            String vehicleType = commandTokens[1];
            double value = Double.parseDouble(commandTokens[2]);

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            try {
                switch (command){
                    case "Drive":
                        if ("Car".equals(vehicleType)){
                            car.drive(value);
                        }else if ("Truck".equals(vehicleType)){
                            truck.drive(value);
                        }else if ("Bus".equals(vehicleType)){
                            bus.driveWithConditioner(value);
                        }
                        System.out.printf("%s travelled %s km%n", vehicleType, decimalFormat.format(value));
                        break;
                    case "DriveEmpty":
                        bus.drive(value);
                        System.out.printf("%s travelled %s km%n", vehicleType, decimalFormat.format(value));
                        break;
                    case "Refuel":
                        if ("Car".equals(vehicleType)){
                            car.refuel(value);
                        }else if ("Truck".equals(vehicleType)){
                            truck.refuel(value);
                        }else if ("Bus".equals(vehicleType)){
                            bus.refuel(value);
                        }
                        break;
                }
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static Vehicle getCar(BufferedReader reader) throws IOException {
        String[] carInfo = reader.readLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carLitersPerKm = Double.parseDouble(carInfo[2]);
        double carTankCapacity = Double.parseDouble(carInfo[3]);
        return new Car(carFuelQuantity, carLitersPerKm, carTankCapacity);
    }

    private static Vehicle getTruck(BufferedReader reader) throws IOException {
        String[] truckInfo = reader.readLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckLitersPerKm = Double.parseDouble(truckInfo[2]);
        double truckTankCapacity = Double.parseDouble(truckInfo[3]);
        return new Truck(truckFuelQuantity, truckLitersPerKm, truckTankCapacity);
    }

    private static Vehicle getBus(BufferedReader reader) throws IOException {
        String[] busInfo = reader.readLine().split("\\s+");
        double busFuelQuantity = Double.parseDouble(busInfo[1]);
        double busLitersPerKm = Double.parseDouble(busInfo[2]);
        double busTankCapacity = Double.parseDouble(busInfo[3]);
        return new Bus(busFuelQuantity, busLitersPerKm, busTankCapacity);
    }
}