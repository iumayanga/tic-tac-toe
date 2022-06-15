import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GameBoard implements Initializable {
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Label lblTurn;
    public TextField txtX;
    public TextField txtO;
    public Label lblWinner;
    public Button btnStart;

    char[] cells = new char[9];

    String playerX = "";
    String playerO = "";
    String currentPlayer = "";

    char winner = ' ';
    GameStatus gameStatus = new GameStatus();

    int count = 0;

    public void btn1_OnAction() {
        setCell(0, btn1);
        btn1.setDisable(true);
        count++;
    }

    public void btn2_OnAction() {
        setCell(1, btn2);
        btn2.setDisable(true);
        count++;
    }

    public void btn3_OnAction() {
        setCell(2, btn3);
        btn3.setDisable(true);
        count++;
    }

    public void btn4_OnAction() {
        setCell(3, btn4);
        btn4.setDisable(true);
        count++;
    }

    public void btn5_OnAction() {
        setCell(4, btn5);
        btn5.setDisable(true);
        count++;
    }

    public void btn6_OnAction() {
        setCell(5, btn6);
        btn6.setDisable(true);
        count++;
    }

    public void btn7_OnAction() {
        setCell(6, btn7);
        btn7.setDisable(true);
        count++;
    }

    public void btn8_OnAction() {
        setCell(7, btn8);
        btn8.setDisable(true);
        count++;
    }

    public void btn9_OnAction() {
        setCell(8, btn9);
        btn9.setDisable(true);
        count++;
    }

    public void btnStart_OnAction() {
        if(btnStart.getText().equals("START GAME") || btnStart.getText().equals("RESTART GAME")){
            if(txtX.getText().equals("") && txtO.getText().equals("")){
                lblWinner.setText("");

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter players' names first!", ButtonType.OK);
                alert.showAndWait();
            }else {
                lblWinner.setText("");

                txtX.setDisable(true);
                txtO.setDisable(true);
                btnStart.setDisable(true);

                playerX = txtX.getText();
                playerO = txtO.getText();
                currentPlayer = playerX;
                lblTurn.setText(playerX+"'s turn");

                boardButtonDisability(false);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardButtonDisability(true);
    }

    public void setCell(int index, Button button){
        if (currentPlayer == playerX){
            cells[index] = 'x';
            winner = gameStatus.check(cells);
            button.setText("X");
            currentPlayer = playerO;
            lblTurn.setText(playerO+"'s turn");
        }else {
            cells[index] = 'o';
            winner = gameStatus.check(cells);
            button.setText("O");
            currentPlayer = playerX;
            lblTurn.setText(playerX+"'s turn");
        }

        if (winner == 'x'){
            lblWinner.setText(playerX);
            restartGame();
        }else if (winner == 'o'){
            lblWinner.setText(playerO);
            restartGame();
        }else if (count == 9){
            lblWinner.setText("DRAW!");
            restartGame();
        }
    }

    public void boardButtonDisability(boolean choice){
        btn1.setDisable(choice);
        btn2.setDisable(choice);
        btn3.setDisable(choice);
        btn4.setDisable(choice);
        btn5.setDisable(choice);
        btn6.setDisable(choice);
        btn7.setDisable(choice);
        btn8.setDisable(choice);
        btn9.setDisable(choice);
    }

    public void restartGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        boardButtonDisability(true);
        btnStart.setText("RESTART GAME");
        btnStart.setDisable(false);
        lblTurn.setText("");
        txtX.clear();
        txtO.clear();
        txtX.setDisable(false);
        txtO.setDisable(false);

        winner = ' ';
        count = 0;
        for (int i = 0; i<cells.length; i++){
            cells[i] = ' ';
        }
    }
}
