package myproject.s29315tpo06.service;

import myproject.s29315tpo06.dto.FakeDataDTO;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FakeDataService {
    public List<FakeDataDTO> generateFakeData(int count, String language, List<String> extras) {
        Faker faker = new Faker(new Locale(language));
        List<FakeDataDTO> fakeDataDTOList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String birthDate = faker.date().birthday(18, 70).toLocalDateTime().toLocalDate().toString();

            Map<String, String> extrasMap = new HashMap<>();
            for (String extra : extras) {
                switch (extra) {
                    case "address" -> extrasMap.put(extra, faker.address().fullAddress());
                    case "university" -> extrasMap.put(extra, faker.university().name());
                    case "phone" -> extrasMap.put(extra, faker.phoneNumber().phoneNumber());
                    case "country" -> extrasMap.put(extra, faker.country().name());
                    case "email" -> extrasMap.put(extra, faker.internet().emailAddress());
                    case "job" -> extrasMap.put(extra, faker.job().title());
                    default -> extrasMap.put(extra, "N/A");
                }
            }
            fakeDataDTOList.add(new FakeDataDTO(firstName, lastName, birthDate, extrasMap));
        }
        return fakeDataDTOList.isEmpty() ? new ArrayList<>() : fakeDataDTOList;
    }
}
