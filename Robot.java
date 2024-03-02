
/**
 * La classe Robot représente un robot dans l'environnement de jeu.
 * Le robot possède un nom, une position (représentée par un objet Point), un nombre de clés collectées,
 * un indicateur indiquant s'il possède un téléporteur et un indicateur indiquant s'il a trouvé un chaton.
 */

public class Robot {
    private String robotName;
    private Point robotPos;
    private int clesCollectees;
    private boolean hasTeleporteur;
    private boolean hasFoundKitten;

    /**
     * Constructeur par défaut de la classe Robot.
     * Initialise les propriétés du robot.
     *
     * @param robotName Le nom du robot.
     * @param robotPos La position initiale du robot, représentée par un objet Point.
     */
    public Robot(String robotName, Point robotPos) {
        this.robotName = robotName;
        this.robotPos = robotPos;
        this.clesCollectees = 0;
        this.hasTeleporteur = false;
        this.hasFoundKitten = false;
    }

    /**
     * Récupère le nom du robot.
     *
     * @return Le nom du robot.
     */
    public String getRobotName() {
        return this.robotName;
    }

    /**
     * Récupère le nombre de clés collectées par le robot.
     *
     * @return Le nombre de clés collectées par le robot.
     */
    public int getClesCollectees() {
        return this.clesCollectees;
    }

    /**
     * Récupère la position actuelle du robot.
     *
     * @return La position actuelle du robot, représentée par un objet Point.
     */
    public Point getRobotPos() {
        return this.robotPos;
    }

    /**
     * Vérifie si le robot possède un téléporteur.
     *
     * @return true si le robot possède un téléporteur, false sinon.
     */
    public boolean getHasTeleporteur() {
        return this.hasTeleporteur;
    }

    /**
     * Vérifie si le robot a trouvé le chaton.
     *
     * @return true si le robot a trouvé le chaton, false sinon.
     */
    public boolean getHasFoundKitten() {
        return this.hasFoundKitten;
    }

    /**
     * Incrémente le nombre de clés collectées par le robot.
     */
    public void incrementerClesCollectees() {
        this.clesCollectees++;
    }
    
    /**
     * Décrémente le nombre de clés collectées par le robot.
     */
    public void decrementerClesCollectees() {
        this.clesCollectees--;
    }

    /**
     * Met à jour l'état du téléporteur du robot.
     *
     * @param status Le nouvel état du téléporteur du robot.
     */
    public void updateHasTeleporteur(boolean status) {
        this.hasTeleporteur = status;
    }

    /**
     * Met à jour la position du robot.
     *
     * @param x La nouvelle coordonnée x de la position du robot.
     * @param y La nouvelle coordonnée y de la position du robot.
     */
    public void updateRobotPos(int x, int y) {
        this.robotPos = new Point(x, y);
    }

    /**
     * Met à jour l'état de la découverte du chaton par le robot.
     *
     * @param status Le nouvel état de la découverte du chaton par le robot.
     */
    public void updateHasfoundkitten(boolean status) {
        this.hasFoundKitten = status;
    }

    /**
     * Renvoie une représentation textuelle du robot.
     *
     * @return La représentation textuelle du robot sous la forme "nom [clesCollectees]T> ",
     * où 'T' est affiché si le robot possède un téléporteur.
     */
    @Override
    public String toString() {
        String representation = this.robotName + " [" + this.clesCollectees + "]";
        if (this.hasTeleporteur) representation += 'T';
        return representation + "> ";
    }

}
