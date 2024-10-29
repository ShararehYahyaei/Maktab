package HomeWork.Session5;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;
import HomeWork.Session5.repository.ArticleDatabase;
import HomeWork.Session5.repository.AuthorDatabase;
import HomeWork.Session5.service.AuthorInterfaceImpl;
import HomeWork.Session5.service.ModeratorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        AuthorDatabase db;
        saveFirstArticleTest();
        secondTimeSaveArticle();
        testForIsArticle();
        testForGettingAllArticlesAreReadyForPublish();
    }

    private static void saveFirstArticleTest() {
        AuthorInterfaceImpl authorserv = new AuthorInterfaceImpl(new AuthorDatabase());
        Author author = new Author();
        Article article = new Article("1", "");
        authorserv.saveArticleforAuthor(author, article);
        if (author.getArticles() != null) {

            if (article.getTitle().equals(author.getArticles()[0].getTitle())) {
                System.out.println("درست انجام شده");
            } else {
                System.out.println("درست نیست");
            }
        }
    }

    public static void secondTimeSaveArticle() {
        AuthorInterfaceImpl authorserv = new AuthorInterfaceImpl(new AuthorDatabase());
        Author author = new Author();

        Article article = new Article("1", "");
        authorserv.saveArticleforAuthor(author, article);

        Article article1 = new Article("2", "");
        authorserv.saveArticleforAuthor(author, article1);
        if (author.getArticles() != null) {
            if (author.getArticles()[1].getTitle().equals(article1.getTitle())) {
                System.out.println("درست انجام شده");
            } else {
                System.out.println("درست نیست");
            }
        }


    }

    public static void testForIsArticle() {
        AuthorInterfaceImpl authorserv = new AuthorInterfaceImpl(new AuthorDatabase());
        Author author = new Author();
        Article article = new Article("1", "");
        Article article1 = new Article("2", "");
        authorserv.saveArticleforAuthor(author, article);
        authorserv.saveArticleforAuthor(author, article1);

        if (author.getArticles() != null) {
            if (article1.getId() == 2) {
                System.out.println("درست انجام شده");
            } else {
                System.out.println("درست نیست");
            }
        }


    }

    public static void testForGettingAllArticlesAreReadyForPublish() {
        Author author = new Author();

        AuthorDatabase db = new AuthorDatabase();
        ArticleDatabase dA = new ArticleDatabase();
        ModeratorService ms = new ModeratorService(db, dA);
        AuthorInterfaceImpl authorserv = new AuthorInterfaceImpl(db);

        author = authorserv.signUp("author", "4580084497", LocalDate.now().minusYears(1));


        Article article = new Article("", "", "", LocalDateTime.of(2021, 8, 22, 0, 0), true, LocalDateTime.of(2021, 8, 22,0,0), null, null);
        Article article1 = new Article("", "", "", LocalDateTime.of(2021, 8, 22, 0, 0), true, LocalDateTime.of(2021, 8, 22,0,0), null, null);
        Article article2 = new Article("", "", "", LocalDateTime.of(2021, 8, 22, 0, 0), false, LocalDateTime.of(2021, 8, 22,0,0), null, null);
        Article articl3 = new Article("", "", "", LocalDateTime.of(2021, 8, 22, 0, 0), false, LocalDateTime.of(2021, 8, 22,0,0), null, null);


        authorserv.saveArticleforAuthor(author, article);
        authorserv.saveArticleforAuthor(author, article1);
        authorserv.saveArticleforAuthor(author, article2);
        authorserv.saveArticleforAuthor(author, articl3);


        List<Article> articles = ms.allArticlesReadyForPublished();
        List<Article> all = new ArrayList<Article>();
        all.add(article);
        all.add(article1);
        if (articles.size() == all.size()) {
            System.out.println("درست است");
        } else {
            System.out.println("درست نیست");
        }

    }

}
