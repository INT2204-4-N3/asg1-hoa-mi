package dictionary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DictionaryManagement {

    private dictionary.Dictionary sach = new dictionary.Dictionary();

    // gọi lại từ điển
    public dictionary.Dictionary getDictionary()
    {
        return sach;
    }
    public void setDictonary(dictionary.Dictionary tudien)
    {
        this.sach = sach;
    }
    public void dictionarySelection() // nhập lựa chọn
    {

        Scanner choose = new Scanner(System.in);

        int numOfSelection;//khoi tao so de lua chon
        numOfSelection = choose.nextInt();


        switch (numOfSelection) {//lua chon so
            case 1:
                this.insertWord();//them tu khi chon 1
                break;
            case 2:
                //this.dictionaryLookup();
                this.dictionarySearcher();//tim kiem tu khi chon 2
                break;
            case 3:
                this.deleteWord();//xóa từ khi chọn 3
                break;
            case 4:
                this.fixWord();//sửa từ khi chọn 4
                break;
            case 5:
                this.showAllWords();//hiện thị tất cả các từ
                break;
            default:
                System.out.println("error");
                break;
        }

    }
    public void insertWord()//xử lý hàm chèn thêm từ
    {
        dictionary.Word wordInsert = new dictionary.Word();
        Scanner choose = new Scanner(System.in);
        System.out.print("Từ thêm vào: ");
        wordInsert.setWordTarget(choose.nextLine());
        System.out.print("Nghĩa của nó : ");
        wordInsert.setWordExplain(choose.nextLine());
        boolean checkInsert = true;

        for ( dictionary.Word word : this.getDictionary().getWord() )
        {
            if ( word.getWordTarget().equals(wordInsert.getWordTarget()))//từ mới thêm trùng với từ mới có sẵn
            {
                checkInsert = false;
                System.out.println("Từ đã có sẵn, thêm từ không thành công");
                break;
            }
        }

        if ( checkInsert )
        {
            sach.getWord().add(wordInsert);
            System.out.println("Thêm từ mới thành công!");
        }
    }
    public void dictionarySearcher()//hàm tim kiếm tra từ
    {
        Scanner choose = new Scanner(System.in);
        System.out.print("Từ bạn cần dịch : ");
        String keyWord = choose.nextLine();
        int num = 0;
        boolean check = false;

        for(  dictionary.Word word : this.getDictionary().getWord() )
        {
            if ( word.getWordTarget().contains(keyWord) && word.getWordTarget().indexOf(keyWord) == 0 )
            {
                num++;
                check = true;
                if ( num == 2 ) System.out.println("STT|\t English \t| VietNamese \t\t");
                System.out.println( num + "\t\t| \t\t" + word.getWordTarget() + "\t\t| " + word.getWordExplain() + "\t\t");
                //in ra ngoai man hinh khi lua chon so 2
            }
        }

        if ( !check ) System.out.println("Không có từ bạn cần tìm");

    }
    public void deleteWord()//hàm xóa từ
    {
        Scanner choose = new Scanner(System.in);
        System.out.print("Từ cần xóa : ");
        String delWord = choose.nextLine();
        boolean checkDelete = false;

        for ( dictionary.Word word : this.getDictionary().getWord() )
        {
            if ( word.getWordTarget().equals(delWord))//neu tu có sẵn có trong danh sách
            {
                this.getDictionary().getWord().remove(word);//xóa từ cần xóa
                checkDelete = true;
                System.out.println("Đã xóa từ thành công");
                break;
            }
        }
        if ( !checkDelete ) System.out.println("Không tìm thấy từ cần xóa");

    }
    public void fixWord()//hàm sửa từ
    {
        Scanner choose = new Scanner(System.in);
        System.out.println("1. Sửa từ bạn cần");
        System.out.println("2. Sửa nghĩa của nó");
        System.out.print("Lựa chọn của bạn : ");


        int selection = choose.nextInt();
        choose.nextLine();
        switch (selection) {//lua chọn
            case 1://sửa từ
                boolean check1 = false;
                System.out.print("Từ cần sửa : ");

                String wordNeedFix1;
                wordNeedFix1 = choose.nextLine();

                for( dictionary.Word word : this.getDictionary().getWord() )
                {
                    if ( word.getWordTarget().equals(wordNeedFix1) )//từ cần sửa nằm trong danh sách từ đã có
                    {
                        System.out.print("Sửa từ thành : ");
                        String wordReplace = choose.nextLine();
                        word.setWordTarget(wordReplace);//thay thế từ
                        check1 = true;
                        System.out.println("Ban đã sửa thành công");
                        break;
                    }
                }
                if (check1 == false) System.out.println("Sửa thất bại!!! KHông tìm thấy từ cần sửa");
                break;
            case 2://sửa nghĩa của từ
                boolean check2 = false;
                System.out.print("Từ có nghĩa cần sửa : ");

                String wordNeedFix2;//khai bao tu can sửa
                wordNeedFix2 = choose.nextLine();

                for( dictionary.Word word : this.getDictionary().getWord() )
                {
                    if ( word.getWordTarget().equals(wordNeedFix2) )
                    {
                        System.out.print("Sửa nghĩa của từ thành : ");
                        String wordReplace = choose.nextLine();
                        word.setWordExplain(wordReplace);
                        check2 = true;
                        System.out.println("Sửa nghĩa thành công !!!");
                        break;
                    }
                }
                if (check2 == false) System.out.println("Sửa thất bại!!! KHông tìm thấy từ cần sửa");
                break;
            default:
                System.out.println("error");
                break;
        }

    }
    public void showAllWords()//in ra ngoài màn hình
    {
        System.out.println("\t STT \t| \t\t English \t| VietNamese \t\t");
        int num = 1;
        for (dictionary.Word word : this.getDictionary().getWord())
        {
            System.out.println(num + "\t| " + word.getWordTarget() + "\t\t| " + word.getWordExplain() + "\t\t");
            num++;
        }
        System.out.println("            |                   |           ");
    }


    public void dictionaryLookup()// tra nguyên 1 từ )
    {
        String keyWord;
        Scanner choose = new Scanner(System.in);
        System.out.print("Nhập từ cần tra, dịch: ");
        keyWord = choose.nextLine();

        boolean checkFinded = false;

        for(dictionary.Word word : this.getDictionary().getWord())
        {
            int numW=1;
            if ( word.getWordTarget().equals(keyWord) )
            {
                checkFinded = true;
                System.out.println("No \t\t| English \t\t| VietNamese \t\t\t\n");
                System.out.println(numW + "\t\t| " + word.getWordTarget() + "\t\t\t| "+ word.getWordExplain() + "\t\t");
            }
        }
        if ( !checkFinded)
        {
            System.out.println("Không tìm thấy từ : " + keyWord);
        }

    }
    public void insertFromFile()// nhập dữ liệu từ file vào từ điển
    {
        File file = new File("sach.txt");//khai báo file mới
        try (Scanner inFile = new Scanner(file)) {
            String word_target, word_explain;
            while(inFile.hasNextLine() )
            {
                String oneLine = inFile.nextLine();
                word_target = oneLine.substring(0, oneLine.indexOf("\t"));
                word_explain = oneLine.substring(oneLine.indexOf("\t") + 1);

                dictionary.Word word = new dictionary.Word();
                word.setWordTarget(word_target);
                word.setWordExplain(word_explain);
                this.getDictionary().getWord().add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        }
    }

    public void dictionaryExportToFile()
    {

    }

}
