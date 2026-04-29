import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, String> symbolTable = new HashMap<>();
    static boolean insideIf = false;

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

                try {
                    // Number type: সংখ্যা x = 10;
                    if (line.startsWith("সংখ্যা")) {
                        String code = line.replaceFirst("সংখ্যা", "").replace(";", "").trim();

                        if (!code.contains("=")) {
                            System.out.println("Syntax Error at line " + lineNumber + ": Missing =");
                            continue;
                        }

                        String[] parts = code.split("=", 2);
                        String variableName = parts[0].trim();
                        String value = parts[1].trim();

                        if (!isNumberExpression(value)) {
                            System.out.println("Type Error at line " + lineNumber + ": সংখ্যা must contain number/arithmetic value");
                            continue;
                        }

                        symbolTable.put(variableName, "number");
                        writer.write(variableName + " = " + value);
                        writer.newLine();
                    }

                    // Text type: লেখা name = "Shahed";
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

                    // IF condition: যদি x > 5 তাহলে
                    else if (line.startsWith("যদি")) {
                        String condition = line.replaceFirst("যদি", "")
                                .replace("তাহলে", "")
                                .trim();

                        writer.write("if " + condition + ":");
                        writer.newLine();
                        insideIf = true;
                    }

                    // Print: দেখাও x;
                    else if (line.startsWith("দেখাও")) {
                        String value = line.replaceFirst("দেখাও", "").replace(";", "").trim();

                        if (insideIf) {
                            writer.write("    print(" + value + ")");
                        } else {
                            writer.write("print(" + value + ")");
                        }

                        writer.newLine();
                    }

                    // End IF block
                    else if (line.startsWith("শেষ")) {
                        insideIf = false;
                    }

                    // Syntax error recovery
                    else {
                        System.out.println("Syntax Error at line " + lineNumber + ": " + line);
                        continue;
                    }

                } catch (Exception error) {
                    System.out.println("Error at line " + lineNumber + ": " + error.getMessage());
                    continue;
                }
            }

            reader.close();
            writer.close();

            System.out.println("Compilation successful!");

        } catch (Exception e) {
            System.out.println("Compiler Error: " + e.getMessage());
        }
    }

    // Allows numbers, variables, and arithmetic operators
    public static boolean isNumberExpression(String value) {
        return value.matches("[0-9a-zA-Z_\\s+\\-*/()]+");
    }
}