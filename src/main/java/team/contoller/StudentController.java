package team.contoller;
import org.springframework.web.bind.annotation.*;
import team.model.Groups;
import team.model.enumFormat.StudentFormat;
import team.repository.GroupsRepo;
import team.repository.StudentRepo;
import team.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/student/")
public class StudentController {
    private final StudentRepo studentRepo;
    private final GroupsRepo groupsRepo;

    public StudentController(StudentRepo studentRepo, GroupsRepo groupsRepo) {
        this.studentRepo = studentRepo;
        this.groupsRepo = groupsRepo;
    }

    @GetMapping("/findStudent/{id}")
    public String findAll(Model model,@PathVariable Long id) {
        model.addAttribute("allstudent", studentRepo.findAll(id));
        model.addAttribute("studentId",id);
        return "find-all-student";
    }

    @PostMapping("/saveStudent/{id}")
    public String studentSave(@PathVariable Long id,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("email") String email,
                              @RequestParam("format") String studentFormat) {
        Groups groups = groupsRepo.findById(id);
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStudentFormat(StudentFormat.valueOf(studentFormat.toUpperCase()));
        student.setGroups(groups);
        studentRepo.save(student);
        return "redirect:/student/findStudent/" + id;
    }

    @GetMapping("/student-save/{id}")
    public String saveCompanyPage(Model model,@PathVariable Long id) {
        model.addAttribute("studentId",id);
        model.addAttribute("groups", groupsRepo.findAll(id));
        return "student-save";
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable Long id) {
        Student student = studentRepo.findById(id);
        studentRepo.delete(student.getId());
        return "redirect:/student/findStudent/"+id;
    }

    @GetMapping("/get/by/student/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Student student = studentRepo.findById(id);
        model.addAttribute("student", student);
        return "find";
    }

    @GetMapping("/update/student/{id}")
    public String updateCourseForm(@PathVariable("id") Long id, Model model) {
        Student student = studentRepo.findById(id);
        model.addAttribute("student", student);
        return "update-student-form";
    }

    @PostMapping("/update/students/{id}")
    public String updateStudent(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("studentFormat") String studentFormat,
                                @PathVariable Long id) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setStudentFormat(StudentFormat.valueOf(studentFormat));
        studentRepo.updateStudent(id, student);
        return "redirect:/student/findStudent/"+id;
    }

    @GetMapping("/clear/student")
    public String clear() {
        studentRepo.clear();
        return "redirect:/student/findStudent/";
    }
}
