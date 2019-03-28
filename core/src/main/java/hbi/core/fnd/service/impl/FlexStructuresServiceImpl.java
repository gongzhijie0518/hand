package hbi.core.fnd.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hbi.core.fnd.dto.FlexStructures;
import hbi.core.fnd.service.IFlexStructuresService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FlexStructuresServiceImpl extends BaseServiceImpl<FlexStructures> implements IFlexStructuresService{
    public static void main(String[] args) {
        System.out.println("面试不会啊？？？？？？？？？？？？？？？？？？？？？？");
    }
}
