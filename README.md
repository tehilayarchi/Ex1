# Ex1 Project  
A project for converting and performing operations on numbers in different formats and bases.

## Objective  
The project provides a set of functions to work with numbers in the `numberPartbbasePart` format, representing numbers in various bases. It converts numbers, checks input validity, compares numbers, and finds the maximum value in an array.

---

## Basic Usage  
### Input and Output Examples

1. **Function `number2Int`**  
   Converts a string in `numberPartbbasePart` format to an integer:
   
   Ex1.number2Int("101b2"); // Output: 5
   
   Ex1.number2Int("10b16"); // Output: 16
   
   Ex1.number2Int("XYZb16"); // Output: -1 (error)
   

3. **Function `isNumber`**  
   Checks if a string is in a valid format:
   
   Ex1.isNumber("101b2"); // Output: true
   
   Ex1.isNumber("123b20"); // Output: false
   

5. **Function `int2Number`**  
   Converts an integer to the `numberPartbbasePart` format:
    
   Ex1.int2Number(5, 2); // Output: "101b2"
   
   Ex1.int2Number(10, 16); // Output: "Ab16"

7. **Function `equals`**  
   Checks if two strings represent the same value:
   
   Ex1.equals("101b2", "5b10"); // Output: true
   
   Ex1.equals("101b2", "10b10"); // Output: false

9. **Function `maxIndex`**  
   Returns the index of the largest string in an array:
   
   String[] arr = {"101b2", "10b10", "20b8"};
   
   Ex1.maxIndex(arr); // Output: 2

---

## Project Structure  
- **Package**: `Ex1Main`  
- **Main Code File**:  
  - `Ex1.java`: Contains the following functions:  
    - `number2Int`: Converts a string in base format to an integer.  
    - `isNumber`: Checks the validity of a string in base format.  
    - `int2Number`: Converts an integer to a base format string.  
    - `equals`: Compares two numbers in base format.  
    - `maxIndex`: Finds the largest value in an array.

---

## Additional Notes  
- The project supports bases between 2 and 16, including bases above 10 represented by letters `A` to `G`.  
- For invalid inputs, functions return default values: `-1` or an empty string.
