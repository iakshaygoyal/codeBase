package lect9.inpol;

public class Client {

	public static void main(String[] args) {
		// Case 1 => reference P, real object P
		P obj1 = new P();

		obj1.Fun();
		obj1.Fun1();
		// obj1.Fun2(); Makes no sense

		System.out.println(obj1.d);
		System.out.println(obj1.d1);

		System.out.println("******************************");
		// Case 2 => reference P, real object C
		P obj2 = new C();

		obj2.Fun();
		obj2.Fun1();
		// obj2.Fun2(); Makes sense, but compiler does not allow it.
		((C) obj2).Fun2();

		System.out.println(obj2.d);
		System.out.println(obj2.d1);
		System.out.println(((C) obj2).d2);

		System.out.println("******************************");
		// Case 3 => reference C, real object P
		// C obj3 = new P(); not allowed.

		System.out.println("******************************");
		// Case 4 => reference C, real object C
		C obj4 = new C();

		obj4.Fun();
		obj4.Fun1();
		obj4.Fun2();

		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		System.out.println(obj4.d);

		// Compile time decisions (return type not part of signature)
		System.out.println(Add(1, 2));
		System.out.println(Add("1", "2"));

		System.out.println(Add(1));
		System.out.println(Add(1, 2));
		System.out.println(Add(1, 2, 3));

		CallFuns(new P());
		CallFuns(new C());

		// P obj = new P();
		// obj.staticFun();
		//
		// obj = new C();
		// obj.staticFun();

		P.staticFun();
		C.staticFun();

		// printLexico(1000);
		printLexicoSingle(1000, 0);
	}

	public static int Add(int... args) {
		int retVal = 0;

		for (int i = 0; i < args.length; i++) {
			retVal += args[i];
		}

		return retVal;
	}

	public static int Add(int i, int j) {
		return i + j;
	}

	public static String Add(String i, String j) {
		return i + j;
	}

	// Invalid overload
	// public static void Add(int i, int j){
	// System.out.println(i + j);
	// }

	public static void CallFuns(P obj) {
		obj.Fun();
		obj.Fun1();
	}

	public static void printLexico(int max) {
		for (int i = 1; i <= 9; i++) {
			printLexicoHelper(max, i);
		}
	}

	public static void printLexicoHelper(int max, int num) {
		if (num > max) {
			return;
		}

		System.out.println(num);

		for (int i = 0; i < 10; i++) {
			printLexicoHelper(max, num * 10 + i);
		}
	}

	public static void printLexicoSingle(int max, int num) {
		if (num > max) {
			return;
		}

		if (num != 0) {
			System.out.println(num);
		}

		for (int i = (num == 0 ? 1 : 0); i < 10; i++) {
			printLexicoSingle(max, num * 10 + i);
		}
	}
}
