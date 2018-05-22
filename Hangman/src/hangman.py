
#opens dictionary text file
text_file = open("dictionary.txt", "r")
dictionary = text_file.read().splitlines()
text_file.close()

#picks a word
import random
n = random.randint(1, 58112)
word = dictionary[n]
length = len(word)
done = False
lives = 5

#make an array for the word
arrWord = []
for i in range(0,length):
    arrWord.append(word[i,i+1])

#make an array for the guessed word
arrGuess = []
for i in range(0,length):
    arrGuess.append("none")

print(word)
print("__ " * length)

while done == False:
    correct = False;    #if letter is in the word
    guess = input("guess a character: ")
    for i in range (0,length):
        if (guess == word[i:i+1]):
            correct = True;
            arrGuess[i] = guess;
    if correct == False:
        ("wrong :(")
        lives -= 1
    else:
        print("you guessed correctly")
    done = True
    string = ""
    for i in range (0,length):
        if (arrGuess[i] != word[i]):
            done = False
            string += "__ "
        else:
            string += word[i] + " "
