**Approach**  
• The NumberPrettifier class is designed to take large numbers and convert them into a format that's easier to read.  
• It uses suffixes like millions (M), billions (B), and trillions (T) for this purpose.   
• If a number is less than a million, it just shows the number without any suffix.

**Assumption**  
•	We're using standard suffixes: M for millions, B for billions, and T for trillions. For now, anything bigger than a trillion is still treated as trillions.  
•	This class keeps the negative sign for negative numbers while applying the same logic as it does for positive numbers.  
•	The numbers are rounded to one decimal place when needed to make them easy to read but still accurate.  
•	We're assuming the numbers are within the range that Java's double type can handle, which covers very large and very small values.  

**Design Decision**  
•	We figure out how big the number is using logarithms, which helps us decide if it’s in the millions, billions, or trillions range.  
•	We cap the exponent at 4, so anything larger than a trillion is treated as a trillion for simplicity.  
•	We use a helper method to assign the correct suffix (M, B, T) based on the number’s magnitude.  
•	There's a method that formats the number, ensuring it's displayed with one decimal place if it’s not a whole number.  

**Clarification**  
•	Our current approach treats anything larger than a trillion as a trillion. If needed, we could expand this to include even larger numbers like quadrillions.  
•	The program keeps running, asking for new numbers to prettify, until the user types 'exit'.  

Example Outputs  
•	For an input of 678, it simply returns 678.  
•	For 1000000, it returns 1M.  
•	For 2800000.87, it returns 2.8M.  
•	For 2123456789, it returns 2.1B.  
•	For -1234567890123456, it returns -1234.6T.  
•	For 10000006700000437, it returns 10000.0T.  

In summary, this class handles both positive and negative numbers well, converting large numbers to the appropriate suffix and showing smaller numbers as they are.
