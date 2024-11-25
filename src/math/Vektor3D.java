package math;



public class Vektor3D {

	public double x;
	public double y;
	public double z;

	public Vektor3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vektor3D round(Vektor3D v) {

		v.x = LineareAlgebra.Round(v.x);
		v.y = LineareAlgebra.Round(v.y);
		v.z = LineareAlgebra.Round(v.z);
		return v;
	}

	/**
	 * Mit sub wird vom Vektor, auf den die Fuktion angewendet wird, ein zweiter
	 * subtrahiert
	 * 
	 * @param v
	 *            übergibt einen Vektor3D, der vom Anwender subtrahiert werden
	 *            soll
	 * @return liefert das Ergebnis als Vektor3D zurück.
	 */

	public Vektor3D sub(Vektor3D v) {
		this.x = LineareAlgebra.sub(this.x, v.x);
		this.y = LineareAlgebra.sub(this.y, v.y);
		this.z = LineareAlgebra.sub(this.z, v.z);
		return this;
	}

	/**
	 * Mit add wird auf den Vektor, auf den die Fuktion angewendet wird, ein
	 * zweiter addiert
	 * 
	 * @param v
	 *            übergibt einen Vektor3D, der auf den Anwender addiert werden
	 *            soll
	 * @return liefert das Ergebnis als Vektor3D zurück.
	 */

	public Vektor3D add(Vektor3D v) {
		this.x = LineareAlgebra.add(this.x, v.x);
		this.y = LineareAlgebra.add(this.y, v.y);
		this.z = LineareAlgebra.add(this.z, v.z);
		return this;
	}

	/**
	 * mult berechnet das Produkt aus dem Vektor auf den die Funktion angewendet
	 * wird und einem double-Wert
	 * 
	 * @param skalar
	 *            nimmt den double Wert mit dem multipliziert werden soll
	 *            entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor3D zurück
	 */
	public Vektor3D mult(double skalar) {
		this.x = LineareAlgebra.mult(this.x, skalar);
		this.y = LineareAlgebra.mult(this.y, skalar);
		this.z = LineareAlgebra.mult(this.z, skalar);
		return this;
	}

	/**
	 * Die Funktion div berechnet den Quotient aus dem Vektor auf den es
	 * angewendet wird und einem double-Wert
	 * 
	 * @param skalar
	 *            nimmt den double Wert mit dem dividiert werden soll entgegen
	 * @return liefert das Ergebnis der Division als Vektor3D zurück
	 */
	public Vektor3D div(double skalar) {

		this.x = LineareAlgebra.div(this.x, skalar);
		this.y = LineareAlgebra.div(this.y, skalar);
		this.z = LineareAlgebra.div(this.z, skalar);
		return this;
	}

	/**
	 * Die Funktion setPosition verändert den Inhalt des Vektors direkt
	 * 
	 * @param x
	 *            nimmt den double Wert für die X-Dimension entgegen
	 * @param y
	 *            nimmt den double Wert für die Y-Dimension entgegen
	 * @param z
	 *            nimmt den double Wert für die Z-Dimension entgegen
	 * @return liefert den veränderten Vektor3D zurück
	 */
	public Vektor3D setPosition(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	/**
	 * Die Funktion length berechnet die Länge des Vektors
	 * 
	 * @return liefert die Länge des Vektors als double Wert
	 */
	public double length() {
		double len = 0;
		double x, y, z;
		if (!this.isNullVector()) {
			x = LineareAlgebra.mult(this.x, this.x);
			y = LineareAlgebra.mult(this.y, this.y);
			z = LineareAlgebra.mult(this.z, this.z);
			len = Math.sqrt(LineareAlgebra.add(LineareAlgebra.add(x, y), z));
		}
		return len;
	}

	/**
	 * Die Funktion length setzt die Länge des Vektors auf 1
	 * 
	 * @return liefert den auf Länge 1 geänderten Vektor zurück
	 */
	public Vektor3D normalize() {
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
		if (this.x == 0 && this.y == 0 && this.z == 0)
			return true;
		else
			return false;

	}

	/**
	 * Die Funktion isNotEqual prüft ob der Vektor auf den die Funktion
	 * angewandt wird und ein übergebener verschieden sind
	 * 
	 * @param v
	 *            übergibt eine Vektor3D mit dem verglichen werden soll
	 * @return liefert true falls die Vektoren nicht identisch sind, ansonsten
	 *         false
	 */
	public boolean isNotEqual(Vektor3D v) {
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
	public boolean isEqual(Vektor3D v) {
		if (this.x == v.x && this.y == v.y && this.z == v.z)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {

	}
}
