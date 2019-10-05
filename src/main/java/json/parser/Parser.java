/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.parser;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhaka
 */
public class Parser {

    private String json = "";
    private final Map<String, Object> map;

    public Parser(String json) {
        this.map = new HashMap<>();
        this.json = json;
        q0(0);
    }

    public Object parse(String key) {
        return map.get(key);
    }

    private void q0(int i) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t' || json.charAt(i) == ' ') {
            q0(++i);
        } else {
            if (this.json.charAt(i) == '{') {
                q1(++i);
            }
        }
    }

    private void q1(int i) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t' || json.charAt(i) == ' ') {
            q1(++i);
        } else {
            if (json.charAt(i) == '"') {
                q2(++i, "");
            }
        }
    }

    private void q2(int i, String key) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t') {
            q2(++i, key);
        } else {
            if (json.charAt(i) == '"') {
                q3(++i, key);
            } else if (Character.isAlphabetic(json.charAt(i)) || json.charAt(i) == '-') {
                q2(++i, key + json.charAt(i - 1));
            }
        }
    }

    private void q3(int i, String key) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t' || json.charAt(i) == ' ') {
            q3(++i, key);
        } else {
            if (json.charAt(i) == ':') {
                q4(++i, key, "");
            }
        }
    }

    private void q4(int i, String key, String value) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t' || json.charAt(i) == ' ') {
            q4(++i, key, value);
        } else {
            if (json.charAt(i) == '"') {
                q5(++i, key, value);
            } else if (json.charAt(i) == '{') {
                int j = i;
                char ch = json.charAt(j);
                while (ch != '}') {
                    j++;
                    ch = json.charAt(j);
                }
                String var = json.substring(i, j + 1);
                Parser parser = new Parser(json.substring(i, j + 1).replaceAll("\n\t", "\n"));
                i = j;
                map.put(key, parser);
                //no need to remove , only remove } 
                q6(i + 1);
            }
        }
    }

    private void q5(int i, String key, String value) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t') {
            q5(++i, key, value);
        } else {
            if (json.charAt(i) == '"') {
                map.put(key, value);
                q6(++i);
            } else if (Character.isLetterOrDigit(json.charAt(i)) || json.charAt(i) == ' ') {
                q5(++i, key, value + json.charAt(i - 1));
            }
        }
    }

    private void q6(int i) {
        String d = json.substring(i);
        if (json.charAt(i) == '\n' || json.charAt(i) == '\t' || json.charAt(i) == ' ') {
            q6(++i);
        } else {
            if (json.charAt(i) == ',') {
                q1(++i);
            } else if (json.charAt(i) == '}') {
                q7();
            }
        }
    }

    private void q7() {
        System.out.println("JSON has been parsed!!");
    }

    @Override
    public String toString() {
        return json; //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Person p = new Person();
        Name n = new Name();
        n.setFirstName("Kshitij");
        n.setMiddleName("Prashad");
        n.setLastName("Dhakal");
        p.setName(n);
        p.setAge(22);
        Parser parser = new Parser(p.toJSON());
        System.out.println(parser);
        Parser name = (Parser) parser.parse("name");
        System.out.println("name : " + name.parse("firstName") + " " + name.parse("middleName") + " " + name.parse("lastName"));
        System.out.println("age : " + parser.parse("age"));
    }

}
