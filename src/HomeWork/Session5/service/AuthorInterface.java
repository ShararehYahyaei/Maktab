package HomeWork.Session5.service;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;

import java.time.LocalDate;


public interface AuthorInterface {
    Author signUp(String userName, String nationalCode, LocalDate birthday);

    Author login(String userName, String password);

    boolean checkUserduplicate(String userName);

    Author getAuthor(String nationalCode);

    Author[] getAllAuthores();

    Article[] getArticle(String nationalCode);

    void saveArticleforAuthor(Author author, Article article);

}
