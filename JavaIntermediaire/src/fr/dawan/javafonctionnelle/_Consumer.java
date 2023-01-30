package fr.dawan.javafonctionnelle;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		
		Contact c = new  Contact("Julien", "0612151817");
		afficherContact(c);
		afficherContactConsumer.accept(c);
		
		afficherContactBiConsumer.accept(c, false);
		

	}
	
	static void afficherContact(Contact c) {
		System.out.println(c);
	}
	
	static Consumer<Contact> afficherContactConsumer = c -> System.out.println(c);
	static BiConsumer<Contact, Boolean> afficherContactBiConsumer = (c, showPhoneNumber) ->
	System.out.println("Bonjour "+c.getContactName()+" merci pour votre enregistrement, tél: "
			+(showPhoneNumber ? c.getPhoneNumber() : "*************"));

}

class Contact {
	private String contactName;
	private String phoneNumber;

	public Contact(String contactName, String phoneNumber) {
		super();
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
