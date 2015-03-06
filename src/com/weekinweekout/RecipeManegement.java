package com.weekinweekout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipeManegement {
	/**
	 * args[0] ... レシピファイル
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("一番目の引数にはレシピファイルを指定してください");
			return;
		}

		String recipeFilePath = args[0];
		outputRecipes(recipeFilePath);
	}

	private static void outputRecipes(String recipeFilePath) throws Exception {
		File recipeFile = new File(recipeFilePath);

		if (!recipeFile.exists()) {
			throw new FileNotFoundException("レシピファイルが見つかりません。");
		}
		
		List<String> recipeDatas = readLinesFromFile(recipeFile);
		
		for (String recipeData : recipeDatas) {
			System.out.println(recipeData);
		}
	}

	private static List<String> readLinesFromFile(File recipeFile) throws Exception {
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
