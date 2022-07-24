package com.demo.docker;

import java.util.Scanner;

public class WelcomePrompt {
    public static void main(String[] args) {
        System.out.print("Welcome, please enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.println("Hello and welcome " + name);
        System.out.println("See you later " + name);
    }
}
