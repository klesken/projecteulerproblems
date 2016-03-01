/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteulerproblems;

import java.util.Arrays;
import java.util.Comparator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
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
        //VBox mainBox = new VBox(1);
        
        //New horizontal box
        //HBox bottomHBox = new HBox(1);
        //HBox middleHBox = new HBox(1);
        
        Button[] buttons = createButtons();
        
        //bottomHBox.getChildren().addAll(Arrays.copyOfRange(buttons, 1, 8));
        //bottomHBox.getChildren().addAll(Arrays.copyOfRange(buttons, 8, buttons.length));
        
        //mainBox.getChildren().addAll(buttons[0], middleHBox, bottomHBox);
        
        //StackPane root = new StackPane();
        FlowPane root = new FlowPane();
        //root.setMaxWidth(800);
        root.getChildren().addAll(buttons);
        
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
        
        final int numberOfButtons = 15;
        Button[] buttons = new Button[numberOfButtons];
                
        Button btn = new Button();
        btn.setText("46");
        btn.setOnAction((ActionEvent event) -> {
            ProjectEulerProblem problem;
            problem = new Problem46();
            problem.solve();
            problem.solution();
        });
        buttons[6] = btn;
        
        
        Button btn2 = new Button();
        btn2.setText("26");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
           
            @Override
            public void handle(ActionEvent event){
                ProjectEulerProblem problem = new Problem26();
                problem.solve();
                problem.solution();
            }
        });
        buttons[1] = btn2;
        
        Button btn3 = new Button();
        btn3.setText("27");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProjectEulerProblem problem = new Problem27();
                problem.solve();
                problem.solution();
            }
        });
        buttons[2] = btn3;
        
        Button btn4 = new Button();
        btn4.setText("50");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProjectEulerProblem problem = new Problem50();
                problem.solve();
                problem.solution();
            }
        });
        buttons[3] = btn4;

        Button btn5 = new Button();
        btn5.setText("44");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProjectEulerProblem problem = new Problem44();
                problem.solve();
                problem.solution();
            }
        });
        buttons[4] = btn5;
        
        Button btn6 = new Button();
        btn6.setText("49");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProjectEulerProblem problem = new Problem49();
                problem.solve();
                problem.solution();
            }
        });
        buttons[5] = btn6;
        
        buttons[7] = new Button();
        buttons[7].setText("45");
        buttons[7].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem45();
            problem.solve();
            problem.solution();
        });        
        
        buttons[8] = new Button();
        buttons[8].setText("2");
        buttons[8].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem2();
            problem.solve();
            problem.solution();
        });
        
        buttons[9] = new Button();
        buttons[9].setText("3");
        buttons[9].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem3();
            problem.solve();
            problem.solution();
        });
        
        buttons[10] = new Button();
        buttons[10].setText("5");
        buttons[10].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem5();
            problem.solve();
            problem.solution();
        });
        
        buttons[11] = new Button();
        buttons[11].setText("6");
        buttons[11].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem6();
            problem.solve();
            problem.solution();
        });
        
        buttons[12] = new Button();
        buttons[12].setText("7");
        buttons[12].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem7();
            problem.solve();
            problem.solution();
        });
        
        buttons[13] = new Button();
        buttons[13].setText("8");
        buttons[13].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem8();
            problem.solve();
            problem.solution();
        });
        
        buttons[14] = new Button();
        buttons[14].setText("9");
        buttons[14].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem9();
            problem.solve();
            problem.solution();
        });
        
        buttons[0] = new Button();
        buttons[0].setText("Current Problem, 502");
        buttons[0].setOnAction( (ActionEvent event) -> {
            ProjectEulerProblem problem;
            
            problem = new Problem502();
            problem.solve();
            problem.solution();
        });              
        
        
        //int numberOfButtons = 5;
        //Button[] buttons = {btn, btn2, btn3, btn4, btn5, btn6};
        //System.out.println(buttons[0].getText());
        Arrays.sort(buttons, new Comparator<Button>(){
            @Override
            public int compare(Button t1, Button t2) {
                String s1 = t1.getText();//.chars().toArray();
                String s2 = t2.getText();//.chars().toArray();
                
                int i1; //= Integer.parseInt(s1);
                int i2; //= Integer.parseInt(s2);
                
                if((s1.chars().toArray())[0] == 'C'){ //Current problem, #
                    //i1 = 0;
                    return -1;
                }
                else if((s2.chars().toArray())[0] == 'C'){ //Current problem, #
                    //i2 = 0;
                    return 1;
                }
                
                i1 = Integer.parseInt(s1);
                i2 = Integer.parseInt(s2);
                
                return(i1 - i2);
            }
        });
        return buttons;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
