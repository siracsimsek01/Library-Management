package librarymanagement;

import java.io.*;
public class Database {
    public static void saveLibrary(Library library, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(library);
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public static Library loadLibrary(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Library();
        }
    }
}

