
public class BirthdaySong {
	String secondLine;
	String animal;
	String verb;
	
	BirthdaySong(String secondLine, String animal, String verb) {
		this.secondLine = secondLine;
		this.animal = animal;
		this.verb = verb;
		}
	
	String toSong() {
		String result= "Happy birthday to you. \n";
		result= result + this.secondLine + "\n";
		result= result + "You look like a " + this.animal + ".\n";
		result= result + "And you " + this.verb + " like one too.";
		return result;
		}
	
	public static void main (String[] args) {
		BirthdaySong song= new BirthdaySong("You hate your party.","disgruntled employee", "act");
		String songString= song.toSong();
		System.out.println(songString);
	}
	
}
