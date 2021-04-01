package fun.yuanjin.common.utils.test;

/**
 * @ClassName MapStructTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-09 14:58
 * @Version 1.0
 */
public class MapStructTest {
    public static void main(String[] args) {
        Person p = new Person(2,"n");
        System.out.println(p.toString());
        Dog dog = CarMapper.INSTANCE.carToCarDto(p);
        System.out.println(dog.toString());
    }
}


class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Dog{
    int age;
    String name;

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
