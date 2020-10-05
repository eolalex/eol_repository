package org.bibalex.eol.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Article {

    private String articleId;
    private int resourceId;
    private String modifiedAt;
    private String nodeId;
    private UUID guid;
    private List<ArticleVersion> versions;
    //todo: Still have to add  location under discussion
    //todo: choose primary key
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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

    public List<ArticleVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ArticleVersion> versions) {
        this.versions = versions;
    }
}
