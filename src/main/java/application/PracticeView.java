
package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PracticeView {
    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word=this.dictionary.getRandomWord();
        
    }
    public Parent getView(){
        GridPane layout=new GridPane();
        Label wordInstruction= new Label ("translate this word: " + this.word);
        TextField translationField= new TextField();
                layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        Button addButton = new Button ("Check translation");
        Label feedback= new Label ("");
                layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(addButton, 1, 0);
        layout.add(feedback,1 , 2);
        
        addButton.setOnMouseClicked((event)->{
        String translation = translationField.getText();
        if (dictionary.get(word).equals(translation)){
            feedback.setText("Correct");
        }else{
            feedback.setText("Incorrect. Translation for the word "+ word + " is  " + dictionary.get(word));
            return;
        }
        this.word=dictionary.getRandomWord();
        wordInstruction.setText("translate this word: " + this.word);
        translationField.clear();
    });



        return layout;
        
    }

    
}
