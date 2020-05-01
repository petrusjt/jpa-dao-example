package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookGenerator {
    private Faker faker;

    public BookGenerator(Locale locale)
    {
        faker = new Faker(locale);
    }

    public Book randomBook()
    {
        Book b = Book.builder()
                .author(faker.book().author())
                .available(faker.bool().bool())
                .isbn13(faker.code().isbn13())
                .pages(faker.number().numberBetween(1, 3000))
                .publicationDate(faker.date().past( 600 * 365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .publisher(faker.book().publisher())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.values()))
                .build();
        return b;
    }
}
