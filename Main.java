import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            InputStreamReader reader = new InputStreamReader( // Opens reader for reading original CSGO lang file
                    new FileInputStream("csgo_english.txt"), "UTF-16LE");
            BufferedReader bufferedReader = new BufferedReader(reader);

            OutputStreamWriter writer = new OutputStreamWriter( // Opens writer to write into output file
                    new FileOutputStream("csgo_awoo.txt"), "UTF-16LE");
            String line;

            while((line = bufferedReader.readLine()) != null){
                writer.write(Converter.lineParse(line)); // Writes awooified lines into output file
                writer.write("\r\n");
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}