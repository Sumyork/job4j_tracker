package ru.job4j.oop;

public class Jukebox {
    public String music(int position) {
        String song = switch (position) {
            case 1 -> "Пусть бегут неуклюже.";
            case 2 -> "Спокойной ночи.";
            default -> "Песня не найдена.";
        };
        return song;
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        System.out.println(jukebox.music(1));
        System.out.println(jukebox.music(2));
        System.out.println(jukebox.music(4));
    }
}
