
/**
 * La classe Cle représente une case qui contient une clé dans l'environnement de jeu.
 * Elle hérite de la classe Case et permet une interaction avec un robot pour collecter la clé.
 */
public class Cle extends Case {

    /**
     * Constructeur par défaut de la classe Cle.
     * Initialise la représentation de la clé avec le caractère (').
     */
    public Cle() {
        super.representation = '\'';
    }

    /**
     * Vérifie si une interaction est possible entre la clé et un robot.
     * Cette méthode retourne toujours true car la clé peut être collectée par le robot.
     *
     * @param robot Le robot avec lequel l'interaction est vérifiée.
     * @return true, car une interaction avec la clé est toujours possible.
     */
    @Override
    public Boolean interactionPossible(Robot robot) {
        return true;
    }

    /**
     * Méthode d'interaction entre la clé et un robot.
     * Lorsqu'un robot interagit avec la clé, il collecte la clé et incrémente le compteur de clés collectées.
     *
     * @param robot Le robot avec lequel l'interaction est effectuée.
     */
    @Override
    public void interagir(Robot robot) {
        robot.incrementerClesCollectees();
    }

    
}
