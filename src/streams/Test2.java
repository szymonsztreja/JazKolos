package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Person> people = getPeople();

    // Filter
        List<Person> females  = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
//        females.forEach(System.out::println);
    // Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
//        sorted.forEach(System.out::println);
    // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);
    // Any match
        boolean anymatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        System.out.println(anymatch);
    // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);
    // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person.getName());
                });
//        Optional<Person> max =  people.stream()
//                .max(Comparator.comparing(Person::getAge));
//        System.out.println(max);

    // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        Optional<String> oldestFemaleInList = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        System.out.println(oldestFemaleInList);


    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
