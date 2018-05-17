# if test, for loop, list, dictionary, functions, classes

# do not need to declare type for variables
age = 17
name = "Fiona"

# LIST:
# list = [], starts at 0, use .append to add to the list
grades = []
grades = ["B", "C"]
grades.append("A")
grades.append("B")

# the two methods are the same
print(grades[0])
print(grades[1])

print(grades)

# ** is power (three to the power of 2)
print( 3 ** 2)

# you can multiply strings and numbers
print("Hello " * 5)
print([1,2,3] * 3)

# you can add lists
even = [2,4,6]
odd = [1,3,5]
numbers = even + odd
print(numbers)

# formatting for strings and objects, %s is for strings, %d is for integers, %f is for floating point numbers
# Prints out "John is 23 years old."
name = "John"
age = 23
print("%s is %d years old." % (name, age))

# you can find the length, index of strings, number of occurances of characters, and cutting strings
# strings start at 0
# python is case sensitive
astring = "Hello world!"
print(len(astring))
print(astring.index("o"))
print(astring.count("l"))
# the string counts are exclusive (7th character doesn't count)
# prints characters 3-6
print(astring[3:7])
# prints character 3
print(astring[3])
# prints character 3 to the end
print(astring[3:])
# prints beginning to character 7
print(astring[:7])
# the position -3 is the 3rd position from the end
# this is an extended slice, with syntax [start : stop : step], and step can be negative or positive
print(astring[3:7:2])
# you can make string uppercase or lowercase
print(astring.upper())
print(astring.lower())
# returns true or false to whether a string ends or starts with a string/character
print(astring.startswith("Hello"))
print(astring.endswith("asdfasdfasdf"))
# you can split a string by a certain character and turn it into a list
afewwords = astring.split(" ")
print(afewwords)

# uses booleans to evaluate conditions (true or false)
x = 2
print(x == 2)
print(x != 2)
print(x == 4)
# uses "and" and "or"
name = "John"
age = 23
print(name == "John" and age == 23)
# uses "in" to check if an objects exists in a list
name = "John"
print(name in ["John", "Rick"])

# testing
a = 1
if (a == 2):
    print("a is 2")
elif (a == 3):
    print("a is 3")
else:
    print("I don't know what a is")
# the "is" operator checks to see if the instances match
# the "not" operator inverts a boolean expression

# for loops
# Prints out the numbers 0,1,2,3,4
for x in range(5):
    print(x)

# Prints out 3,4,5
for x in range(3, 6):
    print(x)

# Prints out 3,5,7
for x in range(3, 8, 2):
    print(x)
# while loops
count = 0
while count < 5:
    print(count)
    count += 1
# "break" exits a loops while "continue" skips the current iteration
# you can have an else in loops

# functions are represented with "def" then the function name then a colon
def printh():
    print("Hello")
# they can pass parameters and "return" returns a value to a caller
# pass statement is a null operation

# basic class
class MyClass:
    variable = "blah"

    def function(self):
        print("This is a message inside the class.")
# assigns the class to an object
myobjectx = MyClass()
# retrieves variable from myobjectx
print(myobjectx.variable)
# accesses function from myobjectx
print(myobjectx.function())

# Dictionary: data type similar to arrays, but works with keys and values instead of indexes.
# Each value stored in a dictionary can be accessed using a key, which is any type of object
# (a string, a number, a list, etc.) instead of using its index to address it.

# Example database of phone numbers, the numbers are the keys and the names are the values stored
phonebook = {}
phonebook["John"] = 938477566
phonebook["Jack"] = 938377264
phonebook["Jill"] = 947662781
print(phonebook)
# how to initialize a whole dictionary
phonebook = {
    "John": 938477566,
    "Jack": 938377264,
    "Jill": 947662781
}
print(phonebook)
# iterating for dictionaries
for name, number in phonebook.items():
    print("Phone number of %s is %d" % (name, number))
# to remove a specific index (2 methods)
del phonebook["John"]
phonebook.pop("Jack")

# "import" imports a module from another module