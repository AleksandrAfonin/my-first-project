package ru.otus.java.basic.homework10;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
  private Map<String, String> records;

  public PhoneBook() {
    records = new HashMap<>();
  }

  public void add(String name, String phone) {
    records.put(phone, name);
    System.out.println("An entry has been added. name: " + name + "  phone: " + phone);
  }

  public void find(String name) {
    if (records.isEmpty()) {
      System.out.println("The phone book is empty.");
      return;
    }

    if (!records.containsValue(name)) {
      System.out.println("The phone book does not contain such name");
      return;
    }

    System.out.println(name + ":");
    for (Map.Entry<String, String> rec : records.entrySet()) {
      if (rec.getValue().equals(name)) {
        System.out.println("\t" + rec.getKey());
      }
    }
  }

  public void containsPhoneNumber(String phone) {
    if (records.containsKey(phone)) {
      System.out.println("The phone number " + phone + " contains");
      return;
    }

    System.out.println("The phone number " + phone + " does not contains");
  }
}
