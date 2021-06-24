package com.mtr;

import java.util.Scanner;

public class Elevators {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to MyLift");
		System.out.println("Door opened....");
		Elevators elevators = new Elevators();
		elevators.run();
	}

	static int maximumFloor = 15;
	static int minimumFloor = 1;
	static int currentFloor = 1;
	static int destinationFloor = 0;

	public static void upwardDirection() {
		try {
			while (currentFloor <= destinationFloor) {
				System.out.println("Floor : " + currentFloor + " ▲");
				currentFloor++;
				Thread.sleep(2000);
			}
			currentFloor--;
			if(currentFloor==destinationFloor) {
				System.out.println("Reached Destination...");
				System.out.println("Thank you.....");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void downwardDirection() {
		try {
			while (currentFloor >= destinationFloor) {
				System.out.println("Floor : " + currentFloor + " ▼");
				currentFloor--;
				Thread.sleep(2000);
			}
			currentFloor++;
			if(currentFloor==destinationFloor) {
				System.out.println("Reached Destination...");
				System.out.println("Thank you.....");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void run() {
		try {
			System.out.println("Waiting at Floor : " + currentFloor);
			destinationFloor = scan.nextInt();
			System.out.println("User Pressed : " + destinationFloor);
			if (destinationFloor < minimumFloor || destinationFloor > maximumFloor) {
				System.out.println("There is no such floor! Enter again");
				run();
			} 
			else if (destinationFloor == currentFloor) {
				System.out.println("you are entering current floor : " + currentFloor);
				run();
			} else {
				System.out.println("Doors closed...");
				Thread.sleep(2000);
				if (destinationFloor < currentFloor) {
					downwardDirection();
				} 
				else if(destinationFloor > currentFloor) {
					upwardDirection();
				}
			}
			run();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
