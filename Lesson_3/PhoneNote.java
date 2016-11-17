package java_2.lesson_3;

/**
 * Created by Валентин Фалин on 12.11.2016.
 */
public class PhoneNote {
    private String surname;
    private String phoneNumber;
    private String email;

    public PhoneNote(String surname, String phoneNumber, String email) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
