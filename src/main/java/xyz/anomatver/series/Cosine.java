package xyz.anomatver.series;

public class Cosine {
    public static double cos(double x) {
        int precision = 10; // задаем точность вычислений
        double result = 0;
        double term = 1;
        for (int i = 0; i < precision; i++) {
            result += term;
            term *= -1 * x * x / ((2 * i + 1) * (2 * i + 2));
        }
        return result;
    }
}
