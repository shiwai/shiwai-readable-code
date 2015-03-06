package com.weekinweekout.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

	public static List<String> readLinesFromFile(File recipeFile)
			throws Exception {
		try (Reader r = new FileReader(recipeFile)) {
			try (BufferedReader br = new BufferedReader(r)) {
				List<String> readLines = new ArrayList<String>();
				String readContent = "";

				do {
					readContent = br.readLine();
					// readLine == null のときはファイルの終わり
					if (readContent == null) {
						break;
					}

					readLines.add(readContent);
				} while (true);

				return readLines;
			}
		}
	}
}
