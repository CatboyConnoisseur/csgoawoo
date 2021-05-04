import java.io.*;

public class CSLangConverter {
    public static void main(String[] args) {
        int quoteCount = 0;
        try {
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream("csgo_english.txt"), "UTF-16LE");
            BufferedReader bufferedReader = new BufferedReader(reader);

            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("csgo_awoo.txt"), "UTF-16LE");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                quoteCount = 0;

                for (int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);
                    //Process char
                    if (quoteCount == 3 && c != '"'){
                        if (c == '{') {
                            do {
                                writer.write(c);
                                i++;
                                if (i >= line.length()) {
                                    break;
                                }
                                c = line.charAt(i);
                            } while (c != '}');
                        }
                        if (c == '<') {
                            do {
                                writer.write(c);
                                i++;
                                if (i >= line.length()) {
                                    break;
                                }
                                c = line.charAt(i);
                            } while (c != '>');
                        }
                        if (c == 'l' || c == 'r') { //this if statement is what should be changed for making a language.
                            c = 'w';
                        }
                        if (c == 'L' || c == 'R') {
                                c = 'W';
                        }
                    }
                    if (c == '"'){
                        quoteCount++;
                    }
                    writer.write(c);
                }
                writer.write("\r\n");
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
