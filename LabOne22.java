import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LabOne22 {

    public static void main(String[] args) {



        // шаг первый: создаем массив a типа long и заполняем его соответствующими 9 числами в порядке возрастания.
        long[] c = {3, 5, 7, 9, 11, 13,
                15, 17, 19};

        // int counter = 3;
        // for (int i = 0; i < 9; i++) {
        //      c[i] = counter;
        //      counter++;
        // }




        // шаг второй: создание массива x типа float и заполнение его 18 случайными числами в указанном диапазоне
        int min = -13, max = 13;

        float[] x = new float[18];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) ThreadLocalRandom.current().nextInt(min, max);
        }
        System.out.println(Arrays.toString(x) + '\n');



        // шаг третий: создание двумерного массива d и заполнение его, как указано
        float[][] d = new float[9][18];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                if (c[i] == 13) {
                    float one = (float) Math.pow(Math.asin(x[j]/26), 2);
                    float two = (float) (Math.pow((1 - (x[j]/(1-x[j]))), 2) + 1);
                    float three = (float) (Math.pow(x[j], (x[j]/2/3))/3/4);

                    d[i][j] = (float) Math.pow(one, (two/three));
//                    d[i][j] = (float) (Math.pow(Math.asin(Math.pow(x[j]/26, 2)),(Math.pow(1-((x[j]/(1-x[j]))),2+1))/(Math.pow((x[j]),(x[j]/2/3))/3/4)));
                } else if (c[i] == 3 || c[i] == 7 || c[i] == 11 || c[i] == 19) {
                    d[i][j] = (float) (Math.cbrt(0.5/x[j]));
                } else {
                    d[i][j] = (float) Math.atan(Math.cos(Math.cos(Math.pow(Math.pow(((x[j]+1)/4), x[j]), Math.pow(x[j], x[j])))));
                }
            }
        }



        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                if (Float.isNaN(d[i][j])) {
                    System.out.print("   NaN   |  ");
                } else if (Float.isInfinite(d[i][j])) {
                    System.out.print("   Inf   |  ");
                } else {System.out.format("%.3f   |  ", d[i][j]);}
            }
            System.out.println();
        }



    }
}
