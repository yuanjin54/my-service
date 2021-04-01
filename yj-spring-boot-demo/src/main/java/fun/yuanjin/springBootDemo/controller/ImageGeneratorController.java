package fun.yuanjin.springBootDemo.controller;

import fun.yuanjin.springBootDemo.domain.TestDO;
import fun.yuanjin.springBootDemo.service.ImageService;
import fun.yuanjin.springBootDemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ImageGeneratorController
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/image")
public class ImageGeneratorController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TestService testService;

    @RequestMapping("/save/{name}")
    @ResponseBody
    public String save(@PathVariable("name") String name) throws Exception {
        TestDO testDO = new TestDO(1, name);
        return testService.save(testDO);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        imageService.deleteBatchImage();
        return "delete success";
    }
}
