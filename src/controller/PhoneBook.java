package controller;

import model.Contact;
import storage.IPhone;
import storage.Phone;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PhoneBook extends Phone implements IPhone {
   private List<Contact> phoneBook;
   Scanner scanner = new Scanner(System.in);

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    @Override
    public void display() {
        phoneBook = ReadWriteFile.readFile();
        System.out.println(phoneBook);
    }

    @Override
    public void insertPhone() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        for (Contact contacts : phoneBook){
            if (contacts.getName().equals(name)){
                contacts.setPhoneNumber(phone);
                System.out.println("updated");
                ReadWriteFile.writeFile(phoneBook);
                return;
            }
        }
        phoneBook.add(new Contact(name,phone));
        System.out.println("Has added success");
        ReadWriteFile.writeFile(phoneBook);
    }

    @Override
    public void removePhone() {
        phoneBook = ReadWriteFile.readFile();
        System.out.println("Enter name need remove: ");
        String name = scanner.nextLine();
        for (int i=0;i<phoneBook.size();++i){
            if (phoneBook.get(i).getName().equals(name)){
                phoneBook.remove(phoneBook.get(i));
                ReadWriteFile.writeFile(phoneBook);
                System.out.println("Contact called " + name + " has successfully deleted");
                return;
            }
        }
        System.out.println("Not found contact " + name);
    }

    @Override
    public void updatePhone() {
        phoneBook = ReadWriteFile.readFile();
        System.out.println("Enter name need update: ");
        String name = scanner.nextLine();
        for (int i=0;i<phoneBook.size();++i){
            if (phoneBook.get(i).getName().equals(name)){
                System.out.println("Enter new phone numbers: ");
                String newPhone = scanner.nextLine();
                phoneBook.get(i).setPhoneNumber(newPhone);
                ReadWriteFile.writeFile(phoneBook);
                System.out.println("Updated successful phone number");
                return;
            }
        }
        System.out.println("Not found contact " + name);
    }

    @Override
    public void searchPhone() {
        phoneBook = ReadWriteFile.readFile();
        System.out.println("Enter name need search: ");
        String name = scanner.nextLine();
        for (Contact contact : phoneBook) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Can't find contact is " + name );
    }

    @Override
    public void sort() {
        phoneBook = ReadWriteFile.readFile();
        phoneBook.sort(Comparator.comparing(Contact::getName));
        ReadWriteFile.writeFile(phoneBook);
    }
}

