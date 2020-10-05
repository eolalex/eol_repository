package org.bibalex.eol.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MediumVersion {

    private String modifiedAt;
    private String subclass;
    private String format;
    private String subject;
    private String title;
    private String name;
    private String description;
    private String accessUrl;
    private String thumbnailUrl;
    private String furtherInformationUrl;
    private String derivedFrom;
    private String createdDate;
    private String language;
    private Double rating;
    private String audience;
    private String license;
    private String rights;
    private String owner;
    private String bibliograhicCitation;
    private String publisher;
    private String contributer;
    private String creator;
    private String[] referenceIds;
    private String baseUrl;
    private String UnmodifiedUrl;
    private String sourceUrl;
    private String sourcePageUrl;
    private String usageStatement;
    private HashMap<String,String> imageInfo;
    private List<Agent> agents;

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getBibliograhicCitation() {
        return bibliograhicCitation;
    }

    public void setBibliograhicCitation(String bibliograhicCitation) {
        this.bibliograhicCitation = bibliograhicCitation;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContributer() {
        return contributer;
    }

    public void setContributer(String contributer) {
        this.contributer = contributer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String[] getReferenceIds() {
        return referenceIds;
    }

    public void setReferenceIds(String[] referenceIds) {
        this.referenceIds = referenceIds;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUnmodifiedUrl() {
        return UnmodifiedUrl;
    }

    public void setUnmodifiedUrl(String unmodifiedUrl) {
        UnmodifiedUrl = unmodifiedUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourcePageUrl() {
        return sourcePageUrl;
    }

    public void setSourcePageUrl(String sourcePageUrl) {
        this.sourcePageUrl = sourcePageUrl;
    }

    public String getUsageStatement() {
        return usageStatement;
    }

    public void setUsageStatement(String usageStatement) {
        this.usageStatement = usageStatement;
    }

    public HashMap<String, String> getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(HashMap<String, String> imageInfo) {
        this.imageInfo = imageInfo;
    }

    public String getSubclass() {

        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFurtherInformationUrl() {
        return furtherInformationUrl;
    }

    public void setFurtherInformationUrl(String furtherInformationUrl) {
        this.furtherInformationUrl = furtherInformationUrl;
    }

    public String getDerivedFrom() {
        return derivedFrom;
    }

    public void setDerivedFrom(String derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
