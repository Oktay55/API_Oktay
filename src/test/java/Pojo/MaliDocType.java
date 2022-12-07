package Pojo;

import java.util.ArrayList;
import java.util.List;

public class MaliDocType {

    private String id;
    private String name;
    private String description;
    private List<String> attachmentStages = new ArrayList<>();
    private String active;
    private String useCamera;
    private String required;
    private List<Translate> translateName = new ArrayList<>();
    private String schoolId;

    public String getId() {
        return id;
    }

    public List<Translate> getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String lang, String data) {
        this.translateName.add(new Translate(lang, data));


    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getAttachmentStages() {
        return attachmentStages;
    }

    public void setAttachmentStages(String attachmentStages) {
        this.attachmentStages.add(attachmentStages);

    }

    public String getUseCamera() {
        return useCamera;
    }

    public void setUseCamera(String useCamera) {
        this.useCamera = useCamera;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;

    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public void setTranslateName(List<Translate> translateName) {
        this.translateName = translateName;
    }
}
