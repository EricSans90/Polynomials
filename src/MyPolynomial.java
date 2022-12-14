import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MyPolynomial {

    private double [] coeffs;
    private int degree;

    public MyPolynomial(double... coeffs){
        this.coeffs = coeffs;
        this.degree= coeffs.length-1;
    }

    public MyPolynomial(int degree){
        this.degree= degree;
        //Important:
        coeffs = new double[degree+1];
        for (int i=0; i<degree; i++){
            this.coeffs[i]=0;
        }
    }

    public MyPolynomial(String filename){
        Scanner in = null;
            try {
                in = new Scanner(new File(filename));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.degree = in.nextInt();
            coeffs = new double[degree+1];
            for (int i=0; i<coeffs.length; i++){
                coeffs[i]=in.nextDouble();
            }

    }
    public int getDegree() {
        return degree;
    }

    public String toString() {
        for (int i=this.degree; i>=1;i--){
            System.out.print(this.coeffs[i]+"·x^"+(i)+"+");
        }
        System.out.print(this.coeffs[0]);
        System.out.println();
        return "";
    }
    public double evaluate(double x){
        double evaluation=0;
        for (int i=this.degree; i>=1;i--){
            evaluation += this.coeffs[i]*Math.pow(x,i);
        }
        evaluation += this.coeffs[0];
        return evaluation;
    }

    public MyPolynomial add(MyPolynomial another) {
        MyPolynomial addition;
        int maxDegree;
        if (this.degree>= another.getDegree()){
            maxDegree =this.degree;
        } else {
            maxDegree=another.getDegree();
        }
        addition = new MyPolynomial(maxDegree);
        if (this.degree== another.getDegree()){
            for (int h=maxDegree; h>=0;h--){
                addition.coeffs[h] = this.coeffs[h]+ another.getCoeffs(h);
            }
            return addition;
        } else if (this.degree> another.getDegree()) {
            int i = 0;
            MyPolynomial aux = new MyPolynomial(this.degree);
            for (i = 0; i <= another.getDegree(); i++) {
                aux.coeffs[i] = another.coeffs[i];
            }
            for (int j = i; j <= this.degree; j++) {
                aux.coeffs[j] = 0;
            }
            for (int h = maxDegree; h >= 0; h--) {
                addition.coeffs[h] = this.coeffs[h] + aux.coeffs[h];
            }
            return addition;
        } else {
            int i = 0;
            MyPolynomial aux = new MyPolynomial(another.getDegree());
            for (i = 0; i <= this.degree; i++) {
                aux.coeffs[i] = this.coeffs[i];
            }
            for (int j = i; j <= another.getDegree(); j++) {
                aux.coeffs[j] = 0;
            }
            for (int h = maxDegree; h >= 0; h--) {
                addition.coeffs[h] = aux.coeffs[h] + another.coeffs[h];
            }
        }
        return addition;
    }

    public MyPolynomial multiply(MyPolynomial another) {
        MyPolynomial multi;
        int maxDegree=this.degree* another.getDegree();
        multi = new MyPolynomial(maxDegree+1);
        for (int i=0; i<=this.degree; i++){
            for(int j=0; j<= another.getDegree(); j++){
                multi.coeffs[i+j]+=this.coeffs[i]*another.getCoeffs(j);
            }
        }
        return multi;
    }

    public double getCoeffs(int n) {
        return coeffs[n];
    }
}

/*     public MyPolynomial add(MyPolynomial another) {
        MyPolynomial addition = null;
        int newDegree, i = 0;
        if (this.degree == another.getDegree()) {
            newDegree = this.degree;
            addition = new MyPolynomial(newDegree);
            for (int h = newDegree; h >= 0; h--) {
                addition.coeffs[h] = this.coeffs[h] + another.coeffs[h];
            }
        } else if (this.degree > another.getDegree()) {
            newDegree = this.degree;
            MyPolynomial aux = new MyPolynomial(newDegree);
            for (i=0; i< another.getDegree();i++){
                aux.coeffs[i]=another.coeffs[i];
        }
            for (int j=i;j<newDegree;j++){
                aux.coeffs[j]=0;
            }
            MyPolynomial addition = new MyPolynomial(newDegree);
            for (int h=newDegree; h>=0;h--){
                addition.coeffs[h] = this.coeffs[h]+aux.coeffs[h];
            }

        } else {
            newDegree = another.getDegree();
            MyPolynomial aux = new MyPolynomial(newDegree);
            for (i=0; i< this.degree;i++){
                aux.coeffs[i]=this.coeffs[i];
            }
            for (int j=i;j<newDegree;j++){
                aux.coeffs[j]=0;
            }

            for (int h=newDegree; h>=0;h--){
                addition.coeffs[h] = aux.coeffs[h]+another.coeffs[h];
            }
        }
*/