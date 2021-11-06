package ui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private int discNumberA=0;
    private int discNumberB=0;
    private int discNumberC=0;
    private String msg="";
    private String FILE_DATA_TXT_PATH = "data/testCases";
    private String FILE_TESTSOLVED_TXT_PATH = "data/testCasesSolved";

    public Main() {
        sc= new Scanner(System.in);
        try {
            importData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            exportData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  main(String args[]) {
        Main main = new Main();
        main.msg="";
        main.createMsg();
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
    public void importData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_DATA_TXT_PATH));
        String line = br.readLine();
        while (line != null) {
            int discs = Integer.parseInt(line);
            test(discs);
            line = br.readLine();
        }
        br.close();
    }

    public void exportData() throws IOException {
        FileWriter fw = new FileWriter(FILE_TESTSOLVED_TXT_PATH,false);
        fw.write(msg);
        fw.close();
    }

    public void test(int discs){
        discNumberA = discs;
        discNumberB=0;
        discNumberC=0;
        msg+=discNumberA + "-" + discNumberB + "-" + discNumberC + "\n";
        HanoiTower(discs, "A", "C", "B");
        msg+="\n\n";
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
