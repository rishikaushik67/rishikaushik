package lesson8.labs.prob4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountWords {
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("The");
		words.add("wish");
		words.add("hunts");
		words.add("continuum");
		words.add("Past");
		words.add("slang");
		words.add("migrates");
		words.add("visit");

		System.out.println(countWordsGood(words, 's', 'c', 5));
		System.out.println(countWordsGood(words, 'e', 'g', 3));

		System.out.println(countWordsBetter(words, 's', 'c', 5));
		System.out.println(countWordsBetter(words, 'e', 'g', 3));

		System.out.println(countWordsBest(words, 's', 'c', 5));
		System.out.println(countWordsBest(words, 'e', 'g', 3));
	}

	public static int countWordsBest(List<String> words, char c, char d, int len) {

		QuadFunction<List<String>, Character, Character, Integer, Integer> countWords = (
				ws, c1, d1, len1) -> (int) ws
				.stream()
				.filter(w -> w.length() == len1 && w.indexOf(c1) > -1
						&& w.indexOf(d1) == -1).count();

		return countWords.apply(words,c, d, len);
	}

	public static int countWordsBetter(List<String> words, char c, char d,
			int len) {

		TriFunction<Character, Character, Integer, Predicate<String>> countWords = (
				c1, d1, len1) -> name -> name.length() == len1
				&& name.indexOf(c1) > -1 && name.indexOf(d1) == -1;

		return (int) words.stream().filter(countWords.apply(c, d, len)).count();
	}

	public static int countWordsGood(List<String> words, char c, char d, int len) {

		return (int) words
				.stream()
				.filter(word -> word.length() == len && word.indexOf(c) > -1
						&& word.indexOf(d) == -1).count();
	}
}
