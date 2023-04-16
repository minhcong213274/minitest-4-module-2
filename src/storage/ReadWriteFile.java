package storage;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile  {
    public static void writeFile(List<Contact> contacts){
        File file = new File("C02.txt");
        try(OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(outputStream)) {
            objectInputStream.writeObject(contacts);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Contact> readFile(){
        File file = new File("C02.txt");
        List<Contact> contacts = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            contacts = (List<Contact>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
        return contacts;
    }

}
