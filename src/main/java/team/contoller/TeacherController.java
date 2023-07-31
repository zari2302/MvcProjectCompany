package team.contoller;
import org.springframework.web.bind.annotation.*;
import team.model.Course;
import team.model.Groups;
import team.model.Teacher;
import team.repository.CourseRepo;
import team.repository.GroupsRepo;
import team.repository.TeacherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/teacher/")
public class TeacherController {
    private final TeacherRepo teacherRepo;
    private final GroupsRepo groupsRepo;

    public TeacherController(TeacherRepo teacherRepo, GroupsRepo groupsRepo) {
        this.teacherRepo = teacherRepo;
        this.groupsRepo = groupsRepo;
    }

    @GetMapping("/findTeacher/{id}")
    public String findAll(Model model,@PathVariable Long id) {
        model.addAttribute("allteacher", teacherRepo.findAll(id));
        model.addAttribute("teacherId",id );
        return "find-all-teacher";
    }

    @PostMapping("saveTeacher/{id}")
    public String save(@PathVariable Long id,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName,
                       @RequestParam("email") String email) throws Exception {
        Teacher teacher = new Teacher();
        Groups groups = groupsRepo.findById(id);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacher.setGroups(groups);
        teacherRepo.save(teacher);
        return "redirect:/teacher/findTeacher/" + id;
    }


    @GetMapping("/teacherForm/{id}")
    public String saveTeacherPage(Model model,@PathVariable Long id) {
        model.addAttribute("teacherId", id);
        model.addAttribute("groupsId", groupsRepo.findAll(id));
        return "teacher-save";
    }


    @GetMapping("/deleteTeacher/{id}")
    public String deleteById(@PathVariable Long id) {
        Teacher teacher = teacherRepo.findById(id);
        teacherRepo.delete(teacher.getId());
        return "redirect:/teacher/findTeacher/"+id;
    }

    @GetMapping("/get/by/teacher/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Teacher teacher = teacherRepo.findById(id);
        model.addAttribute("teacher", teacher);
        return "find-teacher";
    }

    @GetMapping("/update/teacher/{id}")
    public String updateTeacherForm(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherRepo.findById(id);
        model.addAttribute("teacher", teacher);
        return "update-teacher-form";
    }

    @PostMapping("/update/teachers/{id}")
    public String updateTeacher(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @PathVariable Long id) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacherRepo.updateTeacher(id, teacher);
        return "redirect:/teacher/findTeacher/"+id;
    }

    @GetMapping("/clear/teacher")
    public String clear() {
        teacherRepo.clear();
        return "redirect:/findTeacher";
    }
}

