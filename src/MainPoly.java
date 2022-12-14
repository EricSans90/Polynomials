public class MainPoly {
    public static void main(String[] args) {
        MyPolynomial p1= new MyPolynomial(1,2,3);
        /* It's possible to invoke with array:
        double [] coeffs = {1.1,2.4,5.2,5.7};
        MyPolynomial p2 = new MyPolynomial (coeffs);
        * */

        MyPolynomial p2 = new MyPolynomial("poly.txt");
        System.out.println(p1.toString());
        //System.out.println(p2);
        //System.out.println(p1.getDegree());
        //System.out.println(p1.evaluate(2));
        MyPolynomial p3= new MyPolynomial(1,3);
        System.out.println(p3.toString());
        //MyPolynomial p4= new MyPolynomial(5);
        //System.out.println(p4);
        //System.out.println(p3.add(p1));
        System.out.println(p3.multiply(p1));

    }
}
