package cloud.squad.squadMember;


import cloud.common.BaseController;
import cloud.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SquadMemberController extends BaseController {

    @Autowired
    private SquadMemberRepository squadMemberRepository;

    @Resource
    private SquadMemberSevice squadMemberSevice;

    @GetMapping("/squadMember/all")
    public Iterable<SquadMember> getAll(HttpServletRequest request) {
        return squadMemberRepository.findAll();
    }

    @PostMapping("/squadMember/create")
    public Result create(HttpServletRequest request) {

        String squadId = request.getParameter("squadId");
        String userId = request.getParameter("userId");

        SquadMember squadMember = new SquadMember();
        squadMember.setSquadId(squadId);
        squadMember.setUserId(userId);
        squadMember.setContribution(0);
        squadMemberRepository.save(squadMember);

        return new Result("success", "create squad member", squadMember);
    }

    @PostMapping("/squadMember/findAllBySquadId")
    public Result findAllBySquadId(HttpServletRequest request) {

        String squadId = request.getParameter("squadId");

        Iterable<SquadMember> suquadMembers = squadMemberRepository.findAllBySquadId(squadId);

        return new Result("success", "find all By Squad Id", suquadMembers);
    }

    @PostMapping("/squadMember/test")
    public Result test(HttpServletRequest request) {

        String squadId = request.getParameter("squadId");

        List<DataForRankChart> result = squadMemberSevice.squadIdToDataForRankChart(squadId);

        return new Result("success", "find all users", result);
    }

}
