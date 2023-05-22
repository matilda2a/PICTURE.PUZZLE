

package thegame;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class TheGame extends Application {
    private Label name;
    private Label strengh;
    private Button easy;
    private Button medium;
    private Button hard;
    private TextField userName;
     private JFrame BuzzelStructure;
      PuzzleStructure game;
    @Override
    public void start(Stage primaryStage) {  
     Pane root=new Pane();
        
     // definition of label name (Name)
     name=new Label ("Name:");
     name.setFont(new Font("Arial", 35));
     name.setTextFill(Color.AQUAMARINE);
     name.setUnderline(true);
        
     // definition of label name (Choice strength)
     strengh=new Label("Choice strength");
     strengh.setFont(new Font("Arial", 40));
     strengh.setTextFill(Color.AQUAMARINE);
     strengh.setUnderline(true);
     
     //definition of buttons name (Easy,Medium,Hard,Setting,Exit) 
     // and his action like when mouse Enter and Exit
     easy=new Button("Easy");
     easy.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
       
     easy.setOnMouseEntered(event -> {
     easy.setStyle("-fx-background-color: #666; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });      
     easy.setOnMouseExited(event -> {
     easy.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });
      
     medium=new Button("Medium");
     medium.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  
     medium.setOnMouseEntered(event -> {
     medium.setStyle("-fx-background-color: #666; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });       
     medium.setOnMouseExited(event -> {
     medium.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });
     hard=new Button ("Hard"); 
     hard.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  
     hard.setOnMouseEntered(event -> {
     hard.setStyle("-fx-background-color: #666; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });      
     hard.setOnMouseExited(event -> {
     hard.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 35px; -fx-padding: 10px 20px; -fx-border-radius: 20px; -fx-background-radius: 20px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 20, 0, 0, 0);");
  });
     Button setting=new Button("Setting"); 
     setting.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
     setting.setOnMouseEntered(event -> {
     setting.setStyle("-fx-background-color: #666; -fx-text-fill: white; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
  });
        
     setting.setOnMouseExited(event -> {
     setting.setStyle("-fx-background-color: #333; -fx-text-fill: white; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
 });

      Button exit=new Button ("Exit");
     exit.setStyle("-fx-background-color: #333; -fx-text-fill: red; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
     exit.setOnMouseEntered(event -> {
     exit.setStyle("-fx-background-color: #666; -fx-text-fill: red; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
  });
        
     exit.setOnMouseExited(event -> {
     exit.setStyle("-fx-background-color: #333; -fx-text-fill: red; -fx-font-size: 30px; -fx-padding: 10px 20px; -fx-background-radius: 50%;");
 });
          //Action of exit to close the stage 
       exit.setOnAction(e->{
       primaryStage.close();
  });
        //definition of textfield()
     userName=new TextField();
     userName.setStyle("-fx-background-color: #eee; -fx-text-fill: #333; -fx-font-size: 25px; -fx-padding: 10px; -fx-border-color: #ccc; -fx-border-width: 2px; -fx-border-radius: 10px;");

        BorderPane root1 = new BorderPane();
        //add the name and userName to HBox
        HBox h=new HBox(10);
        h.getChildren().addAll(name,userName);
        h.setPadding(new Insets(20,0,20,20));
        h.setAlignment(Pos.TOP_LEFT);
        
        //add the setting and exit to HBox 1
        HBox h1=new HBox(380);
        h1.getChildren().addAll(setting,exit);
        h1.setPadding(new Insets(20,20,20,20)); 
        
        //add the strengh,easy,medium and hard to VBox 
        VBox v=new VBox(10);
        v.getChildren().addAll(strengh,easy,medium,hard); 
        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(20,20,20,20));
        
        //add all of HBox,HBox1 and the VBox to BorderPane
       root1.setTop(h);
       root1.setCenter(v);
       root1.setBottom(h1);
    
           //to make backgrond
     Image image = new Image("background5.gif");
     BackgroundImage backgroundImage = new BackgroundImage(image,
     BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
     BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT); 
     Background background = new Background(backgroundImage);
      
         //Addition all of the background and the BorderPane to Pane 
      root.setBackground(background);
      root. getChildren().addAll(root1); 
      Scene scene=new Scene(root,650,530);
      primaryStage.setTitle("Puzzle Game");
      primaryStage.setScene(scene);
      primaryStage.show(); 

       //All actions of the three buttons(easy,medium,hard)
        easy.setOnAction(event -> {
          primaryStage.close();    
          BuzzelStructure = new BuzzelStructure(userName.getText(), "easy");
        });
       medium.setOnAction(event -> {
          primaryStage.close();  
          BuzzelStructure = new BuzzelStructure(userName.getText(), "medium");
        });              
        hard.setOnAction(e->{
        primaryStage.close();
        BuzzelStructure = new BuzzelStructure(userName.getText(), "hard"); 
   });
/*
        //All actions of the three buttons(easy,medium,hard)
           easy.setOnAction(event -> {
          primaryStage.close();    
          game = new PuzzleStructure(userName.getText(), "easy");
        });
              medium.setOnAction(event -> {
          primaryStage.close();    
            game = new PuzzleStructure(userName.getText(), "medium");
        });
             hard.setOnAction(event -> {
          primaryStage.close();    
            game = new PuzzleStructure(userName.getText(), "hard");
        });
   */        
    }  //end of the start method   
    

   public static void main(String[] args) {
        launch(args);
      
    }//end of the main method 
    
} //end of the class 
