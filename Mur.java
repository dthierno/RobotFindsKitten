
/**
 * La classe Mur représente une case qui est un mur dans l'environnement de jeu.
 * Elle hérite de la classe Case et ne permet pas d'interaction avec un robot.
 */
public class Mur extends Case {

    /**
     * Constructeur par défaut de la classe Mur.
     * Initialise la représentation du mur avec le caractère '%'.
     */
    public Mur() {
        super.representation = '%';
    }

    /**
     * Vérifie si une interaction est possible entre le mur et un robot.
     * Comme un mur ne permet pas d'interaction, cette méthode retourne toujours false.
     *
     * @param robot Le robot avec lequel l'interaction est vérifiée.
     * @return false car une interaction avec un mur n'est pas possible.
     */
    @Override
    public final Boolean interactionPossible(Robot robot) {
        return false;
    }

    /**
     * Méthode d'interaction entre le mur et un robot.
     * Étant donné que le mur ne peut pas être traversé par le robot,
     * cette méthode ne fait rien.
     *
     * @param robot Le robot avec lequel l'interaction est effectuée.
     */
    @Override
    public final void interagir(Robot robot) {
        // Ne rien faire, car un mur ne peut pas être traversé par le robot.
    }
 
}
