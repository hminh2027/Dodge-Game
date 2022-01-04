package IO;


import java.io.*;
import java.util.Properties;

public class FileIO {
    FileWriter file;

    public Properties readProps() throws IOException {
        BufferedReader br = null;
        Properties p = new Properties();
        try {
            br = new BufferedReader(new FileReader(new File("resources/config/config.properties")));
            p.load(br);
        } finally {
            br.close();
        }
        return p;
    }

    public void writeFile(int score) {
        try {
            file = new FileWriter("Java-output.txt");
            file.write("Your last score: " + score);
            file.close();
        } catch (IOException e) {
            System.out.println("Failed to create and write file!");
        }
    }
}
