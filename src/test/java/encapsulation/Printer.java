package encapsulation;

public class Printer {
    private int toner ;
    private boolean duplex ;
    private int noOfPagesPrinted;

    public Printer(int toner, boolean duplex, int noOfPagesPrinted) {
        if(this.toner >-1 && this.toner<=100){
            this.toner = toner;
        }
        this.duplex = duplex;
        this.noOfPagesPrinted = 0;
    }

    public void fillToner(int toner){
        if(this.toner+toner <= 100){
            this.toner +=toner;
            System.out.println("Toner is filled "+this.toner+"successfully");
        }else{
            System.out.println("can't fill toner more then 100% "+ "current toner level is "+this.toner );
        }

    }
    public void printPages(int pages){
        if(duplex){
            this.noOfPagesPrinted = pages /2;
            System.out.println("Printing pages...." + this.noOfPagesPrinted);
        }else{
            System.out.println("Printing pages...." + pages);
            this.noOfPagesPrinted +=pages;
        }

    }

    public int getToner() {
        return toner;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int getNoOfPagesPrinted() {
        return noOfPagesPrinted;
    }
}
