package dictionary;

public class Word {
    private String word_target,word_explain;//tao thuoc tinh tu moi va nghia cua tu
    public Word(String word_target, String word_explain){
        this.word_target = word_target.toLowerCase();//viet dang chu thuong
        this.word_explain = word_explain.toLowerCase();
    }
    public Word(){
        this("","");
    }
    public void setWord_target(String word_target){
        this.word_target = word_target;
    }
    public String getWord_target(){
        return word_target;
    }
    public void setWord_explain(String word_explain){
        this.word_explain = word_explain;
    }
    public String getWord_explain(){
        return word_explain;
    }

}
