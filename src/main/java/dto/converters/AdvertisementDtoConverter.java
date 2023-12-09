package dto.converters;

import dto.AdvertisementDto;
import model.Advertisement;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementDtoConverter {

    public  AdvertisementDto convert(Advertisement advertisement) {


        return new AdvertisementDto(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                advertisement.getCreatedAt(),
                advertisement.getUpdatedAt(),
                advertisement.isActive(),
                advertisement.getUserId(),
                advertisement.getCategoryId());

    }
    public List<AdvertisementDto> convert(List<Advertisement> advertisement) {
        return advertisement.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }


}
