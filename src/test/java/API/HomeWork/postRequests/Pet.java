package API.HomeWork.postRequests;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor

public class Pet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrl;
    private List<Tags> tags;
    private String status;
//
//    public Pet() {
//
//    }
////    public Pet(int id, Category category, String name, List<String> photoUrl, List<Tags> tags, String status) {
//        this.id = id;
//        this.category = category;
//        this.name = name;
//        this.photoUrl = photoUrl;
//        this.tags = tags;
//        this.status = status;


    //}


//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<String> getPhotoUrl() {
//        return photoUrl;
//    }
//
//    public void setPhotoUrl(List<String> photoUrl) {
//        this.photoUrl = photoUrl;
//    }
//
//    public List<Tags> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<Tags> tags) {
//        this.tags = tags;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
