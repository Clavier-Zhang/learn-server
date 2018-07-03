package cloud.squad.squadMember;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class SquadMemberSevice {


    @Autowired
    private SquadMemberRepository squadMemberRepository;


    public void add(String squadId, String userId) {
        SquadMember squadMember = new SquadMember();
        squadMember.setSquadId(squadId);
        squadMember.setUserId(userId);
        squadMember.setContribution(0);
        squadMemberRepository.save(squadMember);
    }
}
