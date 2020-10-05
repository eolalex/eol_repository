package org.bibalex.eol.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Trait {

    private int traitId;
    private String modifiedAt;
    private int resourceId;
    private String nodeId;
    private String bibliographicCitation;
    private String measurementType;
    private String givenMeasurementValue;
    private String givenMeasurementUnit;
    private Double normalizedMeasurementValue;
    private String normalizedMeasurementUnit;
    private String accuracy;
    private String determinedDate;
    private String determinedBy;
    private String measurementMethod;
    private String remarks;
    private String source;
    private String citation;
    private String contributor;
    private String[] referenceIds;
    private String scientificName;
    private String objectNodeId;
    private String targetScientificName;
    private String literal;
    private Double measurement;
    private String sex;
    private String lifestage;
    private TraitLocation location;
    private List<MetaData> metaData;

    public String getContributor() {
        return contributor;
    }

    public void setContributer(String contributor) {
        this.contributor = contributor;
    }

    public String[] getReferenceIds() {
        return referenceIds;
    }

    public void setReferenceIds(String[] referenceIds) {
        this.referenceIds = referenceIds;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getObjectNodeId() {
        return objectNodeId;
    }

    public void setObjectNodeId(String objectNodeId) {
        this.objectNodeId = objectNodeId;
    }

    public String getTargetScientificName() {
        return targetScientificName;
    }

    public void setTargetScientificName(String targetScientificName) {
        this.targetScientificName = targetScientificName;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLifestage() {
        return lifestage;
    }

    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    public TraitLocation getLocation() {
        return location;
    }

    public void setLocation(TraitLocation location) {
        this.location = location;
    }

    public int getTraitId() {

        return traitId;
    }

    public void setTraitId(int traitId) {
        this.traitId = traitId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getBibliographicCitation() {
        return bibliographicCitation;
    }

    public void setBibliographicCitation(String bibliographicCitation) {
        this.bibliographicCitation = bibliographicCitation;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public String getGivenMeasurementValue() {
        return givenMeasurementValue;
    }

    public void setGivenMeasurementValue(String givenMeasurementValue) {
        this.givenMeasurementValue = givenMeasurementValue;
    }

    public String getGivenMeasurementUnit() {
        return givenMeasurementUnit;
    }

    public void setGivenMeasurementUnit(String givenMeasurementUnit) {
        this.givenMeasurementUnit = givenMeasurementUnit;
    }

    public Double getNormalizedMeasurementValue() {
        return normalizedMeasurementValue;
    }

    public void setNormalizedMeasurementValue(Double normalizedMeasurementValue) {
        this.normalizedMeasurementValue = normalizedMeasurementValue;
    }

    public String getNormalizedMeasurementUnit() {
        return normalizedMeasurementUnit;
    }

    public void setNormalizedMeasurementUnit(String normalizedMeasurementUnit) {
        this.normalizedMeasurementUnit = normalizedMeasurementUnit;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getDeterminedDate() {
        return determinedDate;
    }

    public void setDeterminedDate(String determinedDate) {
        this.determinedDate = determinedDate;
    }

    public String getDeterminedBy() {
        return determinedBy;
    }

    public void setDeterminedBy(String determinedBy) {
        this.determinedBy = determinedBy;
    }

    public String getMeasurementMethod() {
        return measurementMethod;
    }

    public void setMeasurementMethod(String measurementMethod) {
        this.measurementMethod = measurementMethod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }
}
