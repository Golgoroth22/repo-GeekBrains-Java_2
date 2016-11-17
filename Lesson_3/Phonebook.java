package java_2.lesson_3;

import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 12.11.2016.
 */
public class Phonebook {
    ArrayList<PhoneNote> phoneNotes = new ArrayList<>();

    public void addNote(String surname, String phoneNumber, String email) {
        phoneNotes.add(new PhoneNote(surname, phoneNumber, email));
    }

    public void findNumber(String surmane) {
        for (PhoneNote phoneNote : phoneNotes) {
            if (phoneNote.getSurname().equals(surmane)) {
                System.out.println(surmane + " phone is " + phoneNote.getPhoneNumber());
            }
        }
    }

    public void findEmail(String surname) {
        for (PhoneNote phoneNote : phoneNotes) {
            if (phoneNote.getSurname().equals(surname)) {
                System.out.println(surname + " email is " + phoneNote.getEmail());
            }
        }
    }
}
