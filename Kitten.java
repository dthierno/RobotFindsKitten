
/**
 * La classe Kitten représente une case qui contient le chaton dans l'environnement de jeu.
 * Elle hérite de la classe Case et permet une interaction avec le robot pour découvrir le chaton.
 */
public class Kitten extends Case{
    private String kittenName;
    private static String[] bankDeKittenName = {
        "Caramel", "Milou", "Kim", "Luna", "Milo",
        "Oliver", "Leo", "Bella", "Charlie", "Lily", "Kitty"
    };
    
    /**
     * Constructeur par défaut de la classe Kitten.
     * Initialise la représentation du chaton avec un symbole aléatoire et attribue un nom de chaton aléatoire.
     */
    public Kitten() {
        super.representation = super.getRandomSymbole();
        this.kittenName = bankDeKittenName[(int) (Math.random() * bankDeKittenName.length)];
    }

    /**
     * Vérifie si une interaction est possible entre le chaton et un robot.
     * Cette méthode retourne toujours true car une interaction avec le chaton est toujours possible.
     *
     * @param robot Le robot avec lequel l'interaction est vérifiée.
     * @return true, car une interaction avec un chaton est toujours possible.
     */
    @Override
    public Boolean interactionPossible(Robot robot) {
        return true;
    }

    /**
     * Méthode d'interaction entre le chaton et un robot.
     * Lorsqu'un robot interagit avec un chaton, le chaton est découvert et son nom est affiché.
     *
     * @param robot Le robot avec lequel l'interaction est effectuée.
     */
    @Override
    public void interagir(Robot robot) {
        System.out.println("You found kitten! Way to go, robot.");
        System.out.println(this.kittenName + " <3 " + robot.getRobotName());
        robot.updateHasfoundkitten(true);
    }
}
