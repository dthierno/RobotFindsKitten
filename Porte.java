
/**
 * La classe Porte représente une case qui est une porte dans l'environnement de jeu.
 * Elle hérite de la classe Case et permet une interaction avec un robot pour passer à travers la porte.
 */
public class Porte extends Case {

    /**
     * Constructeur par défaut de la classe Porte.
     * Initialise la représentation de la porte avec le caractère '!'.
     */
    public Porte() {
        super.representation = '!';
    }

    /**
     * Vérifie si une interaction est possible entre la porte et un robot.
     * Cette méthode retourne true si le robot possède au moins une clé, permettant ainsi de passer à travers la porte.
     *
     * @param robot Le robot avec lequel l'interaction est vérifiée.
     * @return true si une interaction avec la porte est possible, false sinon.
     */
    @Override
    public Boolean interactionPossible(Robot robot) {
        return robot.getClesCollectees() > 0;
    }

    /**
     * Méthode d'interaction entre la porte et un robot.
     * Lorsqu'un robot interagit avec une porte, une clé est utilisée pour la déverrouiller.
     *
     * @param robot Le robot avec lequel l'interaction est effectuée.
     */
    @Override
    public void interagir(Robot robot) {
        robot.decrementerClesCollectees(); 
    }
}
