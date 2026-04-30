import java.io.*;
import java.util.*;

public class Main {

    // Symbol table stores variable name and data type
    // Example: x -> number, name -> text
    static HashMap<String, String> symbolTable = new HashMap<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("examples/test.bc"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output/output.py"));

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) continue;

                // Data type 1: Number
                // Example: সংখ্যা x = 10;
                if (line.startsWith("সংখ্যা")) {
                    String code = line.replaceFirst("সংখ্যা", "").replace(";", "").trim();

                    if (!code.contains("=")) {
                        System.out.println("Syntax Error at line " + lineNumber + ": Missing =");
                        continue;
                    }

                    String[] parts = code.split("=", 2);
                    String variableName = parts[0].trim();
                    String value = parts[1].trim();

                    if (!value.matches("[0-9a-zA-Z_\\s+\\-*/()]+")) {
                        System.out.println("Type Error at line " + lineNumber + ": সংখ্যা must contain a number");
                        continue;
                    }

                    symbolTable.put(variableName, "number");
                    writer.write(variableName + " = " + value);
                    writer.newLine();
                }

                // Data type 2: Text
                // Example: লেখা name = "Shahed";
                else if (line.startsWith("লেখা")) {
                    String code = line.replaceFirst("লেখা", "").replace(";", "").trim();

                    if (!code.contains("=")) {
                        System.out.println("Syntax Error at line " + lineNumber + ": Missing =");
                        continue;
                    }

                    String[] parts = code.split("=", 2);
                    String variableName = parts[0].trim();
                    String value = parts[1].trim();

                    if (!value.startsWith("\"") || !value.endsWith("\"")) {
                        System.out.println("Type Error at line " + lineNumber + ": লেখা must contain text inside quotes");
                        continue;
                    }

                    symbolTable.put(variableName, "text");
                    writer.write(variableName + " = " + value);
                    writer.newLine();
                }
                // Print statement
// Example: দেখাও x;
else if (line.startsWith("দেখাও")) {
    String value = line.replaceFirst("দেখাও", "").replace(";", "").trim();

    if (!symbolTable.containsKey(value) && !value.matches("[0-9a-zA-Z_\\s+\\-*/()]+")) {
        System.out.println("Error at line " + lineNumber + ": Variable not defined");
        continue;
    }

    writer.write("print(" + value + ")");
    writer.newLine();
}

                else {
                    System.out.println("Syntax Error at line " + lineNumber + ": Unknown statement");
                }
            }

            reader.close();
            writer.close();

            System.out.println("Requirement 1 completed: Two data types with type checking.");

        } catch (Exception e) {
            System.out.println("Compiler Error: " + e.getMessage());
        }
    }
}