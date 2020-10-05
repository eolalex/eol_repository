package org.bibalex.eol.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Medium {

    private String mediumId;
    private int resourceId;
    private String modifiedAt;
    private String nodeId;
    private UUID guid;
    private List<MediumVersion> versions;

    //TODO: Still have to add agents and location under discussion
    //todo : specify primary key
    public String getMediaId() {
        return mediumId;
    }

    public void setMediaId(String mediumId) {
        this.mediumId = mediumId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public List<MediumVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<MediumVersion> versions) {
        this.versions = versions;
    }


}
