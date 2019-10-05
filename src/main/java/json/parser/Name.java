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
public class Name {

    String firstName = "";
    String middleName = "";
    String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toJSON() {
        String pattern = "{"
                + "\n\t\"firstName\" : \"${firstName}\","
                + "\n\t\"middleName\" : \"${middleName}\","
                + " \n\t\"lastName\" : \"${lastName}\""
                + "\n} ";
        return pattern.replace("${firstName}", firstName)
                .replace("${middleName}", middleName)
                .replace("${lastName}", lastName);
    }

    public static void main(String[] args) {
        Name name = new Name();
        name.setFirstName("Kshitij");
        name.setLastName("Dhakal");
        System.out.println(name.toJSON());
    }

}
