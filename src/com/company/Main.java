package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Random random = new Random();

    public static void main(String[] args) {
        int task;
        boolean exit = false;
        while (!exit){
            System.out.println("Оберіть номер задачі:");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
            System.out.println("6");
            System.out.println("7");
            System.out.println("8");
            System.out.println("9");
            System.out.println("10");
            System.out.println("11");
            System.out.println("12");
            System.out.println("13");
            System.out.println("14");
            System.out.println("15");
            System.out.println("16");
            System.out.println("17");
            System.out.println("18");
            System.out.println("19");
            System.out.println("20");
            System.out.println("21");
            System.out.println("22");
            System.out.println("23");
            System.out.println("24");
            System.out.println("25");
            System.out.println("Завершити роботу - 666");
            task = scanner.nextInt();
            switch (task){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    task14();
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    task17();
                    break;
                case 18:
                    break;
                case 19:
                    task19();
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    task23();
                    break;
                case 24:
                    break;
                case 25:
                    break;
                case 666:
                    exit = true;
                    break;
                default:
                    System.out.println("Ви ввели неправильний номер завдання!");
                    break;
            }
        }
    }
    private static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    private static void task6(){
        System.out.println("Введіть кількість каменів.");
        int stonesCount = scanner.nextInt();
        int[] stones = new int[stonesCount];
        int bunch1 = 0;
        int bunch2 = 0;
        for (int i = 0; i < stones.length; i++){
            stones[i] = (int) (random()*10000) + 1;
            if(bunch1 <= bunch2){
                bunch1 += stones[i];
            }
            else {
                bunch2 += stones[i];
            }
        }
        if(bunch1/2 > bunch1 || bunch2/2 > bunch1){
            System.out.println("Неможливо розподілити купи.");
        }
        else {
            System.out.println("Купи розподілено.\nКупа 1 -> " + bunch1 + "\nКупа 2 -> " + bunch2);
        }
    }
    private static void task14(){
        System.out.println("Введіть розмір масиву.");
        int size = scanner.nextInt();
        int[] table = new int[size];
        int[] finalTable = new int[size];
        int number;
        for(int i = 0; i < table.length; i++){
            table[i] = (int)(random()*100) + 1;
        }
        System.out.println(Arrays.toString(table));
        for (int i = 0; i < finalTable.length; i++){
            finalTable[i] = table[i];
            for (int j = i; j < table.length; j++){
                if(finalTable[i] < table[j]){
                    finalTable[i] = table[j];
                    break;
                }
            }
            if(finalTable[i] == table[i]){
                finalTable[i] = 0;
            }
        }
        System.out.println(Arrays.toString(finalTable));
    }
    private static void task17(){
        System.out.println("Введіть кількість натуральних чисел.");
        int numCount = scanner.nextInt();
        int[] numbers = new int[numCount];
        int minNum = 2147483647;
        int minNumOfNumbers = 0;
        System.out.println("Елементи послідовності:");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int) (random()*2147483647) + 1;
            System.out.println(numbers[i] + " ");
            if(numbers[i] < minNum){ //Уникаємо одиниці, адже числа нижче неї не є натуральними
                minNum = numbers[i];
                minNumOfNumbers = numbers[i];
            }
        }
        if(minNumOfNumbers != 1){
            minNum = 1;
        }
        else {
            quickSort(numbers, 0, numbers.length - 1);
            for (int number : numbers) {
                if (minNum == number) {
                    minNum++;
                }
            }
        }
        System.out.println("Найменше натуральне число, якого немає в послідовності -> " + minNum);
    }
    private static void task19(){
        int happyTickets = 0;
        String currentTicket;
        int[] tickets = new int[900000];
        int currentNumber;
        int firstThree;
        int lastThree;
        for (int i = 0; i < tickets.length; i++){
            firstThree = 0;
            lastThree = 0;
            tickets[i] = 100000 + i;
            currentTicket = Integer.toString(tickets[i]);
            char[] numbers = currentTicket.toCharArray();
            for (int j = 0; j < numbers.length; j++){
                currentNumber = Character.getNumericValue(numbers[j]);
                if(j < 3){
                    firstThree += currentNumber;
                }
                else {
                    lastThree += currentNumber;
                }
            }
            if(firstThree == lastThree){
                happyTickets++;
            }
        }
        System.out.println("Кількість щасливих квитків -> " + happyTickets);
    }
    private static void task23(){
        int cardsCount = 5;
        int equalCardsBlock1 = 1;
        int equalCardsBlock2 = 1;
        int straightCounter = 1;
        boolean block1End = false;
        int[] cards = new int[cardsCount];
        for(int i = 0; i < cards.length; i++){
            //cards[i] = scanner.nextInt();
            cards[i] = (int) (random()*13) + 1;
        }
        quickSort(cards, 0, cards.length - 1);
        System.out.println(Arrays.toString(cards));
        for(int i = 0; i < cards.length; i++){
            if(i != 4) {
                if(cards[i] + 1 == cards[i + 1]){
                    straightCounter++;
                }
                if(!block1End) {
                    if (cards[i] == cards[i + 1]) {
                        equalCardsBlock1++;
                    }
                    else {
                        block1End = true;
                    }
                }
                else {
                    if(cards[i] == cards[i + 1]){
                        equalCardsBlock2++;
                    }
                }

            }
        }
        if(equalCardsBlock1 == 5){
            System.out.println("Impossible");
        }
        else if(equalCardsBlock1 == 4 || equalCardsBlock2 == 4){
            System.out.println("Four of a Kind");
        }
        else if((equalCardsBlock1 == 3 && equalCardsBlock2 == 2) || (equalCardsBlock1 == 2 && equalCardsBlock2 == 3)){
            System.out.println("Full House");
        }
        else if((equalCardsBlock1 == 3 && equalCardsBlock2 != 2) || (equalCardsBlock1 != 2 && equalCardsBlock2 == 3)){
            System.out.println("Three of a Kind");
        }
        else if(equalCardsBlock1 == 2 && equalCardsBlock2 == 2){
            System.out.println("Two Pairs");
        }
        else if((equalCardsBlock1 == 2 && equalCardsBlock2 != 2 && equalCardsBlock2 != 3) || (equalCardsBlock1 != 2 && equalCardsBlock1 != 3 && equalCardsBlock2 == 2)){
            System.out.println("One Pair");
        }
        else if(straightCounter == 5){
            System.out.println("Straight");
        }
        else {
            System.out.println("Nothing");
        }

    }
}
