//package dictionary;
public class DictionaryCommandline {

    public DictionaryManagement dictionaryManagement = new DictionaryManagement();


    public void showMenu()
    {
        System.out.println();
        System.out.println("****************Dictionary****************");
        System.out.println("1. Thêm từ");
        System.out.println("2. Tra từ");
        System.out.println("3. Xóa từ");
        System.out.println("4. Sửa từ");
        System.out.println("5. Hiện tất cả các từ");
        System.out.print("Lựa chọn của bạn : ");
        dictionaryManagement.dictionarySelection();
        this.showMenu();
    }





    public void dictionaryAdvanced()
    {
        this.dictionaryManagement.insertFromFile();

        dictionaryManagement.showAllWords();

        this.showMenu();


    }

}
