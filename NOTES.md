# BanglaCode Compiler - Viva Notes

---

## Requirement 1: Two Data Types with Type Checking

### Objective
To implement two data types in the language and ensure correct type assignment.

---

### Data Types

1. সংখ্যা → Number type  
2. লেখা → Text (string) type  

---

### Example

Input (BanglaCode):

সংখ্যা x = 10;
লেখা name = "Shahed";

Output (Python):

x = 10
name = "Shahed"

---

### Symbol Table

The symbol table is used to store variable names and their types.

Example:

x → number  
name → text  

---

### Type Checking

The compiler checks if the assigned value matches the declared type.

Valid:

সংখ্যা x = 10;  
লেখা name = "Shahed";  

Invalid:

সংখ্যা x = "hello";  
লেখা name = 123;  

---

### Error Handling

If type mismatch occurs, the compiler shows:

Type Error at line X

Example:

Type Error at line 1: সংখ্যা must contain a number

---

### How It Works (Code Logic)

1. Read each line from source file  
2. Identify if it starts with সংখ্যা or লেখা  
3. Split variable and value using '='  
4. Check:
   - সংখ্যা → must be numeric  
   - লেখা → must be inside quotes  
5. Store variable in symbol table  
6. Generate equivalent Python code  

---

### Key Functions Used

- startsWith() → identify statement type  
- split("=") → separate variable and value  
- matches() → check numeric pattern  
- HashMap → store symbol table  

---

### Viva Questions & Answers

Q: What is type checking?  
A: It ensures that variables are assigned values of the correct data type.

Q: What is a symbol table?  
A: It is a data structure that stores variable names and their types during compilation.

Q: Why is type checking important?  
A: It prevents errors and ensures correct program execution.

---