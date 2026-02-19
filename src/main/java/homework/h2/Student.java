package homework.h2;

import java.util.List;

//1. Создать класс Student, обязательное поле класса Student - List<Book> (минимум по 5 книг у каждого)
//
// 2. Создать текстовый файл со студентами и книгами
//
//3. При помощи внутренних фреймворков и библиотек для ввода-вывода информации в Java считать содержимое файла и заполнить
// List<Student> этими данными (Должен быть реализован механизм заполнения коллекции студентов из текстового файла)
//
//4. При помощи одного (не допускается объявления никаких промежуточных переменных, совсем никаких) стрима:
//
//Вывести в консоль каждого студента (переопределите toString)
//
//Получить для каждого студента список книг
//
//Получить книги
//
//Отсортировать книги по количеству страниц (Не забывайте про условия для сравнения объектов)
//
//Оставить только уникальные книги
//
//Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
//
//Ограничить стрим на 3 элементах
//
//Получить из книг годы выпуска
//
//При помощи методов короткого замыкания (почитайте самостоятельно что это такое) вернуть Optional от года
//
//При помощи методов получения значения из Optional вывести в консоль год выпуска найденной книги, либо запись о том, что такая книга отсутствует
public class Student {
        private String name;
        private List<Book> books;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;

        return name.equals(student.name) && books.equals(student.books);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + books.hashCode();
        return result;
    }

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
