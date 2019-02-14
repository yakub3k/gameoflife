package gameoflife.artefact;

import game.Artifact;
import game.Game;
import util.Log;

import java.util.Collection;


public class Artifactory {
    private ArtifactRepository repository;

    public Artifactory() {
        repository = new ArtifactRepository();
    }

    public Collection<String> getArtifacts() {
        return repository.getArtifactNames();
    }

    public void addArtifacts(Collection<Artifact> collection) {
        collection.forEach(repository::addArtifact);
    }

    //todo add game border check
    public void addArtifactToGame(String artifactName, Game game, int startX, int startY) {
        Artifact model = repository.getArtifact(artifactName);

        Log.log("Add >" + artifactName + "< on x: " + startX + " y: " + startY);
        boolean[][] matrix = model.getMatrix();
        for (int x = 0; x < model.getWidth(); x++) {
            for (int y = 0; y < model.getHeight(); y++) {
                if (matrix[y][x]) {
                    game.setAlive(startX + x, startY + y);
                } else {
                    game.setDead(startX + x, startY + y);
                }
            }
        }
    }
}
