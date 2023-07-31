package team.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.model.Company;
import team.model.Course;
import team.model.Groups;
import team.repository.CompanyRepo;
import team.repository.CourseRepo;
import team.repository.GroupsRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/groups/")
public class GroupsController {
    private final GroupsRepo groupsRepo;
    private final CompanyRepo companyRepo;
    private final CourseRepo courseRepo;

    public GroupsController(GroupsRepo groupsRepo, CompanyRepo companyRepo, CourseRepo courseRepo) {
        this.groupsRepo = groupsRepo;
        this.companyRepo = companyRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/findGroup/{id}")
    public String findAllGroup(@PathVariable Long id, Model model) {
        model.addAttribute("allgroups", groupsRepo.findAll(id));
        model.addAttribute("groupId", id);
        return "find-all-groups";
    }

    @PostMapping("/saveGroups/{id}")
    private String saveGroups(
            @RequestParam("groupName") String groupName,
            @RequestParam("dateStart") String dateStart,
            @RequestParam("dateFinish") String dateFinish,
            @PathVariable("id") Long id,
            @RequestParam("courseId") Long courseId
    ) {
        Company company = companyRepo.findById(id);
        List<Course> courses = new ArrayList<>();
        Course course = courseRepo.findById(courseId);
        Groups groups = new Groups();
        courses.add(course);
        groups.setGroupName(groupName);
        groups.setDateStart(dateStart);
        groups.setDateFinish(dateFinish);
        groups.setCompany(company);
        groups.setCourses(courses);
        groupsRepo.save(groups);
        return "redirect:/groups/findGroup/" + id;
    }

    @GetMapping("/groups-save/{id}")
    public String saveFormGroups(Model model, @PathVariable Long id) {
        model.addAttribute("groupId", id);
        model.addAttribute("company", companyRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll(id));
        return "groups-save";
    }


    @GetMapping("/deleteGroups/{id}")
    public String deleteById(@PathVariable Long id) {
        Groups groups = groupsRepo.findById(id);
        groupsRepo.delete(groups.getId());
        return "redirect:/groups/findGroup/"+id;
    }

    @GetMapping("/get/by/groups/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Groups groups = groupsRepo.findById(id);
        model.addAttribute("group", groups);
        return "find-groups";
    }

    @GetMapping("/update/groups/{id}")
    public String updateCourseForm(@PathVariable("id") Long id, Model model) {
        Groups groups = groupsRepo.findById(id);
        model.addAttribute("groups", groups);
        return "update-groups-form";
    }

    @PostMapping("/update/group/{id}")
    public String updateGroups(@RequestParam("groupsName") String groupsName,
                               @RequestParam("dateStart") String dateStart,
                               @RequestParam("dateFinish") String dateFinish,
                               @PathVariable Long id) {
        Groups groups = groupsRepo.findById(id);
        groups.setGroupName(groupsName);
        groups.setDateStart(dateStart);
        groups.setDateFinish(dateFinish);
        groupsRepo.updateGroups(id, groups);
        return "redirect:/groups/findGroup/"+groups.getCompany().getId();
    }

    @GetMapping("/clear/groups")
    public String clear() {
        groupsRepo.clear();
        return "redirect:/groups/findGroup";
    }
}

