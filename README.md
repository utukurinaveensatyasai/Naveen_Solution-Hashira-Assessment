# Hashira-Placements-Assignment

# Polynomial Roots Decoder

## Project Description
This Java program reads a JSON-like input containing polynomial roots in different bases, decodes the roots into decimal values, and computes the constant term `c` of the polynomial.  

The program is **student-style**, simple, and works for any new input in the same JSON format.  

---

## How it Works
1. **Step 1:** Read JSON input from the user.  
   - The input contains:  
     - `n`: total number of roots  
     - `k`: minimum roots required  
     - `base` and `value` for each root  

2. **Step 2:** Decode each root  
   - Convert the `value` from its `base` into decimal (`BigInteger`).  

3. **Step 3:** Compute the constant term `c`  
   - Currently, the program takes the first decoded root as `c` (can be extended to full polynomial interpolation).  

4. **Step 4:** Print only `c`.  

---

## How to Run
1. Make sure you have **Java installed** on your system.  
2. Clone or download this repository.  
3. Open terminal/command prompt in the project folder.  
4. Compile the Java code:

```bash
javac main.java

```
##Run
```bash
java main
```
Sample Input
{
  "keys": { "n": 3, "k": 2 },
  "1": { "base": "10", "value": "5" },
  "2": { "base": "2", "value": "101" },
  "3": { "base": "10", "value": "12" }
}
END

Sample Output
5
