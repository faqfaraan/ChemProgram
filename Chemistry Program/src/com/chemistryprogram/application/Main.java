package com.chemistryprogram.application;

import com.chemistryprogram.elements.*;
import com.chemistryprogram.Assessment.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Faraan on 1/11/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws  IOException {


        Elements elementsInstance = new Elements();
        ArrayList<Elements> elements = elementsInstance.getElements();

        System.out.println(elementsInstance.getElements().get(1));

        boolean quit = false;
        printMainMenu();
        while (!quit) {
            System.out.println("Make selection:");
            int selection = 99;
            scanner = new Scanner(System.in);
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please select a number.");
            } catch (Exception g) {
                System.out.println("Exception Error");
            }
            switch (selection) {
                case 0:
                    System.out.println("Ending program");
                    quit = true;
                    break;
                case 1:

                    boolean quit1 = false;
                    while(!quit1) {

                        scanner = new Scanner(System.in);
                        System.out.println("Which element? (Atomic Number)");
                        int elementChoice;
                        try {
                            elementChoice = scanner.nextInt();
                            quit1 = true;
                            boolean quit2 = false;

                            while (!quit2) {
                                try {
                                    if (elementChoice <= elements.size() && elementChoice >= 0) {
                                        elements.get(elementChoice).molesToGrams();
                                        quit2 = true;
                                    } else {
                                        System.out.println("Element does not exist");
                                        quit2 = true;
                                        quit1 = false;
                                    }
                                } catch (InputMismatchException f) {
                                    System.out.println("Invalid input type");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Invalid input type wrong message" + "\n");
                                }
                            }
                        } catch (InputMismatchException f) {
                            System.out.println("Invalid element input type");
                        } catch (Exception f) {
                            System.out.println("Some other type of error");
                        }
                    }
                    break;

                case 2:
//                    Convert grams to moles
                    System.out.println("Which element? (Atomic Number)");
                    int elementChoice2 = scanner.nextInt();
                    elements.get(elementChoice2).gramsToMoles();
                    break;

                case 3:
                    scanner = new Scanner(System.in);
                    System.out.println("Enter file name.");
                    String filename = scanner.nextLine();
                    MultipleChoiceTestAssessment multipleChoiceTestAssessment = new MultipleChoiceTestAssessment(filename + ".txt");

                  printAssessmentMenu();

                        System.out.println("Make selection:");
                        selection = scanner.nextInt();
                        switch (selection) {
                            case 0:
                                multipleChoiceTestAssessment.gradeTest();
                                break;
                            case 1:
                                multipleChoiceTestAssessment.printTest();
                        }
                    break;

                default:
                    System.out.println("Not an option");
                    break;

            }
        }
    }


    public static void printMainMenu() {
        System.out.println("0 - End program");
        System.out.println("1 - Convert moles to grams");
        System.out.println("2 - Convert grams to moles");
        System.out.println("3 - Assessment");
    }

    public static void printAssessmentMenu() {
        System.out.println("0 - Grade Test");
        System.out.println("1 - Print Test");
    }

}