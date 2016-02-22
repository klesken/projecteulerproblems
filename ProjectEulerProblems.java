/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vikka994
 */
public class ProjectEulerProblems extends Application {
    
    Problem26 problem26;
    Problem27 problem27;
    Problem50 problem50;
    Problem44 problem;
    
    @Override
    public void start(Stage primaryStage) {
        
        //New vertical box
        VBox mainBox = new VBox(1);
        
        //New horizontal box
        HBox bottomHBox = new HBox(1);
        
        Button[] buttons = createButtons();
        
        bottomHBox.getChildren().addAll(Arrays.copyOf(buttons, 1));
        
        mainBox.getChildren().addAll(buttons[0], bottomHBox);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(mainBox);
        
        //root.setAlignment(bottomHBox, Pos.BOTTOM_RIGHT);
        //root.setAlignment(btn, Pos.TOP_LEFT);
        //root.setAlignment(btn2, Pos.BOTTOM_RIGHT);
        //root.setAlignment(btn3, Pos.BOTTOM_CENTER);
        //root.setAlignment(btn4, Pos.BOTTOM_CENTER);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Project Euler Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Button[] createButtons(){
                
        Button btn = new Button();
        btn.setText("Current Problem, 49");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                (problem = new Problem44()).solve();
                problem.solution();
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Problem 26");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
           
            @Override
            public void handle(ActionEvent event){
                //System.out.println("Hello World!");
                (problem26 = new Problem26()).solve();
                problem26.solution();
            }
        });
        
        Button btn3 = new Button();
        btn3.setText("Problem 27");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                (problem27 = new Problem27()).solve();
                problem27.solution();
            }
        });
        
        Button btn4 = new Button();
        btn4.setText("Problem 50");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                (problem50 = new Problem50()).solve();
                problem50.solution();
            }
        });

        Button btn5 = new Button();
        btn5.setText("Problem 44");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                (problem = new Problem44()).solve();
                problem.solution();
            }
        });
        
        //int numberOfButtons = 5;
        Button[] buttons = {btn, btn2, btn3, btn4, btn5};
        return buttons;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
