package problems;

public class Binary2Decimal {
    public double toDecimal(String binary) {
        double decimal = 0;
        int pos = 7;
        for (int i = 0; i < 8; i++) {
            int digit = binary.charAt(pos);
            digit = digit == 48 ? 0 : 1;
            if (digit == 1) {
                System.out.println(i);
                decimal = decimal + Math.pow(2, i);
            }
            pos--;
        }
        return decimal;
    }

    public String toBinary(int decimal) {
        int n = decimal;
        String binary = "";
        while (n > 0) {
            int remainder = n % 2;
            binary = remainder + binary;
            n = n / 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        Binary2Decimal b2d = new Binary2Decimal();
        double value = b2d.toDecimal("00110101");
        System.out.println(value);

        String s = b2d.toBinary(53);
        System.out.println(s);
    }
}
