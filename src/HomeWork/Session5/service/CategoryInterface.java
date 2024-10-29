package HomeWork.Session5.service;

import HomeWork.Session5.model.Category;

public interface CategoryInterface {
    Category[]getAllCategories();
    Category getCategoryById(int  id);
}
