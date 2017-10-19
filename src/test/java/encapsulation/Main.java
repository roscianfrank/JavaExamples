package encapsulation;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(40,false,10);
        System.out.println("Number of pages printed "+printer.getNoOfPagesPrinted());
        System.out.println("Toner level is "+printer.getToner());
        System.out.println("is printer type is duplex: "+printer.isDuplex());
        printer.printPages(4);
        printer.fillToner(10);
        System.out.println("Toner lever is "+printer.getToner());
        System.out.println("Number of pages printed "+printer.getNoOfPagesPrinted());

    }
}
