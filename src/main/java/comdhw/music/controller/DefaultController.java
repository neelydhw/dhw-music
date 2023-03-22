package comdhw.music.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Neely
 * @date 2023/3/22
 */
@RestController
@RequestMapping("/hello")
@CrossOrigin
public class DefaultController {
    @GetMapping
    public String sayHello(){
        return "欢迎程序员丁洪伟的音乐盒";
    }
}
