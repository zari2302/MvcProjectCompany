package team.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.model.Company;
import team.repository.CompanyRepo;

@Controller
public class CompanyController {

    private final CompanyRepo companyRepo;

    @Autowired
    public CompanyController(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("all", companyRepo.findAll());
        return "find-all";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("name") String companyName,
                               @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepo.save(company);
        return "redirect:/";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage() {
        return "company-save";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        companyRepo.findById(id);
        companyRepo.delete(id);
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Company company = companyRepo.findById(id);
        model.addAttribute("person", company);
        model.addAttribute("company", company);
        return "find";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Company company = companyRepo.findById(id);
        model.addAttribute("company", company);
        return "update-company-form";
        }

        @PostMapping("/update/{id}")
        public String updateCompany (@RequestParam("companyName") String companyName,
                                     @RequestParam("locatedCountry") String locatedCountry,
                                     @PathVariable ("id")Long id){
            Company company = new Company();
            company.setCompanyName(companyName);
            company.setLocatedCountry(locatedCountry);
            companyRepo.updateCompany(id, company);
            return "redirect:/";
        }

        @GetMapping("/clear")
        public String clear () {
            companyRepo.clear();
            return "redirect:/";
        }
    }