import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;

public class w{
    public static void show(){
        System.out.print("\f");
        System.out.println(w); //uncomment to show target word
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("" + grid[i][j][0] + grid[i][j][1] + " ");
            }
            System.out.println();
        }
    }
    static String w;
    static char grid[][][];
    public static void main(String args[]){
        ArrayList<String> wl = new ArrayList<>(3000);
        try{
            Scanner sf = new Scanner(new File("words.txt"));
            while(sf.hasNext()){
                String s = sf.nextLine();
                if(s.length() == 5 && !Character.isUpperCase(s.charAt(0))){
                    wl.add(s.toUpperCase());
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        w = wl.get((int)(Math.random()*wl.size()));
       
        grid = new char[6][5][2];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 2; k++){
                    if(k==0){
                        grid[i][j][k] = '_';
                    }else{
                        grid[i][j][k] = ' ';
                    }
                }
            }
        }
           
        String l = ""; //to show a word is invalid
        Scanner sc = new Scanner(System.in);
        int t = 0;
        while(t<6){
            show();
            System.out.print(l);
            String g = sc.nextLine().toUpperCase();
            if(wl.contains(g)){
                l = "";
                for(int i = 0; i < 5; i++){
                    grid[t][i][0] = g.charAt(i);
                    if(g.charAt(i) == w.charAt(i)){
                        grid[t][i][1] = ' ';
                    }else{
                        grid[t][i][1] = 'x';
                        for(int j = 0; j < 5; j++){
                            if(g.charAt(i) == w.charAt(j)){
                                grid[t][i][1] = '|';
                                continue;
                            }
                        }
                    }
                }
                if(g.equals(w)){
                    t+=7;
                }else{
                    t++;
                }
            }else{
                l = "invalid input";
            }
        }
        show();
        if(t>7){
            System.out.println("You win! The word was " + w);
        }else{
            System.out.println("You lose! The word was " + w);
        }
    }
}
