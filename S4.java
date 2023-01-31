
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class S4 {
    public static void main(String[] args) {

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String text = "";
        try {
            // FileWriter fileWriter = new FileWriter("bd.sql",true);
            // fileWriter.append("Hello word");
            // fileWriter.flush();
            // fileWriter.close();

            try (FileReader fileReader = new FileReader("bd.sql")) {
                while (fileReader.ready()) {
                    text += (char) fileReader.read();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] str = text.split("\n");
        for (int i = 0; i < str.length; i++) {
            String[] sb = str[i].split(" ");
            family.add(sb[0]);
            name.add(sb[1]);
            soname.add(sb[2]);
            age.add(Integer.valueOf(sb[3]));
            gender.add(sb[4].equals("W") ? true : false);
            index.add(i);
        }

        ArrayList<String> sb = new ArrayList<>(name);
        Collections.sort(sb);
        for (int i = 0; i < sb.size(); i++) {
            int j = name.indexOf(sb.get(i));
            index.set(i, j);
        }

        for (int i = 0; i < index.size(); i++) {
             System.out.printf(name.get(index.get(i)) + " ");
        }

    }
}