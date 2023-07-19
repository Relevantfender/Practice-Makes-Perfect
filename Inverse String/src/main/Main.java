package main;

import java.util.Scanner;


public class Main {
    static String input;

    static String[] arrayOfWords;
    static boolean punctuation;
    static int spaceCount = 0;

    public static void main(String[] args) {
        inputWord();
        placeInArray();
        reversePrint();
    }
    private static void inputWord() {
        System.out.println("Input the sentence: ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

    }
    private static int numberOfWords(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
    private static void placeInArray() {
        //format the sentence
        String newString = input.trim().replaceAll("\\s", " ");
        //isolate the last word (need to isolate punctuation so you can place at the end of sentence)
        String lastWord = newString.substring(newString.lastIndexOf(' '));
        //adding space between last word and punctuation
        StringBuilder modifiedWord = new StringBuilder(lastWord);


        for (int i = 1; i < lastWord.length(); i++) {
            //going through word, checking if char is punctuation
            if (!Character.isLetterOrDigit(lastWord.charAt(i))) {
                //inserting space
                modifiedWord.insert(i + spaceCount, " ");
                spaceCount++;
                punctuation = true;
            }

        }
        if (punctuation) {
            //changing last word in the formatted string if need be
            newString = newString.replaceAll(newString.substring(newString.lastIndexOf(' ')), String.valueOf(modifiedWord));

        }

        int count = numberOfWords(newString);

        arrayOfWords = new String[count];
        arrayOfWords = newString.split(" ");


    }
    private static void reversePrint() {
//if last word was changed, elements that are punctuation are shown last, rest is inverse
        if (punctuation) {
            for (int i = arrayOfWords.length - 1 - spaceCount; i >= 0; i--) {
                if (i == arrayOfWords.length - spaceCount - 1) {
                    //changing first letter of the sentence into upper case
                    System.out.print(arrayOfWords[i].substring(0, 1).toUpperCase() + arrayOfWords[i].substring(1) + " ");
                } else {
                    if (i == 0) System.out.print(arrayOfWords[i]);
                    else System.out.print(arrayOfWords[i] + " ");
                }

            }
            for (int i = arrayOfWords.length - 1; i >= arrayOfWords.length - spaceCount; i--) {
                System.out.print(arrayOfWords[i]);

            }
        } else {
            for (int i = arrayOfWords.length - 1; i >= 0; i--) {
                if (i == arrayOfWords.length - 1) {
                    System.out.print(arrayOfWords[i].substring(0, 1).toUpperCase() + arrayOfWords[i].substring(1) + " ");
                } else {
                    System.out.print(arrayOfWords[i] + " ");
                }

            }
        }
    }

}
