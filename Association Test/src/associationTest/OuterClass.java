package associationTest;

public class OuterClass {
	String text;
	InnerClass ic2;
	private int testNumber = 15;

	public OuterClass() {
		this.text = "Outer Class";
		ic2 = new InnerClass();
	}

	public class InnerClass {
		String text = "Inner Class";
		
		public InnerClass() {
			this.text = "Inner Class";
			System.out.println(testNumber);
		}
	}
}
