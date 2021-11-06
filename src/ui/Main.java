package ui;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private int discNumberA=0;
    private int discNumberB=0;
    private int discNumberC=0;
    private String msg="";

    public Main() {
        sc= new Scanner(System.in);
    }

    public static void  main(String args[]) {
        Main main = new Main();
        main.createMsg();
        System.out.println(main.msg);
        main.msg="";
        main.test();
        System.out.println(main.msg);
    }

    public void createMsg(){
        int numberOfCases=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<numberOfCases;i++){
            int discNumber = sc.nextInt();
            sc.nextLine();
            discNumberA = discNumber;
            discNumberB=0;
            discNumberC=0;
            msg+=discNumberA + "-" + discNumberB + "-" + discNumberC + "\n";
            HanoiTower(discNumber, "A", "C", "B");
            msg+="\n\n";
        }
    }

    public void test(){
        int numberOfCases=30;
        int discNumber = 0;
        for(int i=0;i<numberOfCases;i++){
            if(discNumber<5) {
                discNumber++;
            }else{
                discNumber=1;
            }
            discNumberA = discNumber;
            discNumberB=0;
            discNumberC=0;
            msg+=discNumberA + "-" + discNumberB + "-" + discNumberC + "\n";
            HanoiTower(discNumber, "A", "C", "B");
            msg+="\n\n";
        }
    }

    public void HanoiTower(int n, String from_rod, String to_rod, String aux_rod) {
        if (n == 1) {
            if(from_rod.equalsIgnoreCase("A")){
                if(to_rod.equalsIgnoreCase("B")){
                    discNumberA--;
                    discNumberB++;
                }
                else{
                    discNumberA--;
                    discNumberC++;
                }
            }
            else if(from_rod.equalsIgnoreCase("B")){
                if(to_rod.equalsIgnoreCase("A")){
                    discNumberB--;
                    discNumberA++;
                }
                else{
                    discNumberB--;
                    discNumberC++;
                }
            }
            else{
                if(to_rod.equalsIgnoreCase("A")){
                    discNumberC--;
                    discNumberA++;
                }
                else{
                    discNumberC--;
                    discNumberB++;
                }
            }
            msg+=discNumberA+"-"+discNumberB+"-"+discNumberC+"\n";
            return;
        }
        HanoiTower(n - 1, from_rod, aux_rod, to_rod);
        if(from_rod.equalsIgnoreCase("A")){
            if(to_rod.equalsIgnoreCase("B")){
                discNumberA--;
                discNumberB++;
            }
            else{
                discNumberA--;
                discNumberC++;
            }
        }
        else if(from_rod.equalsIgnoreCase("B")){
            if(to_rod.equalsIgnoreCase("A")){
                discNumberB--;
                discNumberA++;
            }
            else{
                discNumberB--;
                discNumberC++;
            }
        }
        else{
            if(to_rod.equalsIgnoreCase("A")){
                discNumberC--;
                discNumberA++;
            }
            else{
                discNumberC--;
                discNumberB++;
            }
        }
        msg+=discNumberA+"-"+discNumberB+"-"+discNumberC+"\n";
        HanoiTower(n - 1, aux_rod, to_rod, from_rod);
    }

}
