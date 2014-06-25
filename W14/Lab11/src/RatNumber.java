//this class represents rational numbers.
public class RatNumber {
	int numer;
	int denom;

	RatNumber(int numer, int denom){
		this.numer = numer;
		this.denom = denom;
	}

	public int getNumer() {
		return this.numer;
	}
	
	public int getDenom() {
		return this.denom;
	}
	
	public RatNumber add(RatNumber rn) {
		//if the denoms are the same just add the numerators
		if (this.denom == rn.getDenom()) {
			int newNumer = this.numer + rn.getNumer();
			int newDenom = this.denom;
			
			//simplify the rational number
			return simplify(newNumer, newDenom);
			
		//if denoms are different convert the rat numbers
		//so they have the same denominators
		} else {
			//convert first rat number
			int numer1 = this.numer * rn.getDenom();
			int denom1 = this.denom * rn.getDenom();
			//convert second rat number
			int numer2= rn.getNumer() * this.denom;
			int denom2 = rn.getDenom() * this.denom;
			
			int newNumer = numer1 + numer2;
			int newDenom = denom1;
			
			return simplify(newNumer, newDenom);
		}
	}
	
	public RatNumber simplify(int newNumer, int newDenom) {
		int simpNumer = newNumer;
		int simpDenom = newDenom;
		
		//check to see if the numerator divides the denominator
		for (int i = 1; i<=newNumer; i++) {
			if(newDenom%i==0 && simpNumer%i==0) {
				simpNumer = newNumer/i;
				simpDenom = newDenom/i;
			}
		}
		RatNumber simp = new RatNumber(simpNumer, simpDenom);
		return simp;
	}
	
	public RatNumber subtract(RatNumber rn) {
		//if denoms are the same subtract the numerators
		if (this.denom == rn.getDenom()) {
			int newNumer = this.numer - rn.getNumer();
			int newDenom = this.denom;
			
			return simplify(newNumer, newDenom);
		//else convert the numbers
		} else {
			//convert first rat number
			int numer1 = this.numer * rn.getDenom();
			int denom1 = this.denom * rn.getDenom();
			
			//convert second rat number
			int numer2= rn.getNumer() * this.denom;
			int denom2 = rn.getDenom() * this.denom;
			
			int newNumer = numer1 - numer2;
			int newDenom = denom1;
			
			return simplify(newNumer, newDenom);
		}
	}
	
	public RatNumber multiply(RatNumber rn) {
		//just multiply straight across
		int newNumer = this.numer * rn.getNumer();
		int newDenom = this.denom * rn.getDenom();
		
		return simplify(newNumer, newDenom);
	}
	
	public RatNumber divide(RatNumber rn) {
		//multiply by the reciprocal
		int newNumer = this.numer * rn.getDenom();
		int newDenom = this.denom * rn.getNumer();
		
		return simplify(newNumer, newDenom);
	}
}
