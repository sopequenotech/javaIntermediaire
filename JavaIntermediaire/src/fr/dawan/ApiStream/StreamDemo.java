package fr.dawan.ApiStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) throws IOException {
		//Pour utiliser l'API Stream, il nous faut une collection d'objets
		
		//Comment charger des données dans un stream:
		
		//Stream à partir d'une liste de valeurs constantes:
		
		Stream<String> streamFromValues = Stream.of("a1","a2","a3");
		
		//Stream from Array
		String[] array = {"a1","a2","a3"};
		Stream<String> streamArray = Arrays.stream(array);
		
		//Stream from file - Charger toutes les lignes dans Stream
		File file = new File("1.tmp");
		Stream<String> fileStream = Files.lines(Paths.get(file.getAbsolutePath()));
		
		//Stream from collection
		Collection<String> myCollection = Arrays.asList("a1","a2");
		Stream<String> collectionStream =  myCollection.stream();
		
		testFilterAndCount();
		testMap();
		testSkipLimit(); //pour la pagination
		testMinMax();
		testSorted();
		testMatch();
		
		

	}

	private static void testMatch() {
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		System.out.println("***********Test Match*************");
		boolean result = collection.stream()
						.anyMatch(s -> s.equals("a4"));
		System.out.println("Any match: "+result);
		
		System.out.println("AllMatch: "+collection.stream().allMatch(s -> s.equals("a")));
		System.out.println("AllMatch: "+collection.stream().allMatch(s -> s.contains("a")));
		System.out.println("NoneMatch: "+collection.stream().noneMatch(s -> s.equals("a4")));
		
	}

	private static void testSorted() {
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		System.out.println("***********Test Sorted**************");
		collection.stream()
		.sorted() //tri croissant par defaut
		.forEach(s -> System.out.println(s));
		
		//Eliminer les doublons à l'affichage
		System.out.println(">>>>> Sans doublons:");
		collection.stream()
		.sorted()
		.distinct()
		.forEach(s -> System.out.println(s));
		
		System.out.println(">>>> Tri inverse:");
		collection.stream()
		.sorted((s1,s2) -> (s1.compareTo(s2)) * -1).forEach(s -> System.out.println(s));
		
	}

	private static void testMinMax() {
		List<People> peoples = new ArrayList<>();
		peoples.add(new People("William", 16, Sex.MAN));
		peoples.add(new People("John", 26, Sex.MAN));
		peoples.add(new People("Helene", 42, Sex.WOMEN));
		peoples.add(new People("Peter", 69, Sex.MAN));
		
		System.out.println("*******Test Min - Max ***********");
		
		//Age max:
		People maxAge = peoples.stream()
						.max((p1,p2) -> ((Integer)p1.getAge()).compareTo((Integer)p2.getAge()))
						.get();
		System.out.println("Age max: "+maxAge.getName());
		
		//Age min:
				People minAge = peoples.stream()
								.min((p1,p2) -> ((Integer)p1.getAge()).compareTo((Integer)p2.getAge()))
								.get();
				System.out.println("Age min: "+minAge.getName());
		
	}

	private static void testSkipLimit() {
	Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
	System.out.println("***********Test SKIL - LIMIT**************");
	//Pagination: 2 éléments par page
	
	collection.stream()
	.skip(0)
	.limit(2)
	.forEach(e -> System.out.println(e));
	
	//page suivante
	System.out.println("Page suivante:");
	collection.stream()
	.skip(2)
	.limit(2)
	.forEach(e -> System.out.println(e));
	
	}

	private static void testMap() {
		List<People> peoples = new ArrayList<>();
		peoples.add(new People("William", 16, Sex.MAN));
		peoples.add(new People("John", 26, Sex.MAN));
		peoples.add(new People("Helene", 42, Sex.WOMEN));
		peoples.add(new People("Peter", 69, Sex.MAN));
		
		System.out.println("*************Test MAP:");
		
		List<PeopleDTO> dtos = peoples.stream()
						.map(p -> new PeopleDTO(p.getName(), p.getAge()))
						.collect(Collectors.toList());
		
		dtos.stream().forEach(d -> System.out.println(d));
						
	}

	private static void testFilterAndCount() {
		System.out.println("********Test Filter And Count***********");
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		//Compter le nombre de a1
		long count =collection.stream()
				.filter("a1"::equals)
				.count();
		System.out.println("Nombre de a1: "+count);
		
		List<People> peoples = new ArrayList<>();
		peoples.add(new People("William", 16, Sex.MAN));
		peoples.add(new People("John", 26, Sex.MAN));
		peoples.add(new People("Helene", 42, Sex.WOMEN));
		peoples.add(new People("Peter", 69, Sex.MAN));
		
		//Le nombre de people apte pour le service militaire: age entre 18 et 27 - de sexe masculin
		System.out.println("****Service militaire*****");
		peoples.stream()
		.filter(p -> p.getAge()>=18 && p.getAge() <= 27 && p.getSex().equals(Sex.MAN))
		.forEach(p -> System.out.println(p.getName()));
		
		//Le nombre de people pouvant travailler: age entre 18 et 65 pour les hommes et 55 pour les femmes
		long nb = peoples.stream()
					.filter(p -> p.getAge() >= 18)
					.filter( p -> (p.getAge() <= 55 && p.getSex().equals(Sex.WOMEN)) 
							|| (p.getAge() <= 65 && p.getSex().equals(Sex.MAN))).count();
		System.out.println("Nb = "+nb);
				
		
		
		
		
	}

}

enum Sex{
	MAN,
	WOMEN
}

class People{
	private String name;
	private int age;
	private Sex sex;
	
	public People(String name, int age, Sex sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, sex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return age == other.age && Objects.equals(name, other.name) && sex == other.sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
}

class PeopleDTO{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public PeopleDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]";
	}
	
	
}
