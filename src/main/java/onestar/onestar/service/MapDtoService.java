package onestar.onestar.service;

import onestar.onestar.dto.MapDto;
import onestar.onestar.entity.StudyCafe;

import java.util.ArrayList;
import java.util.List;

public class MapDtoService {
    public List<MapDto> insert() {
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\data_geo_coding_result.csv");

        List<List<String>> studyCafeData = csvReader.readCSV();
        List<MapDto> mapDtoList = new ArrayList<>();

        for (int i = 1; i < studyCafeData.size(); i++) {
            List<String> tmp = studyCafeData.get(i);

            MapDto mapDto = new MapDto();
            mapDto.setName(tmp.get(1));
            mapDto.setAddress(tmp.get(2));
            mapDto.setLongitude(Double.parseDouble(tmp.get(3)));
            mapDto.setLatitude(Double.parseDouble(tmp.get(4)));
            mapDtoList.add(mapDto);
        }
        return mapDtoList;
    }
}
