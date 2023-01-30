package fr.dawan.javafonctionnelle;

import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {
		System.out.println(isPhoneNumberValidePredicate.test("0652585941"));
		
		System.out.println(isPhoneNumberValidePredicate.or(isPhoneNumberValidePredicate07).test("0745484941"));

	}
	
	static boolean isPhoneNumberValide(String phoneNumber) {
		return phoneNumber.startsWith("06") && phoneNumber.length() == 10;
	}
	
	static Predicate<String> isPhoneNumberValidePredicate = 
			phoneNumber -> phoneNumber.startsWith("06") && phoneNumber.length() == 10;
			
	static Predicate<String> isPhoneNumberValidePredicate07 = 
					phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 10;

}
/*
 * Java SE Api: 
 * 
 */
