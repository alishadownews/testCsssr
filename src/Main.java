public class Main {

    public static void main(String[] args) {
        System.out.println("begin working");

        String s = "сапог сарай арбуз болт бокс биржа";

        VariantImpl1 varint1 = new VariantImpl1(s);
        varint1.calc();


        VariantImpl2 varint2 = new VariantImpl2(s);
        varint2.calc();



        System.out.println();
        System.out.println("end working");
    }
}
