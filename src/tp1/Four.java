package tp1;

public class Four {

    static int dummyFunc(int z) {
        if (z == 0) {
            throw new IllegalArgumentException("Params tidak boleh 0");
        }
        
        return z;
    }

    public static void main(String[] args) {
        // ArithmeticException
        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException : " + e);
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] b = {1, 2};
            b[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException : " + e);
        }

        // IllegalArgumentException
        try {
            dummyFunc(0);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException : " + e);
        }
        
        // NumberFormatException
        try {
            int c = Integer.parseInt("aaa");
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException : " + e);
        }
        
        // NullPointerException
        try {
            int[] d = null;
            System.out.println(d.length);
        } catch (NullPointerException e) {
            System.err.println("NullPointerException : " + e);
        }
    }
}
