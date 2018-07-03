package cloud.squad.squadMember;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SquadMemberController {

    @Autowired
    private SquadMemberRepository squadMemberRepository;

    @GetMapping("/squadMember/all")
    public Iterable<SquadMember> getAll(HttpServletRequest request) {
        return squadMemberRepository.findAll();
    }
}
