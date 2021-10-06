package proj1;

import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

public class Main {
	static ArrayList<Frequencies> wordFreqs;// creating all data members-static because there is only one of each
	static Scanner drew = new Scanner(System.in);
	static String largesample = "";
	static String[] wordList;
	public static void main(String[] args) {

		try {// sequence for bringing in the larger text sample through a  text file
			File myObj = new File("Solomon");// name of the text file
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				largesample = myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {// if the file is not found, then an exception will happen
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		wordList = largesample.toLowerCase().replaceAll("\\p{Punct}", "").split(" ");//removes punctuation, capital letters, and splits up the sentences by words to create just an array of words(no frequencies yet)
																					

		wordFreqs = new ArrayList<Frequencies>();// arraylist of wordfrequencies is created
		String ans = " ";// you get to chose if you want to do the palindrome part or the wordfrequencies part
		System.out.println(
				"Welcome to Recursion/Sort/Search, the experience of a Lifetime. Stay for as long as you would like, but beware, you may never want to leave.\nYou have 2 options:");
		System.out.println(
				"1)Check if a String is a Palindrome\n2)Look at a larger text sample and look at the frequencies of words in the text sample");
		ans = drew.nextLine();
		if (ans.equals("1")) {// depending on your answer, one is done first and then you are asked if you want to do the other
			palindromeCheck();// method that allows you to check palindrome (see below on what that method does)
			System.out.println(
					"Would you now like to look at a larger text sample and look at the frequencies of words in the text sample?(y/n)");
			ans = drew.nextLine();
			if (ans.equals("y")) {//allows you to do the other option
				largerTextSample();
			}
		} else if (ans.equals("2")) {
			largerTextSample();// method that takes you through the whole frequencies part including calling methods for creating the frequencies, sorting, searching (see below on what that method does)
			System.out.println("Now, would you like to check if a String is a Palindrome?");
			ans = drew.nextLine();
			if (ans.equals("y")) {//allows you to do the other option
				palindromeCheck();
			}
		}

	}

	public static String removePunc(String words) {//function to remove all extra characters and spaces turns word lower case 
		String noPunc = words;
		return noPunc.replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+", "").toLowerCase();//returns new string that has only characters
	}

	public static void palindromeCheck() {
		String choice;
		while (true) {
			System.out.println("Enter String:");//gets a string to check if its a palindrome
			String word = drew.nextLine();
			if (palindrome(removePunc(word), "")) {//checks if its a palindrome
				System.out.println(word + " is a palindrome");//tells you if its a palindrome or not
			} else {
				System.out.println(word + " is not a palindrome");
			}
			System.out.println("Would you like to check another word?(y/n)");//allows you to check another word about a palindrome
			choice = drew.nextLine();
			if (choice.equals("n")) {//if you dont want to check another, the loop ends
				break;
			}
		}
	}
	public static boolean palindrome(String sentence, String backwardsSentence) {// checks if the word is a palindrome
		if (backwardsSentence.length() < sentence.length()) {//the recursion in this algorthim creates a new string with the backwards characters of the inputed string
			return palindrome(sentence, backwardsSentence + sentence.charAt(sentence.length() - 1 - backwardsSentence.length()));//so, if the length of the backwards string is less than that of the original string, the corresponding character is added to that backwards string 

		}
		return backwardsSentence.equals(sentence);//if they are the same size, then it compares them to see if the string is the same backwards and fowards-if it is, then its a palindrome
	}

	public static void largerTextSample() {
		String checker;
		System.out.println("Here is the passage:\n" + Main.largesample);//shows you the passage
		System.out.println("I will now count the frequencies of the words in the passage");
		wordFreqs = countPassage(Main.wordList, 0);//counts all the frequencies of the words in the passage
		System.out.println("Now that all the frequencies are counted, I will now display the words in descending order of frequencies");
		sortFreq(0);//frequencies are sorted in descending order by frequency
		for (Frequencies f : wordFreqs) {
			System.out.println(f);//displays the frequencies in descending order
		}
		wordSort(0);//sorts the words alphabetically (by word)
		System.out.println("Now I will allow you to search for a word in the passage");
		while (true) {
			System.out.println("Enter Word");//allows you to search for a word
			checker = drew.nextLine();
			if (binarySearch(0, Main.wordFreqs.size(), checker) == -1) {
				System.out.println(checker + " is not the passage");//if its not in the passage, it tells you it isnt
			} else {//if it is, it tells you how many times
				System.out.println(checker + " is in the passage " + binarySearch(0, Main.wordFreqs.size(), checker) + "times");
			}
			System.out.println("Would you like to search for another word?(y/n)");
			String ans = drew.nextLine();//allows you to search for another word
			if (ans.equals("n")) {
				break;
			}
		}
	}


	public static ArrayList<Frequencies> countPassage(String[] words, int wordNum) {//counts frequencies of a wor
		int place = wordNum;
		if (place == words.length) {//if you fully traversed the array, then all words should be counted so the counting is finished (base case-no recursion)
			return Main.wordFreqs;
		}
		if (Main.wordFreqs.size() == 0) {//if the arraylist is empty, no words are already there, so the word is added with a frequency of 1 (only happens on the first pass ideally)
			Main.wordFreqs.add(new Frequencies(words[place], 1));
			return countPassage(words, place + 1);

		}
		for (int i = 0; i < Main.wordFreqs.size(); i++) {//traverses the arraylist, making sure that it does not count the same word twice (if there is a duplicate the frequency of that word is added by 1)
			if (words[place].equals(Main.wordFreqs.get(i).getWord())) {//checking if that weord has already been counted

				Main.wordFreqs.get(i).addFreq(1);//adds 1
				return countPassage(words, place + 1);//recursively keeps counting the next one
			}
		}
		Main.wordFreqs.add(new Frequencies(words[place], 1));//if it does not exist at all in the arraylist, then a new frequency object is created with that word

		return countPassage(words, place + 1);//recursively keeps counting if it didnt already in the for loop
	}

	public static void sortFreq(int place) {//sorts the frequency in descending order by frequency
		int max = place;
		if (place != Main.wordFreqs.size()) {//if it is not finished traversing through the arraylist, it keeps trying to sort (linearly)
			for (int i = place; i < Main.wordFreqs.size(); i++) {//finds highest frequency from the place on and then swaps the freq at place with the one with the highest frequency
				if (Main.wordFreqs.get(max).getFreq() < Main.wordFreqs.get(i).getFreq()) {
					max = i;
				}
			}
			swap(max, place);
			sortFreq(place + 1);//continues through the arraylist using butt recursion
		}
	}

	public static void swap(int index1, int index2) {//very simple swap method-switches the frequency objects in the arraylist depending on which indexes are passed in
		Frequencies temp = Main.wordFreqs.get(index1);
		Main.wordFreqs.set(index1, Main.wordFreqs.get(index2));
		Main.wordFreqs.set(index2, temp);

	}

	public static void wordSort(int place) {//(insertion) sorts the arralist alphabetically by the word which is accounted
		for (int i = 1; i < Main.wordFreqs.size(); i++) {// goes through the arraylist from 1 to the end
			int temp = i;
			for (int j = i - 1; j >= 0; j--) {// goes through the arraylist, looking at the index 1 less than i, and checks if the name at i is alphabetically earlier the other one, if it is, it swaps the two and continues
				if (Main.wordFreqs.get(temp).getWord().toLowerCase().compareTo(Main.wordFreqs.get(j).getWord().toLowerCase()) < 0) {

					swap(j, temp);//swapping method
					temp--;//if there is a swap then the index has to stay the same because if it does not it will miss a comparison

				} else {
					break;
				}
			}
		}
	}

	public static int binarySearch(int low, int high, String check) {//binary search for a specific word
		String search = check.toLowerCase();
		if (high >= low) {
			int mid = low + (high - low) / 2;//creates the midpoint int

			
			if (Main.wordFreqs.get(mid).getWord().equals(search))//checks if the midpoint is the word-best case scenario, if it is, it returns the frequency of that 
				return Main.wordFreqs.get(mid).getFreq();

			if (Main.wordFreqs.get(mid).getWord().compareTo(search) > 0)//if the word comes earlier in the alphabet, then the binary search is ran again, ignoring the second half of the arraylist
				return binarySearch(low, mid - 1, search);

			return binarySearch(mid + 1, high, search);//if the word comes later in the alphabet, then the binary search is ran again, ignoring the first half of the arraylist
		}
		return -1;//if it is not in the arraylist at all meaning that the indexes being checked are the same because high <= low, so it is not in the array and -1 is returned
	}

}
