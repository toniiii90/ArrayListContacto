import java.util.ArrayList;

class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber=myNumber;
        this.myContacts=new ArrayList<>();
    }

    public boolean addNewContact(Contacto contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        int index = findContact(oldContact);
        if (index != -1 && findContact(newContact)== -1) {
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contacto contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public Contacto queryContact(String name) {
        int index = findContact(name);
        if (index != -1) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " \u2192 " + myContacts.get(i).getPhoneNumber());
        }
    }

    public int findContact(Contacto contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i=0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addContact(Contacto contact) {
        myContacts.add(contact);
    }
}
