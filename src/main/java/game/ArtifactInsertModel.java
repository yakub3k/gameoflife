package game;

import gameoflife.artefact.Artifactory;

public interface ArtifactInsertModel {

    void setInsertModel(String insertModelName);
    String getInsertModel();
    void clearInsertModel();
    boolean hasInsertModel();
    Artifactory getArtifactory();
}
