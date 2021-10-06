package proj1;

public class Frequencies {
	String word;//initializing data types
	int freq;

	public Frequencies(String w, int f) {//constructor: sets the parameters to the proper variables
		freq = f;
		word = w;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	public void addFreq(int amount) {//adds to the frequency (for when another example of the word is 
		freq += amount;
	}

	/**
	 * @return the freq
	 */
	public int getFreq() {
		return freq;
	}

	/**
	 * @param freq the freq to set
	 */
	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String toString() {//to string to allow me to print a freq
		return word + ": " + freq;
	}

}
