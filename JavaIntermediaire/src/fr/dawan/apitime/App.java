package fr.dawan.apitime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		//Avant Java 8 java.util.date
		Date date = new Date();
		
		//A partir de Java 8: utilisation du package Java.time - LocalDate - LocalTime - LocalDateTime 
		//- Period - Instant - Duration
		
		LocalDate d = LocalDate.now(); //date du jour
		LocalDate d2 = LocalDate.of(2018, 5, 25);
		
		LocalTime t = LocalTime.now(); 
		LocalTime t2 = LocalTime.of(16,15,25);
		
		LocalDateTime dt = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.of(2015,10,2,12,45,26);
		
		//Period: différence entre dates
		Period p = Period.between(LocalDate.of(2015, 12, 25), LocalDate.now());
		
		System.out.println("Nombre de jours: "+p.getDays());
		
		//Il existe des enums répertoriants les jours de la semaine, les mois
		
		DayOfWeek dow = DayOfWeek.FRIDAY;
		Month janvier = Month.JANUARY;
		
		LocalDate l3 = LocalDate.of(2020, Month.AUGUST, 25);
		
		//Instant: un point précis dans le temps
		Instant ins1 = Instant.now();
		System.out.println(ins1);
		
		int nano = ins1.getNano();
		System.out.println("nano: "+nano);
		
		//Duration - durée: une différence entre 2 instants
		Instant ins2 = Instant.parse("2022-05-31T14:25:23.390131400Z");
		
		Duration duree = Duration.between(ins1, ins2);
		
		
		

	}

}
