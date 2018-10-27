package dictionary;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {
    private Dictionary sach = new Dictionary();

    // gọi lại từ điển
//    public Dictionary getDictionary()
//    {
//        return sach;
//    }
//    public void setDictonary(Dictionary tudien)
//    {
//        this.sach = sach;
//    }

    ArrayList<Word> result = new ArrayList<>();
    ArrayList<Word> words = new ArrayList<>();

    public DictionaryManagement() {
        this.insertFromFile();
    }

//    public Word setNewWord() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("nhap them tu: ");
//        String word_target = sc.nextLine();
//        System.out.println("nhap nghia: ");
//        String word_explain = sc.nextLine();
//        result.add(new Word(word_target, word_explain));
//
//        return new Word(word_target.toLowerCase(), word_explain.toLowerCase());
//    }
//    public Dictionary insertFromCommandline() {
//        Dictionary dictionary = new Dictionary();
//        Scanner input = new Scanner(System.in);
//        System.out.println("input the number of word: ");
//        int number = input.nextInt();
//        for (int i = 0; i < number; i++) {
//            dictionary.push( setNewWord() );
//        }
//
//        return dictionary;
//    }

    public void insertFromFile() {//ham chen tu tep file
        String[] wordsAdd;


        try {
            //doc file tu dia chi da cho
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/DELL/Desktop/dictionary_hoamygroup/src/E_V.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                wordsAdd = line.split("<html>");
                if (wordsAdd.length >= 2) {
                    Word word = new Word(wordsAdd[0], wordsAdd[1]);
                    result.add(word);
                    words.add(word);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("cannot open file: E_V.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String dictionaryLookup(String value) {//tra cuu tu dien
        Dictionary dic = new Dictionary();
        String test = "";
        for (int i = 0; i < result.size(); i++) {
            if (value.equals(result.get(i).getWord_target())) {
                test = result.get(i).getWord_explain();
            }
        }
        return test;
    }

    //    public void Themdulieu(){
//        Dictionary dictionary = new Dictionary();
//        final String FILENAME = "E_V.txt";
//        BufferedWriter bw = null;
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(FILENAME, true);
//            bw = new BufferedWriter(fw);
//            String c = "\r\n";
//            bw.write(c);
//            String content = "sonthang\tdeptrai";
//            bw.write(content);
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            try{
//                if(bw != null)
//                    bw.close();
//                if(fw != null)
//                    fw.close();
//            }catch (IOException ex){
//                ex.printStackTrace();
//            }
//        }
//
//    }
//    public void dictionnaryExportToFile(){
//        File file = new File("xuat du lieu tu dien.txt");
//        try(PrintWriter pw = new PrintWriter(file)){
//            for(int i=0;i<result.size();i++){
//                pw.print(result.get(i).getWord_target() + "\t" + result.get(i).getWord_explain() +"\r\n");
//            }
//
//        }catch (Exception e){
//        }
//    }
    public ArrayList<Word> Write(Dictionary S) {
        ArrayList<Word> a = new ArrayList<Word>();
        a = S.words;
        System.out.print("nhap tu muon sua");
        Scanner sc = new Scanner(System.in);

        String b = sc.nextLine();
        int dem = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getWord_target().contains(b) || a.get(i).getWord_explain().contains(b)) {
                System.out.println("Nhap tu moi chinh sua");
                Scanner c = new Scanner(System.in);
                a.get(i).setWord_explain(c.nextLine());
                Scanner d = new Scanner(System.in);
                a.get(i).setWord_target(d.nextLine());

                dem = dem + 1;
            }


        }
        if (dem == 0) System.out.println("tu can xoa ko dc tim thay");
        return a;

    }

    public void Delete(Dictionary S) {
        ArrayList<Word> a = new ArrayList<Word>();

        System.out.print("nhap tu muon xoa");
        Scanner sc = new Scanner(System.in);

        a = S.words;
        int dem = 0;
        String b = sc.nextLine();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getWord_target().contains(b) || a.get(i).getWord_explain().contains(b)) {
                a.remove(i);
                dem = dem + 1;
            }


        }
    }
//    public void fixWord()//hàm sửa từ
//    {
//        Scanner choose = new Scanner(System.in);
//        System.out.println("1. Sửa từ bạn cần");
//        System.out.println("2. Sửa nghĩa của nó");
//        System.out.print("Lựa chọn của bạn : ");
//
//
//        int selection = choose.nextInt();
//        String wordNeedFix1;
//        wordNeedFix1 = choose.nextLine();
//
//        for( Word word : this.getd().getWord() )
//        {
//            if ( word.getWordTarget().equals(wordNeedFix1) )//từ cần sửa nằm trong danh sách từ đã có
//            {
//                String wordReplace = choose.nextLine();
//                word.setWordTarget(wordReplace);//thay thế từ
//                check1 = true;
//                System.out.println("Ban đã sửa thành công");
//                break;
//            }
//        }
//        if (check1 == false) System.out.println("Sửa thất bại!!! KHông tìm thấy từ cần sửa");
//        break;
//        String wordNeedFix2;//khai bao tu can sửa
//        wordNeedFix2 = choose.nextLine();
//
//        for(Word word : this.getDictionary().getWord() )
//        {
//            if ( word.getWordTarget().equals(wordNeedFix2) )
//            {
//                word.setWordExplain(wordReplace);
//                break;
//            }
//        }
//        default:
//        System.out.println("error");
//        break;
//    }
//
//}
}

