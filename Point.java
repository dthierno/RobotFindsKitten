
/**
 * La classe Point représente un point dans un espace bidimensionnel défini par ses coordonnées x et y.
 */
public class Point {
    /**
     * La coordonnée x du point.
     */
    private final int x;

    /**
     * La coordonnée y du point.
     */
    private final int y;

    /**
     * Constructeur par défaut de la classe Point.
     * Initialise les coordonnées x et y du point en question.
     *
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
     /**
     * Vérifie si le point a les mêmes coordonnées que celles spécifiées.
     *
     * @param x La coordonnée x à comparer.
     * @param y La coordonnée y à comparer.
     * @return true si les coordonnées spécifiées correspondent à celles du point, false sinon.
     */
    public boolean egal(int x, int y) {
        return x == this.x && y == this.y;
    }
    
    /**
     * Récupère la coordonnée x du point.
     *
     * @return La coordonnée x du point.
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère la coordonnée y du point.
     *
     * @return La coordonnée y du point.
     */
    public int getY() {
        return y;
    }
}
