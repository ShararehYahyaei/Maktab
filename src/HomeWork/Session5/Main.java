package HomeWork.Session5;

import HomeWork.Session5.model.Article;
import HomeWork.Session5.model.Author;
import HomeWork.Session5.model.Category;
import HomeWork.Session5.model.Tag;
import HomeWork.Session5.repository.ArticleDatabase;
import HomeWork.Session5.repository.AuthorDatabase;
import HomeWork.Session5.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static AuthorDatabase database = new AuthorDatabase();
    static ArticleDatabase articleDatabase=new ArticleDatabase();
    static AuthorInterfaceImpl authorService = new AuthorInterfaceImpl(database);
    static ArticleService articleService = new ArticleService(articleDatabase);
    static CtaegoryServiceImpl categoryService = new CtaegoryServiceImpl();
    static TagService tagService = new TagService();

    static ModeratorService moderatorService = new ModeratorService(database,articleDatabase);

    public static void main(String[] args) {

        System.out.println(LocalDate.now().getYear());
        while (true) {
            String result = menu();
            showMenu(result);
        }
    }

    public static String menu() {
        System.out.println("به سامانه  ثبت مقالات خوش آمدید");
        System.out.println(" مدیر گزینه 1 و نویسنده گزینه 2 را انتخاب کند.");
        return scanner.nextLine();
    }

    public static void showMenu(String number) {
        switch (number) {
            case "1":
                System.out.println("لطفا نام کاربری خود را وارد نمائید :");
                String username = scanner.nextLine();
                System.out.println("رمز عبور خود را وارد نمائید :");
                String password = scanner.nextLine();
                boolean result1 = loginModerator(username, password);
                if (result1) {
                    System.out.println("انحام عملیات :");
                    System.out.println("1- مشاهده تمامی مقالات منتطر تائید:");
                    System.out.println("2- تائید یا رد مقالات :");
                    System.out.println("3- خروج از حساب کاربری :");
                    System.out.println("عدد مورد نطر را برای انحام عملیات وارد نمائید.");
                    String resNumber = scanner.nextLine();
                    boolean res;
                    if (resNumber.equals("1")) {
                        List<Article> articles = moderatorService.allArticlesReadyForPublished();
                        for (Article article : articles) {
                            System.out.println(article);
                        }

                    } else if (resNumber.equals("2")) {
                        moderatorService.ApproveOrReject(moderatorService.allArticlesReadyForPublished());

                    } else if (resNumber.equals("3")) {
                        return;
                    } else {
                        System.out.println("گزینه نامناسب را انتخاب کرده اید");
                        return;
                    }

                } else {
                    System.out.println("نام کاربری یا کلمه عبور اشتباه می باشد");
                }
                break;
            case "2":

                System.out.println("نویسنده ی عزیز , در منوی زیر میتوانید درخواست خود راانتخاب کنید :");
                System.out.println("1 - ثبت نام در سامانه :");
                System.out.println("2 - وارد شدن در سامانه :");
                System.out.println("3 - خروج :");
                System.out.println("شماره درخواست خود را وارد نمائید :");
                String result = scanner.nextLine();
                if (result.equals("1")) {
                    signUpAuthor();
                } else if (result.equals("2")) {
                    Author author = loginAuthor();
                    if (author != null) {
                        showLoggedInMenu(author);
                    } else {
                        System.out.println("اطلاعات شما به درستی وارد نشده است  مجدد تلاش کنید");
                    }

                }
                break;
            case "3":
                System.exit(0);

        }
    }

    public static void signUpAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ثبت نام نویسنده: :");
        System.out.println("لطفا نام کاربری خود را وارد نمائید :");
        String userName = scanner.next();
        System.out.println("لطفا کد ملی خود را وارد نمائید:");
        String nationalCode = scanner.next();
        if (nationalCode.length() != 10) {
            System.out.println("کد ملی نامعتبر");
            signUpAuthor();
        }

        boolean result = authorService.checkUserduplicate(nationalCode);
        LocalDate birthday = checkBirthday();
        boolean resultFinal = false;
        if (birthday != null) {
            resultFinal = true;
        } else {
            System.out.println("تاریخ تولد خالی می باشد");
            signUpAuthor();
        }


        if (result == false && resultFinal) {
            Author author = authorService.signUp(userName, nationalCode, birthday);

            if (author != null) {
                System.out.println("اطلاعات شما با موفقیت در سامانه ثبت گردید .");

            } else {
                System.out.println("عملیات ثبت نام ناموفق بودو امکان ذخیره سازی وجود ندارد.");

            }
        } else {
            System.out.println("کاربر با این کد ملی موجود می باشد و لطفا مجددا تلاش فرمائید.");
            signUpAuthor();
        }

    }


    public static Author loginAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" لطفا جهت وارد شدن در سامانه اطلاعات خود را وارد کنید :");
        System.out.println("نام کاربری خود را وارد نمائید :");
        String userName = scanner.next();
        System.out.println("رمز عبور خود را وارد نمائید :");
        String passWord = scanner.next();
        Author author = authorService.login(userName, passWord);
        if (author != null) {
            System.out.println("شما با موفقیت وارد سامانه شده اید ");
        }
        return author;
    }

    public static void showLoggedInMenu(Author author) {
        while (true) {
            System.out.println("شما وارد سامانه شده‌اید. لطفا یکی از گزینه‌های زیر را انتخاب کنید:");
            System.out.println(" نویسنده:" + " " + author.getUserName());
            System.out.println("1-ویرایش رمز عبور");
            System.out.println("2 - مشاهده دسته بندی ها :");
            System.out.println("3 - مشاهده مقالات :");
            System.out.println("4 - ایجاد مقاله جدید :");
            System.out.println("5 - مشاهده مقاله خود :");
            System.out.println("6 - ویرایش مقاله خود :");
            System.out.println("7- مشاهده مقالات منتشر شده بر اساس تاریخ");
            System.out.println("8 - خروج :");
            System.out.println("شماره درخواست خود را وارد نمائید:");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    changePassword(author);
                    break;

                case "2":
                    System.out.println("لیست دسته بندی ها");
                    showCategory();
                    break;
                case "3":
                    showArticles();
                    System.out.println("برای مشاهده کامل مقاله شماره آن را وارد نمائید:");
                    int id=new Scanner(System.in).nextInt();
                    showArticleById(id);


                    break;
                case "4":
                    System.out.println("ایجاد مقاله جدید ");
                    Category category = showCategory();
                    System.out.println("مشاهده تگ ها");
                    Tag tag = showTag();
                    Article newArticle = createArticle(category, tag);
                    authorService.saveArticleforAuthor(author, newArticle);
                    System.out.println("اطلاعات با موفقیت ثبت گردید");
                    break;
                case "5":

                    if (author.getArticles() != null) {
                        for (Article article : author.getArticles()) {
                            if (article != null) {
                                System.out.println(article);
                            }
                        }
                    } else {
                        System.out.println("کاربر دارای هیچ مقاله ای نمی باشد.");
                    }

                    break;
                case "6":
                    editArticle(author);
                    Article[] articles1 = author.getArticles();
                    if (articles1 == null) {
                        System.out.println("مقاله ای یافت نشد");
                        return;
                    }
                    for (Article article : articles1) {
                        if (article != null) {
                            System.out.println(article);
                        }
                    }
                    break;
                case "7":

                case "8":
                    return;
                default:
                    System.out.println("گزینه نامعتبر است. لطفا دوباره تلاش کنید.");
                    loginAuthor();

            }
        }

    }

    public static void showArticles() {
        Article[] articles = articleService.showArticles();
        for (int i = 0; i < articles.length; i++) {
          if (articles[i] != null) {
              System.out.println("عنوان: " + articles[i].getTitle() + "\n" + "خلاصه: " + articles[i].getBrief() + "\n" + "شماره مقاله: " + articles[i].getId() + "\n" + "-----");
          }
        }
    }

    public static void showArticleById(int id) {
        Article article = articleService.showArticle(id);
        System.out.printf(
                "شناسه: %d\n" +
                        "عنوان: %s\n" +
                        "خلاصه: %s\n" +
                        "محتوا: %s\n" +
                        "تاریخ ایجاد: %s\n" +
                        "تاریخ انتشار: %s\n" +
                        "آخرین بروزرسانی: %s\n" +
                        "تگ‌ها: %s\n" +
                        "دسته‌بندی: %s\n",
                article.getId(),
                article.getTitle(),
                article.getBrief(),
                article.getContent(),
                article.getCreateDate(),
                article.getPublishedDate(),
                article.getLastUpdateDate(),
                article.getTag(),
                article.getCategory()
        );

    }

    public static Category showCategory() {
        Category category = null;
        Category[] categories = categoryService.getAllCategories();
        int i = 0;
        for (; i < categories.length; i++) {
            if (categories[i] != null) {
                System.out.println((i + 1) + "- " + categories[i].getTitle());
            } else {
                break;
            }

        }
        System.out.println((i + 1) + "- " + "افزودن دسته بندی جدید:");
        System.out.println("انتخاب دسته بندی:");
        int id = scanner.nextInt();
        if (id == (i + 1)) {
            careateCategory();
            category = showCategory();
        } else {
            category = showOneCategory(id);
        }
        return category;
    }

    public static Category showOneCategory(int id) {

        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            System.out.println(category);
            return category;
        } else {
            System.out.println("گزینه نامناسب");
            return null;
        }
    }

    public static Article createArticle(Category category, Tag tag) {
        scanner = new Scanner(System.in);
        System.out.println("برای ایجاد مقاله جدید موارد زیر را وارد نمائید.");               //
        System.out.println("عنوان مقاله را وارد نمائید.");
        String title = scanner.nextLine();
        System.out.println("خلاصه مقاله را وارد نمائید.");
        String brief = scanner.nextLine();
        System.out.println("متن مقاله را وارد نمائید.");
        String content = scanner.nextLine();
        LocalDate createDate = LocalDate.now();
        LocalDate lastUpdateDate = LocalDate.now();
        System.out.println("برای انتشار مقاله ایجاد شده عدد 1 و در غیر اینصورت عدد 2 را بزنید");
        String response = scanner.nextLine();
        boolean result = false;
        if (response.equals("1")) {
            result = true;
        }
        Article article = new Article(title, brief, content, createDate, result, lastUpdateDate, category, tag);
        return article;
    }

    public static LocalDate checkBirthday() {
        boolean resultDate = false;
        System.out.println("لطفا تاریخ تولد خود را به ترتیب سال و ماه و روز وارد نمائید:");
        System.out.println("لطفا سال تولد خود را وارد کنید:");
        int year = scanner.nextInt();
        if (year <= 0 || year > LocalDate.now().getYear()) {
            System.out.println("سال وارد شده معتبر نیست.");
            resultDate = false;
            signUpAuthor();

        }

        System.out.println("لطفا ماه تولد خود را وارد کنید:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("ماه وارد شده معتبر نیست.");
            resultDate = false;
            signUpAuthor();

        }

        System.out.println("لطفا روز تولد خود را وارد کنید:");
        int day = scanner.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("روز وارد شده معتبر نیست.");
            resultDate = false;
            signUpAuthor();

        }
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        if (birthday.isBefore(currentDate)) {
            resultDate = true;
        } else {
            System.out.println("تاریخ تولد نامعتبر");
        }
        if (resultDate) {
            return birthday;
        } else {
            return null;
        }
    }

    public static void changePassword(Author author) {
        System.out.println("برای تغییر رمز عبور موارد زیر را وارد نمائید.");

        System.out.println("رمز عبور جدید خود را وارد نمائید");
        String changePassWord = scanner.next();
        author.setPassWord(changePassWord);

        System.out.println("رمز عبور با موفقیت تغییر یافت.");
    }


    public static void editArticle(Author author) {
        scanner = new Scanner(System.in);
        System.out.println("کدام مقاله را میخواهید تغییر دهید:");
        Article[] articles = author.getArticles();
        if (articles == null) {
            System.out.println("کاربرهیچ مقاله ای برای نمایش ندارد");
            return;
        }
        for (Article article : articles) {
            if (article != null) {
                System.out.println(article);
            }
        }

        System.out.println("عدد مقاله مورد نظر خود را وارد نمائید.");
        int result = scanner.nextInt();
        Article article1 = getArticleForAuthor(author, result);
        System.out.println("مقاله انتخاب شده: " + article1);


        System.out.println("کدام مورد را میخواهید تغییر بدهید: ");
        System.out.println("برای تغییر عنوان مقاله  - 1");
        System.out.println("برای تغییر خلاصه مقاله  - 2");
        System.out.println("برای تغییر متن مقاله  - 3");
        System.out.println("برای تغییر وضعیت انتشار  - 4");
        System.out.println("برای تغییر دسته بندی  - 5");
        System.out.println("برای تغییر تگ مقاله  - 6");
        System.out.println("گزینه درخواست شده را انتخاب کنید:");
        int request = scanner.nextInt();
        scanner.nextLine();
        switch (request) {
            case 1:
                System.out.println("عنوان مقاله را وارد نمائید");
                String title = scanner.nextLine();
                article1.setTitle(title);
                break;
            case 2:
                System.out.println("خلاصه مقاله را وارد نمائید");
                String brief = scanner.nextLine();
                article1.setBrief(brief);
                break;
            case 3:
                System.out.println("متن مقاله را وارد نمائید");
                String content = scanner.nextLine();
                article1.setContent(content);
                break;
            case 4:
                System.out.println("برای انتشار مقاله ایجاد شده عدد 1 و در غیر اینصورت عدد 2 را بزنید");
                int response = scanner.nextInt();
                if (response == 1) {
                    article1.setStatus(true);
                } else {
                    article1.setStatus(false);
                }
                break;
            case 5:

                Category category = showCategory();
                article1.setCategory(category);
                break;
            case 6:
                Tag tag = showTag();
                article1.setTag(tag);
                article1.setLastUpdateDate(LocalDate.now());
                break;
            default: {
                System.out.println("گزینه نامناسب را انتخاب کرده اید");
            }
            System.out.println("تغییرات با موفقیت ذخیره شد.");

        }
    }

    public static Category careateCategory() {
        scanner = new Scanner(System.in);
        System.out.println("افزودن دسته بندی جدید.");
        String title = scanner.nextLine();
        System.out.println("توضیحات جدید:");
        String description = scanner.nextLine();
        Category category = categoryService.createNewCategory(title, description);
        return category;
    }

    public static Tag showTag() {
        Tag[] tags = tagService.getAllTags();
        Tag tag = null;
        int i = 0;
        for (; i < tags.length; i++) {
            if (tags[i] != null) {
                System.out.println(tags[i].getId() + " - " + tags[i].getTitleTag());
            } else {
                break;
            }

        }
        System.out.println((i + 1) + " - " + "افزودن تگ جدید: ");
        System.out.println("انتخاب تگ مورد نظر:");
        int id = scanner.nextInt();
        if (id == (i + 1)) {
            createTag();
            tag = showTag();
        } else {
            tag = showOneTag(id);
        }
        return tag;
    }

    public static Tag createTag() {
        scanner = new Scanner(System.in);
        System.out.println("افزودن عنوان تگ جدید.");
        String title = scanner.nextLine();
        Tag tag = tagService.createTag(title);
        return tag;
    }


    public static Tag showOneTag(int id) {
        Tag tag = tagService.getTagById(id);
        System.out.println("شما این عنوان تگ را انتخاب کرده اید :" + tag);
        return tag;
    }

    public static Article getArticleForAuthor(Author author, int id) {
        Article[] articles = author.getArticles();
        for (Article article : articles) {
            if (article != null) {
                if (article.getId() == id) {
                    return article;
                }
            }
        }
        return null;
    }

    public static boolean loginModerator(String username, String passWord) {
        boolean flag = false;
        if (username.equals("admin") && passWord.equals("admin")) {
            flag = true;
        }
        return flag;
    }

    public static Author[] authores() {
        return authorService.getAllAuthores();

    }

}
