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


---

## Requirement 2: Arithmetic Operations with Precedence

### Objective
To support arithmetic expressions with correct operator precedence.

---

### Supported Operators

+ → addition  
- → subtraction  
* → multiplication  
/ → division  

---

### Example

Input (BanglaCode):

সংখ্যা x = 10;
সংখ্যা y = 20;
সংখ্যা total = x + y * 2;

Output (Python):

total = x + y * 2

---

### Operator Precedence

Multiplication (*) has higher priority than addition (+)

Example:

x + y * 2 = 10 + (20 * 2) = 50

---

### How It Works

The compiler does NOT evaluate expressions.

It directly sends the expression to Python.

Python handles precedence automatically.

---

### Code Logic

The regex was updated to allow:

numbers, variables, operators, brackets

Pattern used:

[0-9a-zA-Z_\\s+\\-*/()]+

---
### Print Statement Support

The compiler supports the print statement using the keyword:

দেখাও

Example:

দেখাও total;

Converted to:

print(total)


### Viva Questions & Answers

Q: Does your compiler evaluate expressions?  
A: No, it forwards the expression to Python which evaluates it.

Q: How is precedence handled?  
A: Python automatically follows correct operator precedence.

Q: Why use regex here?  
A: To allow valid arithmetic expressions.

---

---

## Requirement 3: Assignment Statements

### Objective
To support assignment statements where values are stored inside variables.

---

### Example

BanglaCode:

সংখ্যা x = 10;
লেখা name = "Shahed";

Python output:

x = 10
name = "Shahed"

---

### How Assignment Works

The compiler reads a line and checks for the assignment operator:

=

Then it splits the statement into two parts:

1. Variable name
2. Assigned value

Example:

সংখ্যা x = 10;

Variable name: x  
Value: 10  

---

### Code Logic

The compiler uses:

split("=", 2)

This separates the left side and right side of the assignment.

---

### Viva Questions & Answers

Q: What is an assignment statement?  
A: It stores a value inside a variable.

Q: Which symbol is used for assignment?  
A: The equal sign (=).

Q: How does your compiler process assignment?  
A: It splits the statement using =, then stores the variable name and value.

---

---

## Requirement 4: IF Condition

### Objective
To support conditional execution using IF statements.

---

### Syntax

যদি condition তাহলে  
statements  
শেষ  

---

### Example

যদি total > 30 তাহলে  
দেখাও total;  
শেষ  

---

### Python Output

if total > 30:
    print(total)

---

### How It Works

- The compiler detects "যদি"
- Extracts condition
- Converts it to Python "if"
- Adds ":" at the end
- Uses indentation for inside block

---

### Key Concept

Python uses indentation instead of {}  
So spaces are added for nested statements.

---

### Viva Questions & Answers

Q: How does your IF work?  
A: It converts Bangla condition into Python if statement.

Q: Why indentation is needed?  
A: Python uses indentation to define blocks.

Q: What does "শেষ" do?  
A: It ends the IF block.

---

---

## Requirement 5: Syntax Error Handling

### Objective
To detect errors in source code and prevent incorrect execution.

---

### Types of Errors Handled

1. Missing semicolon  
2. Unknown statement  
3. Type mismatch  
4. Undefined variable  

---

### Example Errors

Missing semicolon:

সংখ্যা x = 10

Output:

Syntax Error at line 1: Missing semicolon

---

Undefined variable:

দেখাও z;

Output:

Error: Variable not defined

---

### How It Works

- Each line is checked before processing  
- If error found, message is printed  
- Compiler continues to next line  

---

### Key Concept

Compiler should not crash on errors  
It should recover and continue execution  

---

### Viva Questions & Answers

Q: What is syntax error?  
A: A mistake in program structure or format.

Q: How does your compiler handle errors?  
A: It prints error message and continues execution.

Q: Why continue after error?  
A: To detect multiple errors in one run.

---

---

## Requirement 6: Code Generation

### Objective
To generate executable target code from Bangla source program.

---

### Output Language

Python was used as the target language.

---

### Output File

output/output.py

---

### Example

BanglaCode:

সংখ্যা x = 10;
দেখাও x;

Generated Python:

x = 10
print(x)

---

### How It Works

- Compiler reads Bangla code
- Converts each statement
- Writes equivalent Python code
- Saves into output file

---

### Why Python?

- Simple syntax
- Easy to generate code
- Automatically handles expressions

---

### Key Concept

Compiler translates source code into another language.

---

### Viva Questions & Answers

Q: What is code generation?  
A: It is the process of converting source code into another executable form.

Q: What is your target language?  
A: Python.

Q: Why Python?  
A: It is simple and handles expressions automatically.

---