package myproject.s29315tpo06.controller;

import myproject.s29315tpo06.service.FakeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FakeDataController {

    private FakeDataService fakeDataService;

    public FakeDataController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
    }

    @GetMapping("/")
    public String formPage() {
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

        List<?> result = fakeDataService.generateFakeData(count, language, fields == null ? List.of() : fields);
        model.addAttribute("data", result);
        return "generator";
    }
}
