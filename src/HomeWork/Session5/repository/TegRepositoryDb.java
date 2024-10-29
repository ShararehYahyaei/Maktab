package HomeWork.Session5.repository;

import HomeWork.Session5.model.Tag;

public class TegRepositoryDb {
    Tag[] tags = new Tag[10];

    public Tag[] tagInit() {
        for (int index = 0; index < tags.length; index++) {
            tags[0] = new Tag(1, "اینترنت جهانی");
            tags[1] = new Tag(2, "تکنولوژی ");
            tags[2] = new Tag(3, " انسان خلاق");
        }

        return tags;
    }

    public Tag createNewTag(String title) {
        for (int index = 0; index < tags.length; index++) {
            if (tags[index] == null) {
                int id = tags[index - 1].getId();
                Tag tag = new Tag(id + 1, title);
                tags[index] = tag;
                return tags[index];
            }
        }
        return null;
    }

    public Tag getTagById(int id) {
        for (int index = 0; index < tags.length; index++) {
            if (tags[index].getId() == id) {
                return tags[index];
            }
        }
        return null;
    }
}
