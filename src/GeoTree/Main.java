// Практическая работа № 2 - ООП
// Задача 1. Реализовать, с учетом ООП-подхода, приложение для проведения исследований с генеалогическим древом.
// Дополнительно использовать абстрактные классы (People) и интерфейсы (Education).

package GeoTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nЗадача 1. Реализовать с использованием ООП - подхода работу с генеалогическим древом.\nДополнительно использовать абстрактные классы и интерфейсы");
        // формируем список людей для древа
        Person irina = new Person("Ирина", 55, "woman");
        Person ivan = new Person("Иван", 60, "man");
        Person masha = new Person("Маша", 40, "woman");
        Person sasha = new Person("Саша", 42, "man");
        Person lena = new Person("Лена", 8, "woman");
        Person gena = new Person("Гена", 12, "man");
        GeoTree gt = new GeoTree();

        // формируем родственные связи между людьми
        gt.append(irina, Relationship.parent, masha, Relationship.children);
        gt.append(ivan, Relationship.parent, sasha, Relationship.children);

        gt.append(masha, Relationship.wife, sasha, Relationship.husband);

        gt.append(masha, Relationship.parent, lena, Relationship.children);
        gt.append(masha, Relationship.parent, gena, Relationship.children);
        gt.append(sasha, Relationship.parent, lena, Relationship.children);
        gt.append(sasha, Relationship.parent, gena, Relationship.children);

        gt.append(irina, Relationship.grandParent, lena, Relationship.grandChildren);
        gt.append(irina, Relationship.grandParent, gena, Relationship.grandChildren);
        gt.append(ivan, Relationship.grandParent, lena, Relationship.grandChildren);
        gt.append(ivan, Relationship.grandParent, gena, Relationship.grandChildren);

        // выводим на консоль людей и их родственные связи
        System.out.println("\nВ базе данных есть следующие люди, с родственными связями:");
        print(gt, irina, Relationship.parent); // кому Ирина является родителем
        print(gt, ivan, Relationship.parent); // кому Иван является родителем
        System.out.println("");
        print(gt, sasha, Relationship.husband); // кому Саша является мужем
        print(gt, masha, Relationship.wife); // кому Маша является женой
        System.out.println("");
        print(gt, lena, Relationship.children); // кому Лена является дочерью
        print(gt, gena, Relationship.children); // кому Гена является сыном
        System.out.println("");
        print(gt, irina, Relationship.grandParent); // кому Ирина является бабушкой
        print(gt, ivan, Relationship.grandParent); // кому Иван является дедушкой
        System.out.println("");
        print(gt, lena, Relationship.grandChildren); // кому Лена является внучкой
        print(gt, gena, Relationship.grandChildren); // кому Гена является внуком
        System.out.println("\nВ базе данных есть следующие мужчины и женщины:");
        print(gt, Gender.woman); // все женщины
        print(gt, Gender.man); // все мужчины

        // реализуем добавление члена семьи в древо (ввод с консоли)
        System.out.printf("\nУ %s и %s родился еще один ребенок (это мальчик), введите пож-та его в базу данных" +
                " (укажите любое имя и возраст для примера).", masha, sasha);

        Scanner in = new Scanner(System.in); // добавляем нового ребенка через консоль
        System.out.println("\nВведите имя нового ребенка: ");
        String newChildrenName = in.nextLine();
        System.out.println("Введите возраст нового ребенка (цифру): ");
        int newChildrenAge = in.nextInt();
        in.close();
        Person newChildren = new Person(newChildrenName, newChildrenAge, "man");

        // формируем родственные связи нового ребенка
        gt.append(masha, Relationship.parent, newChildren, Relationship.children); // связь нового ребенка с родителями
        gt.append(sasha, Relationship.parent, newChildren, Relationship.children); // связь нового ребенка с родителями
        gt.append(irina, Relationship.grandParent, newChildren, Relationship.grandChildren); // связь нового ребенка с бабушкой
        gt.append(ivan, Relationship.grandParent, newChildren, Relationship.grandChildren);// связь нового ребенка с дедушкой
        System.out.println("\nОбновленная база данных по мужчинам и женщинам: ");
        print(gt, Gender.woman); // все женщины
        print(gt, Gender.man); // все мужчины

        // выводим на консоль людей и их родственные связи, с учетом нового члена семьи
        System.out.println("\nОбновленная база данных по детям и их связям с родителями, бабушкой и дедушкой: ");
        print(gt, lena, Relationship.children); // кому Лена является дочерью
        print(gt, gena, Relationship.children); // кому Гена является сыном
        print(gt, newChildren, Relationship.children); // кто родители нового ребенка
        System.out.println("");
        print(gt, lena, Relationship.grandChildren); // кому Лена является внучкой
        print(gt, gena, Relationship.grandChildren); // кому Гена является внуком
        print(gt, newChildren, Relationship.grandChildren); // кто бабушка и дедушка нового ребенка

        // имплементация интерфейса - Education
        System.out.println("\nИнформация о наличии высшего образования у членов семьи (имплементация интерфейса Education): ");
        System.out.printf("%s, %s - ", masha.getFullName(), sasha.getFullName() ); irina.edu();

        System.out.println("\n_______конец_______");
    }

    static void print(GeoTree tree, Person people, Relationship rs) {
        System.out.printf("%s - %s по отношению к: ", people, rs.toString());
        System.out.println(new Research(tree).spend(people, rs));
    }

    static void print(GeoTree tree, Gender gender) {
        System.out.printf("%s: ", gender);
        System.out.println(new Research(tree).spend(gender));
    }
}