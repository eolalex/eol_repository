package org.bibalex.eol.collections;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document
public class Node {

    private String nodeId;
    @Indexed
    private int resourceId;
    @LastModifiedDate
    private Instant modifiedAt;
    private Integer parentGNId;
    private Boolean preferred;
    private Integer pageId;
    private String acceptedNameUsageId;
    private String rank;
    @Id private String _id;
    private String canonicalName;
    private String scientificName;
    private String italicizedScientificName;
    private String taxonomicStatus;
    private Integer landMark;
    private String[] referenceIds;
    private String[] identifiers;
    private Boolean inUnMappedArea;
    private Boolean hasBreadCrumb;
    private String sourceUrl;
    private String[] attributesFromGnParser;
    private String remarks;
    private String attributions;
    private List<Vernacular> vernaculars;


    public String getNodeId() {

        return nodeId;
    }

    public String toString() {
        return "Page: " + pageId + " -Sci:" + scientificName + " -res: " + resourceId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Integer getParentGNId() {
        return parentGNId;
    }

    public void setParentGNId(Integer parentGNId) {
        this.parentGNId = parentGNId;
    }

    public Boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getAcceptedNameUsageId() {
        return acceptedNameUsageId;
    }

    public void setAcceptedNameUsageId(String acceptedNameUsageId) {
        this.acceptedNameUsageId = acceptedNameUsageId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getItalicizedScientificName() {
        return italicizedScientificName;
    }

    public void setItalicizedScientificName(String italicizedScientificName) {
        this.italicizedScientificName = italicizedScientificName;
    }

    public String getTaxonomicStatus() {
        return taxonomicStatus;
    }

    public void setTaxonomicStatus(String taxonomicStatus) {
        this.taxonomicStatus = taxonomicStatus;
    }

    public Integer getLandMark() {
        return landMark;
    }

    public void setLandMark(Integer landMark) {
        this.landMark = landMark;
    }

    public String[] getReferenceIds() {
        return referenceIds;
    }

    public void setReferenceIds(String[] referenceIds) {
        this.referenceIds = referenceIds;
    }

    public String[] getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(String[] identifiers) {
        this.identifiers = identifiers;
    }

    public Boolean isInUnMappedArea() {
        return inUnMappedArea;
    }

    public void setInUnMappedArea(Boolean inUnMappedArea) {
        this.inUnMappedArea = inUnMappedArea;
    }

    public Boolean isHasBreadCrumb() {
        return hasBreadCrumb;
    }

    public void setHasBreadCrumb(Boolean hasBreadCrumb) {
        this.hasBreadCrumb = hasBreadCrumb;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String[] getAttributesFromGnParser() {
        return attributesFromGnParser;
    }

    public void setAttributesFromGnParser(String[] attributesFromGnParser) {
        this.attributesFromGnParser = attributesFromGnParser;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAttributions() {
        return attributions;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    public List<Vernacular> getVernaculars() {
        return vernaculars;
    }

    public void setVernaculars(List<Vernacular> vernaculars) {
        this.vernaculars = vernaculars;
    }
}
