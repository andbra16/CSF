import java.util.List;


public class CupidProfile {
	String name;
	CupidPet pet;
	CupidZodiac zodiac;
	CupidSmoker smoker;
	
	CupidProfile (String name, CupidPet pet, CupidZodiac zodiac, CupidSmoker smoker) {
		this.name = name;
		this.pet = pet;
		this.zodiac = zodiac;
		this.smoker = smoker;
	}
	
	CupidProfile getBestMatch(List<CupidProfile> others) {
		int matches1 = 0;
		int matches2 = 0;
		
		CupidProfile match1 = others.get(0);
		CupidProfile match2 = others.get(1);
		
		//test for pet match
		if (match1.pet.equals(this.pet)) {
			matches1++;
		}
		if (match2.pet.equals(this.pet)) {
			matches2++;
		}
		
		//test for zodiac match or zodiac unmatch
		CupidZodiac firstMatch = this.zodiac.findFirstMatch();
		CupidZodiac secondMatch = this.zodiac.findSecondMatch();
		CupidZodiac opposite = this.zodiac.findOpposite();
		
		if (firstMatch.equals(match1.zodiac) || secondMatch.equals(match1.zodiac)) {
			matches1++;			
		}
		if (opposite.equals(match1.zodiac)) {
			matches1--;
		}
		
		if (firstMatch.equals(match2.zodiac) || secondMatch.equals(match2.zodiac)) {
			matches2++;			
		}
		if (opposite.equals(match2.zodiac)) {
			matches2--;
		}
		
		//test for smoker
		
		if (match1.smoker.equals(this.smoker)) {
			matches1++;
		} else {
			matches1--;
		}
		if (match2.smoker.equals(this.smoker)) {
			matches2++;
		} else {
			matches2--;
		}
		
		if (matches1 >= matches2) {
			return match1;
		} else {
			return match2;
		}
	}
}
