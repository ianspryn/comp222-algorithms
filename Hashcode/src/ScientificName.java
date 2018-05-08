
public class ScientificName {
	private String genus, taxon;

		
	public ScientificName(String genus, String taxon) {
		this.genus = genus;
		this.taxon = taxon;
	}



//	@Override
//	public int hashCode() {
//		int hash = 7;
//		for (char c: genus.toCharArray()) {
//			hash = hash * 31 + c;
//		}
//		for (char c: taxon.toCharArray()) {
//			hash = hash * 31 + c;
//		}
//		return hash;
//	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		for (char c1: genus.toCharArray()) {
			hash *= c1 * 3;
		}
		for (char c2: taxon.toCharArray()) {
			hash *= c2 * 3;
		}
		
		return hash;
	}
}
