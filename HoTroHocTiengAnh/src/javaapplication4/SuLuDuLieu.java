/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nghia
 */
public class SuLuDuLieu {

    public static int s=0;
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static int dem2 = 0;//de thuc hien.long
    public static int dem1 = 0;//de thuc hien.long
    public static int dem3 = 0;//de thuc hien.long
     public static String[] cot1 ;//Luu cac gia tri cua cot 1
    public static String[] cotchuyendoi  ;//Luu cac gia tri arpabet cua tu
     public static String[] cot2 ;//Luu cac gia tri cua cot 2
    public static int DemSoTu = 0;
    public static int temp = 0;//de thuc hien swich
    public static SuLuDuLieu dl = new SuLuDuLieu();
    ;
    public static String[][] array = new String[1000][2];

    public static void main(String[] args) {
        Theme a = new Theme();
        a.giaodien();
    }

    public static void read(String tenfile) throws FileNotFoundException, IOException {
        a="";
        b="";
        c="";
        DemSoTu = 0;
        temp = 0;
        try
        {
        FileInputStream file = new FileInputStream(tenfile);
        XSSFWorkbook wb = new XSSFWorkbook(file);// chuyen file inputstream ve excel
        XSSFSheet sheet = wb.getSheetAt(0);// doc tu sheet thu 0

        
        for (Row row : sheet) {
            if (row.getCell(0) != null) {
                a = row.getCell(0).toString();
                c += a.replaceAll("\\s+", "") + " ";
                DemSoTu += 2;
                
            }
            if (row.getCell(1) != null) {
                System.out.print(" ");
                a = row.getCell(1).toString();
               
                ChuyenArpabet();
                 

            }

        }
        }
        catch(Exception e)
        {
            
        }

    }

    public static String convert(String chucai) {

        if (chucai.equals("ɑ:")) {
            chucai = "AA";
        } else if (chucai.equals("e")) {
            chucai = "EH";
        } else if (chucai.equals("i")) {
            chucai = "IH";
        } else if (chucai.equals("ʌ")) {
            chucai = "AH";
        } else if (chucai.equals("æ")) {
            chucai = "AE";
        } else if (chucai.equals("aʊ")) {
            chucai = "AW";
        } else if (chucai.equals("ə")) {
            chucai = "ER";
        } else if (chucai.equals("ɚ")) {
            chucai = "AXR";
        } else if (chucai.equals("e")) {
            chucai = "EH";
        } else if (chucai.equalsIgnoreCase("ʊ")) {
            chucai = "UH";
        } else if (chucai.equals("ð")) {
            chucai = "DH";
        } else if (chucai.equals("ɾ")) {
            chucai = "DX";
        } else if (chucai.equals("∫")) {
            chucai = "SH";
        } else if (chucai.equals("ʃ")) {
            chucai = "SH";
        } else if (chucai.equals("θ")) {
            chucai = "TH";
        } else if (chucai.equals("ʒ")) {
            chucai = "ZH";
        } else if (chucai.equals("ŋ")) {
            chucai = "NG";
        } // 2 nguyen am 
        else if (chucai.equals("ɜ:")) {
            chucai = "ER";
        } else if (chucai.equals("ɔ:")) {
            chucai = "AO";
        } else if (chucai.equals("u:")) {
            chucai = "UW";
        } else if (chucai.equals("i:")) {
            chucai = "IY";
        } else if (chucai.equals("əʊ")) {
            chucai = "OW";
        } else if (chucai.equals("ɔi")) {
            chucai = "OY";
        } else if (chucai.equals("tʃ")) {
            chucai = "CH";
        } else if (chucai.equals("dʒ")) {
            chucai = "JH";
        } else if (chucai.equals("ai")) {
            chucai = "AY";
        } else if (chucai.equals("ei")) {
            chucai = "EY";
        } // phu am 
        else if (chucai.equalsIgnoreCase("b")) {
            chucai = "B";
        } else if (chucai.equalsIgnoreCase("d")) {
            chucai = "D";
        } else if (chucai.equalsIgnoreCase("f")) {
            chucai = "F";
        } else if (chucai.equalsIgnoreCase("g")) {
            chucai = "G";
        } else if (chucai.equals("h")) {
            chucai = "HH";
        } else if (chucai.equalsIgnoreCase("k")) {
            chucai = "K";
        } else if (chucai.equalsIgnoreCase("l")) {
            chucai = "L";
        } else if (chucai.equalsIgnoreCase("m")) {
            chucai = "M";
        } else if (chucai.equalsIgnoreCase("n")) {
            chucai = "N";
        } else if (chucai.equalsIgnoreCase("p")) {
            chucai = "P";
        } else if (chucai.equalsIgnoreCase("r")) {
            chucai = "R";
        } else if (chucai.equalsIgnoreCase("s")) {
            chucai = "S";
        } else if (chucai.equalsIgnoreCase("t")) {
            chucai = "T";
        } else if (chucai.equalsIgnoreCase("v")) {
            chucai = "V";
        } else if (chucai.equalsIgnoreCase("w")) {
            chucai = "W";
        } else if (chucai.equalsIgnoreCase("y")) {
            chucai = "Y";
        } else if (chucai.equalsIgnoreCase("z")) {
            chucai = "Z";
        }

        return chucai;

    }

    public static void ChuyenArpabet() {

        dl.chuyenString3(a);
        dl.chuyenString3(a);
        dl.chuyenString3(a);
        b += a.replaceAll("\\s+", "") + " ";

    }

    public void chuyenString(String chucai) {
        int c = chucai.length();
        String[] b = new String[chucai.length()];
        for (int i = 0; i < c; i++) {
            b[i] = String.valueOf(chucai.charAt(i));
        }
        chucai = "";
        for (int i = 0; i < c; i++) {
            chucai += convert(b[i]) + " ";

        }
        a = chucai;
    }

    public void chuyenString2(String chucai) {

        if (chucai.indexOf("əʊ") > -1)// kiem tra de chay swich
        {
            temp = 1;
        } else if (chucai.indexOf("ai") > -1) {
            temp = 2;
        } else if (chucai.indexOf("ɔi") > -1) {
            temp = 3;
        } else if (chucai.indexOf("dʒ") > -1) {
            temp = 4;
        } else if (chucai.indexOf("tʃ") > -1) {
            temp = 5;
        } else if (chucai.indexOf("aʊ") > -1) {
            temp = 6;
        } else if (chucai.indexOf("ei") > -1) {
            temp = 7;
        }

        switch (temp) {
            case 1:
                chuyen2phienam("əʊ", chucai);
                break;
            case 2:
                chuyen2phienam("ai", chucai);
                break;
            case 3:
                chuyen2phienam("ɔi", chucai);
                break;
            case 4:
                chuyen2phienam("dʒ", chucai);
                break;
            case 5:
                chuyen2phienam("tʃ", chucai);
                break;
            case 6:
                chuyen2phienam("aʊ", chucai);
                break;
            case 7:
                chuyen2phienam("ei", chucai);

                break;
            default:
                chuyenString(chucai);
                break;

        }
        temp = 0;

    }

    public void chuyenString3(String chucai) {

        if (chucai.indexOf("i:") > -1) {
            temp = 7;
        } else if (chucai.indexOf("ɜ:") > -1) {
            temp = 8;
        } else if (chucai.indexOf("u:") > -1) {
            temp = 9;
        } else if (chucai.indexOf("ɔ:") > -1) {
            temp = 10;
        } else if (chucai.indexOf("ɑ:") > -1) {
            temp = 11;
        }

        switch (temp) {
            case 7:
                chuyen2phienam("i:", chucai);
                break;
            case 8:
                chuyen2phienam("ɜ:", chucai);
                break;
            case 9:
                chuyen2phienam("u:", chucai);
                break;
            case 10:
                chuyen2phienam("ɔ:", chucai);
                break;
            case 11:
                chuyen2phienam("ɑ:", chucai);
                break;

            default:
                chuyenString2(chucai);
                break;

        }
        temp = 0;

    }

    public void chuyen2phienam(String c1, String a1) {
        String d = "";
        int e = a1.length();
        String[] b = new String[e];
        for (int i = 0; i < e; i++) {// phan tach chuoi thanh ki tu luu vao mang
            b[i] = String.valueOf(a1.charAt(i));
        }
        for (int i = a1.indexOf(c1); i <= a1.indexOf(c1) + 1; i++) {// tim xem co ki tu nao phien am 2 chu lay ra luu vao d 
            b[i] = String.valueOf(a.charAt(i));
            d += b[i];
            b[i] = "";
        }
        a1 = "";
        for (int i = 0; i < e; i++) {// neu phan tu nao trong cong them d 
            if ("".equals(b[i])) {

                a1 += convert(d);// luu phiên am có 2 từ

                i += 1;// vi chu cai d co 2 chu .  hoi nay xoa het 1  khoang trong
            } else {
                a1 += b[i];// ghep lai cac chu cai

            }
        }

        a = a1;

    }

}
