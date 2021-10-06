package associationTest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person p1 = new Person("Joseph", 75000, new Wallet(50), new BankAccount(12000));
//		System.out.println(p1);

		//wrong - OuterClass.InnerClass ic2 = new OuterClass.InnerClass();
		
		//OuterClass.InnerClass ic3 = new oc1.InnerClass();
//		OuterClass oc1 = new OuterClass();
//		//OuterClass.InnerClass ic1 = oc1.new InnerClass();
//		
//		System.out.println(oc1.text);
//		System.out.println(oc1.ic2.text);
		Album abbyRoad = new Album("Abby Road", "The Beatles", 1969);
		abbyRoad.songAdd("Come Together", "4", "19");
		abbyRoad.songAdd("Something", "3", "02");
		abbyRoad.songAdd("Maxwell's Silver Hammer", "3", "27");
		abbyRoad.songAdd("Oh! Darling", "3", "27");
		abbyRoad.songAdd("Octopus's Garden", "2", "51");
		abbyRoad.songAdd("I Want You (She's So Heavy)", "7", "47");
		
		abbyRoad.display();
		
	}

}
