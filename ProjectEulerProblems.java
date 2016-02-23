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
    
    //Problem26 problem26;
    //Problem27 problem27;
    //Problem50 problem50;
    //Problem44 problem;
    
    @Override
    public void start(Stage primaryStage) {
        
        //New vertical box
        VBox mainBox = new VBox(1);
        
        //New horizontal box
        HBox bottomHBox = new HBox(1);
        
        Button[] buttons = createButtons();
        
        bottomHBox.getChildren().addAll(buttons);
        
        mainBox.getChildren().addAll(buttons[0], bottomHBox);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(mainBox);
        
        //root.setAlignment(bottomHBox, Pos.BOTTOM_RIGHT);
        //root.setAlignment(btn, Pos.TOP_LEFT);
        //root.setAlignment(btn2, Pos.BOTTOM_RIGHT);
        //root.setAlignment(btn3, Pos.BOTTOM_CENTER);
        //root.setAlignment(btn4, Pos.BOTTOM_CENTER);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Project Euler Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Button[] createButtons(){
        
        Button[] buttons = new Button[7];
                
        Button btn = new Button();
        btn.setText("Problem 46");
        btn.setOnAction((ActionEvent event) -> {
            Problem46 problem;
            problem = new Problem46();
            problem.solve();
            problem.solution();
        });
        buttons[6] = btn;
        
        Button btn2 = new Button();
        btn2.setText("Problem 26");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
           
            @Override
            public void handle(ActionEvent event){
                Problem26 problem = new Problem26();
                problem.solve();
                problem.solution();
            }
        });
        buttons[1] = btn2;
        
        Button btn3 = new Button();
        btn3.setText("Problem 27");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Problem27 problem = new Problem27();
                problem.solve();
                problem.solution();
            }
        });
        buttons[2] = btn3;
        
        Button btn4 = new Button();
        btn4.setText("Problem 50");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Problem50 problem = new Problem50();
                problem.solve();
                problem.solution();
            }
        });
        buttons[3] = btn4;

        Button btn5 = new Button();
        btn5.setText("Problem 44");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Problem44 problem = new Problem44();
                problem.solve();
                problem.solution();
            }
        });
        buttons[4] = btn5;
        
        Button btn6 = new Button();
        btn6.setText("Problem 49");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Problem49 problem = new Problem49();
                problem.solve();
                problem.solution();
            }
        });
        buttons[5] = btn6;
        
        buttons[0] = new Button();
        buttons[0].setText("Current Problem, 45");
        buttons[0].setOnAction( (ActionEvent event) -> {
            Problem45 problem;
            
            problem = new Problem45();
            problem.solve();
            problem.solution();
            //System.out.println("Problem 45 took " + UtilityClass.endTimer() + " ms to complete.");
        });
        
        
        //int numberOfButtons = 5;
        //Button[] buttons = {btn, btn2, btn3, btn4, btn5, btn6};
        
        return buttons;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
