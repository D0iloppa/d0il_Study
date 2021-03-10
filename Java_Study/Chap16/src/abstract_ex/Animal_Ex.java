package abstract_ex;

public class Animal_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println("--------------------");
		
		Animal animal = new Dog();
		
		animal.sound();
		animal = new Cat();
		animal.sound();
	//	animal.name = "°í¾ç¾²";
		
		animalSound(new Dog());
		animalSound(new Cat());
		
	
		
		

	}
	
	static void animalSound(Animal animal) { animal.sound(); }

}
