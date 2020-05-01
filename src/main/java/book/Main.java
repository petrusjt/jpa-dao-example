package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

import java.util.List;
import java.util.Locale;

public class Main {
    private static int NUMBER_OF_BOOKS = 1000;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        Locale locale = new Locale("hu");
        BookGenerator bookGenerator = new BookGenerator(locale);
        for(int i = 0; i < NUMBER_OF_BOOKS; i++)
        {
            bookDao.persist(bookGenerator.randomBook());
        }

        List<Book> bookList = bookDao.findAll();

        bookList.stream().forEach(System.out::println);
    }
}
