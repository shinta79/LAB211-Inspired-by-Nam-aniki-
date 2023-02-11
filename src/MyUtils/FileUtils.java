package MyUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author giahu
 */
public class FileUtils {

    public ArrayList<String> loadFromText(String path) throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList();

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String str;

        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        fr.close();
        br.close();

        return list;
    }

    public <E> void saveToText(String path, ArrayList<E> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);

        for (E x : list) {
            pw.println(x);
            pw.flush();
        }
        pw.close();
        fw.close();
    }

    public <E> E load(String path) throws IOException, ClassNotFoundException {
        E obj;

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        obj = (E) ois.readObject();

        fis.close();
        ois.close();

        return obj;
    }

    public <E> void save(String path, E obj) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);

        fos.close();
        oos.close();
    }
}
