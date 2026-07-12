package task4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList(
                "Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        long personsBefore18 = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();
        System.out.println(personsBefore18);

        List<String> personsForArmy = persons.stream()
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(personsForArmy);

        List<Person> personsWorkableMan = persons.stream()
                .filter(sex -> sex.getSex() == Sex.MAN)
                .filter(age -> age.getAge() >= 18 && age.getAge() < 65)
                .collect(Collectors.toList());

        List<Person> personsWorkableWoman = persons.stream()
                .filter(sex -> sex.getSex() == Sex.WOMAN)
                .filter(age -> age.getAge() >= 18 && age.getAge() < 60)
                .collect(Collectors.toList());

        List<Person> personList = Stream.of(personsWorkableWoman, personsWorkableMan)
                .flatMap(List::stream)
                .filter(ed -> ed.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(personList);
    }
}
