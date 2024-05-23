This program finds the determinant of any square matrix.
The matrix needs to formated with each rows on a different row. It can have a arbitrary ammount of spaces of between its values.
It can handle negatives and improparly formated matrices. In the second it provides a error message.
Example matrices:

1
1

1
1 2

2
-3 -4
11 1

4
12.2 0.5 11.0 3.1
 4.0 63.5 12.8 0.1
 0.0 1.2 -0.7 16.0
 6.31 9.85 1.15 0.86


Assignment A
Objective:
Design a program that calculates the determinant of a square matrix.
Design Specification:
The matrix is represented as a two-dimensional array of floating-point numbers. 
The matrix is read from a text file with the following structure:
- First line contains a single integer value which represents the dimension of the matrix N
- Thew N following lines contain N floating-point values which represent the sequential rows of 
the matrix. Values are separated by one or more blanks
Example:
4
12.2 0.5 11.0 3.1
 4.0 63.5 12.8 0.1
 0.0 1.2 -0.7 16.0
 6.31 9.85 1.15 0.86
1 / 3
Remarks:
- The program should terminate on invalid input;
- Code documentation will be considered a plus.
