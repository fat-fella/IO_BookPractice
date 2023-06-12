package quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Fos {

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("a.txt")) {
			fw.write("Hello, World");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
