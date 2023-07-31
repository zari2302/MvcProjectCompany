package team.contoller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.model.Company;
import team.repository.CompanyRepo;
import team.repository.CourseRepo;
import team.model.Course;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/course/")
public class CourseController {
    private final CourseRepo courseRepo;
    private final CompanyRepo companyRepo;

    public CourseController(CourseRepo courseRepo, CompanyRepo companyRepo) {
        this.courseRepo = courseRepo;
        this.companyRepo = companyRepo;
    }

    @GetMapping("/findCourse/{id}")
    public String findAll(Model model,@PathVariable Long id) {
        model.addAttribute("allcourse", courseRepo.findAll(id));
        model.addAttribute("courseId",id);
        return "find-all-course";
    }

    @PostMapping("/saveCourse/{id}")
    private String saveCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("duration") String duration,
            @PathVariable("id") Long id) {
        Company company = companyRepo.findById(id);
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepo.save(course);
        return "redirect:/course/findCourse/" + id;
    }

    @GetMapping("/course-save/{id}")
    public String saveFormCourse(Model model, @PathVariable Long id) {
        model.addAttribute("courseId", id);
        model.addAttribute("company", companyRepo.findAll());
        return "course-save";
    }


    @GetMapping("/deleteCourse/{id}")
    public String deleteById(@PathVariable ("id")Long id) {
        Course course = courseRepo.findById(id);
        courseRepo.delete(course.getId());
        return "redirect:/course/findCourse/"+id;
    }

    @GetMapping("/get/course/by/{id}")
    public String getById(Model model, @PathVariable("id") Long id) {
        Course course = courseRepo.findById(id);
        model.addAttribute("course", course);
        return "find-course";
    }

    @GetMapping("/update/course/{id}")
    public String updateCourseForm(@PathVariable("id") Long id, Model model) {
        Course course = courseRepo.findById(id);
        model.addAttribute("course", course);
        return "update-course-form";
    }

    @PostMapping("/updateCourse/{id}")
    public String updateCourse(@RequestParam("courseName") String courseName,
                               @RequestParam("duration") String duration,
                               @PathVariable("id") Long id) {
        Course course = courseRepo.findById(id);
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepo.updateCourse(id, course);
        return "redirect:/course/findCourse/"+id;
    }

    @GetMapping("/clear/course")
    public String clear() {
        courseRepo.clear();
        return "redirect:/course/findCourse";
    }
}

