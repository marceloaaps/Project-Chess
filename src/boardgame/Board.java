package boardgame;

public class Board {

    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Erro criando tabuleiro, é necessário que haja pelo menos uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece (int row, int columns){
        if (!positionExists(row, columns)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[row][columns];
    }

    public Piece piece (Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void PlacePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça na seguinte posição: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece (Position position){
        if (!positionExists(position)){
            throw new BoardException("Essa posição não está no tabuleiro!");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    private boolean positionExists (int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists (Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return piece(position) != null;
    }


}
