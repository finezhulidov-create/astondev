package mod2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiTask {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Hello, how are you?",
                "I hope you are doing well.",
                "Hello, again!",
                "You are welcome."
        );

// подсчитать количество уникальных слов
        Long unique = sentences.stream()
                .flatMap(str -> Arrays.stream(str.split("[\\s\\p{Punct}]")))
                .map(String::toLowerCase)
                .distinct().count();
        System.out.println(unique);
// самая повторяемая буква в листе
        /*
        * 1. создаем стрим строк
        * 2. создаем из стрима строк стрим кодов символов
        * 3. создаем стрим Character из стрима кодов символов
        * 4. оставляем только буквыенные символы
        * 5. собираем стрим в Мапу ключи буквы, значения повторения
        * 6. максимальное значение пары вычисляем
        * 7. получаем опшинал от ключа
        *
        * */
        String mostCommonChar = sentences.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('&').toString();

        System.out.println(mostCommonChar);
        System.out.println();

        //Расшифровать и вывести в одну строку разделенную запятыми. Алгоритм шифрования Base64
        List<List<String>> lists = List.of(
                List.of("SGUxMTExbC0tMGxvMjEyMy4uLi8v", "dzBvcjFsZA=="),
                List.of("aW4=", "dGgxMTExMjMyaXM="),
                List.of("YmVhdXQxMjNpZjMxMnVs", "ZGF5"));

        String decoded = lists.stream()
                .flatMap(List::stream)
                .map(s -> new String(Base64.getDecoder().decode(s)))
                .map(s -> s.replaceAll("[^a-zA-Z]",""))
                .collect(Collectors.joining(", "));

        System.out.println(decoded);
        System.out.println();

        //Собрать статистику по коллекции (максимальный, минимальный, сумма всех элементов, среднее арифметическое, количество элементов) за один проход по коллекции
        List<Integer> list = List.of(1, 1, 1, 1, 1, 1, 3, 2, 4, 5, 6, 7, 8);
        IntSummaryStatistics statistics = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println(statistics.getMax()+" "
                +statistics.getMin()+" "
                + statistics.getAverage()+" "
                + statistics.getSum()+" "
                + statistics.getCount());

        System.out.println();

        // входные данные
        List<Employee> employees = List.of(
                new Employee("Alex", "IT", true, "alex@dev.com", 100.0, List.of()),
                new Employee("Bob", "HR", true, "bob@dev.com", 80.0, List.of("88005553535")),
                new Employee("Charles", "IT", false, "charles@dev.com", 60.0, List.of("123456"))
        );

// найти сотрудника с наибольшей зп
        Double maxSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary)
                .orElse(null);
        System.out.println(maxSalary);
// найти сотрудников с наибольшей зп в каждом департаменте
        Map<String, Optional<Employee>> maxSalariesByDepartments = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Function.identity(),
                        Collectors.reducing(BinaryOperator.maxBy(
                                Comparator.comparing(Employee::getSalary))))));
        maxSalariesByDepartments.forEach((dept, optEmpl ) ->
                System.out.println(dept + " -> " + optEmpl.map(Employee::getName).orElse("No Employee")) );

// вывести все телефоны всех работников у кого они есть, в списке должны быть отсортированы по уменьшению длины номера
        List<String> phones = employees.stream()
                .flatMap(emp -> emp.getPhones().stream())
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();
        System.out.println(phones);
// получаем список зарплат только fullTime работников.
// При этом "IT" повышаем зарплату на 20%. Сортируем по зарплате
        Map<Employee, Double> fullTimeSalaries = employees.stream()
                .filter(Employee::isFullTime)
                .collect(Collectors.toMap(
                        Function.identity(), emp -> emp.getDepartment()
                                .equalsIgnoreCase("IT")
                                ? emp.getSalary() * 1.2 : emp.getSalary(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)-> e1,
                        LinkedHashMap::new
                ));
        fullTimeSalaries.entrySet()
                .forEach(System.out::println);
    }
}
