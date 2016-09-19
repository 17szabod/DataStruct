package assignment2;

public class LinkedStringLogTester {
	public static void main(String[] args) {
		LinkedStringLog log1 = new LinkedStringLog("log1");
		LinkedStringLog log2 = new LinkedStringLog("log2");
		log1.insert("Hi");
		log1.insert("Name");
		log1.insert("My");
		log1.insert("Is");
		log1.insertLast("Marley");
		log1.insert("Bob");
		
		log2.insert("Hi");
		log2.insertLast("Marley");
		log2.insert("Name");
		log2.insert("My");
		log2.insert("Is");
		log2.insert("Bob");
		
		System.out.println(log1.toString());
		System.out.println(log2.toString());
		System.out.println(log1.equals(log2));
	}

}