public class test {
    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i=i>>>1;
        System.out.println(Integer.toBinaryString(i));
        i=i>>>10;
        System.out.println(Integer.toBinaryString(i));
    }
}
