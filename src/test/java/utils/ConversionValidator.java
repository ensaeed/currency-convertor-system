package utils;

public class ConversionValidator {


        public static double calculateExpected(double amount, double rate)
        {
            return amount * rate;
        }

        public static boolean isWithinTolerance(double expected, double actual) {
            double tolerance = expected * 0.01;
            return actual >= (expected - tolerance) && actual <= (expected + tolerance);
        }
    }

