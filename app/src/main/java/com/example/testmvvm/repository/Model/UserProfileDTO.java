package com.example.testmvvm.repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.example.testmvvm.Domain.Model.UserProfile;
import com.google.gson.Gson;

import java.util.List;

@Entity(tableName = "user_profile", primaryKeys = {"id"}, ignoredColumns = {"images", "creator"})
public class UserProfileDTO extends UserProfile {
    @ColumnInfo
    private String creatorDTO;

    @ColumnInfo
    private String imagesDTO;

    public String getCreatorDTO() {
        return creatorDTO;
    }

    public void setCreatorDTO(String creatorDTO) {
        this.creatorDTO = creatorDTO;
    }

    public String getImagesDTO() {
        return imagesDTO;
    }

    public void setImagesDTO(String imagesDTO) {
        this.imagesDTO = imagesDTO;
        super.setImages(new Gson().fromJson(this.imagesDTO, List.class));
    }

    @Override
    public List<String> getImages() {
        if (super.getImages() == null || super.getImages().isEmpty()) {
            super.setImages(new Gson().fromJson(this.imagesDTO, List.class));
        }
        return super.getImages();
    }

    @Override
    public void setImages(List<String> images) {
        super.setImages(images);
        this.imagesDTO = new Gson().toJson(images);
    }

    public static UserProfileDTO convertFromParty(UserProfile profile) {
        UserProfileDTO dto = new UserProfileDTO();

        dto.setId(profile.getId());
        dto.setName(profile.getName());
        dto.setCreator(profile.getCreator());
        dto.setAddress(profile.getAddress());
        dto.setDescription(profile.getDescription());
        dto.setImages(profile.getImages());

        return dto;
    }
}
