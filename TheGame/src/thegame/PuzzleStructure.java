

package thegame;

import java.io.File;
import java.io.FileInputStream;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import static javafx.scene.input.TransferMode.COPY;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import static javafx.scene.layout.BackgroundPosition.DEFAULT;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class PuzzleStructure  extends Pane {
            Stage stage;
            Scene scene;
            Pane root = new Pane();       
    Button reset;
    String username;
    String strength;
   private static final long serialVersionUID = 1L;
   Image defaultIcon = new Image("pic/background8.png");
   Image greetWinnerIcon = new Image("pic/winner.gif");

   private Label[] sortedLabelsArray;
    private Label[] unsortedLabelsArray;

    Label collectedPoints;
    Label greetWinner;
    Label finalImageShape;
    Label referenceIconTitle;

    String[] defaultSortedIconsArray;
    Label level;
     
    int levelId=0;
    LevelInformation levelStructure;  
    private int correctTriesCounter = 0;
    private String finalImagePath;
    private String[] strength_Level = {"easy", "medium", "hard"};
    private int strength_Level_current_index = 0;
    
   private int widthBack;
   private int heightBack;
   
     private int shifXLength = 0;
     
     TransferHandlerAction transferHandler;
    public PuzzleStructure (String userName,String strength){
    this.username=userName;
    this.strength=strength;

    if (this.strength.equals("easy") || this.strength.equals("medium")) {
            shifXLength = 0;
        } else if (this.strength.equals("hard")) {
            shifXLength = 300;
        }
  
      transferHandler = new TransferHandlerAction();  
    levelStructure=new LevelInformation(strength);
    initalizeTheNextLevel();
       

     reset = new Button("RESET");
        reset.setTranslateX(765+shifXLength);
        reset.setTranslateY(170);
        reset.setFont(new Font("Arial",20)); 
        root.getChildren().add(reset);
        
        reset.setOnAction(e->{  
   
     initalizeTheNextLevel();
     
    reset.setDisable(true);
 
        });
       
    
      
      flush();
     scene=new Scene(root);
     stage=new Stage();  
     stage.setScene(scene);
     stage.setTitle("Picture Puzzle");
     stage.show();
   }
    
  
     public void initalizeTheNextLevel() {
    	this.correctTriesCounter=0;
        constructArrayBasedOnStrenghType(this.strength);
      this.getLevelInformation(this.levelId);
       initUI();
       resetImages();
        setLevelDateOnUI();
        
    }
     private void resetImages() {
    for (int i = 0; i < sortedLabelsArray.length; i++) {
        ImageView view2 = new ImageView(defaultIcon);  
        sortedLabelsArray[i].setGraphic(view2); 
    }
    for (int i = 0; i < unsortedLabelsArray.length; i++) {
        ImageView view1 = new ImageView(new Image(defaultSortedIconsArray[i]));  
        unsortedLabelsArray[i].setGraphic(view1);
    }
}
     
      private void constructArrayBasedOnStrenghType(String type) {
        if (type != null && type.equals("easy")) {
            sortedLabelsArray = new Label[4];
            unsortedLabelsArray = new Label[4];
            this.strength_Level_current_index=0;
        } else if (type != null && type.equals("medium")) {
            sortedLabelsArray = new Label[9];
            unsortedLabelsArray = new Label[9];
            this.strength_Level_current_index=1;
        } else if (type != null && type.equals("hard")) {
            sortedLabelsArray = new Label[12];
            unsortedLabelsArray = new Label[12];
            this.strength_Level_current_index=2;

        }

    }
    
       private void getLevelInformation(int levelNumber) {

        LevelRequirments level = levelStructure.getLevelById(levelNumber);
        this.defaultSortedIconsArray = level.getDefaultSortedIconsArray();
        this.levelId = level.getLevelNumber();
        this.finalImagePath = level.getDefaultIconPath();
    }
       
   
        public void initUI() {
      this.flush(); 
        int unsorted_x = 10;
        int unsorted_y = 10;
        int width = 100;
        int height = 100;

        int sorted_x = 10;
        int sorted_y = 300;
       
    
        int sorted_x_counter = 1;
        int sorted_y_counter = 1;

        int numberOfImagesPerLine = 0;
        

        if (this.strength.equals("easy")) {
            numberOfImagesPerLine = 2;
            unsorted_x=300;
            widthBack=920;
            heightBack=600;
        } else if (this.strength.equals("medium")) {
            numberOfImagesPerLine = 3;
            widthBack=920;
            heightBack=600;
        }else if(this.strength.equals("hard")){
            numberOfImagesPerLine = 4;
            widthBack=1220;
            heightBack=600;
        }
        
       
         Image image = new Image("background3.jpeg");
         BackgroundSize backgroundSize = new BackgroundSize(widthBack, heightBack, true, true, true, true);
       BackgroundImage backgroundImage = new BackgroundImage(image,
       BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
       BackgroundPosition.DEFAULT, backgroundSize);
       Background background = new Background(backgroundImage);
      root.setBackground(background);
        
     /*   
      unsortedLabelsArray = new Label[sortedLabelsArray.length];
       sortedLabelsArray= new Label[sortedLabelsArray.length];
for (int i = 0; i < sortedLabelsArray.length; i++) {
    unsortedLabelsArray[i] = new Label();
    unsortedLabelsArray[i].setPrefSize(width, height);
    unsortedLabelsArray[i].setLayoutX(unsorted_x);
    unsortedLabelsArray[i].setLayoutY(unsorted_y);

  setDragAndDropHandler(unsortedLabelsArray[i], defaultSortedIconsArray);
     
     
     sortedLabelsArray[i] = new Label();
    sortedLabelsArray[i].setPrefSize(width, height);
    sortedLabelsArray[i].setLayoutX(sorted_x);
    sortedLabelsArray[i].setLayoutY(sorted_y);
    sortedLabelsArray[i].setGraphic(new ImageView(defaultIcon));
    
    setDragAndDropHandler( sortedLabelsArray[i], defaultSortedIconsArray);   
    */
      
      
        DragMouseAdapter listener = new DragMouseAdapter();
    for (int i = 0; i < sortedLabelsArray.length; i++) {
        unsortedLabelsArray[i] = new Label();
        unsortedLabelsArray[i].setOnDragDetected(listener);
        unsortedLabelsArray[i].setLayoutX(unsorted_x);
        unsortedLabelsArray[i].setLayoutY(unsorted_y);
         transferHandler.setTransferAction(unsortedLabelsArray[i], defaultIcon);

        sortedLabelsArray[i] = new Label();
        sortedLabelsArray[i].setOnDragDetected(listener);
        sortedLabelsArray[i].setLayoutX(sorted_x);
        sortedLabelsArray[i].setLayoutY(sorted_y);
         transferHandler.setTransferAction(sortedLabelsArray[i], defaultIcon);
        sortedLabelsArray[i].setGraphic(new ImageView(defaultIcon));
        
        getChildren().addAll(unsortedLabelsArray[i], sortedLabelsArray[i]);
    


           unsorted_x += 100;
            if (sorted_y_counter >= numberOfImagesPerLine) {
                sorted_y += 100;
                sorted_y_counter = 0;
            }
            if (sorted_x_counter < numberOfImagesPerLine) {
                sorted_x += 100;
            } else {
                sorted_x = 10;
                sorted_x_counter = 0;
            }
            sorted_y_counter++;
            sorted_x_counter++;   
  
}
  
 //root. getChildren().addAll(unsortedLabelsArray);
 // root. getChildren().addAll(sortedLabelsArray);
        
        createAdditionalComponentLayout();
  
    } 
       
     
        public void createAdditionalComponentLayout() {
    
        Label usernameLabel = new Label();
        usernameLabel.setPrefSize(200, 40);
        usernameLabel.setPadding(new Insets(150,0,0,10));
        usernameLabel.setFont(new Font("Verdana", 20));
        usernameLabel.setTextFill(Color.WHEAT);
        usernameLabel.setText("Hello , " + this.username);
        
        Label strength_level = new Label();
        strength_level.setPadding(new Insets(180,0,0,10));
        strength_level.setFont(new Font("Verdana", 20));
        strength_level.setText("Strength : " + this.strength);
        strength_level.setTextFill(Color.WHEAT);
        
         level = new Label();
         level.setPrefSize(200, 10);
         level.setPadding(new Insets(210,0,0,10));
         level.setFont(new Font("Verdana", 20));
         level.setTextFill(Color.WHEAT);
         level.setText("Level : " + (this.levelId+1));

       
        
        greetWinner = new Label();
        greetWinner.setPrefSize(100, 100);
        greetWinner.setPadding(new Insets(210,0,0,200));

        referenceIconTitle = new Label("Reference Image");
        referenceIconTitle.setLayoutX((730 + shifXLength));
        referenceIconTitle.setLayoutY(240);
        referenceIconTitle.setFont(new Font("Serif", 20));
        referenceIconTitle.setTextFill(Color.RED);
        
        finalImageShape = new Label();
        finalImageShape.setPrefSize(200,200);
        finalImageShape.setPadding(new Insets(270,0,0,(700 + shifXLength)));
            
        collectedPoints = new Label("Score : " + correctTriesCounter + " / " + sortedLabelsArray.length);
        collectedPoints.setLayoutX((730 + shifXLength));
        collectedPoints.setLayoutY(480);
        collectedPoints.setFont(new Font("Verdana", 22));
         collectedPoints.setTextFill(Color.WHEAT);

         
        
      root.getChildren().addAll(usernameLabel,strength_level,level,referenceIconTitle,finalImageShape,collectedPoints,greetWinner);
      
}
         
         private void setLevelDateOnUI() {
        String[] arr = Randomize(this.defaultSortedIconsArray);
        for (int i = 0; i < unsortedLabelsArray.length; i++) {
           ImageView view1 =new ImageView(new Image(arr[i]));  
            unsortedLabelsArray[i].setGraphic(view1);
            root. getChildren().addAll(unsortedLabelsArray[i]);
        }
        
        for (int i = 0; i < sortedLabelsArray.length; i++) {
            root.getChildren().remove(sortedLabelsArray[i].getGraphic());
           ImageView view2 =new ImageView(defaultIcon);  
            sortedLabelsArray[i].setGraphic(view2); 
            root. getChildren().addAll(sortedLabelsArray[i]);
        }
        
        ImageView view3 =new ImageView(new Image(this.finalImagePath)); 
        this.finalImageShape.setGraphic(view3);
       this.greetWinner.setGraphic(null);

    }
        
         
         
          public static String[] Randomize(String[] arr) {
        String[] randomizedArray = new String[arr.length];
        System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
        Random rgen = new Random();

        for (int i = 0; i < randomizedArray.length; i++) {
            int randPos = rgen.nextInt(randomizedArray.length);
            String tmp = randomizedArray[i];
            randomizedArray[i] = randomizedArray[randPos];
            randomizedArray[randPos] = tmp;
        }

        return randomizedArray;
    }
          
         
          
       
       public void flush() {
		root.getChildren().removeAll();
		if (this.strength != null && this.strength.equals("easy")) {
			root.setPrefSize(920, 600);

		} else if (this.strength != null && this.strength.equals("medium")) {
			root.setPrefSize(920, 600);

		} else if (this.strength != null && this.strength.equals("hard")) {
			root.setPrefSize(1220, 600);

		}
	}
       
       
       private class DragMouseAdapter implements EventHandler<MouseEvent> {
           
       public void handle(MouseEvent event) {
    Node node = (Node) event.getSource();
    Dragboard db = node.startDragAndDrop(TransferMode.COPY_OR_MOVE);
    ClipboardContent content = new ClipboardContent();
    if (((Label) node).getGraphic() != null && !((Label) node).getGraphic().equals(defaultIcon)) {
        content.putImage(((ImageView) ((Label) node).getGraphic()).getImage());
        db.setContent(content);
        event.consume();
    
    }
}
       }
    private class TransferHandlerAction {
    public void setTransferAction(Label label, Image icon) {

    label.setOnDragOver(event -> {
        if (event.getGestureSource() != label && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    });

    label.setOnDragDropped(event -> {
        Dragboard db = event.getDragboard();
        if (db.hasImage()) {
            // Get source and target labels
            Label sourceLabel = (Label) event.getGestureSource();
            Label targetLabel = (Label) event.getSource();
            // Swap the images between the source and target labels
            Image sourceImage = ((ImageView) sourceLabel.getGraphic()).getImage();
            Image targetImage = ((ImageView) targetLabel.getGraphic()).getImage();
            
            ((ImageView) sourceLabel.getGraphic()).setImage(targetImage);
            ((ImageView) targetLabel.getGraphic()).setImage(sourceImage);
            
            ((ImageView) label.getGraphic()).setImage(sourceImage);
            
            soundPlayer("drapImage.wav");
            //collectSuccessTries();
            correctTriesCounter = 0;
    for (int i = 0; i < sortedLabelsArray.length; i++) {
        if (((ImageView)targetLabel.getGraphic()).getImage().impl_getUrl().equals(defaultSortedIconsArray[i])) {
            correctTriesCounter++;
        }
    }
    collectedPoints.setText("Score : " + correctTriesCounter + " / " + sortedLabelsArray.length);
        
            event.setDropCompleted(true);
            
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    });
}}
  /*     
       private void setDragAndDropHandler(Label label,String[] defaultSortedIconsArray) {
    label.setOnDragDetected(event -> {
        Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putImage(((ImageView) label.getGraphic()).getImage());
        db.setContent(content);
        event.consume();
    });

    label.setOnDragOver(event -> {
        if (event.getGestureSource() != label && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    });

    label.setOnDragDropped(event -> {
        Dragboard db = event.getDragboard();
        if (db.hasImage()) {
            // Get source and target labels
            Label sourceLabel = (Label) event.getGestureSource();
             Label targetLabel = label;

            // Swap images
            Image sourceImage = ((ImageView) sourceLabel.getGraphic()).getImage();
            Image targetImage = ((ImageView) targetLabel.getGraphic()).getImage();
            ((ImageView) sourceLabel.getGraphic()).setImage(targetImage);
             ((ImageView) targetLabel.getGraphic()).setImage(sourceImage);

              
             collectSuccessTries();
        soundPlayer("drapImage.wav");
        event.setDropCompleted(true);
    } else {
        event.setDropCompleted(false);
    }
    event.consume();
});
}
       */
 
private void collectSuccessTries() {
    correctTriesCounter = 0;
    for (int i = 0; i < sortedLabelsArray.length; i++) {
        if (((ImageView)sortedLabelsArray[i].getGraphic()).getImage().impl_getUrl().equals(defaultSortedIconsArray[i])) {
            correctTriesCounter++;
        }
    }
    collectedPoints.setText("Score : " + correctTriesCounter + " / " + sortedLabelsArray.length);
        
        
    if (correctTriesCounter == defaultSortedIconsArray.length) {
        ((ImageView)greetWinner.getGraphic()).setImage(greetWinnerIcon);
        soundPlayer("win.wav");
        int selectedOption = JOptionPane.showConfirmDialog(null, "Congratulations, Do You Want To Move To NextLevel");
        if (selectedOption == 0) {       	
            int lastLevel = levelStructure.levelComponentsList.size() - 1;
            if (this.levelId == lastLevel) {
                int option = JOptionPane.showConfirmDialog(null, "Now You Win All levels , Waiting the next more strength click ok.");
                if (option == 0) {
                    if (this.strength_Level_current_index == this.strength_Level.length-1) {
                        this.strength_Level_current_index = 0;
                    } else {
                        this.strength_Level_current_index++;
                    }
                    this.levelId = 0;
                    this.strength=this.strength_Level[this.strength_Level_current_index];
                    levelStructure = new LevelInformation(this.strength); 
                    this.initalizeTheNextLevel(); 
                }
                if (option == 1) {
                    System.exit(0);
                }

            } else {
                collectedPoints.setText("Score : 0  / " + sortedLabelsArray.length);
                this.levelId = this.levelId + 1;
                this.getLevelInformation(levelId);
                this.setLevelDateOnUI();
                level.setText("Level : " + (this.levelId+1));

            }

        }  
    }
}
        





private void soundPlayer(String soundFile) {
    try {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/sound/" + soundFile);
        Media sound = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 
}
 
       
       
       



