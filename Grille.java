
/**
 * La classe Grille représente la grille de jeu dans laquelle évolue le robot.
 * Elle contient des cases avec différentes caractéristiques telles que des murs,
 * des portes, des clés, des téléporteurs, des non-kittens et un kitten.
 */
public class Grille {
    private Case[][] grille; // La grille de jeu
    private int nbrPiecesX; // Le nombre de pièces en largeur
    private int nbrPiecesY; // Le nombre de pièces en hauteur
    private int largeurPiece; // La largeur d'une pièce
    private int hauteurPiece; // La hauteur d'une pièce
    private int nbrNonKitten; // Le nombre de non-kittens présents sur la grille

    /**
     * Constructeur de la classe Grille.
     * Initialise la grille en fonction des paramètres passés.
     *
     * @param nbrPiecesX    Le nombre de pièces en largeur.
     * @param nbrPiecesY    Le nombre de pièces en hauteur.
     * @param largeurPiece  La largeur d'une pièce.
     * @param hauteurPiece  La hauteur d'une pièce.
     * @param nbrNonKitten  Le nombre de non-kittens à placer sur la grille.
     */
    
    public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece, int hauteurPiece, int nbrNonKitten) {

        // Initialisations des variables
        this.nbrPiecesX = nbrPiecesX;
        this.nbrPiecesY = nbrPiecesY;
        this.largeurPiece = largeurPiece;
        this.hauteurPiece = hauteurPiece;
        this.nbrNonKitten = nbrNonKitten;

        // Initialisation de la grille
        this.grille = new Case[this.hauteurPiece * this.nbrPiecesY][this.largeurPiece * this.nbrPiecesX];

        // Création du mur du nord '%' de la grille.
        for (int i = 0; i < this.grille.length; i++) {
            this.grille[i][0] = new Mur();
        }

        // Création du mur de l'ouest '%' de la grille.
        for (int i = 0; i < this.grille[0].length; i++) {
            this.grille[0][i] = new Mur();
        }

        // Création du mur du centre et la création des portes.
        for (int x = 1; x < this.nbrPiecesY; x++) {
            for (int i = 0; i < this.grille[0].length; i++) {
                if (i % this.largeurPiece == (int) (this.largeurPiece / 2)) {
                    this.grille[(this.hauteurPiece * x)][i] = new Porte();
                } else {
                    this.grille[(this.hauteurPiece * x)][i] = new Mur();
                }
            }
        }
        
        // Création des mur verticaux et la création des portes.
        for(int x = 1; x < this.nbrPiecesX; x++) {
            for (int i = 0; i < this.grille.length; i++) {
                if (i % this.hauteurPiece == (int) (this.hauteurPiece / 2)) {
                    this.grille[i][x * this.largeurPiece] = new Porte();
                } else {
                    this.grille[i][x * this.largeurPiece] = new Mur();
                }
            }
        }

        // Nous mettons les clés dans le grillage (une par case).
        for(int i = 0; i < this.nbrPiecesY; i++) {
            for(int x = 0; x < this.nbrPiecesX; x++) {

                // On génère aléatoirement où placer la clé.
                int coordY = (int)(Math.random() * (this.hauteurPiece - 1)) + 1 + i * this.hauteurPiece;
                int coordX = (int)(Math.random() * (this.largeurPiece - 1)) + 1 + x * this.largeurPiece;

                // On place la clé aléatoirement dans chaque case.
                this.grille[coordY][coordX] = new Cle();
                
            }
        }

        // On place chaque non kitten items spécifié dans la grille.
        for (int i = 0; i < this.nbrNonKitten; i++) {
            Point nonKittenCoord= this.randomEmptyCell();
            this.grille[nonKittenCoord.getX()][nonKittenCoord.getY()] = new NonKitten();
        }

        // On cherche à rajouter les téléporteurs sur la grille.
        Point teleporteur = this.randomEmptyCell();
        int teleporteurCoordX = teleporteur.getX();
        int teleporteurCoordY = teleporteur.getY();
        this.grille[teleporteurCoordX][teleporteurCoordY] = new Teleporteur();
        
        // On cherche à placer le Kitten sur la grille.
        Point kitten = this.randomEmptyCell();
        int kittenCoordX = kitten.getX();
        int kittenCoordY = kitten.getY();
        this.grille[kittenCoordX][kittenCoordY] = new Kitten();  
    }

    /**
     * Trouve une cellule vide aléatoire sur la grille.
     *
     * @return La position d'une cellule vide sous forme de Point.
     */
    public final Point randomEmptyCell() {
        int coordX; int coordY;

        do {
            coordX = (int) (Math.random() * this.grille.length);
            coordY = (int) (Math.random() * this.grille[0].length);
        } while (this.grille[coordX][coordY] != null);

        return new Point(coordX, coordY);
    }

    /**
     * Affiche la grille avec la position du robot.
     *
     * @param robot Le robot dont la position doit être affichée.
     */
    public final void afficher(Robot robot) {
        for (int i = 0; i < this.grille.length; i++) {
            for (int x = 0; x < this.grille[i].length; x++) {
                if (robot.getRobotPos().egal(i, x)) {
                    System.out.print('#');
                } else if (this.grille[i][x] == null) {
                    System.out.print(' ');
                } else {
                    System.out.print(this.grille[i][x].getRepresentation());
                }
            }
            System.out.println('%');
        }

        for (int i = 0; i <= this.grille[0].length ; i++) {
            System.out.print('%');
        }

        System.out.println();
    }

    /**
     * Vérifie si le déplacement du robot vers une certaine cellule est possible.
     *
     * @param robot Le robot dont on veut vérifier le déplacement.
     * @param x     La coordonnée x de la cellule à vérifier.
     * @param y     La coordonnée y de la cellule à vérifier.
     * @return      Vrai si le déplacement est possible, sinon faux.
     */
    public boolean deplacementPossible(Robot robot, int x, int y) {
        // Vérifie si les coordonnées sont valides dans la grille
        if (x < 0 || x >= grille.length || y < 0 || y >= grille[0].length) {
            return false; // Déplacement impossible en dehors de la grille
        }

        // Vérifie si la case est vide ou contient une porte
        return grille[x][y] == null || grille[x][y] instanceof Porte;
    }

    /**
     * Lance l'interaction entre le robot et la case de la grille sur laquelle il se trouve.
     *
     * @param robot Le robot avec lequel l'interaction doit avoir lieu.
     */
    void interagir(Robot robot) {
         // Récupère les cooonnées du robot
        Point positionRobot = robot.getRobotPos();
        int x = positionRobot.getX();
        int y = positionRobot.getY();

        // Vérifie si les coordonnées sont valides dans la grille
        if (x >= 0 && x < grille.length && y >= 0 && y < grille[0].length) {
            // Récupère la case sur laquelle se trouve le robot
            Case caseCourante = grille[x][y];
            // Vérifie s'il y a une interaction possible avec la case
            if (caseCourante != null) {
                // Lance l'interaction avec la case
                caseCourante.interagir(robot);
            }
        }
    }

    /**
     * Retourne la grille de jeu.
     *
     * @return La grille de jeu sous forme de tableau de cases.
     */
    public Case[][] getGrille() {
        return grille;
    }


}

