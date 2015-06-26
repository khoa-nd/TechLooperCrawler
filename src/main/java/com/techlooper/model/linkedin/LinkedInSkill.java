package com.techlooper.model.linkedin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by NguyenDangKhoa on 6/19/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedInSkill {

    private String id;

    private String displayName;

    public LinkedInSkill() {
    }

    public LinkedInSkill(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
