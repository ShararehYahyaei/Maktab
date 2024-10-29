package HomeWork.Session5.service;


import HomeWork.Session5.model.Article;
import HomeWork.Session5.repository.ArticleDatabase;

public class ArticleService {
    ArticleDatabase database ;

    public ArticleService(ArticleDatabase database) {
        this.database = database;
    }

    public Article[] showArticles() {
        Article[] articles = database.getArticleInit();
        return articles;
    }


    public Article showArticle(int id) {
        Article article = database.showArticle(id);
        return article;
    }


}
