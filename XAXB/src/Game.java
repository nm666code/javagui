import java.security.SecureRandom;
public class Game {
	
	private String easyAns, hardAns;
	
	public String genEasyAns() {
		int rand;
		String out = new String();
		SecureRandom srand = new SecureRandom();
		while(out.length()<4) {
			rand = srand.nextInt(10);
			if(out.indexOf(rand+'0')==-1)
				out+=(char)(rand+'0');
		}
		return out;
	}
	
	public String genHardAns() {
		int rand;
		String out = new String();
		SecureRandom srand = new SecureRandom();
		char ch;
		while(out.length()<4) {
			rand = srand.nextInt(36);
			if(rand < 10)
				ch = (char)(rand+'0');
			else
				ch = (char)(rand+'A'-10);
			if(out.indexOf(ch)==-1)
				out+=(char)(rand+'0');
		}
		return out;
	}
	
	public String checkXAXB(String ans, String input) {
		int A = 0, B = 0;
		String out = new String();
		for(int i = 0; i < ans.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(ans.toUpperCase().charAt(i) == input.toUpperCase().charAt(j)) {
					if(i == j)
						A++;
					else
						B++;
				}
			}
		}
		out = (char)(A+'0')+"A"+(char)(B+'0')+"B";
		return out;
	}

	public String getEasyAns() {
		return easyAns;
	}

	public void setEasyAns(String easyAns) {
		this.easyAns = easyAns;
	}

	public String getHardAns() {
		return hardAns;
	}

	public void setHardAns(String hardAns) {
		this.hardAns = hardAns;
	}
}
