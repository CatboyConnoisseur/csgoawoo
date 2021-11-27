public class Converter {
    public static String lineParse(String line) {
        int quoteCount = 0;
        String finalLine = "";
        if(line.length() > 0){
            for(int i = 0; i < line.length(); i++){
                char currentChar = line.charAt(i);
                if (quoteCount == 3 && currentChar != '"'){ // Begins awooification
                    if (currentChar == '{') { // Skips content between { and }
                        do {
                            finalLine = finalLine + currentChar;

                            i++;
                            if (i >= line.length()) {
                                break;
                            }
                            currentChar = line.charAt(i);
                        } while (currentChar != '}');
                    }
                    if (currentChar == '<') { // Skips content between < and >
                        do {
                            finalLine = finalLine + currentChar;
                            i++;
                            if (i >= line.length()) {
                                break;
                            }
                            currentChar = line.charAt(i);
                        } while (currentChar != '>');
                    }
                    if (currentChar == 'l' || currentChar == 'r') { // This if statement is what should be changed for making a language.
                        currentChar = 'w';
                    }
                    if (currentChar == 'L' || currentChar == 'R') {
                        currentChar = 'W';
                    }
                }
                if(currentChar == '"'){ quoteCount++; }
                finalLine = finalLine + currentChar;
            }
        }
        return finalLine;
    }
}