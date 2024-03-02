import java.util.Scanner;

/**
 * La classe principale du jeu RobotFindsKitten.
 * Ce jeu consiste à déplacer un robot dans une grille pour trouver le chaton (kitten).
 */
public class RobotFindsKitten {
    /**
     * Méthode principale qui lance le jeu.
     * @param args Les arguments de ligne de commande (non utilisés dans cette application).
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Présentation du jeu.
        presentation();
 
        // Initialisation des paramètres de départ.
        Grille grille = new Grille(5, 2, 12, 6, 50);
        Robot robot = new Robot("R.O.B.", grille.randomEmptyCell());
        
        while(true) {
            // Tant que le robot n'a pas trouvé le chaton
            while(!robot.getHasFoundKitten()) {
                grille.afficher(robot);
                System.out.println();
                System.out.print(robot);

                // Position du robot
                int robotCoordX = robot.getRobotPos().getX();
                int robotCoordY = robot.getRobotPos().getY();

                // Taking user input
                char reponse = scanner.next().toLowerCase().charAt(0);
                
                switch (reponse) {
                    case 'w':
                        robotCoordX--;
                        break;
                    case 'a':
                        robotCoordY--;
                        break;
                    case 's':
                        robotCoordX++;
                        break;
                    case 'd':
                        robotCoordY++;
                        break;
                    case 't':
                        if (robot.getHasTeleporteur()) {
                            Point coord = grille.randomEmptyCell();
                            robot.updateRobotPos(coord.getX(), coord.getY());
                            continue;
                        } else System.out.println("Vous n'avez pas de téléporteur.");
                        break;
                    default:
                        System.out.println("Veuillez entrer une lettre entre (w, a, s, d et t).");
                        break;
                }

                // Vérification si le déplacement est valide et interaction avec la case
                if (robotCoordX >= 0 && robotCoordY >=0 && robotCoordX != grille.getGrille().length && robotCoordY != grille.getGrille()[0].length) {
                    if (grille.getGrille()[robotCoordX][robotCoordY] == null || grille.getGrille()[robotCoordX][robotCoordY].interactionPossible(robot)){
                        robot.updateRobotPos(robotCoordX, robotCoordY);
                        if (grille.getGrille()[robotCoordX][robotCoordY] != null) {
                            grille.getGrille()[robotCoordX][robotCoordY].interagir(robot);
                            if (!(grille.getGrille()[robotCoordX][robotCoordY] instanceof NonKitten)) {
                                grille.getGrille()[robotCoordX][robotCoordY] = null;
                            }
                        }
                    }
                }
            }
            scanner.close();
            break;
        }
    }

    /**
     * Méthode statique pour afficher la présentation du jeu.
     */
    static void presentation() {
        System.out.println(); System.out.println();
        System.out.println("       " + "       Bienvenue dans RobotFindsKitten");
        System.out.println("       " + "Super Dungeon Master 3000 Ultra Turbo Edition !");
        System.out.println(); System.out.println();
    }
}
