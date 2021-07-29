package function.entity;

/**
 * @author tusong
 * @version V1.0
 * @Package function.entity
 * @ClassName Employee.java
 * @date 2021/7/12
 * @Description: 此处添加类描述……
 */
public class Employee {

    private String name;

    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
