package com.zero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  static  final int FEE = 30;

    public static void main(String[] args) {
        final int ENTERING = 1;
        final int LEFTING =2;
        final int STATUS= 3;
        int func = 0;
        String data = "AAAAAA,15121321,0";
        String[] ss = data.split(",");
        System.out.println(ss[0]);
        System.out.println(ss[1]);
        System.out.println(ss[2]);
        Car c = new Car(ss[0]);
        c.enterTime = Long.parseLong(ss[1]);


        List<Car> carlist= new ArrayList<>();
        while (func != 4) {
            System.out.println("1) Car entering");
            System.out.println("2) Car lefting");
            System.out.println("3) Status");
            System.out.println("4) Exit");
            System.out.println("Please enter the number to run the function");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            func = Integer.parseInt(s);

            switch (func) {
                case ENTERING:
                    System.out.println("Please enter the car id.");
                    Car carEnter = new Car(scanner.nextLine());
                    carlist.add(carEnter);
                    carEnter.enter();
                    break;

                case LEFTING:
                    System.out.println("Please enter the car id.");
                    Car carLeft = new Car(scanner.nextLine());
                    carLeft.left();
                    for ( Car cccc: carlist) {
                        if (carLeft.id.equals(cccc.id)){
                            long duration = carLeft.leaveTime-carLeft.enterTime;
                            long money = duration*FEE;
                            carlist.remove(carLeft);
                            System.out.println("Car ID :" + carLeft.id+" enter time: "+ carLeft.enterTime+" left time: "+carLeft.leaveTime);
                            System.out.println("fee : " + money);
                        }
                    }
                    break;

                case STATUS:
                    for ( Car car: carlist) {
                        System.out.println("Car ID :" + car.id+" enter time: "+ car.enterTime+" left time: "+car.leaveTime);
                    }
                    break;
            }
        }
    }
}
