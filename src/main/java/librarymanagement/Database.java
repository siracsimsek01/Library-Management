package librarymanagement;

import java.io.*;

public class Database {
    public static void saveLibrary(Library library, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static Library loadLibrary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No existing data found, starting with an empty database.");
            return new Library();
        }
    }
}