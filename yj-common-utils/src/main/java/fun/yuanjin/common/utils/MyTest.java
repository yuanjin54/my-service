package fun.yuanjin.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-10-12 18:19
 * @Version 1.0
 */
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        Person p1 = new Person(1, "one");
        Person p2 = new Person(2, "two");
        Person p3 = new Person(3, "three");
        Person p4 = new Person(4, "four");
        Person p5 = new Person(5, "five");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        for (Person person : list) {
//            System.out.println(person.toString());
            person.setName(person.getName()+"1");
        }
        for (Person person : list) {
            System.out.println(person.toString());
        }

        Thread.sleep(10000000);

    }
}

class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
