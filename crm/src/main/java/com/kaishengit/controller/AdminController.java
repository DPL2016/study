package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Inject
    private UserService userService;

    /**
     * 显示用户列表页面
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userList(){
        return "admin/userlist";
    }

    @RequestMapping(value = "/user/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult userLoad(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");
        keyword = Strings.toUTF8(keyword);
        Map<String,Object>param = Maps.newHashMap();
        param.put("draw",draw);
        param.put("start",start);
        param.put("length",length);
        param.put("keyword",keyword);
        List<User> userList = userService.findByParam(param);
        Long count = userService.countUser();
        Long filterCount = userService.countByParam();
        return new DataTablesResult(draw,userList,count,filterCount);
    }
}
