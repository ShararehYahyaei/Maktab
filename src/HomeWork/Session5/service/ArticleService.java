package HomeWork.Session5.service;


import HomeWork.Session5.model.Article;
import HomeWork.Session5.repository.ArticleDatabase;

import java.time.LocalDate;
import java.util.Scanner;

public class ArticleService {
    ArticleDatabase database;

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

    public Article[] showArticlesForCreateDate() {
        Article[] newArticleFilter = null;
        System.out.println("1 - بر اساس یکساعت اخیر  .");
        System.out.println(" 2 - بر اساس 1 هفته اخیر .");
        System.out.println(" 3 - بر اساس  6 ماه اخیر.");
        System.out.println("4 - بر اساس  1 سال اخیر.");
        System.out.println("نوغ فیلتر  مد نظر خود را وارد نمائید .");
        String res = new Scanner(System.in).nextLine();

        switch (res) {
            case "1":
                break;
            case "2":
                newArticleFilter = showArticlesBasedOnaWeekAgo();
                break;
            case "3":
                newArticleFilter = showArticlesBasedOn6MonthAgo();
                break;
            case "4":
                newArticleFilter = showArticleBasedOnOneYear();
                break;
            default:
                System.out.println("گزینه نامناسب");

        }
        return newArticleFilter;
    }


    public Article[] showArticleBasedOnOneYear() {
        Article[] articles = database.getArticleInit();
        Article[] newArticleForOneYear = new Article[articles.length + 1];
        LocalDate now = LocalDate.now();
        LocalDate oneYear = now.minusYears(1);
        for (Article article : articles) {

           if(article!=null){
               if (article.getCreateDate().isAfter(oneYear)) {
                   for (int i = 0; i < newArticleForOneYear.length; i++) {
                       if (newArticleForOneYear[i] == null) {
                           newArticleForOneYear[i] = article;
                           break;
                       }
                   }
               }
           }
        }

        return newArticleForOneYear;
    }

    public Article[] showArticlesBasedOn6MonthAgo() {
        Article[] articles = database.getArticleInit();
        Article[] newArticleForOneYear = new Article[articles.length + 5];
        LocalDate now = LocalDate.now();
        LocalDate sixMonthsAgo = now.minusMonths(6);
        for (Article article : articles) {

            if(article!=null){
                if (article.getCreateDate().isAfter(sixMonthsAgo)) {
                    for (int i = 0; i < newArticleForOneYear.length; i++) {
                        if (newArticleForOneYear[i] == null) {
                            newArticleForOneYear[i] = article;
                            break;
                        }
                    }
                }
            }
        }

        return newArticleForOneYear;
    }

    public Article[] showArticlesBasedOnaWeekAgo() {
        Article[] articles = database.getArticleInit();
        Article[] newArticleForOneYear = new Article[articles.length + 5];
        LocalDate now = LocalDate.now();
        LocalDate oneWeekAgo = now.minusWeeks(1);
        for (Article article : articles) {

            if(article!=null){
                if (article.getCreateDate().isAfter(oneWeekAgo)) {
                    for (int i = 0; i < newArticleForOneYear.length; i++) {
                        if (newArticleForOneYear[i] == null) {
                            newArticleForOneYear[i] = article;
                            break;
                        }
                    }
                }
            }
        }

        return newArticleForOneYear;
    }



}
