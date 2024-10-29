package HomeWork.Session5.model;


import java.time.LocalDate;

public class Author {

    private int id;
    private String userName;
    private String nationalCode;
    private LocalDate birthday;
    private String passWord;
    private Article[] articles;
    private int articleCount;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    @Override
    public String toString() {
        return "جزئیات نویسنده:\n" +
                "----------------------------\n" +
                "شناسه          : " + id + "\n" +
                "نام کاربری     : " + userName + "\n" +
                "کد ملی         : " + nationalCode + "\n" +
                "تاریخ تولد     : " + birthday + "\n" +
                "رمز عبور       : " + passWord + "\n" +
                "----------------------------";
    }


    public Article[] getArticles() {
        return articles;
    }
}
