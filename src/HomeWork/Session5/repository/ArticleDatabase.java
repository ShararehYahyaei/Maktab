package HomeWork.Session5.repository;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Category;
import HomeWork.Session5.model.Tag;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ArticleDatabase {
    Article[] articles = init();

    public void addPublishedArticles(Article article) {
        Article[] newArticles = new Article[articles.length + 2];

            for (int j = 0; j < articles.length; j++) {
                newArticles[j] = articles[j];
            }

            articles = addToInitArticles(article, newArticles);


    }

    private Article[] addToInitArticles(Article article, Article[] articles) {
        for (int j = 0; j < articles.length; j++) {
            if (articles[j] == null) {
                article.setId(j+1);
                articles[j] = article;
                break;
            }
        }
        return articles;
    }

    public Article[] getArticleInit() {

        return articles;

    }

    public Article showArticle(int id) {
        Article[] articles = getArticleInit();
        for (int i = 0; i < articles.length; i++) {
            if (articles[i].getId() == id) {
                return articles[i];
            }
        }
        return null;

    }

    private Article[] init() {
        Article[] articles = new Article[3];
        Article article1 = new Article(
                1,
                "اینترنت",
                "خلاصه هوش مصنوعی",
                "انقلاب هوش مصنوعی در جهان",
                LocalDateTime.of(2024, 06, 20,0,0),
                true,
                LocalDate.of(2023, 11, 15),
                LocalDateTime.of(2022, 12, 25,0,0),
                new Tag(1, "اینترنت جهانی"),
                new Category("شبکه و اینترنت ", "\"تحولات اخیر در تکنولوژی 5G")


        );

        Article article2 = new Article(
                2,
                "آب و هوا",
                "خلاصه آب و هوا",
                "محتوا در مورد تاثیرات تغییرات آب و هوا",
                LocalDateTime.of(2024, 10, 22,0,0),
                true,
                LocalDate.of(2023, 3, 10),
                LocalDateTime.of(2021, 10, 10,0,0),
                new Tag(2, "تکنولوژی پیش بینی هوا"),
                new Category("هوش مصنوعی", "نقش هوش مصنوعی در اتوماسیون ")


        );

        Article article3 = new Article(
                3,
                "سیاست",
                "خلاصه ای از سیایست ایران و جوامع",
                "سیاست ایران از قبل تا کنون",
                LocalDateTime.of(2021, 8, 22,0,0),
                true,
                LocalDate.of(2021, 12, 30),
                LocalDateTime.of(2021, 10, 10,0,0),
                new Tag(3, " انسان خلاق"),
                new Category("خلاقیت", "نقش خلاقیت در توسعه ")

        );

        articles[0] = article1;
        articles[1] = article2;
        articles[2] = article3;
        return articles;
    }
}
