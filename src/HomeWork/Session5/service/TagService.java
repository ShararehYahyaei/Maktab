package HomeWork.Session5.service;

import HomeWork.Session5.model.Tag;
import HomeWork.Session5.repository.TegRepositoryDb;

public class TagService {
    TegRepositoryDb tagRepo = new TegRepositoryDb();

    public Tag createTag(String title) {
        Tag tag = tagRepo.createNewTag(title);
        return tag;
    }

    public Tag[] getAllTags() {
        Tag[] tags = tagRepo.tagInit();
        return tags;
    }


    public Tag getTagById(int id) {
        Tag tag = tagRepo.getTagById(id);
        return tag;
    }
}
