
/**
 * La classe Teleporteur représente une case qui est un téléporteur dans l'environnement de jeu.
 * Elle hérite de la classe Case et permet une interaction avec un robot pour stocker le téléporteur.
 */
public class Teleporteur extends Case {

    /**
     * Constructeur par défaut de la classe Teleporteur.
     * Initialise la représentation du téléporteur avec le caractère 'T'.
     */
    public Teleporteur() {
        super.representation = 'T';
    }

    /**
     * Vérifie si une interaction est possible entre le téléporteur et un robot.
     * Cette méthode retourne toujours true car un robot peut toujours intéragir avec le téléporteur pour le stocker.
     *
     * @param robot Le robot avec lequel l'interaction est vérifiée.
     * @return true, car une interaction avec un téléporteur est toujours possible.
     */
    @Override
    public Boolean interactionPossible(Robot robot) {
        return true;
    }

    /**
     * Méthode d'interaction entre le téléporteur et un robot.
     * Lorsqu'un robot interagit avec un téléporteur, celui-ci est stocké.
     *
     * @param robot Le robot avec lequel l'interaction est effectuée.
     */
    @Override
    public void interagir(Robot robot) {
        robot.updateHasTeleporteur(true);
    }
}
