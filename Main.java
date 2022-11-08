
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // создаём массивы, требуемые по заданию
        long[] a = new long[(15 - 2) + 1];
        double[] x = new double[10];
        double[][] z = new double[14][10];


        // заполнение массивов a и x
        int count = 0;
        for (long i = 15; i > 1; i--) {
            a[count++] = i;
        }
        /*
        for (int i = 0; i < 14; i++ ) {
            System.out.println(a[i]);
        }
        */

        for (int i = 0; i < 10; i++) {
            x[i] = new Random().nextFloat() * 6 - 4;
        }

        /*
        for (int i = 0; i < 10; i++) {
            System.out.println(x[i]);
        }
        */

        //создание переменных для удобства в дальнейшем
        final double E = Math.E;
        final double PI = Math.PI;

        //заполнение массива z, путём разбиения выражений на действия
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                double x1 = x[j];
                if (a[i] == 5) {
                    z[i][j] = Math.log(Math.pow(PI / (Math.tan(x1) * Math.tan(x1)), 2));
                } else if (a[i] == 2 || a[i] == 7 || a[i] == 4 || a[i] == 9 || a[i] == 10 || a[i] == 11 || a[i] == 15) {
                    double pow1 = Math.pow(Math.asin((x1 - 1) / 6), ((2.0 / 3) * (2.0 / 3 + (x1 / (x1 + 1)))));
                    double pow2 = Math.pow(Math.abs(x1), pow1);
                    z[i][j] = Math.atan(1.0 / Math.pow(E, pow2));
                } else {
                    double pow11 = Math.pow((Math.sin(x1)) / 2, Math.cbrt(x1));
                    double pow22 = Math.pow(E, pow11);
                    double p = Math.pow((x1 - 1) / 6, 2);
                    double p1 = 4 + Math.asin(Math.pow(p, 2));
                    double pend = pow22 * p1;
                    z[i][j] = Math.pow(Math.log(Math.abs(Math.log(Math.cos(x1) * Math.cos(x1)))), pend);

                }


            }
        }
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(String.format(" %.2f ", z[i][j]));


            }
            System.out.println();
        }


    }
}