package HASH;

import java.util.Hashtable;

public class HASHMAP_implementaion {
    static Hashtable<String, ContactDetail> hashtable = new Hashtable<>();

    void addContact(ContactDetail contactDetail) {
        if (hashtable.containsKey(contactDetail.getName())) {
            System.out.println("CollisionHappen - " + contactDetail.getName() + " Already exists");
        }
        hashtable.put(contactDetail.getName(), contactDetail);
    }

    ContactDetail searchContact(String name) {
        if (hashtable.containsKey(name)) {
            return hashtable.get(name);
        } else {
            return null;
        }
    }

    void removeContact(String name) {
        if (hashtable.containsKey(name)) {
            hashtable.remove(name);
        }
    }

    void removeAllContacts() {
        hashtable.clear();
    }

    public static void main(String[] args) {
        HASHMAP_implementaion phoneBookUsingHashTable = new HASHMAP_implementaion();

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setName("Deepak");
        contactDetail.setPhoneNumber(123L);
        phoneBookUsingHashTable.addContact(contactDetail);

        ContactDetail contactDetail1 = new ContactDetail();
        contactDetail1.setName("Avi");
        contactDetail1.setPhoneNumber(456L);
        phoneBookUsingHashTable.addContact(contactDetail1);

        ContactDetail contactDetail2 = new ContactDetail();
        contactDetail2.setName("Amam");
        contactDetail2.setPhoneNumber(789L);
        phoneBookUsingHashTable.addContact(contactDetail2);

        System.out.println(phoneBookUsingHashTable.searchContact("Deepak"));
        phoneBookUsingHashTable.removeContact("Deepak");
        System.out.println("----- removing contact ---------");
        System.out.println(phoneBookUsingHashTable.searchContact("Deepak"));
// phoneBookUsingHashTable.removeAllContacts();
        phoneBookUsingHashTable.printHashTable();
// System.out.println(hashtable);

    }

    private void printHashTable() {
        hashtable.forEach((name, contactDetail) -> {
            System.out.println("Name : " + name + " | Phone Number : " + contactDetail.getPhoneNumber());
        });



    }
}
class ContactDetail {

    private String name;

    private Long phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ContactDetail : {" +
                "name='" + name + '\'' +
                ", phone number=" + phoneNumber +
                '}';
    }
}