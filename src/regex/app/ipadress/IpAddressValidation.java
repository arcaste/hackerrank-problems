package regex.app.ipadress;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class IpAddressValidation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfLines = in.nextInt();
		in.nextLine();
		if (numberOfLines <= 50) {
			for (int i = 0; i < numberOfLines; i++) {
				String myText = in.nextLine();

				Pattern p1 = Pattern.compile(
						"^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])[.]([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])[.]([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])[.]([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$");
				Matcher m1 = p1.matcher(myText);

				if (m1.find())
					System.out.println("IPv4");
				else {
					Pattern p2 = Pattern.compile(
							"^([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})[:]([0-9a-fA-F]{1,4})$");
					Matcher m2 = p2.matcher(myText);

					if (m2.find())
						System.out.println("IPv6");
					else
						System.out.println("Neither");
				}
			}
		}
	}
}
