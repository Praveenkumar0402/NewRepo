package day_13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;

public class WordsSortedCount {
	public static void main(String[] args) throws IOException {
		var fr = Files.readString(Path.of("Home\\Documents\\Praveen\\marks.txt"));
		var words = fr.split("\\W+");
		var count = new TreeMap<String, Integer>();
		for (var w : words) {
			if (count.containsKey(w))
				count.replace(w, count.get(w) + 1);
			else
				count.put(w, 1);
		}
		for (var w : count.keySet()) {
			System.out.printf("%-5s %3d\n", w, count.get(w));
		}
	}

}
