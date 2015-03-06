package com.weekinweekout.logic;

import java.io.File;
import java.util.List;

import com.weekinweekout.util.Utilities;

public class RecipeManager {

	private List<String> recipeDatas;

	public RecipeManager(File recipeFile) throws Exception {
		this.recipeDatas = Utilities.readLinesFromFile(recipeFile);
	}

	public List<String> getRecipes() {
		return this.recipeDatas;
	}

}
