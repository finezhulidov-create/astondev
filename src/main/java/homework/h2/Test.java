package homework.h2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class Test {
    public static void main(String[] args) {
        String filePath = "src/main/java/homework/h2/resources/StudentsNDBooks.txt";
        try (Stream<String> line = Files.lines(Paths.get(filePath))){
            Map<String, String> studentsAndBook = new HashMap<>();
            Iterator<String> iterator = line.iterator();
            while (iterator.hasNext()){
                String name = iterator.next();
                String book = iterator.hasNext() ? iterator.next() : "";
                studentsAndBook.put(name, book);
            }
            Optional<Integer> result = studentsAndBook.entrySet().stream()
                    .map(entry -> {
                        System.out.println("Рассматриваемый студент: " + entry.getKey());
                        List<Book> books = Arrays.stream(entry.getValue().split(";"))
                                .map(part ->{
                                    String[] dataBook = part.split(",") ;
                                    return new Book(dataBook[0].trim(),
                                            Integer.parseInt(dataBook[1].trim()), Integer.parseInt(dataBook[2].trim()));
                                })
                                .toList();
                        return new Student(entry.getKey(), books);
                    })
                    .peek(System.out::println)
                    .flatMap(student -> student.getBooks().stream())
                    .sorted(Comparator.comparing(Book::getNumberOfPages))
                    .distinct()
                    .filter(book -> book.getYearOfRelease() > 2000)
                    .limit(3)
                    .map(Book::getYearOfRelease)
                    .findFirst();
            System.out.println(result.map(year -> "Год найденной книги: " + year)
                    .orElse("Книга не найдена"));
            System.out.println("Год: " + result.orElse(-1));
            if (result.isPresent()){
                System.out.println( result.get());
            } else {
                System.out.println("Год не найден");
            }


        } catch (IOException e){
            System.out.println("File not found in this directory: " + filePath);
        }
    }
}
