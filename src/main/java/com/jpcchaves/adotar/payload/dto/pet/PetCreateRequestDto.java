package com.jpcchaves.adotar.payload.dto.pet;

import com.jpcchaves.adotar.domain.Enum.AnimalGender;
import com.jpcchaves.adotar.domain.Enum.AnimalSize;
import com.jpcchaves.adotar.domain.Enum.HealthCondition;
import com.jpcchaves.adotar.payload.dto.address.AddressRequestDto;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class PetCreateRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @PositiveOrZero(message = "A idade em anos deve ser um valor maior ou igual a 0")
    @Min(value = 0, message = "A idade em anos deve ser 0 ou maior")
    @Max(value = 25, message = "Verifique a idade em anos informada e tente novamente")
    @NotNull(message = "A idade em anos é obrigatória")
    private int yearsAge;

    @Min(value = 1, message = "A idade em meses deve ser um valor entre 1 e 11 (meses do ano)")
    @Max(value = 11, message = "A idade em meses deve ser um valor entre 1 e 11 (meses do ano)")
    @Positive(message = "A idade em meses deve ser um valor maior ou igual a 1")
    @NotNull(message = "A idade em meses é obrigatória")
    private int monthsAge;

    private AnimalGender gender;
    private AnimalSize size;
    private HealthCondition healthCondition;

    @NotBlank(message = "A cor é obrigatória")
    private String color;
    private String description;
    private boolean active;
    private boolean isAvailable;
    private List<Long> characteristicsIds = new ArrayList<>();

    private AddressRequestDto address;
    @NotNull(message = "O tipo do animal é obrigatório")
    private Long typeId;

    @NotNull(message = "A raça do animal é obrigatória")
    private Long breedId;

    private List<MultipartFile> petPictures;

    public PetCreateRequestDto() {
    }

    public PetCreateRequestDto(String name,
                               int yearsAge,
                               int monthsAge,
                               AnimalGender gender,
                               AnimalSize size,
                               HealthCondition healthCondition,
                               String color,
                               String description,
                               boolean active,
                               boolean isAvailable,
                               List<Long> characteristicsIds,
                               AddressRequestDto address,
                               Long typeId,
                               Long breedId,
                               List<MultipartFile> petPictures) {
        this.name = name;
        this.yearsAge = yearsAge;
        this.monthsAge = monthsAge;
        this.address = address;
        this.size = size;
        this.healthCondition = healthCondition;
        this.gender = gender;
        this.color = color;
        this.description = description;
        this.active = active;
        this.isAvailable = isAvailable;
        this.characteristicsIds = characteristicsIds;
        this.typeId = typeId;
        this.breedId = breedId;
        this.petPictures = petPictures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsAge() {
        return yearsAge;
    }

    public void setYearsAge(int yearsAge) {
        this.yearsAge = yearsAge;
    }

    public int getMonthsAge() {
        return monthsAge;
    }

    public void setMonthsAge(int monthsAge) {
        this.monthsAge = monthsAge;
    }

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
    }

    public AnimalSize getSize() {
        return size;
    }

    public void setSize(AnimalSize size) {
        this.size = size;
    }

    public HealthCondition getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(HealthCondition healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Long> getCharacteristicsIds() {
        return characteristicsIds;
    }

    public void setCharacteristicsIds(List<Long> characteristicsIds) {
        this.characteristicsIds = characteristicsIds;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }


    public List<MultipartFile> getPetPictures() {
        return petPictures;
    }

    public void setPetPictures(List<MultipartFile> petPictures) {
        this.petPictures = petPictures;
    }
}
