package HomeWork.Session5.service;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;
import HomeWork.Session5.repository.ArticleDatabase;
import HomeWork.Session5.repository.AuthorDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModeratorService {
    private AuthorDatabase authorDatabase;
    private ArticleDatabase articleDatabase ;


    public ModeratorService(AuthorDatabase authorDatabase,ArticleDatabase articleDatabase) {
        this.authorDatabase = authorDatabase;
        this.articleDatabase = articleDatabase;
    }

    public List<Article> allArticlesReadyForPublished() {
        Author[] authors = authorDatabase.getAllAuthores();
        List<Article> articlesForPublishStatus = new ArrayList<>();

        if (authors == null) {
            System.out.println("هیچ نویسنده‌ای وجود ندارد");
            return null;
        }

        for (Author author : authors) {
            if (author == null) continue;

            Article[] articles = author.getArticles();
            if (articles == null) {
                System.out.println("نویسنده " + author.getUserName() + " هیچ مقاله‌ای ندارد");
                continue;
            }

            for (Article article : articles) {
                if (article != null && article.isPublished()) {
                    articlesForPublishStatus.add(article);
                }
            }
        }

        if (articlesForPublishStatus.isEmpty()) {
            System.out.println("هیچ مقاله‌ای آماده برای انتشار وجود ندارد");
            return null;
        }
        return articlesForPublishStatus;
    }

    public void ApproveOrReject(List<Article> articles) {
        showBreifArticle(articles);
        System.out.println("انتخاب مقاله مورد نظر");
        int res = new Scanner(System.in).nextInt();
        Article article = findArticleById(res, articles);
        System.out.println("نائید یا رد : تائید 1 و رد عدد 2");
        String resultF = new Scanner(System.in).next();
        if (resultF.equals("1")) {
            article.setStatus(true);
            article.setPublishedDate(LocalDate.now());
            articleDatabase.addPublishedArticles(article);
            System.out.println("مقاله تایید و اضافه شد.");

        } else {
            System.out.println("مفاله رد شد و مورد نائید قرار نگرقت.");

        }

    }

    private static void showBreifArticle(List<Article> articles) {
        for (int i = 0; i < articles.size(); i++) {
           if (articles.get(i) != null) {
               System.out.println(articles.get(i).getId() + " " + articles.get(i).getTitle());

           }
            return ;
        }

    }

    public static Article findArticleById(int id, List<Article> targetArticles) {
        for (Article article : targetArticles) {
            if (article.getId() == id) {
                return article;
            }
        }
        System.out.println("شماره مقاله یاقت نشد");
        return null;
    }
}
