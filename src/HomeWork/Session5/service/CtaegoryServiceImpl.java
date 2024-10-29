package HomeWork.Session5.service;

import HomeWork.Session5.model.Category;
import HomeWork.Session5.repository.CategoryDatabase;

public class CtaegoryServiceImpl implements CategoryInterface {
    CategoryDatabase categoryDatabase = new CategoryDatabase();

    @Override
    public Category[] getAllCategories() {
        Category[] categories = categoryDatabase.CategoryInit();
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = categoryDatabase.getCategoryById(id);
        return category;
    }


    public Category createNewCategory(String title, String description) {
        Category category = categoryDatabase.addNewCategory(title, description);
        return category;
    }
}
