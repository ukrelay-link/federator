package link.ukrelay.federator.services;

import link.ukrelay.federator.model.Instance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstanceServiceImpl implements InstanceService {

    @Override
    public List<Instance> list() {

        var list = new ArrayList<Instance>();

        var one = new Instance();
        one.setName("one.one.one");

        var two = new Instance();
        two.setName("two.two.two");

        var three = new Instance();
        three.setName("three.three.three");

        list.add(one);
        list.add(two);
        list.add(three);

        return list;
    }

}
