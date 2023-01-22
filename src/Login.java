import java.util.Scanner;

public class Login {
	void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Authorized person's Name");
		String name = sc.nextLine();
		System.out.println("Enter Authorize Id  ");
		String Id = sc.next();
		if ((Id.equals("election2023")) && (name.equals("Gopal"))) {
			System.out.println("Authorized login successfully ");
		} else {
			System.out.println("you are not authorize person ");
			System.exit(1);
		}

	}
}
