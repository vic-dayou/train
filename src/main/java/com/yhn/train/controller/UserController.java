package com.yhn.train.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhn.train.dto.QueryDto;
import com.yhn.train.entity.User;
import com.yhn.train.service.UserService;
import com.yhn.train.utils.UUIDUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 列表展示
   */
  @GetMapping("/list")
  public String list(Model model) {
    PageHelper.startPage(1,10);
    List<User> users = userService.findAll(null);
    PageInfo<User> pageInfo = new PageInfo<>(users);
    model.addAttribute("pageInfo", pageInfo);
    return "list";
  }

  /**
   * 新增/修改页面
   */
  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("user", new User());
    return "add";
  }

  /**
   * 增加或者修改数据
   */
  @Transactional
  @PostMapping("/add")
  @ResponseBody
  public Map<String,String> add(@RequestBody User user) {
    // 验证手机号码唯一，若存在，则不更新和新增

    Map<String,String> map = new HashMap<>();
    if (!"".equals(user.getId())) {
      userService.updateUser(user);
    } else {
      int count = userService.validatePhone(user.getPhone());
      if (count != 0){
        map.put("status","error");
        map.put("mgs","手机号已经存在！");
        return map;
      }
      user.setId(UUIDUtil.generate());
      userService.addUser(user);
    }
    map.put("status","success");
    map.put("mgs","操作成功");
    return map;
  }

  /**
   * 编辑页面
   */
  @GetMapping("/{id}/edit")
  public String edit(@PathVariable("id") String id, Model model) {
    model.addAttribute("user", userService.findOne(id));
    return "add";
  }

  /**
   * 删除
   */
  @GetMapping("/{id}/delete")
  public String delete(@PathVariable("id") String id) {
    userService.deleteUser(id);
    return "redirect: /train/user/list";
  }

  /**
   * 查询
   */
  @PostMapping("/findAll")
  public String findAll(@RequestBody QueryDto queryDto, Model model) {
    PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
    List<User> users = userService.findAll(queryDto);
    PageInfo<User> pageInfo = new PageInfo<>(users);
    model.addAttribute("pageInfo", pageInfo);
    return "list :: userList";
  }


  /**
  * 明细
  */
  @GetMapping("/{id}/info")
  public String info(@PathVariable("id") String id, Model model) {
    model.addAttribute("user",userService.findOne(id));
    return "info";
  }
}
