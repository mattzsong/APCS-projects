## Complex Number Calculator

Consider the following interface:

public interface number{
public number add(number num);
public number subtract(number num);
public number multiply(number num);
public number divide(number num);
}

Write a program using the above Java interface called number which will be used
by two classes, fraction and complexNumber, and will input two numbers of one
type and an operation and will output the result.

When working with fractions the input for this class will be a numerator and
denominator. Do not allow the user to input a 0 in the denominator. This class
will output the fraction in reduced form and if the fraction has a denominator of
one, it will only print the numerator.

The second class will create a complex number comprised of doubles. The input
will be the real and imaginary portion. When outputting, if either the real or
imaginary portion of the number is zero, do not print that portion of the complex
number. If both are zero print 0. If the imaginary number is negative, print only a
subtraction sign between the two portions of numbers.

You must use inheritance effectively to reduce redundant code.

Extra credit: Allow the complex number to be comprised of fractions and use
your created fraction class to perform the operations with complex numbers.

