import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //One of the Thread() constructor receives a Runnable argument
        //It helps to implement functional interfaces (That have only one method)
        //If it had more I couldn't just implement it with a lambda, it would be different
        new Thread(() -> System.out.println("Printing from Runnable")).start();

        new Thread(() -> {
           System.out.println("Printing from runnable 2");
           System.out.println("Line 2");
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buckala", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee daniel = new Employee("Daniel Campuzano", 27);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jack);
        employees.add(tim);
        employees.add(daniel);

        Collections.sort(employees, (emp1, emp2) ->
                emp1.getName().compareTo(emp2.getName()) );

        employees.forEach((employee) -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
        /*for(Employee emp : employees) {
            //I can print emp inside the lambda because emp is efectively final
            //Every iteration a variable is created inside the for loop
            System.out.println(emp.getName());
            new Thread(() -> System.out.println(emp.getAge())).start();
        }*/

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        //ANOTHER WAY APPART FROM THE CODE ABOVE
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return  uc.upperAndConcat(s1, s2);
    }

}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface  UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething(){
        int i = 0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is "+ getClass().getSimpleName());
            //System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The another class's name is: "+ getClass().getSimpleName());

        return Main.doStringStuff(uc, "String1", "String2");

/*        System.out.println("The another class's name is: "+ getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase()+s2.toUpperCase();
            }
        }, "String1", "String2");*/
    }
}
