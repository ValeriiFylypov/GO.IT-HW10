# GO.IT-HW10

Task 1.
Given a text file file.txt, which contains a list of phone numbers (one line - one phone).

Write a method that will read the file and print all valid phone numbers to the console.

A phone number is considered valid if it matches one of two formats (x is a single digit):

(xxx) xxx-xxxx
xxx-xxx-xxxx
Example:

For a file.txt file with the following content:

987-123-4567
123 456 7890
(123) 456-7890

The method should display the following:

987-123-4567
(123) 456-7890

Task 2.
There is a text file file.txt. You need to read the file, convert it to a list of objects of type User, and write them to a new file user.json.

The file format is as follows:

the first line is the title
each subsequent line is a separate object, each column is separated by a space
Example:

For the file.txt file with the contents:

name age
alice 21
ryan 30

you need to create the following user.json file:

[
    {
        "name": "alice",
        "age":21
    },
    {
        "name": "ryan",
        "age":30
    }
]

Task 3
Write a method to count the frequency of each word in the file words.txt.

Assume that:

words.txt contains only lowercase words separated by a space
Each word contains only lowercase letters
The words are separated by one or more spaces or a line break
Example:

For the file words.txt with the content:

the day is sunny the
the sunny is is

The method should return a result like this:

the 4
is 3
sunny 2
day 1

WARNING.
The output to the console should be sorted by frequency (the most frequent words go first)
