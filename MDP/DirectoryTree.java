import java.io.File;

public class DirectoryTree {

    public static void main(String[] args) {
        // Vérifiez si un chemin de répertoire est fourni
        if (args.length != 1) {
            System.out.println("veuillez fournir un chemin de repertoire");
            System.exit(1);
        }

        // Obtenir le chemin du répertoire à partir des arguments
        String directoryPath = args[0];
        File directory = new File(directoryPath);

        // Vérifiez si le chemin est un répertoire valide
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
            System.exit(1);
        }

        // Afficher l'arborescence du répertoire
        displayDirectoryTree(directory, 0);
    }

    // Méthode récursive pour afficher l'arborescence des répertoires
    public static void displayDirectoryTree(File dir, int level) {
        // Obtenir tous les fichiers et répertoires dans le répertoire actuel
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        // Trier les fichiers et répertoires par nom pour un affichage ordonné
        java.util.Arrays.sort(files);

        for (File file : files) {
            // Afficher l'indentation en fonction du niveau de profondeur
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            // Afficher le nom du fichier ou du répertoire
            System.out.println("|-- " + file.getName());

            // Si c'est un répertoire, appeler récursivement pour afficher son contenu
            if (file.isDirectory()) {
                displayDirectoryTree(file, level + 1);
            }
        }
    }
}
