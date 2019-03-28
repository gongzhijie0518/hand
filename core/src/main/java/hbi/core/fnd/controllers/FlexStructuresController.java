package hbi.core.fnd.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.fnd.dto.FlexStructures;
import hbi.core.fnd.service.IFlexStructuresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;

    @Controller
    public class FlexStructuresController extends BaseController{

    @Autowired
    private IFlexStructuresService service;

    @RequestMapping(value = "/fnd/flex/structures/query")
    @ResponseBody
    public ResponseData query(FlexStructures dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/fnd/flex/structures/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<FlexStructures> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/fnd/flex/structures/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<FlexStructures> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }