package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSurname("Leshkevich");
        student.setGroup("OB-32");
        student.setYearOfAdmission(2023);
        System.out.println(student.getSurname() + " group " + student.getGroup() + ", "
            + student.getYearOfAdmission());
    }
}
