package oopsconcept;
import java.util.ArrayList;
import java.util.Scanner;

    class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\n";
        }
    }

    public class AddressBook {
        private ArrayList<Contact> contacts = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            AddressBook addressBook = new AddressBook();
            addressBook.run();
        }

        private void run() {
            while (true) {
                System.out.println("\nAddress Book Management System");
                System.out.println("1. Add Contact");
                System.out.println("2. View All Contacts");
                System.out.println("3. Search Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        viewAllContacts();
                        break;
                    case 3:
                        searchContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        System.out.println("Exiting Address Book Management System.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void addContact() {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Contact newContact = new Contact(name, phoneNumber, email);
            contacts.add(newContact);

            System.out.println("Contact added successfully.");
        }

        private void viewAllContacts() {
            if (contacts.isEmpty()) {
                System.out.println("Address book is empty.");
            } else {
                System.out.println("\nAll Contacts:");
                for (Contact contact : contacts) {
                    System.out.println(contact);
                }
            }
        }

        private void searchContact() {
            System.out.print("Enter the name to search: ");
            String searchName = scanner.nextLine();

            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(searchName)) {
                    System.out.println("\nContact Found:");
                    System.out.println(contact);
                    return;
                }
            }

            System.out.println("Contact not found with the name: " + searchName);
        }

        private void deleteContact() {
            System.out.print("Enter the name to delete: ");
            String deleteName = scanner.nextLine();

            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(deleteName)) {
                    contacts.remove(contact);
                    System.out.println("Contact deleted successfully.");
                    return;
                }
            }

            System.out.println("Contact not found with the name: " + deleteName);
        }
    }

