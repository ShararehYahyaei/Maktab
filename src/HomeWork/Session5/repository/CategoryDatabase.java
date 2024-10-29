package HomeWork.Session5.repository;

import HomeWork.Session5.model.Category;

public class CategoryDatabase {
    Category[] categories = new Category[100];

    public Category[] CategoryInit() {
        categories[0] = new Category("شبکه و اینترنت ", "\"تحولات اخیر در تکنولوژی 5G");
        categories[1] = new Category("هوش مصنوعی", "نقش هوش مصنوعی در اتوماسیون ");
        categories[2] = new Category("خلاقیت", "نقش خلاقیت در توسعه ");
        return categories;
    }

    public Category addNewCategory(String title, String description) {
        for (int index = 0; index < categories.length; index++) {
            if (categories[index] == null) {
                Category category = new Category(title, description);
                categories[index] = category;
                return categories[index];
            }
        }
        return null;
    }


    public Category getCategoryById(int id) {
        for (int index = 0; index < categories.length; index++) {
            if (categories[index] != null) {
                if (index == id - 1) {
                    return categories[index];
                }
            }else{
                return null;
            }

        }
        return null;
    }


}
