##Program 6: Characters Program
 
Allow the user to input a string.  The program will count the number of characters and words and the number of times each word appears in the string. 
 
For example if the string input is:
 
        	         	And  	he     came 2	school.
 
The output will be:    
17 characters                                   	
5 words
And             	1
He               	1
Came           		1
2                  	1
School         		1
 
Please note that the sentence can have multiple spaces at the beginning, end and in between words.
A word is defined as any string which:
If it does not come at the start or end of the sentence a word will have a space on either side of it. 
If it does come at the beginning or end it will have a space only at the end or beginning of the word respectively.
 
If the input is
The dog and the cat ran and ran.
 
The output would be:
25 characters
8 words
The  	2
Dog 	1
And 	2
Cat   	1
Ran  	2
 
Please note that capital letters for The and the are ignored and punctuation is also ignored.
When writing this program, you may only use the String methods (see Useful String Methods sheet for full method descriptions):
 
charAt(an Index) [returns char]
compareTo(a String) [returns int]
equals (a String) [returns Boolean]
equalsIgnoreCase (a String) [returns boolean]
indexOf(a Character) [returns int]
indexOf(a Character, begin index) [returns int]
indexOf(a Substring) [returns int]
indexOf(a Substring, begin index) [returns int]
length() [returns int]
replace(oldChar, newChar) [returns String]
substring(beginIndex) [returns String]
substring(beginIndex, endIndex) [returns String]
toLowerCase() [returns String]
toUpperCase() [returns String]
trim() [returns String]
 
You must use the substring methods somewhere in your program, but it must be an efficient application.
