package de.fuwa.bomberman.game.utils;

import de.fuwa.bomberman.game.components.PositionComponent;
import de.fuwa.bomberman.game.enums.BlockType;

public class GameUtils {

    /**
     * Returns true if the specified positions are logically in the same cell.
     *
     * @param p1 the first position
     * @param p2 the second position
     * @return true if the positions are refering to the same logical cell
     */
    public static boolean inSameCell(PositionComponent p1, PositionComponent p2) {
        int x1 = Math.round(p1.getX());
        int x2 = Math.round(p2.getX());
        int y1 = Math.round(p1.getY());
        int y2 = Math.round(p2.getY());
        return x1 == x2 && y1 == y2;
    }

    public static GameField createSimpleGameField() {
        int width = 11;
        int height = 11;

        GameField gameField = new GameField(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || x == 0 || y == height - 1 || x == width - 1 || (x % 2 == 0 && y % 2 == 0)) {
                    gameField.setBlock(x, y, BlockType.Undestroyable);
                }
            }
        }
        return gameField;
    }

    public static GameField createComplexGameField(){
        int width = 11;
        int height = 11;

        GameField gameField = new GameField(width, height);

        int[][] field = {{1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,2,2,2,2,2,0,0,1},
                {1,0,1,2,1,2,1,2,1,0,1},
                {1,2,2,2,2,2,2,2,2,2,1},
                {1,2,1,2,1,2,1,2,1,2,1},
                {1,2,2,2,2,2,2,2,2,2,1},
                {1,2,1,2,1,2,1,2,1,2,1},
                {1,2,2,2,2,2,2,2,2,2,1},
                {1,0,1,2,1,2,1,2,1,0,1},
                {1,0,0,2,2,2,2,2,0,0,1,},
                {1,1,1,1,1,1,1,1,1,1,1}};

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(field[x][y] == 1) gameField.setBlock(x,y, BlockType.Undestroyable);
                else if(field[x][y] == 2) gameField.setBlock(x, y, BlockType.Destroyable);
            }
        }

        return gameField;
    }
    public static PositionComponent getCellPosition(PositionComponent pos){
        int x = Math.round(pos.getX());
        int y = Math.round(pos.getY());
        return new PositionComponent(x,y);
    }
}
