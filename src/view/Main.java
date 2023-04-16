package view;

import controller.PhoneBook;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true){
            System.out.println("""
                 ==================================
                |   Phone book management program  |
                |==================================|
                | 1, Add new numbers(insertPhone). |
                | 2, Display list contact.         |
                | 3, Find the number by name.      |
                | 4, Sort by name.                 |
                | 5, Update numbers.               |
                | 6, Delete the number by name.    |
                | 0,           EXIT                |
                 ==================================
                      Your choice 0 -> 6
                """);
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> phoneBook.insertPhone();
                case "2" -> phoneBook.display();
                case "3" -> phoneBook.searchPhone();
                case "4" -> phoneBook.sort();
                case "5" -> phoneBook.updatePhone();
                case "6" -> phoneBook.removePhone();
                case "0" -> {
                    return;
                }
            }
        }
    }
}
