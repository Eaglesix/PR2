
public class LottoZahlenAnzahl implements Comparable<LottoZahlenAnzahl>{
	private int zahl;
	private int counter;
	public LottoZahlenAnzahl(int zahl) {
		super();
		this.zahl = zahl;
		counter = 1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + counter;
		result = prime * result + zahl;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LottoZahlenAnzahl other = (LottoZahlenAnzahl) obj;

		if (zahl != other.zahl)
			return false;
		
		return true;
	}
	public int getCounter() {
		return counter;
	}
	public void increment() {
		this.counter++;
	}
	public int getZahl() {
		return zahl;
	}
	@Override
	public String toString() {
		return "LottoZahlenAnzahl [zahl=" + zahl + ", counter=" + counter + "]";
	}
	@Override
	public int compareTo(LottoZahlenAnzahl o) {
		// TODO Auto-generated method stub
		if (counter > o.counter)
			return -1;
		if (counter < o.counter)
			return 1;
		return 0;
	}
	
	
}
