package sample;

import dictionary.DictionaryCommandline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;


public class Controller {
    @FXML
    public TextField Input;
    @FXML
    public ListView<String> listView;
    @FXML
    public WebView webViewExplain;
    @FXML
    DictionaryCommandline dictionaryCommandline= new DictionaryCommandline();

    @FXML
    public void handleClickListView(MouseEvent event) {//xu ly che do nhan
        String y = listView.getSelectionModel().getSelectedItem();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(y), "text/html");
    }
   @FXML
    public void handleClickListViewSearch(MouseEvent event){//ham xu ly che do nhan vao kieu nu nut
       //su dung trong cho tim kiem tu
        String input = Input.getText();//gan inpu
        String x ;
        x = dictionaryCommandline.dictionarySearcher(input).get(0);

        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(x), "text/html");//tro ve tu tim kiem

    }
    public  void update(KeyEvent event){//ham cap nhat lai khi da xoa va nhap tu moi
        listView.getItems().setAll(dictionaryCommandline.dictionarySearcher(Input.getText()));

    }
//    public void handleClickDelete(MouseEvent event){
//        String z=
//    }

}