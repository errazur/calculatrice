package org.openjfx.calculatrice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	
//	Button b1= new Button ();
	protected Label lbl = new Label("Calcule mon ptit bg");
	protected Background bg = new Background(new BackgroundFill(Color.LIGHTPINK, null, null));
	protected String str = "";
	double nb1;
	double nb2;
	double res;
	String op;

	public double calc (double a, double b, String l) {
		switch (l) {
		case "+":
			return  a + b;
		case "-": 
			return a - b;
		case "x": 
			return a * b;
		case "%":
			return a / b;
		default:
			return 0;
		}
	}
	
 
	@Override
    public void start(Stage stage) {
    
			TilePane root = new TilePane();
            BorderPane root2 = new BorderPane();
            
            Font tailleF = new Font(20);
            Insets marge = new Insets(5);
            
            lbl.setFont(tailleF);
            lbl.setPadding(marge);
            BorderPane.setAlignment(lbl, Pos.CENTER_RIGHT);
            
            Scene scene = new Scene(root2, 241, 300);
            
            String Buttun [] = { "7", "8", "9", "x", "4", "5", "6", "%", "1", "2", "3", "+", "0", ".", "=", "-"};
            
            for(int i = 0; i < 16; i++) {
              Button btn = new Button(String.valueOf(Buttun[i]));
              btn.setPrefSize(60, 60);
              root.getChildren().add(btn);
              btn.setOnAction(new HandleClick());
            }
            
            root2.setBackground(bg);
            stage.setResizable(false);
            root2.setTop(lbl);
            root2.setBottom(root);
            stage.setTitle("Calcule bg");
            stage.setScene(scene);
            stage.show();
    }
    
    class HandleClick implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	Button btn = (Button) event.getSource();
        	
        	if (btn.getText() == "+") {
                nb1 = Integer.valueOf(lbl.getText());
                op="+";
                lbl.setText("");
                str= "+";
                lbl.setText(String.valueOf(str));
                str="";
               }
        	
        	else if (btn.getText() == "-") {
        		if (str != "" ) {
        			 nb1 = Integer.valueOf(lbl.getText());
        			 op="-";
        			 lbl.setText("");
        			 str= "-";
        			 lbl.setText(String.valueOf(str));
        			 str="";
        		}
        		else {
        			str += btn.getText();
                	lbl.setText(String.valueOf(str));
        		}
               }
        	
        	else if (btn.getText() == "x") {
                nb1 = Integer.valueOf(lbl.getText());
                op="x";
                lbl.setText("");
                str= "x";
                lbl.setText(String.valueOf(str));
                str="";
               }
        	
        	else if (btn.getText() == "%") {
                nb1 = Integer.valueOf(lbl.getText());
                op="%";
                lbl.setText("");
                str= "%";
                lbl.setText(String.valueOf(str));
                str="";
               }
        	
        	else if (btn.getText() == "=") {
                nb2 = Integer.valueOf(lbl.getText());
                res = calc(nb1,nb2,op);
                lbl.setText("");
                str= "";
                lbl.setText(String.valueOf(res));
               }
        	
        	else {
        	str += btn.getText();
        	lbl.setText(String.valueOf(str));
        	}
        	
        	if (res == 69) {
        		lbl.setText(String.valueOf(res)+", Nord Vpn");
        	}

        }
              
      }
    
    
    

    public static void main(String[] args) {
        launch();
    }
   
}