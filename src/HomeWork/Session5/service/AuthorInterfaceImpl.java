package HomeWork.Session5.service;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;
import HomeWork.Session5.repository.AuthorDatabase;

import java.time.LocalDate;


public class AuthorInterfaceImpl implements AuthorInterface {
    private AuthorDatabase database;

    public AuthorInterfaceImpl(AuthorDatabase database) {
        this.database = database;
    }

    @Override
    public Author signUp(String userName, String nationalCode, LocalDate birthday) {
        Author author = database.addAuthor(userName, nationalCode, birthday);
        return author;

    }

    @Override
    public Author login(String userName, String password) {
        Author author = database.loginAuthor(userName, password);
        return author;
    }

    @Override
    public boolean checkUserduplicate(String nationalCode) {
        boolean result = database.checkUserDuplicate(nationalCode);
        return result;
    }

    @Override
    public Author getAuthor(String nationalCode) {
        return null;
    }

    @Override
    public Author[] getAllAuthores() {
        Author[] authores = database.getAllAuthores();
        return authores;
    }

    @Override
    public Article[] getArticle(String nationalCode) {
        Article[] article = database.getArticle(nationalCode);
        return article;
    }

    @Override
    public void saveArticleforAuthor(Author author, Article article) {

        if (author.getArticles() == null) {
            Article[] articles = new Article[10];
            article.setId(1);
            article.setAuthor(author);
            articles[0] = article;
            author.setArticles(articles);

        } else {
            int id = 0;
            for (int k = 0; k < author.getArticles().length; k++) {
                if (author.getArticles()[k] == null) {
                    article.setAuthor(author);
                    article.setId(++id);
                    author.getArticles()[k] = article;
                    break;
                } else {
                    id = author.getArticles()[k].getId();
                }
            }
        }

    }


    public boolean changeNationalCode(String userName, String passWord) {
        boolean result = database.changeNationalCode(userName, passWord);
        return result;
    }

    public boolean checkNationalCode(String nationalCode) {
        boolean result = database.checkNationalCode(nationalCode);
        return result;
    }


}
