package HomeWork.Session5.model;

public class Tag {
    private int id;
    private String titleTag;

    public Tag(String titleTag) {
        this. titleTag = titleTag;
    }

    public Tag(int id, String titleTag) {
        this.id = id;
        this.titleTag = titleTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    @Override
    public String toString() {
        return "-----\n" +
                "شماره تگ: " + id + "\n" +
                "عنوان تگ: " + titleTag + "\n" +
                "-----";
    }
}
