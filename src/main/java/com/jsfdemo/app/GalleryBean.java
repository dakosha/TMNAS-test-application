package com.jsfdemo.app;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean demonstrating: h:graphicImage, h:outputLink, h:outputStylesheet,
 * h:panelGrid, h:panelGroup, h:outputText
 */
@Named("galleryBean")
@ViewScoped
public class GalleryBean implements Serializable {

    private List<GalleryItem> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
        items.add(new GalleryItem(
                "WildFly Application Server",
                "https://design.jboss.org/wildfly/logo/final/wildfly_logo.svg",
                "https://www.wildfly.org/",
                "The flexible, lightweight, managed application runtime that helps you build amazing applications."
        ));
        items.add(new GalleryItem(
                "Jakarta EE",
                "https://jakarta.ee/images/jakarta/jakarta-ee-logo-color.svg",
                "https://jakarta.ee/",
                "The open source platform for building cloud native enterprise Java applications."
        ));
        items.add(new GalleryItem(
                "Apache Maven",
                "https://maven.apache.org/images/maven-logo-black-on-white.png",
                "https://maven.apache.org/",
                "A software project management and comprehension tool based on the concept of POM."
        ));
    }

    public List<GalleryItem> getItems() {
        return items;
    }

    /**
     * Inner class representing a gallery item.
     */
    public static class GalleryItem implements Serializable {
        private String title;
        private String imageUrl;
        private String linkUrl;
        private String description;

        public GalleryItem() {
        }

        public GalleryItem(String title, String imageUrl, String linkUrl, String description) {
            this.title = title;
            this.imageUrl = imageUrl;
            this.linkUrl = linkUrl;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

