package HomeWork.Session5.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    private int id;
    private String title;
    private String brief;
    private String content;
    private LocalDateTime createDate;
    private boolean isPublished;
    private LocalDate lastUpdateDate;
    private LocalDateTime publishedDate;
    private boolean status;
    private Category category;
    private Tag[] tags;
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Article(String title, String brief) {
        this.title = title;
        this.brief = brief;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public Article(int id, String title, String brief, String content, LocalDateTime createDate, boolean isPublished, LocalDate lastUpdateDate, LocalDateTime publishedDate, Tag tag, Category category) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.lastUpdateDate = lastUpdateDate;
        this.publishedDate = publishedDate;
        this.tag = tag;
        this.category = category;

    }

    public Article(String title, String brief, String content, LocalDateTime createDate, boolean isPublished, LocalDate lastUpdateDate, Category category, Tag tag) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.lastUpdateDate = lastUpdateDate;
        this.category = category;
        this.tag = tag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "-------\n" +
                "مقاله شماره: " + id + "\n" +
                "عنوان مقاله: " + title + "\n" +
                "خلاصه مقاله: " + brief + "\n" +
                "محتوا: " + content + "\n" +
                "تاریخ ایجاد: " + createDate + "\n" +
                "آخرین تغییر: " + lastUpdateDate + "\n" +
                "تاریخ انتشار: " + (publishedDate != null ? publishedDate : "هنوز منتشر نشده") + "\n" +
                "تگ: " + tag + "\n" +
                "دسته بندی: " + category + "\n" +
                "-------";
    }

    private Tag tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }


}


