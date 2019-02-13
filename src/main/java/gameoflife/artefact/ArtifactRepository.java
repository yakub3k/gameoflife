package gameoflife.artefact;

import game.Artifact;
import gameoflife.artefact.models.Dot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArtifactRepository {
    private Map<String, Artifact> map;
    private Artifact defaultArtifact = new Dot();

    public ArtifactRepository() {
        this.map = new HashMap<>();
    }

    public void addArtifact(Artifact artifact) {
        this.map.put(artifact.getName(), artifact);
    }

    public void addDefaultArtifact(Artifact artifact) {
        this.map.put(artifact.getName(), artifact);
        this.defaultArtifact = artifact;
    }

    Artifact getArtifact(String name) {
        Artifact artifact = map.get(name);
        return artifact != null ? artifact : defaultArtifact;
    }

    public Collection<String> getArtifactNames(){
        return map.keySet();
    }


}
