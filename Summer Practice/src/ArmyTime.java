import java.util.*;

public class ArmyTime {
	public static void main(String[] args) {
		String s = "12:05:45PM";
		System.out.println(timeConversion(s));
	}
	
	static String timeConversion(String s) {
        Scanner scnr = new Scanner(s);
        char time = s.charAt(8);
        scnr.useDelimiter(":");
        String[] parts = {scnr.next(), scnr.next(), ""};
        Scanner seconds = new Scanner(scnr.next());
        seconds.useDelimiter("[A-Z]");
        parts[2] += seconds.next() + seconds.next();
        switch (time) {
            case 'A':
                if (parts[0].equals("12")) {
                    parts[0] = Integer.toString(Integer.parseInt(parts[0]) - 12);
                }
                break;
            case 'P':
                 if (!parts[0].equals("12")) {
                    parts[0] = Integer.toString(Integer.parseInt(parts[0]) + 12);
                }
                break;
        }
        
            String newTime = parts[0] + ":" + parts[1] + ":" + parts[2];
            return newTime;

    }
	
}
