package HomeWork.Session5.model;

public class Category {

    private String title ;
    private String description ;

    public Category(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "-------\n" +
                "عنوان دسته‌بندی: " + title + "\n" +
                "توضیحات: " + description + "\n" +
                "------";
    }
}
