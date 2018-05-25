import random

print("Welcome to Hangman!")

#opens dictionary text file
text_file = open("dictionary.txt", "r")
dictionary = text_file.read().splitlines()
text_file.close()

lives = 10

while lives > 0:
    done = False

    #picks a word
    n = random.randint(1, len(dictionary))
    word = dictionary[n]
    length = len(word)

    #make an array for the word
    arrWord = list(word)

    #make an array for the guessed word
    arrGuess = []
    for i in range(0,length):
        arrGuess.append("none")


    #make an array for all guessed letters
    arrLet = []

    #print(word)
    print("__ " * length)

    while done == False:
        correct = False;    #if letter is in the word

        repeat = True
        while repeat:
            repeat = False

            #checks if letter is in the word and replaces in the list
            guess = input("guess a character: ")
            for i in range(0, len(arrLet)):
                if guess == arrLet[i]:
                    repeat = True
                    print("You repeated a character, pick another one")

        arrLet.append(guess)
        for i in range(0, length):
            if guess == word[i:i+1]:
                correct = True;
                arrGuess[i] = guess;
        if not correct:
            print("nope :(")
            lives -= 1
        else:
            print("you guessed correctly")

        #makes string and sees if program is done
        done = True
        string = ""
        for i in range (0,length):
            if (arrGuess[i] != word[i]):
                done = False
                string += "__ "
            else:
                string += word[i] + " "
        print(string)
        print("Number of lives left: " + str(lives))
        print("Guessed letters: " + str(arrLet))
        if lives <= 0:
            done = True
            print("You lost the game :(")
        if done:
            print("The word was: " + word)