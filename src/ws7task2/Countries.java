/* Alexis Arellano Tuesday November 17/2020 */

package ws7task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Countries extends Application {
	
	private String display;
	private WorldMap map = new WorldMap();
	private String city;
	private TextField field_country = new TextField();
	
	public static void main (String[] args) {
	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		// TODO Auto-generated method stub
		Label label_country = new Label("Enter the country: ");
		
		// Form display
		Button btnQuery = new Button("Submit");
		Button btnExit = new Button("Exit");
		GridPane gpane1 = new GridPane();
		gpane1.add(label_country, 0,0);
		gpane1.add(field_country, 1,0);
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(btnQuery,btnExit);
		gpane1.add(hbox1,0,1);
		
		gpane1.setHgap(10);
		gpane1.setVgap(10);
		gpane1.setPadding(new Insets(10,10,10,10));
		Scene scene1 = new Scene (gpane1);
		
		primaryStage.setScene(scene1);
		primaryStage.setHeight(150);
		primaryStage.setWidth(300);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		// Results
		GridPane gpane2 = new GridPane();
		Text text1 = new Text(display);
		Text text2 = new Text("Do you want to search for another country?");
		
		Button btnYes = new Button("Yes");
		Button btnNo = new Button("No");
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(btnYes,btnNo);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(text1, text2);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(0,0,10,0));
		gpane2.setPadding(new Insets(10,10,10,10));
		
		gpane2.add(vbox, 0,0);
		gpane2.add(hbox, 0,1);
		
		Scene scene2 = new Scene(gpane2);
		
		btnQuery.setOnAction(e->{
			setCity();
			setDisplay();
			text1.setText(display);
			primaryStage.setScene(scene2);
		});
		
		btnExit.setOnAction(e->{
			primaryStage.close();
		});
		
		btnYes.setOnAction(e->{
			primaryStage.setScene(scene1);
		});
		
		btnNo.setOnAction(e->{
			primaryStage.close();
		});
	}
	
	public void setCity() {
		city = map.getCity(field_country.getText());
	}
	public void setDisplay() {
		
		if (city == null) {
			display = "This country is not on the list, or does not exist.";
		} 
		else {
			display = "The capital city of " + field_country.getText() + " is " + city;
		}
	}
}
