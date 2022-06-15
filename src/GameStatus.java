public class GameStatus {
    public char check(char[] cells){
        char winner = ' ';

        if(cells[0]==cells[1] && cells[0]==cells[2]){ // rows
            winner = cells[0];
        }else if (cells[3]==cells[4] && cells[3]==cells[5]){
            winner = cells[3];
        }else if (cells[6]==cells[7] && cells[6]==cells[8]){
            winner = cells[6];
        }else if (cells[0]==cells[3] && cells[0]==cells[6]){ // columns
            winner = cells[0];
        }else if (cells[1]==cells[4] && cells[1]==cells[7]){
            winner = cells[1];
        }else if (cells[2]==cells[5] && cells[2]==cells[8]){
            winner = cells[2];
        }else if (cells[0]==cells[4] && cells[0]==cells[8]){ // diagonals
            winner = cells[0];
        }else if (cells[2]==cells[4] && cells[2]==cells[6]){
            winner = cells[2];
        }

        return winner;
    }
}
