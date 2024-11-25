package math;

public class LineareAlgebra {

	private LineareAlgebra() {

	}

	/**
	 * Die Funktion round dient der Vermeidung von Rundungsfehlern und begrenzt
	 * die Genauigkeit Fauf 3 Stellen nach dem Komma.
	 * 
	 * @param Ist
	 *            der eingabe Parameter als double-Wert
	 * @return liefert das begrenzte und gerundete Ergebnis als double-Wert
	 *         zurück.
	 */
	public static double Round(double temp) {

		temp = temp * 1000;
		temp = Math.round(temp);
		temp = temp / 1000.0;
		return temp;
	}

	/**
	 * Mit add werden zwei Vektoren addiert
	 * 
	 * @param v1
	 *            - übergibt ersten Vektor2D
	 * @param v2
	 *            - übergibt zweiten Vektor2D
	 * @return liefert das Ergebnis als Vektor2D zurück.
	 */
	public static Vektor2D add(Vektor2D v1, Vektor2D v2) {
		Vektor2D v = new Vektor2D(v1.x, v1.y);
		return v.add(v2);
	}

	/**
	 * Mit add werden zwei Vektoren addiert
	 * 
	 * @param v1
	 *           - übergibt ersten Vektor3D 
	 * @param v1
	 * 			 - übergibt zweiten Vektor3D
	 * @return liefert das begrenzte Ergebnis als Vektor3D zurück.
	 */
	public static Vektor3D add(Vektor3D v1, Vektor3D v2) {
		Vektor3D v = new Vektor3D(v1.x, v1.y, v1.z);
		return v.add(v2);
	}

	/**
	 * Mit add werden zwei Skalar addiert
	 * 
	 * @param skalar1
	 *            übergibt ersten double-Wert @param skalar2 übergibt zweiten
	 *            double-Wert
	 * @return liefert das Ergebnis als double-Wert zurück.
	 */
	public static double add(double skalar1, double skalar2) {
		// Speicherüberlauf abfangen
		if ((skalar1 >= 0 && skalar2 >= 0 && skalar1 >= Double.MAX_VALUE - skalar2)
				|| (skalar1 < 0 && skalar2 < 0 && skalar1 <= -Double.MAX_VALUE - skalar2)) {
			throw new doubleOverflow("Beim addieren kam es zu einem Überlauf!");
		}

		return skalar1 + skalar2;
	}

	/**
	 * Die Funktion sub nimmt 2 Vektoren des zweidimensionalen Raums und
	 * berechnet deren Differenz
	 * 
	 * @param v1
	 *            ist der erste Vektor
	 * @param v2
	 *            ist der zweite Vektor
	 * @return gibt das Ergebnis der Subtraktion als Vektor zurück
	 */
	public static Vektor2D sub(Vektor2D v1, Vektor2D v2) {
		Vektor2D v = new Vektor2D(v1.x, v1.y);
		return v.sub(v2);
	}

	/**
	 * Die Funktion sub nimmt 2 Vektoren des dreidimensionalen Raums und
	 * berechnet deren Differenz
	 * 
	 * @param v1
	 *            ist der erste Vektor
	 * @param v2
	 *            ist der zweite Vektor
	 * @return gibt das Ergebnis der Subtraktion als Vektor zurück
	 */
	public static Vektor3D sub(Vektor3D v1, Vektor3D v2) {
		Vektor3D v = new Vektor3D(v1.x, v1.y, v1.z);

		return v.sub(v2);
	}

	/**
	 * Die Funktion sub nimmt 2 double Werte und berechnet deren Differenz
	 * 
	 * @param skalar1
	 *            ist der erste Wert
	 * @param skalar2
	 *            ist der zweite Wert
	 * @return gibt das Ergebnis der Subtraktion als double-Wert zurück
	 */
	public static double sub(double skalar1, double skalar2) {
		// Speicherüberlauf abfangen
		if ((skalar1 >= 0 && skalar2 < 0 && skalar1 >= Double.MAX_VALUE + skalar2)
				|| (skalar1 < 0 && skalar2 > 0 && skalar1 <= -Double.MAX_VALUE + skalar2))
			throw new doubleOverflow("Beim Subtrahieren kam es zu einem Überlauf!");

		return skalar1 - skalar2;
	}

	/**
	 * Die Funktion mult berechnet das Produkt aus einem Vektor2D und einem
	 * double-Wert
	 * 
	 * @param v1
	 *            nimmt den Vektor2D entgegen
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor2D zurück
	 */
	public static Vektor2D mult(Vektor2D v1, double s) {
		Vektor2D v = new Vektor2D(v1.x, v1.y);
		return v.mult(s);
	}

	/**
	 * Die Funktion mult berechnet das Produkt aus einem Vektor3D und einem
	 * double-Wert
	 * 
	 * @param v1
	 *            nimmt den Vektor3D entgegen
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor3D zurück
	 */
	public static Vektor3D mult(Vektor3D v1, double s) {
		Vektor3D v = new Vektor3D(v1.x, v1.y, v1.z);
		return v.mult(s);
	}

	/**
	 * Die Funktion mult berechnet das Produkt aus zwei double-Werten
	 * 
	 * @param skalar1
	 *            nimmt den Vektor2D entgegen
	 * @param skalar2
	 *            nimmt den double Wert entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor zurück
	 */
	public static double mult(double skalar1, double skalar2) {
		// Speicherüberlauf abfangen
		if (skalar2 > 1) {
			if ((skalar1 > 1 && skalar1 >= Double.MAX_VALUE / skalar2)
					|| (skalar1 < -1 && skalar1 <= -Double.MAX_VALUE / skalar2))
				throw new doubleOverflow("Beim multiplizieren kam es zu einem Überlauf!");
		} else if (skalar2 < -1) {
			if ((skalar1 < -1 && -skalar1 >= -Double.MAX_VALUE / skalar2)
					|| (skalar1 > 1 && skalar1 >= -Double.MAX_VALUE / skalar2)) {
				throw new doubleOverflow("Beim multiplizieren kam es zu einem Überlauf!");
			}
		}

		return skalar1 * skalar2;
	}

	/**
	 * Die Funktion mult berechnet das Produkt aus einem double-Wert und einem
	 * Vektor2D
	 * 
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @param v1
	 *            nimmt den Vektor2D entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor2D zurück
	 */
	public static Vektor2D mult(double s, Vektor2D v1) {
		Vektor2D v = new Vektor2D(v1.x, v1.y);
		return v.mult(s);
	}

	/**
	 * Die Funktion mult berechnet das Produkt aus einem double-Wert und einem
	 * Vektor3D
	 * 
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @param v1
	 *            nimmt den Vektor3D entgegen
	 * @return liefert das Ergebnis der Multiplikation als Vektor3D zurück
	 */
	public static Vektor3D mult(double s, Vektor3D v1) {
		Vektor3D v = new Vektor3D(v1.x, v1.y, v1.z);
		return v.mult(s);
	}

	/**
	 * Die Funktion div berechnet den Quotient aus einem Vektor2D und einem
	 * double-Wert
	 * 
	 * @param v1
	 *            nimmt den Vektor2D entgegen
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @return liefert das Ergebnis der Division als Vektor2D zurück
	 */
	public static Vektor2D div(Vektor2D v1, double s) {
		Vektor2D v = new Vektor2D(v1.x, v1.y);
		return v.div(s);
	}

	/**
	 * Die Funktion div berechnet den Quotient aus einem Vektor3D und einem
	 * double-Wert
	 * 
	 * @param v1
	 *            nimmt den Vektor3D entgegen
	 * @param s
	 *            nimmt den double Wert entgegen
	 * @return liefert das Ergebnis der Division als Vektor3D zurück
	 */
	public static Vektor3D div(Vektor3D v1, double s) {
		Vektor3D v = new Vektor3D(v1.x, v1.y, v1.z);
		return v.div(s);
	}

	/**
	 * Die Funktion div berechnet den Quotient aus zwei double-Werten
	 * 
	 * @param skalar1
	 *            nimmt den ersten double-Wert entgegen
	 * @param skalar2
	 *            nimmt den zweiten double-Wert entgegen
	 * @return liefert das Ergebnis der Division als double-Wert zurück
	 */
	public static double div(double skalar1, double skalar2) {
		if (skalar2 == 0) {
			throw new IllegalArgumentException("Division durch 0");
		} else if ((skalar2 > -1 && skalar2 < 1)) {
			double retWert = skalar1 / skalar2;
			if (Double.isInfinite(retWert)) {
				throw new doubleOverflow("Beim dividieren kam es zu einem Überlauf!");
			} else
				return retWert;
		} else
			return skalar1 / skalar2;

	}

	/**
	 * Die Funktion isEqual überprüft, ob zwei Vektoren identisch sind.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return gibt true im postiven Fall und false im negativen Fall als
	 *         boolean-Wert zurück
	 */
	public static boolean isEqual(Vektor2D v1, Vektor2D v2) {
		return v1.isEqual(v2);
	}

	/**
	 * Die Funktion isEqual überprüft, ob zwei Vektoren identisch sind.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return gibt true im postiven Fall und false im negativen Fall als
	 *         boolean-Wert zurück
	 */
	public static boolean isEqual(Vektor3D v1, Vektor3D v2) {
		return v1.isEqual(v2);
	}

	/**
	 * Die Funktion isNotEqual überprüft, ob zwei Vektoren nicht identisch sind.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return gibt true im postiven Fall und false im negativen Fall als
	 *         boolean-Wert zurück
	 */
	public static boolean isNotEqual(Vektor2D v1, Vektor2D v2) {
		return v1.isNotEqual(v2);
	}

	/**
	 * Die Funktion isNotEqual überprüft, ob zwei Vektoren nicht identisch sind.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return gibt true im postiven Fall und false im negativen Fall als
	 *         boolean-Wert zurück
	 */
	public static boolean isNotEqual(Vektor3D v1, Vektor3D v2) {
		return v1.isNotEqual(v2);
	}

	/**
	 * Die Funktion length brechnet die Länge eines Vektors
	 * 
	 * @param v
	 *            übergibt das Vektor2D-Objekt
	 * @return liefert die Länge als double-Wert
	 */
	public static double length(Vektor2D v) {
		return v.length();
	}

	/**
	 * Die Funktion length brechnet die Länge eines Vektors
	 * 
	 * @param v
	 *            übergibt das Vektor3D-Objekt
	 * @return liefert die Länge als double-Wert
	 */
	public static double length(Vektor3D v) {
		return v.length();
	}

	/**
	 * Die Funktion normalize normiert ein Vektor2D objekt, sodass dessen Länge
	 * gleich 1 ist.
	 * 
	 * @param v
	 *            übergibt das Vektor2D-Objekt
	 * @return liefert das normierte Vektor2D objekt
	 */
	public static Vektor2D normalize(Vektor2D v) {
		return v.normalize();
	}

	/**
	 * Die Funktion normalize normiert ein Vektor3D objekt, sodass dessen Länge
	 * gleich 1 ist.
	 * 
	 * @param v
	 *            übergibt das Vektor2D-Objekt
	 * @return liefert das normierte Vektor3D objekt
	 */
	public static Vektor3D normalize(Vektor3D v) {
		return v.normalize();
	}

	/**
	 * Die Funktion euklDistance berechnet die euklidische Distanz zweier
	 * Vektoren indem einer der Vektoren vom anderen subtrahiert wird und danach
	 * die Laenge des Ergebnisvektors berechnet wird.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt den Subtrahend als Vektor2D-Objekt
	 * @return liefert die Länge des Ergbnisvektors als double-Wert
	 */
	public static double euklDistance(Vektor2D v1, Vektor2D v2) {
		return length(sub(v1, v2));
	}

	/**
	 * Die Funktion euklDistance berechnet die euklidische Distanz zweier
	 * Vektoren/Punkte indem einer der Vektoren vom anderen subtrahiert wird und
	 * danach die Laenge des Ergebnisvektors berechnet wird.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt den Subtrahend als Vektor3D-Objekt
	 * @return liefert die Länge des Ergbnisvektors als double-Wert
	 */
	public static double euklDistance(Vektor3D v1, Vektor3D v2) {
		return length(sub(v1, v2));
	}

	/**
	 * Die Funktion manhattanDistance berechnet die Manhattan-Distanz zweier
	 * Vektoren/Punkte indem die Differenz der Koordinatenpunkte als Beträge
	 * aufsummiert werden.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert die Distanz als double-Wert
	 */
	public static double manhattanDistance(Vektor2D v1, Vektor2D v2) {
		double x, y;
		x = abs(sub(v2.x, v1.x));
		y = abs(sub(v2.y, v1.y));
		double manhD = add(x, y);
		return manhD;
	}

	/**
	 * Die Funktion manhattanDistance berechnet die Manhattan-Distanz zweier
	 * Vektoren/Punkte indem die Differenz der Koordinatenpunkte als Beträge
	 * aufsummiert werden.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert die Distanz als double-Wert
	 */
	public static double manhattanDistance(Vektor3D v1, Vektor3D v2) {
		double x, y, z;
		x = abs(sub(v2.x, v1.x));
		y = abs(sub(v2.y, v1.y));
		z = abs(sub(v2.z, v1.z));
		double manhD = add(add(x, y), z);
		return manhD;
	}

	/**
	 * Die Funktion crossProduct berechnet das Kreuzprodukt zweier Vektoren im
	 * dreidimensionalen Raum, mithilfe der Regel von Sarrus.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert das Kreuzprodukt als Vektor3D-Objekt
	 */
	public static Vektor3D crossProduct(Vektor3D v1, Vektor3D v2) {
		double a, b, c;
		a = sub(mult(v1.y, v2.z), mult(v1.z, v2.y));
		b = sub(mult(v1.z, v2.x), mult(v1.x, v2.z));
		c = sub(mult(v1.x, v2.y), mult(v1.y, v2.x));
		Vektor3D crossPr = new Vektor3D(a, b, c);
		return crossPr;
	}

	/**
	 * Die Funktion dotProduct berechnet das Skalarprodukt zweier Vektoren,
	 * indem die Koordinaten mit des einen Vektors mit den Koordinaten des
	 * zweiten Vektors multipliziert und anschließend aufsummiert werden.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert das Skalarprodukt als double-Wert
	 */
	public static double dotProduct(Vektor3D v1, Vektor3D v2) {
		double skalar = add(mult(v1.x, v2.x), mult(v1.y, v2.y));
		return add(skalar, mult(v1.z, v2.z));
	}

	/**
	 * Die Funktion dotProduct berechnet das Skalarprodukt zweier Vektoren,
	 * indem die Koordinaten mit des einen Vektors mit den Koordinaten des
	 * zweiten Vektors multipliziert und anschließend aufsummiert werden.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert das Skalarprodukt als double-Wert
	 */
	public static double dotProduct(Vektor2D v1, Vektor2D v2) {
		return add(mult(v1.x, v2.x), mult(v1.y, v2.y));
	}

	/**
	 * Die Funktion cosEquation berechnet den Cosinus zweier Vektoren, und gibt
	 * den Cosunus in Radiant zurück. Hierfür wird die Funktion anlgeRad
	 * benutzt.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert den Cosinus in Radiant als double-Wert
	 */
	public static double cosEquation(Vektor2D v1, Vektor2D v2) throws Exception {

		return angleRad(v1, v2);
	}

	/**
	 * Die Funktion cosEquation berechnet den Cosinus zweier Vektoren, und gibt
	 * den Cosunus in Radiant zurück. Hierfür wird die Funktion anlgeRad
	 * benutzt.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert den Cosinus in Radiant als double-Wert
	 */
	public static double cosEquation(Vektor3D v1, Vektor3D v2) throws Exception {
		return angleRad(v1, v2);
	}

	/**
	 * Die Funktion sinEquation berechnet den Sinus zweier Vektoren, und gibt
	 * den Sinus in Radiant zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert den Sinus in Radiant als double-Wert
	 */
	public static double sinEquation(Vektor2D v1, Vektor2D v2) throws Exception {
		double cosq;
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else {
			cosq = Math.pow(angleRad(v1, v2), 2);
		}
		return Math.sqrt(1 - cosq);
	}

	/**
	 * Die Funktion sinEquation berechnet den Sinus zweier Vektoren, und gibt
	 * den Sinus in Radiant zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert den Sinus in Radiant als double-Wert
	 */
	public static double sinEquation(Vektor3D v1, Vektor3D v2) throws Exception {
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else
			return Math.asin(length(crossProduct(v1, v2)) / (v1.length() * v2.length()));
	}

	/**
	 * Die Funktion angleRad berechnet den Winkel zweier Vektoren zueinander,
	 * und gibt den Winkel in Radiant zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert den Winkel in Radiant als double-Wert
	 */
	public static double angleRad(Vektor2D v1, Vektor2D v2) throws Exception {
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else
			return Math.acos(dotProduct(v1, v2) / (v1.length() * v2.length()));
	}

	/**
	 * Die Funktion angleRad berechnet den Winkel zweier Vektoren zueinander,
	 * und gibt den Winkel in Radiant zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert den Winkel in Radiant als double-Wert
	 */
	public static double angleRad(Vektor3D v1, Vektor3D v2) throws Exception {
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else
			return Math.acos(dotProduct(v1, v2) / (v1.length() * v2.length()));
	}

	/**
	 * Die Funktion angleDegree berechnet den Winkel zweier Vektoren zueinander,
	 * und gibt den Winkel in Grad zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert den Winkel in Grad als double-Wert
	 */
	public static double angleDegree(Vektor2D v1, Vektor2D v2) throws Exception {
		double rad;
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else
			rad = Math.acos(dotProduct(v1, v2) / (v1.length() * v2.length()));

		return radToDegree(rad);
	}

	/**
	 * Die Funktion angleDegree berechnet den Winkel zweier Vektoren zueinander,
	 * und gibt den Winkel in Grad zurück.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v2
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert den Winkel in Grad als double-Wert
	 */
	public static double angleDegree(Vektor3D v1, Vektor3D v2) throws Exception {
		double rad;
		if (v1.isNullVector() || v2.isNullVector())
			throw new Exception("Nullvektor exception");
		else
			rad = Math.acos(dotProduct(v1, v2) / (v1.length() * v2.length()));

		return radToDegree(rad);
	}

	/**
	 * Die Funktion radToDegree rechnet Radiant in Grad um.
	 * 
	 * @param rad
	 *            übergibt den Winkel in Radiant
	 * @return liefert den Winkel in Grad als double-Wert
	 */
	public static double radToDegree(double rad) {
		return Round(rad * (180 / Math.PI));
	}

	/**
	 * Die Funktion degreeToRad rechnet Grad in Radiant um.
	 * 
	 * @param degree
	 *            übergibt den Winkel in Grad
	 * @return liefert den Winkel in Radiant als double-Wert
	 */
	public static double degreeToRad(double degree) {
		return (degree / 180) * Math.PI;
	}

	/**
	 * Die Funktion determinante berechnet die Determinante zweier Vektoren im
	 * zweidimensionalen Raum, indem die Koordinaten überkreuzt multipliziert
	 * und die Ergebnisse voneinander subtrahiert werden.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor2D-Objekt
	 * @param v1
	 *            übergibt das zweite Vektor2D-Objekt
	 * @return liefert die Determinante als double-Wert
	 */
	public static double determinante(Vektor2D v1, Vektor2D v2) {
		return sub(mult(v1.x, v2.y), mult(v1.y, v2.x));
	}

	/**
	 * Die Funktion determinante berechnet die Determinante zweier Vektoren im
	 * dreidimensionalen Raum mithilfe der Regel von Sarrus.
	 * 
	 * @param v1
	 *            übergibt das erste Vektor3D-Objekt
	 * @param v1
	 *            übergibt das zweite Vektor3D-Objekt
	 * @return liefert die Determinante als double-Wert
	 */
	public static double determinante(Vektor3D v1, Vektor3D v2, Vektor3D v3) {
		double det = mult(mult(v1.x, v2.y), v3.z);
		det = add(det, mult(mult(v1.y, v2.z), v3.x));
		det = add(det, mult(mult(v1.z, v2.x), v3.y));
		det = sub(det, mult(mult(v1.z, v2.y), v3.x));
		det = sub(det, mult(mult(v1.x, v2.z), v3.y));
		det = sub(det, mult(mult(v1.y, v2.x), v3.z));
		return det;
	}

	/**
	 * Die Funktion abs berechnet den Betrag eines double-Wertes.
	 * 
	 * @param value
	 *            liefert den Eingangswert
	 * @return gibt den Betrag des Eingangswertes als double-Wert zurück.
	 */
	public static double abs(double value) {
		if (value < 0)
			return (value * -1);
		return value;
	}

	// show
	public static void show(Vektor2D v) {
		System.out.println("( " + v.x + ", " + v.y + " )");
	}

	public static void show(Vektor3D v) {
		System.out.println("( " + v.x + ", " + v.y + ", " + v.z + " )");
	}
}
