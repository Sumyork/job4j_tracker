package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{\r\n"
                + "\t\"name\"" + " : \"" + name + "\",\r\n"
                + "\t\"body\"" + " : \"" + body + "\"\r\n"
                + "}";
    }
}
