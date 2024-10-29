package HomeWork.Session5.repository;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;

import java.time.LocalDate;

public class AuthorDatabase {


    Author[] authors = new Author[10];

    private int id = 0;


    public Author addAuthor(String userName, String nationalCode, LocalDate birthday) {

        Author author = new Author();
        if (id >= authors.length) {
            System.out.println("امگان دخیره سازی وحود ندارد");
            return null;
        }
        author.setId(id);
        author.setUserName(userName);
        author.setNationalCode(nationalCode);
        author.setBirthday(birthday);
        author.setPassWord(nationalCode);
        authors[id] = author;
        id++;
        return author;
    }

    public Author loginAuthor(String userName, String passWord) {
        for (int index = 0; index < authors.length; index++) {
            if (authors[index] != null) {
                if (authors[index].getUserName().equals(userName) && authors[index].getPassWord().equals(passWord)) {
                    Author author = authors[index];
                    return author;
                }
            }

        }
        return null;
    }

    public boolean checkUserDuplicate(String nationalCode) {
        boolean result = false;
        for (int index = 0; index < authors.length; index++) {
            if (authors[index] != null && authors[index].getNationalCode().equals(nationalCode)) {
                result = true;
                return result;

            }
        }

        return result;
    }

    public Author getAuthor(String nationalCode) {
        for (int index = 0; index < authors.length; index++) {
            if (authors[index] != null) {
                if (authors[index].getNationalCode().equals(nationalCode)) {
                    return authors[index];
                }
            }


        }
        return null;
    }


    public boolean changeNationalCode(String username, String passWord) {
        boolean result = false;
        for (int index = 0; index < authors.length; index++) {
            if (authors[index] != null) {
                if (authors[index].getUserName().equals(username)) {
                    authors[index].setPassWord(passWord);
                    result = true;
                }
            }
        }
        return result;
    }

    public Article[] getArticle(String nationalCode) {
        for (int index = 0; index < authors.length; index++) {
            if (authors[index] != null && authors[index].getNationalCode().equals(nationalCode)) {
                Article[] article = authors[index].getArticles();
                return article;
            }
        }
        return null;
    }

    public boolean checkNationalCode(String nationalCode) {
        boolean result = false;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].getNationalCode().equals(nationalCode)) {
                result = true;
                return result;
            }

        }
        return result;
    }

    public Author[] getAllAuthores() {
        return authors;
    }

    public Article[] getArticles() {
        for (int index = 0; index < authors.length; index++) {
            return authors[index].getArticles();
        }
        return null;
    }


}


