package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("qazwsx@mail.ru", "Bez Prekras");
        hashMap.put("qqqq1234@mail.ru", "Ivanov Ivan");
        hashMap.put("kastruly@mail.ru", "Kastruly Julia");
        hashMap.put("taras@mail.ru", "Don Taras");
        hashMap.put("qazwsx@mail.ru", "Samokat Velosipedov");
        hashMap.put("foodmaster@mail.ru", "Albedo BezObeda");
        hashMap.put("kastruly@mail.ru", "Kastruly Skovorodovna");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " --- " + value);
        }
    }
}
