/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.parser;

/**
 *
 * @author dhaka
 */
public class Person {

    Name name;
    int age;

    public Person() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toJSON() {
        String pattern = "{"
                + "\n\t\"name\" : ${name},"
                + "\n\t\"age\" : \"${age}\","
                + "\n} ";
        return pattern.replace("${name}", name.toJSON().replace("\n", "\n\t"))
                .replace("${age}", age + "");
    }
    
    public static void main(String[] args) {
        Person p = new Person();
        Name n = new Name();
        n.setFirstName("Kshitij");
        n.setLastName("Dhakal");
        p.setName(n);
        p.setAge(22);
        System.out.println(p.toJSON());
    }

}
