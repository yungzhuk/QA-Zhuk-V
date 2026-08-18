package lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (contacts.containsKey(lastName)) {
            List<String> list = contacts.get(lastName);
            list.add(phoneNumber);
        } else {
            List<String> list = new ArrayList<>();
            list.add(phoneNumber);
            contacts.put(lastName, list);
        }
    }

    public List<String> get(String lastName) {
        if (contacts.containsKey(lastName)) {
            return contacts.get(lastName);
        } else {
            return new ArrayList<>();
        }
    }
}
