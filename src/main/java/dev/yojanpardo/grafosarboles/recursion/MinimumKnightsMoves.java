package dev.yojanpardo.grafosarboles.recursion;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static dev.yojanpardo.Helper.scanner;

/**
 * En un tablero de ajedrez infinito se tiene un caballo en la casilla [origenX,origenY]
 * devuelve el numero minimo de movimientos que tiene que hacer un caballo para
 * llegar a las casillas objetivo [objetivoX, objetivoY]
 * Se garantiza que la respuesta exite.
 */
public class MinimumKnightsMoves {

    private static final Set<Move> POSSIBLE_MOVES = new HashSet<>();
    private static final Set<Move> VISITED_CELLS = new HashSet<>();


    public static void main(String[] args) {
        System.out.println("Welcome to Minimum knights moves!");
        System.out.println("in here you can calculate the minimum moves a chess knight needs to move from x,y point to another coordinates in an infinite chess board.");

        System.out.print("please insert the x coordinate for the initial position: ");
        final int startX = scanner.nextInt();

        System.out.print("please insert the y coordinate for the initial position: ");
        final int startY = scanner.nextInt();

        final Move start = new Move(startX, startY);

        System.out.println("now you need to insert the destination coordinates...");
        System.out.print("insert the x destination coordinate: ");
        final int destinationX = scanner.nextInt();

        System.out.print("insert the y destination coordinate: ");
        final int destinationY = scanner.nextInt();

        final Move destination = new Move(destinationX, destinationY);

        System.out.printf("the minimum moves to move from [%d,%d] to [%d,%d] are: [%d]", start.getX(), start.getY(), destination.getX(), destination.getY(), calculateMoves(start, destination));
    }

    private static int calculateMoves(final Move start, final Move destination) {

        int moves = 0;

        if(start.equals(destination)){
            return moves;
        }

        Queue<Move> movements =  new LinkedList<>();
        movements.add(start);
        VISITED_CELLS.add(start);
        POSSIBLE_MOVES.add(start);

        while(!movements.isEmpty()){

            int size = movements.size();
            printBoard();

            for(int i = 0; i < size; i++){
                Move actualMove = movements.poll();

                if (actualMove.equals(destination)) {
                    printBoard();
                    return moves;
                }
                for(Move nextMove : getPossibleMovementsForKnight(actualMove)){
                    if(!VISITED_CELLS.contains(nextMove)){
                        VISITED_CELLS.add(nextMove);
                        movements.add(nextMove);
                    }
                }
            }
            moves++;

        }

        return moves;
    }

    private static Queue<Move> getPossibleMovementsForKnight(final Move start) {

        //System.out.printf("Possible new movements for knight at [%d,%d] are: \n", start.getX(), start.getY());
        Queue<Move> moves = new LinkedList<>();

        int[][] directions = new int[][]{{2, 1}, {1, 2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};

        for (int[] d : directions) {
            // No se verifica aquí si ha sido visitado, esa lógica se maneja en calculateMoves.
            validateAndAddNonVisitedCell(moves, new Move(start.getX() + d[0], start.getY() + d[1]));
        }

        return moves;
    }

    private static void validateAndAddNonVisitedCell(Queue<Move> moves, Move move) {
        if(!POSSIBLE_MOVES.contains(move)) {
            POSSIBLE_MOVES.add(move);
            moves.add(move);
           // System.out.printf("\t [%d,%d]\n", move.getX(), move.getY());
        }
    }

    private static void printBoard(){
        int minX = POSSIBLE_MOVES.stream().min(Comparator.comparingInt(Move::getX)).orElseThrow().getX();
        int maxX = POSSIBLE_MOVES.stream().max(Comparator.comparingInt(Move::getX)).orElseThrow().getX();
        int minY = POSSIBLE_MOVES.stream().min(Comparator.comparingInt(Move::getY)).orElseThrow().getY();
        int maxY = POSSIBLE_MOVES.stream().max(Comparator.comparingInt(Move::getY)).orElseThrow().getY();

        for(int x = minX; x <= maxX; x++){
            for(int y = minY; y <= maxY; y++){
                Move currentMove = new Move(x,y);
                if(POSSIBLE_MOVES.contains(currentMove)){
                    System.out.print(" V ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }

        System.out.println("------------------------------");
    }

}
