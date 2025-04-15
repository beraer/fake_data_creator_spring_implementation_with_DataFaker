package myproject.s29315tpo06.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import myproject.s29315tpo06.dto.FakeDataDTO;
import myproject.s29315tpo06.service.FakeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FakeDataController {

    private final FakeDataService fakeDataService;
    private final ObjectMapper objectMapper;

    public FakeDataController(FakeDataService fakeDataService, ObjectMapper objectMapper) {
        this.fakeDataService = fakeDataService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/")
    public String formPage(Model model) {
        model.addAttribute("data", null);
        return "generator";
    }

    @PostMapping("/generate")
    public String generate(
            @RequestParam(defaultValue = "1") int count,
            @RequestParam(defaultValue = "en") String language,
            @RequestParam(required = false) List<String> fields,
            Model model
    ) {
        if (count <= 0) {
            model.addAttribute("error", "Please enter a valid number of entries.");
            return "generator";
        }

        List<FakeDataDTO> result = fakeDataService.generateFakeData(count, language, fields == null ? List.of() : fields);

        if(result == null || result.isEmpty()) {
            model.addAttribute("error", "No data was generated. Please try again.");
        } else {
            model.addAttribute("data", result);

            Map<String, String> localizedHeaders = getLocalizedHeaders(language);
            model.addAttribute("headers", localizedHeaders);

            try {
                String jsonData = objectMapper.writeValueAsString(result);
                model.addAttribute("jsonData", jsonData);
            } catch (JsonProcessingException e) {
                model.addAttribute("error", "Error processing data for download.");
            }
        }

        return "generator";
    }

    private Map<String, String> getLocalizedHeaders(String lang) {
        return switch (lang) {
            case "es" -> Map.of(
                    "firstName", "Nombre",
                    "lastName", "Apellido",
                    "birthDate", "Fecha de Nacimiento",
                    "address", "Dirección",
                    "university", "Universidad",
                    "country", "País",
                    "phone", "Teléfono",
                    "email", "Correo electrónico",
                    "job", "Trabajo"
            );
            case "fr" -> Map.of(
                    "firstName", "Prénom",
                    "lastName", "Nom",
                    "birthDate", "Date de Naissance",
                    "address", "Adresse",
                    "university", "Université",
                    "country", "Pays",
                    "phone", "Téléphone",
                    "email", "Courriel",
                    "job", "Emploi"
            );
            default -> Map.of(
                    "firstName", "First Name",
                    "lastName", "Last Name",
                    "birthDate", "Date of Birth",
                    "address", "Address",
                    "university", "University",
                    "country", "Country",
                    "phone", "Phone",
                    "email", "Email",
                    "job", "Job"
            );
        };
    }

}