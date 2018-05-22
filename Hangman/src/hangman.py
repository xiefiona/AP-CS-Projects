
#opens dictionary text file
text_file = open("dictionary.txt", "r")
dictionary = text_file.read().split(',')
print dictionary
print len(dictionary)
text_file.close()

import random
n = random.randint(1, 99)