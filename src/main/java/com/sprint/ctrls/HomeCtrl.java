package com.sprint.ctrls;

import com.sprint.models.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class HomeCtrl {
	
	@RequestMapping("/")
	public String index(Model model) {
		Msg msg = new Msg("测试标题", "测试内容", "额外信息,只对管理员显示");
		model.addAttribute("msg", msg);
		return "home";
	}
}

