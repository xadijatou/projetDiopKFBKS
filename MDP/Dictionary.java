import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public static void main(String[] args) {
        String absolutePath = "dic.txt"; // Chemin absolu vers le fichier du dictionnaire

        try {
            BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
            List<String> dictionary = new ArrayList<>();

            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word); // Ajoute le mot au dictionnaire
            }
            reader.close();

            boolean passwordFound = false;
            while (!passwordFound) {
                System.out.print("Entrez un mot de passe : ");
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                String enteredPassword = inputReader.readLine();

                if (dictionary.contains(enteredPassword)) {
                    System.out.println("Mot de passe trouvé !");
                    passwordFound = true;
                } else {
                    System.out.println("Mot de passe non trouvé. Réessayez.");
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
