package math;



public class Vektor2D {
	public double x;
	public double y;

	public Vektor2D() {
		this(0, 0);
	}
	
	public Vektor2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vektor2D Round() {

		this.x = LineareAlgebra.Round(this.x);
		this.y = LineareAlgebra.Round(this.y);
		return this;
	}

	/**
	 * Mit sub wird vom Vektor, auf den die Fuktion angewendet wird, ein zweiter
	 * subtrahiert
	 * 
	 * @param v
	 *            übergibt einen Vektor2D, der vom Anwender subtrahiert werden
	 *            soll
	 * @return liefert das Ergebnis als Vektor2D zurück.
	 */
	public Vektor2D sub(Vektor2D v) {
		this.x = LineareAlgebra.sub(this.x, v.x);
		this.y = LineareAlgebra.sub(this.y, v.y);
		return this;
	}

	/**
	 * Mit add wird auf den Vektor, auf den die Fuktion angewendet wird, ein
	 * zweiter addiert
	 * 
	 * @param v
	 *            übergibt einen Vektor2D, der auf den Anwender addiert werden
	 *            soll
	 * @return liefert das Ergebnis als Vektor2D zurück.
	 */
	public Vektor2D add(Vektor2D v) {
		this.x = LineareAlgebra.add(this.x, v.x);
		this.y = LineareAlgebra.add(this.y, v.y);
		return this;
	}

	/**
	 * mult berechnet das Produkt aus dem Vektor auf den die Funktion angewendet
	 * wird und einem double-Wert
	 * 
	 * @param skalar
	 *            nimmt den double Wert mit dem multipliziert werden soll
	 *            entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor2D zurück
	 */
	public Vektor2D mult(double skalar) {
		this.x = LineareAlgebra.mult(this.x, skalar);
		this.y = LineareAlgebra.mult(this.y, skalar);
		return this;
	}

	/**
	 * Die Funktion div berechnet den Quotient aus dem Vektor auf den es
	 * angewendet wird und einem double-Wert
	 * 
	 * @param skalar
	 *            nimmt den double Wert mit dem dividiert werden soll entgegen
	 * @return liefert das Ergebnis der Division als Vektor2D zurück
	 */
	public Vektor2D div(double skalar) {
		this.x = LineareAlgebra.div(this.x, skalar);
		this.y = LineareAlgebra.div(this.y, skalar);
		return this;
	}

	/**
	 * Die Funktion setPosition verändert den Inhalt des Vektors direkt
	 * 
	 * @param x
	 *            nimmt den double Wert für die X-Dimension entgegen
	 * @param y
	 *            nimmt den double Wert für die Y-Dimension entgegen
	 * @return liefert den veränderten Vektor zurück
	 */
	public Vektor2D setPosition(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}

	/**
	 * Die Funktion length berechnet die Länge des Vektors
	 * 
	 * @return liefert die Länge des Vektors als double Wert
	 */
	public double length() {
		double len = 0;
		double x, y;
		if (!this.isNullVector()) {
			x = LineareAlgebra.mult(this.x, this.x);
			y = LineareAlgebra.mult(this.y, this.y);
			len = Math.sqrt(LineareAlgebra.add(x, y));
		}
		return len;
	}

	/**
	 * Die Funktion length setzt die Länge des Vektors auf 1
	 * 
	 * @return liefert den auf Länge 1 geänderten Vektor zurück
	 */
	public Vektor2D normalize() {
		double len = this.length();
		if (len == 0)
			throw new IllegalArgumentException("Division durch 0");
		else if (len != 1)
			this.div(len);

		return this;
	}

	/**
	 * Die Funktion isNullVector überprüft ob der Vektor ein Null-Vektor ist
	 * 
	 * @return liefert true falls es sich um einen Null-Vektor handelt,
	 *         ansonsten false
	 */
	public boolean isNullVector() {
		if (this.x == 0 && this.y == 0)
			return true;
		else
			return false;

	}

	/**
	 * Die Funktion isNotEqual prüft ob der Vektor auf den die Funktion
	 * angewandt wird und ein übergebener verschieden sind
	 * 
	 * @param v
	 *            übergibt eine Vektor2D mit dem verglichen werden soll
	 * @return liefert true falls die Vektoren nicht identisch sind, ansonsten
	 *         false
	 */
	public boolean isNotEqual(Vektor2D v) {
		return !(isEqual(v));
	}

	/**
	 * Die Funktion isEqual prüft ob der Vektor auf den die Funktion angewandt
	 * wird und ein übergebener identisch sind
	 * 
	 * @param v
	 *            übernimmt eine Vektor2D mit dem verglichen werden soll
	 * @return liefert true falls die Vektoren identisch sind, ansonsten false
	 */
	public boolean isEqual(Vektor2D v) {
		if (this.x == v.x && this.y == v.y)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {

		Vektor2D a = new Vektor2D(1, 1);
		Vektor2D b = new Vektor2D(2, 2);
		a.add(b);
		LineareAlgebra.show(a);

	}
}
