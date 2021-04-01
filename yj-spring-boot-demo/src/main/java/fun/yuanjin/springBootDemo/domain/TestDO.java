package fun.yuanjin.springBootDemo.domain;

import java.io.Serializable;

/**
 * @ClassName TestDO
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-23 21:57
 * @Version 1.0
 */
public class TestDO implements Serializable {
    private Integer id;
    private Integer count;
    private String name;

    public TestDO(Integer count, String name) {
        this.count = count;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDO{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
