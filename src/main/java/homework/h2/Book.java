package homework.h2;

public class Book {
    private final String title;
    private final Integer yearOfRelease;
    private final Integer numberOfPages;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;

        return title.equals(book.title) && yearOfRelease.equals(book.yearOfRelease) && numberOfPages.equals(book.numberOfPages);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + yearOfRelease.hashCode();
        result = 31 * result + numberOfPages.hashCode();
        return result;
    }

    public Book(String title, Integer yearOfRelease, Integer numberOfPages) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }


    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
